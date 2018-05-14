/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

        String password = encryptPassword(haslo);
        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, password, email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String password = encryptPassword(haslo);
        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, adres, telefon, password, email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email, Model.Stanowisko stanowisko) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String password = encryptPassword(haslo);
        Model.Osoba osoba = new Model.Osoba(imie, nazwisko, adres, telefon, password, email, stanowisko);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getImie(String sid) throws Exception {
        String imie = "";
        int id =Integer.parseInt(sid);

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

    public void setImie(String sid, String imie) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setImie(imie);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwisko(String sid) throws Exception {
        String nazwisko = "";
        int id =Integer.parseInt(sid);

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

    public void setNazwisko(String sid, String nazwisko) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setNazwisko(nazwisko);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getAdres(String sid) throws Exception {
        String adres = "";
        int id =Integer.parseInt(sid);

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

    public void setAdres(String sid, String adres) throws Exception {
        int id =Integer.parseInt(sid);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setAdres(adres);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getTelefon(String sid) throws Exception {
        String telefon = "";
        int id =Integer.parseInt(sid);

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

    public void setTelefon(String sid, String telefon) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setTelefon(telefon);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    private String getHaslo(String sid) throws Exception {
        String haslo = "";
        int id =Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        haslo = osoba.getHaslo();

        em.getTransaction().commit();
        em.close();

        return haslo;
    }

    public void setHaslo(String sid, String haslo) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        String password = encryptPassword(haslo);
        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setHaslo(password);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    public String getEmail(String sid) throws Exception {
        String email = null;
        int id =Integer.parseInt(sid);

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

    public void setEmail(String sid, String email) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);
        osoba.setEmail(email);

        em.persist(osoba);
        em.getTransaction().commit();
        em.close();
    }

    private static String encryptPassword(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (Exception e) {
            e.printStackTrace();

        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public Model.Osoba checkUser(String email, String password) throws Exception {
        Model.Osoba osoba = null;
        password = encryptPassword(password);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("SELECT o FROM Osoba o WHERE o.email = '" + email + "'");

        if (q.getSingleResult() != null) {
            
            osoba = (Model.Osoba) q.getSingleResult();
            if (!osoba.getHaslo().equals(password)) {
                osoba = null;
            }
        } else {
            osoba = null;
        }
        System.out.print("dziala");

        em.getTransaction().commit();
        em.close();

        return osoba;
    }

    public List<Model.Osoba> getOsoby() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT o FROM Osoba o");
        List osoby = (List) q.getResultList();

        em.close();
        
        return osoby;
    }
    
    public Model.Osoba getOsoba(String sid) throws Exception {
        int id =Integer.parseInt(sid);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Osoba osoba = em.find(Model.Osoba.class, id);

        em.close();

        return osoba;
    }

    public static void main(String[] args) {
        String password = "CosTam12";
        try {           
          //  Osoba osoba = new Osoba("wolontariusz", "wolontariusz", "wolontariusz", "wolontariusz@wolontariusz.pl");
            
            
            
        } catch (Exception e) {
        }

    }
}
