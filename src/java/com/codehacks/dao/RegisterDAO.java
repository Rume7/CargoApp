package com.codehacks.dao;

import com.codehacks.controller.exceptions.NonexistentEntityException;
import com.codehacks.model.RegisteredUser;

/**
 *
 * @author E238958
 */
public interface RegisterDAO {
    
    public void registerUser(RegisteredUser user);                     // create
    
    public boolean checkIfUserExist(RegisteredUser user);
            
    public RegisteredUser getUser(String email);                          // read
    
    public void updateUser(RegisteredUser user) throws 
            NonexistentEntityException, Exception;
    
    public void deleteUser(String email) throws NonexistentEntityException;    // delete
    
}
