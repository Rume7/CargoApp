package com.codehacks.dao;

import com.codehacks.model.Client;
import java.util.List;
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
    
    public LoginDaoImpl() {
        emf = Persistence.createEntityManagerFactory("CargoAppPU");
    }
        
    public EntityManager getEntityManager() {
        return emf.createEntityManager();        
    }
    
    @Override
    public void createLogin(Client client) {
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
}
