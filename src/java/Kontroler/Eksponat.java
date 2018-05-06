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
public class Eksponat {

    private static final String DbName = "MCITPU";

    public Eksponat() {

    }

    public Eksponat(String nazwa) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = new Model.Eksponaty(nazwa);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public Eksponat(String nazwa, String opis, Date rokPow, Date rokZak) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = new Model.Eksponaty(nazwa, opis, rokPow, rokZak);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public Eksponat(String nazwa, String opis, Date rokPow, Date rokZak, String zdj) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = new Model.Eksponaty(nazwa, opis, rokPow, rokZak, zdj);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(int id) throws Exception {
        String nazwa = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        nazwa = eksponat.getNazwa();

        em.getTransaction().commit();
        em.close();

        return nazwa;
    }

    public void setNazwa(int id, String nazwa) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setNazwa(nazwa);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getOpis(int id) throws Exception {
        String opis = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        opis = eksponat.getOpis();

        em.getTransaction().commit();
        em.close();

        return opis;
    }

    public void setOpis(int id, String opis) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setOpis(opis);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public Date getRokPow(int id) throws Exception {
        Date rokPow = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        rokPow = eksponat.getRokpow();

        em.getTransaction().commit();
        em.close();

        return rokPow;
    }

    public void setRokPow(int id, Date rokPow) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setRokpow(rokPow);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public Date getRokZak(int id) throws Exception {
        Date rokZak = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        rokZak = eksponat.getRokzak();

        em.getTransaction().commit();
        em.close();

        return rokZak;
    }

    public void setRokZak(int id, Date rokZak) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setRokzak(rokZak);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public List<Model.Eksponaty> getEksponaty() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT e FROM Eksponat e");
        List eksponaty = (List) q.getResultList();

        em.close();

        return eksponaty;
    }

    public Model.Eksponaty getEksponat(int id) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);

        em.close();
        
        return eksponat;
    }

    public static void main(String[] args) {

    }
}
