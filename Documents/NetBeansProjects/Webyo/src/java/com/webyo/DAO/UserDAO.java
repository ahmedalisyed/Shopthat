/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.DAO;

import com.webyo.models.User;

/**
 *
 * @author Welcome
 */
public interface UserDAO {
    public User createUser(User u);
    public User readUser(User u);
    public void updateUser(User u);
    public void deleteUser(User u);
    
}
