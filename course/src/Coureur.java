import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
/**
 * classe métier de gestion d'une course
 *
 * @author Franck Fogue
 * @version 1.0
 * @see Course
 */
public class Coureur {
    /**
     * identifiant du coureur
     */
    protected int idCoureur;
    /**
     * matricule  du coureur
     */
    protected String matricule;
    /**
     * prenom du coureur
     */
    protected String prenom;
    /**
     * nom du coureur
     */
    protected String nom;
    /**
     * datenaissance coureur
     */
    protected LocalDate dateNaiss;
    /**
     * nationalité du coureur
     */
    protected String nationalite;
    /**
     * ville de residence coureur
     */
    protected String villeResidence;


    public Coureur(int idCoureur,String matricule,String prenom, String nom,LocalDate datenaiss,String nationalite,String villeResidence)
    {
        this.idCoureur=idCoureur;
        this.matricule=matricule;
        this.prenom=prenom;
        this.nom=nom;
        this.dateNaiss=datenaiss;
        this.nationalite=nationalite;
        this.villeResidence=villeResidence;
    }
    // Getters and Setters
    public int getIdCoureur() {
        return idCoureur;
    }

    public void setIdCoureur(int idCoureur) {
        this.idCoureur = idCoureur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getVilleResidence() {
        return villeResidence;
    }

    public void setVilleResidence(String villeResidence) {
        this.villeResidence = villeResidence;
    }
}
