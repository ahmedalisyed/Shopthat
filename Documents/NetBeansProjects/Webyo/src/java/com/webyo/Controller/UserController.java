/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.Controller;

import com.webyo.DAO.CategoryDAO;
import com.webyo.DAO.ProductDAO;
import com.webyo.DAO.ProductDetailsDAO;
import com.webyo.DAO.RoleDAO;
import com.webyo.DAO.UserDAO;
import com.webyo.models.Role;
import com.webyo.models.User;
import com.webyo.service.CategoryDAOimp;
import com.webyo.service.ProductDAOimp;
import com.webyo.service.ProductDetailsDAOimp;
import com.webyo.service.RoleDAOimp;
import com.webyo.service.UserDAOimp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Welcome
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String req=request.getHeader("referer");
        out.print(req);
        String mailId=request.getParameter("mailId");
        String password=request.getParameter("password");
        UserDAO ud=new UserDAOimp();
        RoleDAO rld=new RoleDAOimp();
        ProductDAO pd=new ProductDAOimp();
        ProductDetailsDAO pdt=new ProductDetailsDAOimp();
        User user;
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
        if(req.contains("Login")){
            user=new User(mailId,password);
            user=ud.readUser(user);
      
            //out.println(user);
            if(user.getId()!=0){  
                    Cookie c=new Cookie("mail",user.getMailId());
                    HttpSession session=request.getSession();
                    session.setAttribute("user",user);
                    Role r=new Role(user.getId());
                Role[] roles=rld.readRole(r);
                user.setRoles(roles);
                CategoryDAO cd=new CategoryDAOimp();
                session.setAttribute("categories",cd.read());
                session.setAttribute("products", pd.read());
                session.setAttribute("productDetails",pdt.read());
                response.sendRedirect("Hello.jsp?r="+roles[0].getRoleName());
            }
            else{
                out.println("User ID or password incorrect");
                rd.include(request,response);
            }
           
        }else if(req.contains("index")){
            String firstName=request.getParameter("firstName");
            
            String lastName=request.getParameter("lastName");
           
            out.print("Create User Obj <br/>");
            user=new User(firstName,lastName,mailId,password);
            user=ud.createUser(user);
             out.print("Save User");
            user=ud.createUser(user);
            out.print("Done User");
            Role r=new Role("Customer",user.getId());
            rld.createRole(r);
            if(user.error!=null){
                
                out.print(user.error);
                rd.include(request, response);
            }
        rd.forward(request, response);    
        }
        
        
        
    
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        UserDAO ud=new UserDAOimp();
        RoleDAO rld=new RoleDAOimp();
       User user;
       
       user=new User("a@a","s");
            user=ud.readUser(user);
            Role r=new Role(user.getId());
                Role[] roles=rld.readRole(r);
                user.setRoles(roles);
                System.out.println(roles[0].getRoleName());
   }
        
    }

    

    

   

