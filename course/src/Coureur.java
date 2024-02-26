import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
/**
 * classe métier de gestion d'un coureur
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

    /**
     * constructeur paramétré
     *
     * @param idCoureur identifiant unique du coureur, affecté par la base de
     * données
     * @param matricule  du coureur
     * @param prenom prénom du coureur
     * @param nom nom du coureur
     * @param datenaiss date de naissance du coureur
     * @param nationalite nationalite du coureur
     * @param villeResidence ville de residence du coureur
     */
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
    /**
     * getter idCoureur
     *
     * @return identifiant du coureur
     */
    public int getIdCoureur() {
        return idCoureur;
    }
    /**
     * setter idCoureur
     *
     * @param idCoureur identifiant du coureur
     */
    public void setIdCoureur(int idCoureur) {
        this.idCoureur = idCoureur;
    }

    /**
     * getter matricule
     *
     * @return matricule
     */
    public String getMatricule() {
        return matricule;
    }
    /**
     * setter matricule
     *
     * @param matricule matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter prenom
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     *
     * @param prenom prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter nom
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     *
     * @param nom nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter date naissance
     *
     * @return dateNaiss
     */
    public LocalDate getDateNaiss() {
        return dateNaiss;
    }
    /**
     * setter datenaissance
     *
     * @param dateNaiss date naissance
     */
    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
    /**
     * getter nationalite
     *
     * @return nationalite
     */
    public String getNationalite() {
        return nationalite;
    }
    /**
     * setter nationalite
     *
     * @param nationalite nationalite
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    /**
     * getter ville residence
     *
     * @return villeResidence
     */
    public String getVilleResidence() {
        return villeResidence;
    }
    /**
     * setter ville residence
     *
     * @param villeResidence ville residence
     */
    public void setVilleResidence(String villeResidence) {
        this.villeResidence = villeResidence;
    }
}
