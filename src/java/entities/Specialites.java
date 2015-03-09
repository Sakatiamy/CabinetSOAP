/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakatiamy
 */
@Entity
@Table(name = "Specialites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialites.findAll", query = "SELECT s FROM Specialites s"),
    @NamedQuery(name = "Specialites.findById", query = "SELECT s FROM Specialites s WHERE s.id = :id"),
    @NamedQuery(name = "Specialites.findByNom", query = "SELECT s FROM Specialites s WHERE s.nom = :nom")})
public class Specialites implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Nom")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSpecialite")
    private Collection<Medecins> medecinsCollection;

    public Specialites() {
    }

    public Specialites(Integer id) {
        this.id = id;
    }

    public Specialites(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Medecins> getMedecinsCollection() {
        return medecinsCollection;
    }

    public void setMedecinsCollection(Collection<Medecins> medecinsCollection) {
        this.medecinsCollection = medecinsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialites)) {
            return false;
        }
        Specialites other = (Specialites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Specialites[ id=" + id + " ]";
    }
    
}
