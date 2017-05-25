/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.Controller;

import com.webyo.DAO.CategoryDAO;
import com.webyo.DAO.ProductDAO;
import com.webyo.models.Category;
import com.webyo.models.Product;
import com.webyo.service.CategoryDAOimp;
import com.webyo.service.ProductDAOimp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Welcome
 */
@WebServlet(name = "ProductController", urlPatterns = {"/Product"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        ProductDAO pd=new ProductDAOimp();
        CategoryDAO cd=new CategoryDAOimp();
        Product p;
        Category c=new Category(0);
        List<Category> categories=cd.read();
        String mode=request.getParameter("m");
        String name="",description="",manufactureName="";
        float price=0;int categoryId=0;
        out.println(mode);
        if(mode.equals("s")){
            int id=Integer.parseInt(request.getParameter("id"));
            c=new Category(id);
            session.setAttribute("products",pd.read(c));
        }else{
        try{
            name=request.getParameter("name");
            description=request.getParameter("description");
            price=Float.parseFloat(request.getParameter("price"));
            categoryId=Integer.parseInt(request.getParameter("categoryId"));
            manufactureName=request.getParameter("manufacturename");
        }catch(Exception e){}
        if(mode.equals("c")){
            p=new Product(name, description, price, categoryId, manufactureName);
            pd.create(p);
            out.print(p.getName());
            out.print(p.getDescription());
            out.print(p.getPrice());
            out.print(p.getCategoryId());
            out.print(p.getManufacturename());
        }
        else{
            int id=Integer.parseInt(request.getParameter("id"));
            if(mode.equals("e")){
                p=new Product(id);
                p=pd.read(p);
                session.setAttribute("product",p);
                c=new Category(p.getCategoryId());
                session.setAttribute("category",cd.read(c));
                for(int i=0;i<categories.size();i++){
                if(categories.get(i).getId()==c.getId()){
                    categories.remove(i);
                }
        }
            }else if(mode.equals("u")){
                p=new Product(name, description, price, categoryId, manufactureName);
                p.setId(id);
                pd.update(p);
                c=new Category(p.getCategoryId());
                session.setAttribute("product",null);
                session.setAttribute("category",null);
            }else{
                p=new Product(id);
                out.print("Delete"+id);
                pd.delete(p);
            }
        }
        }
        session.setAttribute("categories",categories);
        session.setAttribute("products",pd.read(c));
        response.sendRedirect("Product.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


   