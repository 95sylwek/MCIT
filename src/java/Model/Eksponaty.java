/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sylwester
 */
@Entity
@Table(name = "eksponaty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eksponaty.findAll", query = "SELECT e FROM Eksponaty e")
    , @NamedQuery(name = "Eksponaty.findByNazwa", query = "SELECT e FROM Eksponaty e WHERE e.nazwa = :nazwa")
    , @NamedQuery(name = "Eksponaty.findByIdEksponat", query = "SELECT e FROM Eksponaty e WHERE e.idEksponat = :idEksponat")
    , @NamedQuery(name = "Eksponaty.findByOpis", query = "SELECT e FROM Eksponaty e WHERE e.opis = :opis")
    , @NamedQuery(name = "Eksponaty.findByRokpow", query = "SELECT e FROM Eksponaty e WHERE e.rokpow = :rokpow")
    , @NamedQuery(name = "Eksponaty.findByRokzak", query = "SELECT e FROM Eksponaty e WHERE e.rokzak = :rokzak")
    , @NamedQuery(name = "Eksponaty.findByZdj", query = "SELECT e FROM Eksponaty e WHERE e.zdj = :zdj")})
public class Eksponaty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_eksponat")
    private Integer idEksponat;
    @Column(name = "opis")
    private String opis;
    @Column(name = "rokpow")
    @Temporal(TemporalType.DATE)
    private Date rokpow;
    @Column(name = "rokzak")
    @Temporal(TemporalType.DATE)
    private Date rokzak;
    @Column(name = "zdj")
    private String zdj;
    @JoinColumn(name = "kategoria", referencedColumnName = "id_kategoria")
    @ManyToOne
    private Kategorie kategoria;
    @JoinColumn(name = "loklaizacja", referencedColumnName = "id_lokalizacja")
    @ManyToOne
    private Loklaizacja loklaizacja;
    @JoinColumn(name = "pooducent", referencedColumnName = "id_producent")
    @ManyToOne
    private Producenci pooducent;

    public Eksponaty() {
    }

    public Eksponaty(Integer idEksponat) {
        this.idEksponat = idEksponat;
    }

    public Eksponaty(Integer idEksponat, String nazwa) {
        this.idEksponat = idEksponat;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getIdEksponat() {
        return idEksponat;
    }

    public void setIdEksponat(Integer idEksponat) {
        this.idEksponat = idEksponat;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getRokpow() {
        return rokpow;
    }

    public void setRokpow(Date rokpow) {
        this.rokpow = rokpow;
    }

    public Date getRokzak() {
        return rokzak;
    }

    public void setRokzak(Date rokzak) {
        this.rokzak = rokzak;
    }

    public String getZdj() {
        return zdj;
    }

    public void setZdj(String zdj) {
        this.zdj = zdj;
    }

    public Kategorie getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategorie kategoria) {
        this.kategoria = kategoria;
    }

    public Loklaizacja getLoklaizacja() {
        return loklaizacja;
    }

    public void setLoklaizacja(Loklaizacja loklaizacja) {
        this.loklaizacja = loklaizacja;
    }

    public Producenci getPooducent() {
        return pooducent;
    }

    public void setPooducent(Producenci pooducent) {
        this.pooducent = pooducent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEksponat != null ? idEksponat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eksponaty)) {
            return false;
        }
        Eksponaty other = (Eksponaty) object;
        if ((this.idEksponat == null && other.idEksponat != null) || (this.idEksponat != null && !this.idEksponat.equals(other.idEksponat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Eksponaty[ idEksponat=" + idEksponat + " ]";
    }
    
}
