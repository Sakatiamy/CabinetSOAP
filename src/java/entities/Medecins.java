/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakatiamy
 */
@Entity
@Table(name = "Medecins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecins.findAll", query = "SELECT m FROM Medecins m"),
    @NamedQuery(name = "Medecins.findById", query = "SELECT m FROM Medecins m WHERE m.id = :id"),
    @NamedQuery(name = "Medecins.findByNom", query = "SELECT m FROM Medecins m WHERE m.nom = :nom"),
    @NamedQuery(name = "Medecins.findByPrenom", query = "SELECT m FROM Medecins m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Medecins.findByDateNaissance", query = "SELECT m FROM Medecins m WHERE m.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Medecins.findByAdresse", query = "SELECT m FROM Medecins m WHERE m.adresse = :adresse"),
    @NamedQuery(name = "Medecins.findByCp", query = "SELECT m FROM Medecins m WHERE m.cp = :cp"),
    @NamedQuery(name = "Medecins.findByVille", query = "SELECT m FROM Medecins m WHERE m.ville = :ville"),
    @NamedQuery(name = "Medecins.findByTel", query = "SELECT m FROM Medecins m WHERE m.tel = :tel")})
public class Medecins implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Naissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CP")
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Ville")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Tel")
    private String tel;
    @JoinColumn(name = "id_specialite", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Specialites idSpecialite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedecin")
    private Collection<Consultations> consultationsCollection;

    public Medecins() {
    }

    public Medecins(Integer id) {
        this.id = id;
    }

    public Medecins(Integer id, String nom, String prenom, Date dateNaissance, String adresse, String cp, String ville, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.tel = tel;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Specialites getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Specialites idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    @XmlTransient
    public Collection<Consultations> getConsultationsCollection() {
        return consultationsCollection;
    }

    public void setConsultationsCollection(Collection<Consultations> consultationsCollection) {
        this.consultationsCollection = consultationsCollection;
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
        if (!(object instanceof Medecins)) {
            return false;
        }
        Medecins other = (Medecins) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Medecins[ id=" + id + " ]";
    }
    
}
