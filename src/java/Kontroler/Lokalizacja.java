/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.Loklaizacja;
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
public class Lokalizacja {

    private static final String DbName = "MCITPU";

    public Lokalizacja() {

    }

    public Lokalizacja(String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = new Loklaizacja(name);
        em.persist(lokalizacja);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public Lokalizacja(String name, String descrip) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = new Model.Loklaizacja(name, descrip);
        em.persist(lokalizacja);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public Lokalizacja(String name, String descrip, Date dateFrom, Date dateTo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = new Model.Loklaizacja(name, descrip, dateFrom, dateTo);
        em.persist(lokalizacja);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(int id) throws Exception {
        String name = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        name = lokalizacja.getNazwa();

        em.getTransaction().commit();
        em.close();

        return name;
    }

    public void setNazwa(int id, String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setNazwa(name);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public String getOpis(int id) throws Exception {
        String descrip = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        descrip = lokalizacja.getOpis();

        em.getTransaction().commit();
        em.close();

        return descrip;
    }

    public void setOpis(int id, String descrip) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setOpis(descrip);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public Date getDataOd(int id) throws Exception {
        Date dateFrom = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        dateFrom = lokalizacja.getDataod();

        em.getTransaction().commit();
        em.close();

        return dateFrom;
    }

    public void setDataOd(int id, Date dateFrom) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setDataod(dateFrom);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public Date getDataDo(int id) throws Exception {
        Date dateTo = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        dateTo = lokalizacja.getDatado();

        em.getTransaction().commit();
        em.close();

        return dateTo;
    }

    public void setDataDo(int id, Date dateTo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setDatado(dateTo);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public List<Model.Loklaizacja> getLoklaizacje() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Lokalizacja l");
        List lokalizacje = (List) q.getResultList();

        em.close();

        return lokalizacje;
    }

    public Model.Loklaizacja getLoklaizacja(int id) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);

        em.close();

        return lokalizacja;
    }

    public static void main(String[] args) {

    }
}
