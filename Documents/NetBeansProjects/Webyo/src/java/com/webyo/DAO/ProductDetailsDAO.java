/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.DAO;

import com.webyo.models.Product;
import com.webyo.models.ProductDetails;
import java.util.List;

/**
 *
 * @author Welcome
 */
public interface ProductDetailsDAO {
    public void create(ProductDetails p);
    public ProductDetails read(ProductDetails p);
    public List<ProductDetails> read(Product p);
    public List<ProductDetails> read();
    public void update(ProductDetails p);
    public void delete(ProductDetails p);
}
