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
public class Osoba {

    private static final String DbName = "MCITPU";

    public Osoba() {

    }

    public Osoba(String imie, String nazwisko, String haslo, String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, haslo, email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, adres, telefon, haslo, email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email, Model.Stanowisko stanowisko) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, adres, telefon, haslo, email, stanowisko);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getImie(int id) throws Exception {
        String imie = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        imie = osoba.getImie();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return imie;
    }

    public void setImie(int id, String imie) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setImie(imie);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwisko(int id) throws Exception {
        String nazwisko = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        nazwisko = osoba.getNazwisko();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return nazwisko;
    }

    public void setNazwisko(int id, String nazwisko) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setNazwisko(nazwisko);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getAdres(int id) throws Exception {
        String adres = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        adres = osoba.getAdres();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return adres;
    }

    public void setAdres(int id, String adres) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setAdres(adres);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getTelefon(int id) throws Exception {
        String telefon = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        telefon = osoba.getTelefon();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return telefon;
    }

    public void setTelefon(int id, String telefon) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setTelefon(telefon);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getHaslo(int id) throws Exception {
        String haslo = "";

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        haslo = osoba.getHaslo();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return haslo;
    }

    public void setHaslo(int id, String haslo) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setHaslo(haslo);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getEmail(int id) throws Exception {
        String email = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        email = osoba.getEmail();

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();

        return email;
    }

    public void setEmail(int id, String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setEmail(email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void main(String[] args) {
        
    }
}
