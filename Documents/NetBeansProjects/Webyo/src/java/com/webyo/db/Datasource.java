/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.db;

import java.sql.*;

/**
 *
 * @author Welcome
 */
public class Datasource {
    private Connection con;
private PreparedStatement ps;

//prepared statements
//supply queries
    
    String url;

    public Datasource() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
         DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        this.url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    }
    
    
    public Connection getCon() {
        return con;
    }

    public void setCon() throws SQLException {
        this.con = DriverManager.getConnection(url,"root","hououinkyouma183");
        
    }

    public PreparedStatement getPs() {

        return ps;
    }

    public void setPs(String query) throws SQLException {
        ps=con.prepareCall(query);
    }
    
}
