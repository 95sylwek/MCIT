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
@Table(name = "loklaizacja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loklaizacja.findAll", query = "SELECT l FROM Loklaizacja l")
    , @NamedQuery(name = "Loklaizacja.findByIdLokalizacja", query = "SELECT l FROM Loklaizacja l WHERE l.idLokalizacja = :idLokalizacja")
    , @NamedQuery(name = "Loklaizacja.findByNazwa", query = "SELECT l FROM Loklaizacja l WHERE l.nazwa = :nazwa")
    , @NamedQuery(name = "Loklaizacja.findByOpis", query = "SELECT l FROM Loklaizacja l WHERE l.opis = :opis")
    , @NamedQuery(name = "Loklaizacja.findByDataod", query = "SELECT l FROM Loklaizacja l WHERE l.dataod = :dataod")
    , @NamedQuery(name = "Loklaizacja.findByDatado", query = "SELECT l FROM Loklaizacja l WHERE l.datado = :datado")})
public class Loklaizacja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lokalizacja")
    private Integer idLokalizacja;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "opis")
    private String opis;
    @Column(name = "dataod")
    @Temporal(TemporalType.DATE)
    private Date dataod;
    @Column(name = "datado")
    @Temporal(TemporalType.DATE)
    private Date datado;
    @OneToMany(mappedBy = "loklaizacja")
    private Collection<Eksponaty> eksponatyCollection;

    public Loklaizacja() {
    }

    public Loklaizacja(Integer idLokalizacja) {
        this.idLokalizacja = idLokalizacja;
    }

    public Loklaizacja(Integer idLokalizacja, String nazwa) {
        this.idLokalizacja = idLokalizacja;
        this.nazwa = nazwa;
    }

    public Integer getIdLokalizacja() {
        return idLokalizacja;
    }

    public void setIdLokalizacja(Integer idLokalizacja) {
        this.idLokalizacja = idLokalizacja;
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

    public Date getDataod() {
        return dataod;
    }

    public void setDataod(Date dataod) {
        this.dataod = dataod;
    }

    public Date getDatado() {
        return datado;
    }

    public void setDatado(Date datado) {
        this.datado = datado;
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
        hash += (idLokalizacja != null ? idLokalizacja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loklaizacja)) {
            return false;
        }
        Loklaizacja other = (Loklaizacja) object;
        if ((this.idLokalizacja == null && other.idLokalizacja != null) || (this.idLokalizacja != null && !this.idLokalizacja.equals(other.idLokalizacja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Loklaizacja[ idLokalizacja=" + idLokalizacja + " ]";
    }
    
}
