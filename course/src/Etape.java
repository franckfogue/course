import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

/**
 * Classe représentant les étapes d'une course.
 * Chaque instance de cette classe contient des informations sur une étape spécifique d'une course,
 * telles que son identifiant, son numéro, sa description, sa date, sa distance, les villes de départ et d'arrivée,
 * ainsi que la course à laquelle elle appartient.
 *
 *@see Ville
 * @see Course
 *
 * @author Franck Fogue
 */
public class Etape {
    /**
     * Identifiant unique de l'etape
     */
    protected int idEtape;
    /**
     * numero de l'etape
     */
    protected int numero;
    /**
     * description de l'etape
     */
    protected String description;
    /**
     * date de l'Etape
     */
    protected LocalDate dateEtape;
    /**
     *  La distance de l'étape.
     */
    protected int km;
    /**
     *  La ville de départ de l'étape.
     */
    protected Ville villeDepart;
    /**
     *  La ville de arrivée de l'étape.
     */
    protected Ville villeArrivee;
    /**
     *  La course à laquelle appartient cette étape.
     */
    protected Course course;

    /**
     * Constructeur paramétré de la classe Etape.
     *
     * @param idEtape       L'identifiant unique de l'étape.
     * @param numero        Le numéro de l'étape.
     * @param description   La description de l'étape.
     * @param dateEtape     La date de l'étape.
     * @param km            La distance de l'étape.
     * @param villeDepart   La ville de départ de l'étape.
     * @param villeArrivee  La ville d'arrivée de l'étape.
     * @param course        La course à laquelle appartient cette étape.
     */
    public Etape(int idEtape, int numero, String description, LocalDate dateEtape, int km,
                 Ville villeDepart, Ville villeArrivee, Course course) {
        this.idEtape = idEtape;
        this.numero = numero;
        this.description = description;
        this.dateEtape = dateEtape;
        this.km = km;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.course = course;
    }

    // Getters et Setters pour la classe Etape

    /**
     * Obtient l'identifiant de l'étape.
     *
     * @return L'identifiant de l'étape.
     */
    public int getIdEtape() {
        return idEtape;
    }

    /**
     * Définit l'identifiant de l'étape.
     *
     * @param idEtape Le nouvel identifiant de l'étape.
     */
    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }

    /**
     * Obtient le numéro de l'étape.
     *
     * @return Le numéro de l'étape.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Définit le numéro de l'étape.
     *
     * @param numero Le nouveau numéro de l'étape.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtient la description de l'étape.
     *
     * @return La description de l'étape.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description de l'étape.
     *
     * @param description La nouvelle description de l'étape.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtient la date de l'étape.
     *
     * @return La date de l'étape.
     */
    public LocalDate getDateEtape() {
        return dateEtape;
    }

    /**
     * Définit la date de l'étape.
     *
     * @param dateEtape La nouvelle date de l'étape.
     */
    public void setDateEtape(LocalDate dateEtape) {
        this.dateEtape = dateEtape;
    }

    /**
     * Obtient la distance de l'étape.
     *
     * @return La distance de l'étape.
     */
    public int getKm() {
        return km;
    }

    /**
     * Définit la distance de l'étape.
     *
     * @param km La nouvelle distance de l'étape.
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Obtient la ville de départ de l'étape.
     *
     * @return La ville de départ de l'étape.
     */
    public Ville getVilleDepart() {
        return villeDepart;
    }

    /**
     * Définit la ville de départ de l'étape.
     *
     * @param villeDepart La nouvelle ville de départ de l'étape.
     */
    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    /**
     * Obtient la ville d'arrivée de l'étape.
     *
     * @return La ville d'arrivée de l'étape.
     */
    public Ville getVilleArrivee() {
        return villeArrivee;
    }

    /**
     * Définit la ville d'arrivée de l'étape.
     *
     * @param villeArrivee La nouvelle ville d'arrivée de l'étape.
     */
    public void setVilleArrivee(Ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

}
