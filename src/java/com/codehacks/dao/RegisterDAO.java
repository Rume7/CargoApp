package com.codehacks.dao;

import com.codehacks.model.RegisteredUser;

/**
 *
 * @author E238958
 */
public interface RegisterDAO {
    
    // CRUD
    
    public void registerUser(RegisteredUser user);                     // create
    
    public boolean checkIfUserExist(RegisteredUser user);
            
    public RegisteredUser getUser(String email);                          // read
    
    public void updateUser(RegisteredUser user);                       // update
    
    public boolean deleteUser(String email);    // delete
    
}
