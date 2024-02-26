import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * Classe représentant une ville avec ses coordonnées géographiques.
 * Cette classe permet de stocker des informations sur une ville, telles que son identifiant unique,
 * son nom, sa latitude, sa longitude et le pays dans lequel elle se trouve.
 *
 * @author Franck Fogue
 * @version 1.0
 */
public class Ville {
    /**
     * Identifiant unique de la ville.
     */
    protected int idVille;
    /**
     * Nom de la ville.
     */
    protected String nom;
    /**
     * Latitude de la ville.
     */
    protected double latitude;
    /**
     * Longitude de la ville.
     */
    protected double longitude;
    /**
     * Pays dans lequel se trouve la ville.
     */
    protected String pays;

    /**
     * Constructeur paramétré de la classe Ville.
     *
     * @param idVille   Identifiant de la ville.
     * @param nom       Nom de la ville.
     * @param latitude  Latitude de la ville.
     * @param longitude Longitude de la ville.
     * @param pays      Pays dans lequel se trouve la ville.
     */
    public Ville(int idVille, String nom, double latitude, double longitude, String pays) {
        this.idVille = idVille;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pays = pays;
    }

    // Getters et Setters

    /**
     * Obtient l'identifiant de la ville.
     *
     * @return L'identifiant de la ville.
     */
    public int getIdVille() {
        return idVille;
    }

    /**
     * Définit l'identifiant de la ville.
     *
     * @param idVille Le nouvel identifiant de la ville.
     */
    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    /**
     * Obtient le nom de la ville.
     *
     * @return Le nom de la ville.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la ville.
     *
     * @param nom Le nouveau nom de la ville.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient la latitude de la ville.
     *
     * @return La latitude de la ville.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Définit la latitude de la ville.
     *
     * @param latitude La nouvelle latitude de la ville.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Obtient la longitude de la ville.
     *
     * @return La longitude de la ville.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Définit la longitude de la ville.
     *
     * @param longitude La nouvelle longitude de la ville.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Obtient le pays dans lequel se trouve la ville.
     *
     * @return Le pays dans lequel se trouve la ville.
     */
    public String getPays() {
        return pays;
    }

    /**
     * Définit le pays dans lequel se trouve la ville.
     *
     * @param pays Le nouveau pays dans lequel se trouve la ville.
     */
    public void setPays(String pays) {
        this.pays = pays;
    }
}
