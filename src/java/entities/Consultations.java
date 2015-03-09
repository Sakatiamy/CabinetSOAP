/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sakatiamy
 */
@Entity
@Table(name = "Consultations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultations.findAll", query = "SELECT c FROM Consultations c"),
    @NamedQuery(name = "Consultations.findById", query = "SELECT c FROM Consultations c WHERE c.id = :id"),
    @NamedQuery(name = "Consultations.findByDate", query = "SELECT c FROM Consultations c WHERE c.date = :date")})
public class Consultations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "id_Secretaire", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Secretaires idSecretaire;
    @JoinColumn(name = "id_Salle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Salles idSalle;
    @JoinColumn(name = "id_Patient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Patients idPatient;
    @JoinColumn(name = "id_Medecin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medecins idMedecin;

    public Consultations() {
    }

    public Consultations(Integer id) {
        this.id = id;
    }

    public Consultations(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Secretaires getIdSecretaire() {
        return idSecretaire;
    }

    public void setIdSecretaire(Secretaires idSecretaire) {
        this.idSecretaire = idSecretaire;
    }

    public Salles getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Salles idSalle) {
        this.idSalle = idSalle;
    }

    public Patients getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patients idPatient) {
        this.idPatient = idPatient;
    }

    public Medecins getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Medecins idMedecin) {
        this.idMedecin = idMedecin;
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
        if (!(object instanceof Consultations)) {
            return false;
        }
        Consultations other = (Consultations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consultations[ id=" + id + " ]";
    }
    
}
