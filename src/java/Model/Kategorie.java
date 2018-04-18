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
@Table(name = "kategorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorie.findAll", query = "SELECT k FROM Kategorie k")
    , @NamedQuery(name = "Kategorie.findByIdKategoria", query = "SELECT k FROM Kategorie k WHERE k.idKategoria = :idKategoria")
    , @NamedQuery(name = "Kategorie.findByNazwa", query = "SELECT k FROM Kategorie k WHERE k.nazwa = :nazwa")
    , @NamedQuery(name = "Kategorie.findByOpis", query = "SELECT k FROM Kategorie k WHERE k.opis = :opis")})
public class Kategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kategoria")
    private Integer idKategoria;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "opis")
    private String opis;
    @OneToMany(mappedBy = "kategoria")
    private Collection<Eksponaty> eksponatyCollection;

    public Kategorie() {
    }

    public Kategorie(Integer idKategoria) {
        this.idKategoria = idKategoria;
    }

    public Kategorie(Integer idKategoria, String nazwa) {
        this.idKategoria = idKategoria;
        this.nazwa = nazwa;
    }

    public Integer getIdKategoria() {
        return idKategoria;
    }

    public void setIdKategoria(Integer idKategoria) {
        this.idKategoria = idKategoria;
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
        hash += (idKategoria != null ? idKategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorie)) {
            return false;
        }
        Kategorie other = (Kategorie) object;
        if ((this.idKategoria == null && other.idKategoria != null) || (this.idKategoria != null && !this.idKategoria.equals(other.idKategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Kategorie[ idKategoria=" + idKategoria + " ]";
    }
    
}
