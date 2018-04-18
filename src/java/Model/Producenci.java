/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sylwester
 */
@Entity
@Table(name = "producenci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producenci.findAll", query = "SELECT p FROM Producenci p")
    , @NamedQuery(name = "Producenci.findByIdProducent", query = "SELECT p FROM Producenci p WHERE p.idProducent = :idProducent")
    , @NamedQuery(name = "Producenci.findByNazwa", query = "SELECT p FROM Producenci p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Producenci.findByOpis", query = "SELECT p FROM Producenci p WHERE p.opis = :opis")
    , @NamedQuery(name = "Producenci.findByRokpow", query = "SELECT p FROM Producenci p WHERE p.rokpow = :rokpow")
    , @NamedQuery(name = "Producenci.findByRokzak", query = "SELECT p FROM Producenci p WHERE p.rokzak = :rokzak")})
public class Producenci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producent")
    private Integer idProducent;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "opis")
    private String opis;
    @Column(name = "rokpow")
    @Temporal(TemporalType.DATE)
    private Date rokpow;
    @Column(name = "rokzak")
    @Temporal(TemporalType.DATE)
    private Date rokzak;
    @OneToMany(mappedBy = "pooducent")
    private Collection<Eksponaty> eksponatyCollection;

    public Producenci() {
    }

    public Producenci(Integer idProducent) {
        this.idProducent = idProducent;
    }

    public Producenci(Integer idProducent, String nazwa) {
        this.idProducent = idProducent;
        this.nazwa = nazwa;
    }

    public Integer getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(Integer idProducent) {
        this.idProducent = idProducent;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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

    @XmlTransient
    public Collection<Eksponaty> getEksponatyCollection() {
        return eksponatyCollection;
    }

    public void setEksponatyCollection(Collection<Eksponaty> eksponatyCollection) {
        this.eksponatyCollection = eksponatyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducent != null ? idProducent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producenci)) {
            return false;
        }
        Producenci other = (Producenci) object;
        if ((this.idProducent == null && other.idProducent != null) || (this.idProducent != null && !this.idProducent.equals(other.idProducent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Producenci[ idProducent=" + idProducent + " ]";
    }
    
}
