package com.codehacks.dao;

import com.codehacks.model.Client;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author E238958
 */
public class LoginDaoImpl implements LoginDAO {
    
    @PersistenceUnit
    private EntityManagerFactory emf = null;
    
    private final Map<String, String> clientLogin = new HashMap<>();

    public LoginDaoImpl() {
        emf = Persistence.createEntityManagerFactory("CargoAppPU");
    }
        
    public EntityManager getEntityManager() {
        return emf.createEntityManager();        
    }
    
    @Override
    public Map<String, String> retrieveAllLogins(String email, String password) {
          return clientLogin;
    }
    
    @Override
    public Client retrieveLogin(String email) {
        String clientPassword = clientLogin.get(email);
        Client c1 = new Client();
        c1.setEmail(email);
        c1.setPassword(clientPassword);
        return c1;
    }
    
    @Override
    public void createLogin(Client client) {
        clientLogin.put("barry@gmail.com", "barry");
        clientLogin.put("larry@gmail.com", "larry");
        clientLogin.put("harry@gmail.com", "harry");
        clientLogin.put("garry@gmail.com", "garry");
        clientLogin.put("parry@gmail.com", "parry");
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean validLogin(Client client) {
        //createLogin(client);
        if (clientLogin.containsKey(client.getEmail())) {
            String clientValue = clientLogin.get(client.getEmail());
            if (clientValue.equals(client.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
}
