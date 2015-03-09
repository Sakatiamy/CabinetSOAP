/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.ConsultationsFacade;
import beans.MedecinsFacade;
import beans.PatientsFacade;
import beans.SallesFacade;
import beans.SecretairesFacade;
import beans.SpecialitesFacade;
import entities.Consultations;
import entities.Medecins;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import entities.Patients;
import entities.Salles;
import entities.Secretaires;
import entities.Specialites;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sakatiamy
 */
@WebService(serviceName = "CabinetSOAP")
public class CabinetSOAP {

    @EJB
    private SallesFacade sallesFacade;
    @EJB
    private ConsultationsFacade consultationsFacade;
    @EJB
    private MedecinsFacade medecinsFacade;
    @EJB
    private PatientsFacade patientsFacade;
    @EJB
    private SecretairesFacade secretairesFacade;
    @EJB
    private SpecialitesFacade specialitesFacade;

    /**
     * Consultations
     */
    @WebMethod(operationName = "getConsultations")
    public List<Consultations> getConsultations() {
        return consultationsFacade.findAll();
    }

    @WebMethod(operationName = "getConsultation")
    public Consultations getConsultation(@WebParam(name = "id") int id) {
        return consultationsFacade.find(id);
    }

    @WebMethod(operationName = "deleteConsultation")
    public void deleteConsultation(@WebParam(name = "id") int id) {
        Consultations consultation = new Consultations();
        for (Consultations p : consultationsFacade.findAll()) {
            if (p.getId() == id) {
                consultation = p;
            }
        }
        consultationsFacade.remove(consultation);
    }

    @WebMethod(operationName = "createConsultation")
    public void createConsultation(@WebParam(name = "idMedecin") int idMedecin,
            @WebParam(name = "idPatient") int idPatient,
            @WebParam(name = "idSalle") int idSalle,
            @WebParam(name = "idSecretaire") int idSecretaire,
            @WebParam(name = "date") Date date) {
        Consultations consultation = new Consultations();
        consultation.setIdMedecin(getMedecin(idMedecin));
        consultation.setIdPatient(getPatient(idPatient));
        consultation.setIdSalle(getSalle(idSalle));
        consultation.setIdSecretaire(getSecretaire(idSecretaire));
        consultation.setDate(date);
        consultationsFacade.create(consultation);
    }
    
    @WebMethod(operationName = "updateConsultation")
    public void updateConsultation(@WebParam(name = "id") int id, @WebParam(name = "idMedecin") int idMedecin,
            @WebParam(name = "idPatient") int idPatient,
            @WebParam(name = "idSalle") int idSalle,
            @WebParam(name = "idSecretaire") int idSecretaire,
            @WebParam(name = "date") Date date) {
        Consultations consultation = getConsultation(id);
        consultation.setIdMedecin(getMedecin(idMedecin));
        consultation.setIdPatient(getPatient(idPatient));
        consultation.setIdSalle(getSalle(idSalle));
        consultation.setIdSecretaire(getSecretaire(idSecretaire));
        consultation.setDate(date);
        consultationsFacade.edit(consultation);
    }

    /**
     * Medecins
     */
    @WebMethod(operationName = "getMedecin")
    public Medecins getMedecin(@WebParam(name = "id") int id) {
        return medecinsFacade.find(id);
    }

    @WebMethod(operationName = "getMedecins")
    public List<Medecins> getMedecins() {
        return medecinsFacade.findAll();
    }
       
    @WebMethod(operationName = "deleteMedecin")
    public void deleteMedecin(@WebParam(name = "id") int id) {
        Medecins medecin = new Medecins();
        for (Medecins p : medecinsFacade.findAll()) {
            if (p.getId() == id) {
                medecin = p;
            }
        }
        medecinsFacade.remove(medecin);
    }

    @WebMethod(operationName = "createMedecin")
    public void createMedecin(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "idSpecialite") int idSpecialite,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Medecins medecin = new Medecins();
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setDateNaissance(dateNaissance);
        medecin.setIdSpecialite(getSpecialite(idSpecialite));
        medecin.setAdresse(adresse);
        medecin.setVille(ville);
        medecin.setCp(cp);
        medecin.setTel(tel);
        medecinsFacade.create(medecin);
    }

    @WebMethod(operationName = "updateMedecin")
    public void updateMedecin(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "idSpecialite") int idSpecialite,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Medecins medecin = getMedecin(id);
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setDateNaissance(dateNaissance);
        medecin.setIdSpecialite(getSpecialite(idSpecialite));
        medecin.setAdresse(adresse);
        medecin.setVille(ville);
        medecin.setCp(cp);
        medecin.setTel(tel);
        medecinsFacade.edit(medecin);
    }

    /**
     * Patients
     */
    @WebMethod(operationName = "getPatients")
    public List<Patients> getPatients() {
        return patientsFacade.findAll();
    }

    @WebMethod(operationName = "getPatient")
    public Patients getPatient(@WebParam(name = "id") int id) {
        return patientsFacade.find(id);
    }

    @WebMethod(operationName = "deletePatient")
    public void deletePatient(@WebParam(name = "id") int id) {
        Patients patient = new Patients();
        for (Patients p : patientsFacade.findAll()) {
            if (p.getId() == id) {
                patient = p;
            }
        }
        patientsFacade.remove(patient);
    }

    @WebMethod(operationName = "createPatient")
    public void createPatient(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Patients patient = new Patients();
        patient.setNom(nom);
        patient.setPrenom(prenom);
        System.out.println(dateNaissance);
        patient.setDateNaissance(dateNaissance);
        patient.setAdresse(adresse);
        patient.setVille(ville);
        patient.setCp(cp);
        patient.setTel(tel);
        patientsFacade.create(patient);
    }

    @WebMethod(operationName = "updatePatient")
    public void updatePatient(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Patients patient = getPatient(id);
        patient.setNom(nom);
        patient.setPrenom(prenom);
        patient.setDateNaissance(dateNaissance);
        patient.setAdresse(adresse);
        patient.setVille(ville);
        patient.setCp(cp);
        patient.setTel(tel);
        patientsFacade.edit(patient);
    }

    /**
     * Salles
     */
    @WebMethod(operationName = "getSalles")
    public List<Salles> getSalles() {
        return sallesFacade.findAll();
    }

    @WebMethod(operationName = "getSalle")
    public Salles getSalle(@WebParam(name = "id") int id) {
        return sallesFacade.find(id);
    }

    @WebMethod(operationName = "deleteSalle")
    public void deleteSalle(@WebParam(name = "id") int id) {
        Salles salle = new Salles();
        for (Salles p : sallesFacade.findAll()) {
            if (p.getId() == id) {
                salle = p;
            }
        }
        sallesFacade.remove(salle);
    }

    @WebMethod(operationName = "createSalle")
    public void createSalle(@WebParam(name = "nom") String nom) {
        Salles salle = new Salles();
        salle.setNom(nom);
        sallesFacade.create(salle);
    }

    @WebMethod(operationName = "updateSalle")
    public void updateSalle(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom) {
        Salles salle = getSalle(id);
        salle.setNom(nom);
        sallesFacade.edit(salle);
    }

    /**
     * Secretaires
     */
    @WebMethod(operationName = "getSecretaire")
    public Secretaires getSecretaire(@WebParam(name = "id") int id) {
        return secretairesFacade.find(id);
    }

    @WebMethod(operationName = "getSecretaires")
    public List<Secretaires> getSecretaires() {
        return secretairesFacade.findAll();
    }

    @WebMethod(operationName = "deleteSecretaire")
    public void deleteSecretaire(@WebParam(name = "id") int id) {
        Secretaires secretaire = new Secretaires();
        for (Secretaires p : secretairesFacade.findAll()) {
            if (p.getId() == id) {
                secretaire = p;
            }
        }
        secretairesFacade.remove(secretaire);
    }

    @WebMethod(operationName = "createSecretaire")
    public void createSecretaire(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Secretaires secretaire = new Secretaires();
        secretaire.setNom(nom);
        secretaire.setPrenom(prenom);
        secretaire.setDateNaissance(dateNaissance);
        secretaire.setAdresse(adresse);
        secretaire.setVille(ville);
        secretaire.setCp(cp);
        secretaire.setTel(tel);
        secretairesFacade.create(secretaire);
    }

    @WebMethod(operationName = "updateSecretaire")
    public void updateSecretaire(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
            @WebParam(name = "dateNaissance") Date dateNaissance,
            @WebParam(name = "adresse") String adresse,
            @WebParam(name = "ville") String ville,
            @WebParam(name = "cp") String cp, @WebParam(name = "tel") String tel) {
        Secretaires secretaire = getSecretaire(id);
        secretaire.setNom(nom);
        secretaire.setPrenom(prenom);
        secretaire.setDateNaissance(dateNaissance);
        secretaire.setAdresse(adresse);
        secretaire.setVille(ville);
        secretaire.setCp(cp);
        secretaire.setTel(tel);
        secretairesFacade.edit(secretaire);
    }

    /**
     * Specialite
     */
    @WebMethod(operationName = "getSpecialites")
    public List<Specialites> getSpecialites() {
        return specialitesFacade.findAll();
    }

    @WebMethod(operationName = "getSpecialite")
    public Specialites getSpecialite(@WebParam(name = "id") int id) {
        return specialitesFacade.find(id);
    }

    @WebMethod(operationName = "deleteSpecialite")
    public void deleteSpecialite(@WebParam(name = "id") int id) {
        Specialites specialite = new Specialites();
        for (Specialites p : specialitesFacade.findAll()) {
            if (p.getId() == id) {
                specialite = p;
            }
        }
        specialitesFacade.remove(specialite);
    }

    @WebMethod(operationName = "createSpecialite")
    public void createSpecialite(@WebParam(name = "nom") String nom) {
        Specialites specialite = new Specialites();
        specialite.setNom(nom);
        specialitesFacade.create(specialite);
    }

    @WebMethod(operationName = "updateSpecialite")
    public void updateSpecialite(@WebParam(name = "id") int id,
            @WebParam(name = "nom") String nom) {
        Specialites specialite = getSpecialite(id);
        specialite.setNom(nom);
        specialitesFacade.edit(specialite);
    }
}
