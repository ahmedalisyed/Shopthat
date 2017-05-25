/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.service;

import com.webyo.DAO.ProductDetailsDAO;
import com.webyo.db.Datasource;
import com.webyo.models.Product;
import com.webyo.models.ProductDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Welcome
 */
public class ProductDetailsDAOimp implements ProductDetailsDAO {
    Datasource ds;

    public ProductDetailsDAOimp() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.ds = new Datasource();
    }
    @Override
    public void create(ProductDetails p) {
        try {
            ds.setCon();
            ds.setPs("insert into productdetails(serialNumber,productId,manufactureDate,expiryDate,size,color,sellerId) values (?,?,?,?,?,?,?)");
            ds.getPs().setString(1,String.valueOf(p.getSerialNumber()));
            ds.getPs().setInt(2,p.getProductId());
            ds.getPs().setDate(3,p.getManufactureDate());
            ds.getPs().setDate(4,p.getExpiryDate());
            ds.getPs().setString(5,p.getSize());
            ds.getPs().setString(6,p.getColor());
            ds.getPs().setInt(7,p.getSellerId());
            ds.getPs().executeUpdate();
            ds.getCon().commit();
            ds.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDetailsDAOimp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ProductDetails read(ProductDetails pd) {
        try{
            ds.setCon();
            ds.setPs("select * from productdetails where SerialNumber="+pd.getSerialNumber());
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("SerialNumber"));
                   p.setSerialNumber(rs.getInt("sno"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpiryDate(rs.getDate("expiryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
            }
            ds.getCon().close();
        }catch(Exception e){}
        return pd;
    }

    @Override
    public List<ProductDetails> read(Product pid) {
         List<ProductDetails> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from productdetails where productId="+pid.getId());
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("Id"));
                   p.setSerialNumber(rs.getInt("sno"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpiryDate(rs.getDate("expiryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public List<ProductDetails> read() {
        List<ProductDetails> products=new ArrayList<>();
         try{
            ds.setCon();
            ds.setPs("select * from productdetails");
             ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                   ProductDetails p=new ProductDetails(rs.getInt("serialNumber"));
                   p.setProductId(rs.getInt("ProductId"));
                   p.setManufactureDate(rs.getDate("manufactureDate"));
                   p.setExpiryDate(rs.getDate("expiryDate"));
                   p.setSize(rs.getString("size"));
                   p.setColor(rs.getString("color"));
                   p.setSellerId(rs.getInt("sellerId"));
                   products.add(p);
            }
            ds.getCon().close();
        }catch(Exception e){}
        return products;
    }

    @Override
    public void update(ProductDetails p) {
        try{
        ds.setCon();
        ds.setPs("update productdetails set productId=?,manufactureDate=?,expiryDate=?,size=?,color=?,sellerId=? where sno=?");
        
        ds.getPs().setInt(1,p.getProductId());
        ds.getPs().setDate(2,p.getManufactureDate());
        ds.getPs().setDate(3,p.getExpiryDate());
        ds.getPs().setString(4,p.getSize());
        ds.getPs().setString(5,p.getColor());
        ds.getPs().setInt(6,p.getSellerId());
        ds.getPs().setLong(7,p.getSerialNumber());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }

    @Override
    public void delete(ProductDetails p) {
         try{
        ds.setCon();
        ds.setPs("Delete from productdetails where sno=?");
        ds.getPs().setLong(1,p.getSerialNumber());
        ds.getPs().executeUpdate();
        ds.getCon().commit();
        ds.getCon().close();
        }catch(Exception e){
        }
    }
    
}
