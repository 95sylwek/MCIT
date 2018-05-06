/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sebastian
 */
public class Producenci {

    private static final String DbName = "MCITPU";

    public Producenci() {

    }

    public Producenci(String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producent poroducent = new Model.Producent(name);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }

    public Producenci(String nazwa, String opis, Date rokPow, Date rokZak) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = new Model.Producenci(nazwa, opis, rokPow, rokZak);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(int id) throws Exception {
        String name = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        name = poroducent.getNazwa();

        em.getTransaction().commit();
        em.close();

        return name;
    }

    public void setNazwa(int id, String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        poroducent.setNazwa(name);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }

    public String getOpis(int id) throws Exception {
        String descrip = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        descrip = poroducent.getOpis();

        em.getTransaction().commit();
        em.close();

        return descrip;
    }

    public void setOpis(int id, String descrip) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        poroducent.setOpis(descrip);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }

    public Date getRokPow(int id) throws Exception {
        Date dateFrom = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        dateFrom = poroducent.getRokpow();

        em.getTransaction().commit();
        em.close();

        return dateFrom;
    }

    public void setRokPow(int id, Date rokPow) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        poroducent.setRokpow(rokPow);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }

    public Date getRokZak(int id) throws Exception {
        Date dateFrom = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        dateFrom = poroducent.getRokzak();

        em.getTransaction().commit();
        em.close();

        return dateFrom;
    }

    public void setRokZak(int id, Date rokZak) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Producenci poroducent = em.find(Model.Producenci.class, id);
        poroducent.setRokzak(rokZak);

        em.persist(poroducent);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Model.Producenci> getProducenci() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT p FROM Producent p");
        List producenci = (List) q.getResultList();

        em.close();
        
        return producenci;
    }
    
    public Model.Producenci getProducent(int id) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Producenci producent = em.find(Model.Producenci.class, id);

        em.close();
        
        return producent;
    }
    
    public static void main(String[] args) {
        
    }
}
