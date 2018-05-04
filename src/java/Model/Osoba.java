/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sylwester
 */
@Entity
@Table(name = "osoba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o")
    , @NamedQuery(name = "Osoba.findByIdOsoba", query = "SELECT o FROM Osoba o WHERE o.idOsoba = :idOsoba")
    , @NamedQuery(name = "Osoba.findByImie", query = "SELECT o FROM Osoba o WHERE o.imie = :imie")
    , @NamedQuery(name = "Osoba.findByNazwisko", query = "SELECT o FROM Osoba o WHERE o.nazwisko = :nazwisko")
    , @NamedQuery(name = "Osoba.findByAdres", query = "SELECT o FROM Osoba o WHERE o.adres = :adres")
    , @NamedQuery(name = "Osoba.findByTelefon", query = "SELECT o FROM Osoba o WHERE o.telefon = :telefon")
    , @NamedQuery(name = "Osoba.findByEmail", query = "SELECT o FROM Osoba o WHERE o.email = :email")
    , @NamedQuery(name = "Osoba.findByHaslo", query = "SELECT o FROM Osoba o WHERE o.haslo = :haslo")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_osoba")
    private Integer idOsoba;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "adres")
    private String adres;
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "haslo")
    private String haslo;
    @JoinColumn(name = "stanowisko", referencedColumnName = "id_stanowisko")
    @ManyToOne
    private Stanowisko stanowisko;

    public Osoba() {
    }

    public Osoba(Integer idOsoba) {
        this.idOsoba = idOsoba;
    }

    public Osoba(Integer idOsoba, String email, String haslo) {
        this.idOsoba = idOsoba;
        this.email = email;
        this.haslo = haslo;
    }
    
    public Osoba(String imie, String nazwisko, String haslo, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.haslo = haslo;
        this.email = email;
    }
    
    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;
        this.haslo = haslo;
        this.email = email;        
    }

    public Osoba(String imie, String nazwisko, String adres, String telefon, String haslo, String email, Stanowisko stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.telefon = telefon;
        this.haslo = haslo;
        this.email = email;
        this.stanowisko = stanowisko;
    }

    public Integer getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(Integer idOsoba) {
        this.idOsoba = idOsoba;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOsoba != null ? idOsoba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.idOsoba == null && other.idOsoba != null) || (this.idOsoba != null && !this.idOsoba.equals(other.idOsoba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Osoba[ idOsoba=" + idOsoba + " ]";
    }
    
}
