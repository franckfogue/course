import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
/**
 * Classe métier représentant le classement d'un coureur pour une course spécifique.
 * Chaque instance de cette classe contient l'identifiant du classement, le coureur associé,
 * sa place dans la course et le gain qu'il a obtenu.
 *
 * @author Franck Fogue
 * @version 1.0
 */
public class Classement {
    /**
     * Identifiant unique du classement.
     */
    protected int idClassement;
    /**
     * coureur associé
     */
    protected Coureur coureur;
    /**
     * place obtenue
     */
    protected int place;
    /**
     * gain obtenu
     */
    protected BigDecimal gain;

    /**
     * Constructeur paramétré de la classe Classement.
     *
     * @param idClassement L'identifiant unique du classement.
     * @param coureur      Le coureur associé à ce classement.
     * @param place        La place obtenue par le coureur dans la course.
     * @param gain         Le gain monétaire obtenu par le coureur pour cette course.
     */
    public Classement(int idClassement, Coureur coureur, int place, BigDecimal gain) {
        this.idClassement = idClassement;
        this.coureur = coureur;
        this.place = place;
        this.gain = gain;
    }

    // Getters et Setters



    /**
     * Obtient l'identifiant du classement.
     *
     * @return L'identifiant du classement.
     */
    public int getIdClassement() {
        return idClassement;
    }

    /**
     * Définit l'identifiant du classement.
     *
     * @param idClassement Le nouvel identifiant du classement.
     */
    public void setIdClassement(int idClassement) {
        this.idClassement = idClassement;
    }

    /**
     * Obtient le coureur associé à ce classement.
     *
     * @return Le coureur associé à ce classement.
     */
    public Coureur getCoureur() {
        return coureur;
    }

    /**
     * Définit le coureur associé à ce classement.
     *
     * @param coureur Le nouveau coureur associé à ce classement.
     */
    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }

    /**
     * Obtient la place obtenue par le coureur dans la course.
     *
     * @return La place obtenue par le coureur dans la course.
     */
    public int getPlace() {
        return place;
    }

    /**
     * Définit la place obtenue par le coureur dans la course.
     *
     * @param place La nouvelle place obtenue par le coureur dans la course.
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * Obtient le gain monétaire obtenu par le coureur pour cette course.
     *
     * @return Le gain monétaire obtenu par le coureur pour cette course.
     */
    public BigDecimal getGain() {
        return gain;
    }

    /**
     * Définit le gain monétaire obtenu par le coureur pour cette course.
     *
     * @param gain Le nouveau gain monétaire obtenu par le coureur pour cette course.
     */
    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }
}
