package com.codehacks.dao;

import com.codehacks.model.Client;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author E238958
 */
public class LoginDaoImpl implements LoginDAO {

    private final Map<String, String> clientLogin = new HashMap<>();
    
    @Override
    public Map<String, String> retrieveAllLogins(String email, String password) {
        createLogins();
        return clientLogin;
    }
    
    @Override
    public Client retrieveLogin(String email) {
        String clientPassword = clientLogin.get(email);
        return new Client(email, clientPassword);
    }
    
    public void createLogins() {
        clientLogin.put("barry@gmail.com", "barry");
        clientLogin.put("larry@gmail.com", "larry");
        clientLogin.put("harry@gmail.com", "harry");
        clientLogin.put("garry@gmail.com", "garry");
        clientLogin.put("parry@gmail.com", "parry");
    }

    @Override
    public boolean validLogin(Client client) {
        createLogins();
        if (clientLogin.containsKey(client.getEmail())) {
            String clientValue = clientLogin.get(client.getEmail());
            if (clientValue.equals(client.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
}
