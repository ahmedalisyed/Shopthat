package com.webyo.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.webyo.DAO.UserDAO;
import com.webyo.models.User;
import com.webyo.db.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Welcome
 */
public class UserDAOimp implements UserDAO {
    Datasource ds;

    public UserDAOimp() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.ds = new Datasource();
    }
    @Override
    public User createUser(User u) {
        try{
        ds.setCon();
        
        ds.setPs("insert into new_table(firstName,lastName,mailId,password) values (?,?,?,?)");
        ds.getPs().setString(1,u.getFirstName());
        ds.getPs().setString(2,u.getLastName());
        
        ds.getPs().setString(3,u.getMailId());
        ds.getPs().setString(4,u.getPassword());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(SQLException e){
            u.error=e.toString();
        }
        return u;
    }

    @Override
    public User readUser(User u) {
         try{
            ds.setCon();
           ds.setPs("Select * from new_table where mailId=?");
           ds.getPs().setString(1,u.getMailId());
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
                if((rs.getString("password")).equals(u.getPassword())){
                    u.setFirstName(rs.getString("firstName"));
                    u.setLastName(rs.getString("lastName"));
                    u.setId(rs.getInt("Id"));
                    
                }
                
            }
            
        }catch(SQLException e){}
        return u;
        
    }

    @Override
    public void updateUser(User u) {
        
    }

    @Override
    public void deleteUser(User u) {
        
    }
    
}
   
    
    

