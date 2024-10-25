package com.tarik.controle1.DAO.impl;

import com.tarik.controle1.DAO.CDInterface;
import com.tarik.controle1.model.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CdImpl implements CDInterface {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("livres");
    @Override
    public List<CD> getAllAvailableCDs() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c WHERE c.available = true", CD.class);
        List<CD> cds = query.getResultList();
        em.close();
        return cds;
    }

    @Override
    public boolean emprunterCD(int cdId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CD cd = em.find(CD.class, cdId);
            if (cd != null && cd.isAvailable()) {
                cd.setAvailable(false);
                em.merge(cd);
                em.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }



}
