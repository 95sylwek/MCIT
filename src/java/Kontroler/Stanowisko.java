/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class Stanowisko {

    private static final String DbName = "MCITPU";

    public Stanowisko() {

    }

    public Stanowisko(String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Stanowisko stanowisko = new Model.Stanowisko(name);

        em.persist(stanowisko);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(int id) throws Exception {
        String name = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Stanowisko stanowisko = em.find(Model.Stanowisko.class, id);
        name = stanowisko.getNazwa();

        em.getTransaction().commit();
        em.close();

        return name;
    }

    public void setNazwa(int id, String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Stanowisko stanowisko = em.find(Model.Stanowisko.class, id);
        stanowisko.setNazwa(name);

        em.persist(stanowisko);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        try {
            Stanowisko stanowisko = new Stanowisko();
            System.out.println(stanowisko.getNazwa(1));
        } catch (Exception e) {
            //System.err.println(e.getMessage());
        }

    }
}
