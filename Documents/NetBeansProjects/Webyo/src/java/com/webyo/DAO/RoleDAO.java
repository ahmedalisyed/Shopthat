/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.DAO;

import com.webyo.models.Role;

/**
 *
 * @author Welcome
 */
public interface RoleDAO {
     public void createRole(Role role);
    public Role[] readRole(Role role);
    public void updateRole(Role role);
    public void deleteRole(Role role);
}
