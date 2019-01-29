package com.codehacks.dao;

import com.codehacks.model.Goods;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author E238958
 */
public class GoodsDaoImpl implements GoodsDAO {

    @PersistenceUnit
    private EntityManagerFactory emf = null;

    public GoodsDaoImpl() {
        emf = Persistence.createEntityManagerFactory("CargoAppPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void persistGoods(Goods good) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(good);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Goods> getAllGoodsByEmail(String email) {
        EntityManager em = getEntityManager();
        try{
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    @Override
    public void updateGoodStatus(Goods good) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(good);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
