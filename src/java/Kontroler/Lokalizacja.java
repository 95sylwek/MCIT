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

    public String getNazwa(String sid) throws Exception {
        String name = "";
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        name = lokalizacja.getNazwa();

        em.getTransaction().commit();
        em.close();

        return name;
    }

    public void setNazwa(String sid, String name) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setNazwa(name);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public String getOpis(String sid) throws Exception {
        int id = Integer.parseInt(sid);
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

    public void setOpis(String sid, String descrip) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setOpis(descrip);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public String getDataOd(String sid) throws Exception {
        int id = Integer.parseInt(sid);
        String data = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        Integer day = lokalizacja.getDataod().getDate();
        String sday = day.toString();
        if (sday.length() == 1) {
            sday = "0" + sday;
        }

        Integer mouth = lokalizacja.getDataod().getMonth() + 1;
        String smouth = mouth.toString();
        if (smouth.length() == 1) {
            smouth = "0" + smouth;
        }
        Integer year = lokalizacja.getDataod().getYear() + 1900;
        String syear = year.toString();

        data = syear + "-" + smouth + "-" + sday;

        em.getTransaction().commit();
        em.close();

        return data;
    }

    public void setDataOd(String sid, Date dateFrom) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        lokalizacja.setDataod(dateFrom);

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public String getDataDo(String sid) throws Exception {
        int id = Integer.parseInt(sid);
        String data = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        Integer day = lokalizacja.getDatado().getDate();
        String sday = day.toString();
        if (sday.length() == 1) {
            sday = "0" + sday;
        }

        Integer mouth = lokalizacja.getDatado().getMonth() + 1;
        String smouth = mouth.toString();
        if (smouth.length() == 1) {
            smouth = "0" + smouth;
        }
        Integer year = lokalizacja.getDatado().getYear() + 1900;
        String syear = year.toString();

        data = syear + "-" + smouth + "-" + sday;

        em.getTransaction().commit();
        em.close();

        return data;
    }

    public void setDataDo(String sid, Date dateTo) throws Exception {
        int id = Integer.parseInt(sid);
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

        Query q = em.createQuery("SELECT l FROM Loklaizacja l");
        List<Model.Loklaizacja> lokalizacje = (List) q.getResultList();

        em.close();

        return lokalizacje;
    }

    public Model.Loklaizacja getLoklaizacja(String sid) throws Exception {
        int id = Integer.parseInt(sid);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);

        em.close();

        return lokalizacja;
    }

    public void remove(String sid) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);

        em.remove(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(String sid, String name, String descrip, Date dateFrom, Date dateTo) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Loklaizacja lokalizacja = em.find(Model.Loklaizacja.class, id);
        if (name != null) {
            lokalizacja.setNazwa(name);
        }
        if (descrip != null) {
            lokalizacja.setOpis(descrip);
        }
        if (dateFrom != null) {
            lokalizacja.setDatado(dateFrom);
        }
        if (dateTo != null) {
            lokalizacja.setDatado(dateTo);
        }

        em.persist(lokalizacja);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
       
    }
}
