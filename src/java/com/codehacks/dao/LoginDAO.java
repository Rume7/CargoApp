package com.codehacks.dao;

import com.codehacks.model.Client;
import java.util.Map;

/**
 *
 * @author E238958
 */
public interface LoginDAO {
    
    public Map<String, String> retrieveAllLogins(String email, String password);
    
    public Client retrieveLogin(String email);
    
    public boolean validLogin(Client client);
}
