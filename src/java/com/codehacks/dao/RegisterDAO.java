package com.codehacks.dao;

import com.codehacks.model.User;

/**
 *
 * @author E238958
 */
public interface RegisterDAO {
    
    // CRUD
    
    public void registerUser(User user);                     // create
    
    public boolean checkIfUserExist(User user);
            
    public User getUser(String email);                          // read
    
    public void updateUser(User user);                       // update
    
    public boolean deleteUser(String email);    // delete
    
}
