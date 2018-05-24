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

    public Eksponat(String nazwa, String opis, Date rokPow, Date rokZak, String zdj, Model.Kategorie kategoria, Model.Loklaizacja loklaizacja, Model.Producenci pooducent) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = new Model.Eksponaty(nazwa, opis, rokPow, rokZak, zdj, kategoria, loklaizacja, pooducent);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getNazwa(String sid) throws Exception {
        int id = Integer.parseInt(sid);
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

    public void setNazwa(String sid, String nazwa) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setNazwa(nazwa);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getOpis(String sid) throws Exception {
        int id = Integer.parseInt(sid);
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

    public void setOpis(String sid, String opis) throws Exception {
        int id = Integer.parseInt(sid);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setOpis(opis);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getRokPow(String sid) throws Exception {
        int id = Integer.parseInt(sid);
        String data = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        Integer day = eksponat.getRokpow().getDate();
        String sday = day.toString();
        if (sday.length() == 1) {
            sday = "0" + sday;
        }
        
        Integer mouth = eksponat.getRokpow().getMonth();
        String smouth = mouth.toString();
        if (smouth.length() == 1) {
            smouth = "0" + smouth;
        }
        Integer year = eksponat.getRokpow().getYear()+1900;
        String syear = year.toString();
        
        data = syear+"-"+smouth+"-"+sday;
        

        em.getTransaction().commit();
        em.close();

        return data;
    }

    public void setRokPow(String sid, Date rokPow) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setRokpow(rokPow);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getRokZak(String sid) throws Exception {
         int id = Integer.parseInt(sid);
        String data = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        Integer day = eksponat.getRokzak().getDate();
        String sday = day.toString();
        if (sday.length() == 1) {
            sday = "0" + sday;
        }
        
        Integer mouth = eksponat.getRokzak().getMonth();
        String smouth = mouth.toString();
        if (smouth.length() == 1) {
            smouth = "0" + smouth;
        }
        Integer year = eksponat.getRokzak().getYear()+1900;
        String syear = year.toString();
        
        data = syear+"-"+smouth+"-"+sday;
        

        em.getTransaction().commit();
        em.close();

        return data;
    }

    public void setRokZak(String sid, Date rokZak) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        eksponat.setRokzak(rokZak);

        em.persist(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public String getZdj(String sid) throws Exception {
        int id = Integer.parseInt(sid);
        String zdj = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);
        zdj = eksponat.getZdj();

        em.getTransaction().commit();
        em.close();

        return zdj;
    }

    public List<Model.Eksponaty> getEksponaty() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT e FROM Eksponaty e");
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

    public void remove(String sid) throws Exception {
        int id = Integer.parseInt(sid);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(DbName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Model.Eksponaty eksponat = em.find(Model.Eksponaty.class, id);

        em.remove(eksponat);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
       
    }
}
