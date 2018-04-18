/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sylwester
 */
@Entity
@Table(name = "stanowisko")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stanowisko.findAll", query = "SELECT s FROM Stanowisko s")
    , @NamedQuery(name = "Stanowisko.findByIdStanowisko", query = "SELECT s FROM Stanowisko s WHERE s.idStanowisko = :idStanowisko")
    , @NamedQuery(name = "Stanowisko.findByNazwa", query = "SELECT s FROM Stanowisko s WHERE s.nazwa = :nazwa")})
public class Stanowisko implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stanowisko")
    private Integer idStanowisko;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(mappedBy = "stanowisko")
    private Collection<Osoba> osobaCollection;

    public Stanowisko() {
    }

    public Stanowisko(Integer idStanowisko) {
        this.idStanowisko = idStanowisko;
    }

    public Stanowisko(Integer idStanowisko, String nazwa) {
        this.idStanowisko = idStanowisko;
        this.nazwa = nazwa;
    }

    public Integer getIdStanowisko() {
        return idStanowisko;
    }

    public void setIdStanowisko(Integer idStanowisko) {
        this.idStanowisko = idStanowisko;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<Osoba> getOsobaCollection() {
        return osobaCollection;
    }

    public void setOsobaCollection(Collection<Osoba> osobaCollection) {
        this.osobaCollection = osobaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStanowisko != null ? idStanowisko.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stanowisko)) {
            return false;
        }
        Stanowisko other = (Stanowisko) object;
        if ((this.idStanowisko == null && other.idStanowisko != null) || (this.idStanowisko != null && !this.idStanowisko.equals(other.idStanowisko))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Stanowisko[ idStanowisko=" + idStanowisko + " ]";
    }
    
}
