package com.codehacks.dao;

import com.codehacks.controller.exceptions.NonexistentEntityException;
import com.codehacks.model.RegisteredUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author E238958
 */
public class RegisterDaoImpl implements RegisterDAO {

    @PersistenceUnit
    private EntityManagerFactory emf = null;

    private final Map<String, RegisteredUser> registeredUser = new HashMap<>();

    public RegisterDaoImpl() {
        emf = Persistence.createEntityManagerFactory("CargoAppPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private void createRegisteredUsers() {
        RegisteredUser user1 = new RegisteredUser("Tom", "Tom", "Tommy", "tommy@gmail.com", "tom123");
        RegisteredUser user2 = new RegisteredUser("Pat", "Lowe", "Pavlov", "larry@gmail.com", "larry");
        RegisteredUser user3 = new RegisteredUser("John", "Booke", "Johnny", "harry@gmail.com", "harry");
        RegisteredUser user4 = new RegisteredUser("Jude", "Gray", "Glow", "parry@gmail.com", "parry");
        RegisteredUser user5 = new RegisteredUser("Blue", "Tom", "Groovy", "garry@gmail.com", "garry");
        registeredUser.put(user1.getEmail(), user1);
        registeredUser.put(user2.getEmail(), user2);
        registeredUser.put(user3.getEmail(), user3);
        registeredUser.put(user4.getEmail(), user4);
        registeredUser.put(user5.getEmail(), user5);
    }

    @Override
    public void registerUser(RegisteredUser user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public boolean checkIfUserExist(RegisteredUser user) {
        List<RegisteredUser> allUsers = getUsers();
        return allUsers.stream().anyMatch((nextUser) -> (user.getEmail().equals(nextUser.getEmail())));
    }

    @Override
    public RegisteredUser getUser(String email) {
        RegisteredUser user = null;
        EntityManager em = getEntityManager();
        try {
            user = em.find(RegisteredUser.class, email);
        } finally {
            if (em != null){
                em.close();
            }
        }        
        return user;
    }

    public List<RegisteredUser> getUsers() {
        List<RegisteredUser> usersList = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            usersList = findRegisteredUserEntities(true, -1, -1);
        } finally {
            if (em != null){
                em.close();
            }
        }
        return usersList;
    }
    
    private List<RegisteredUser> findRegisteredUserEntities(boolean all, 
            int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RegisteredUser.class));
            Query query = em.createQuery(cq);
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public void updateUser(RegisteredUser user) throws NonexistentEntityException,
            Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            RegisteredUser reg = em.merge(user);
            em.getTransaction().commit();
        } catch(Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                throw new NonexistentEntityException("The user with email" +
                        user.getEmail() + " no longer exists.");
            }
        } finally{ 
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteUser(String email) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            RegisteredUser user;
            try {
                user = em.getReference(RegisteredUser.class, email);
                //user.getEmail();
            } catch(EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The user with email: " + email + 
                        " no longer exists.");
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
