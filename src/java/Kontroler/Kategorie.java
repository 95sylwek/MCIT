/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sebastian
 */
public class Kategorie {

    private static final String DbName = "MCITPU";

    public Kategorie() {
    }

    public Kategorie(String name) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Kategorie kategoria = new Model.Kategorie(name);
        em.persist(kategoria);

        em.persist(kategoria);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(String sid) throws Exception {
        String name = "";
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Kategorie kategoria = em.find(Model.Kategorie.class, id);
        name = kategoria.getNazwa();

        em.getTransaction().commit();
        em.close();

        return name;
    }

    public void setNazwa(String sid, String name) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Kategorie kategoria = em.find(Model.Kategorie.class, id);
        kategoria.setNazwa(name);

        em.persist(kategoria);
        em.getTransaction().commit();
        em.close();
    }

    public List<Model.Kategorie> getKategorie() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT k FROM Kategorie k");
        List kategorie = (List) q.getResultList();

        em.close();

        return kategorie;
    }

    public Model.Kategorie getKategoria(String sid) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Kategorie kategoria = em.find(Model.Kategorie.class, id);

        em.close();

        return kategoria;
    }

    public static void main(String[] args) {
        try {
            Kategorie kategoria = new Kategorie();
            kategoria.getKategoria("1").getEksponatyCollection();
            for( Model.Eksponaty row :kategoria.getKategoria("1").getEksponatyCollection()){
                System.err.println(row.getNazwa());
            }
        } catch (Exception e) {
        }

    }
}
