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
 * @see Coureur
 * @see Etape
 */
public class Course {
    /**
     * identifiant unique-numéro de course
     */
    protected int courseId;
    /**
     * nom course
     */
    protected String nom;
    /**
     * pricemoney de la course
     */
    protected BigDecimal priceMoney;
    /**
     * date debut course
     */
    protected LocalDate dateDebut;
    /**
     * date fin course
     */
    protected LocalDate dateFin;
    /**
     * km total course
     */
    protected int kmTotal;
    /**
     * enssemble liste des etapes de course
     */
    protected List<Etape> etapes;
    /**
     * enssemble liste des coureur
     */
    protected List<Coureur> inscrits;
    /**
     * emssemble liste classement course
     */
    protected List<Classement> classements;
    /**
     * constructeur paramétré
     *
     * @param courseId id de la course
     * @param nom nom de la course
     * @param priceMoney pricemoney de la course
     * @param dateDebut date de debut de la course
     * @param dateFin date de fin de la course
     * @param kmTotal total km de la course
     */
    public Course(int courseId,String nom,BigDecimal priceMoney,LocalDate dateDebut,LocalDate dateFin,int kmTotal) {
        this.courseId=courseId;
        this.nom=nom;
        this.priceMoney=priceMoney;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.kmTotal=kmTotal;
        this.etapes = new ArrayList<>();
        this.inscrits = new ArrayList<>();
        this.classements = new ArrayList<>();
    }

    // Getters and Setters
    /**
     * getter courseId
     *
     * @return identifiant de la course
     */
    public int getCourseId() {
        return courseId;
    }
    /**
     * setter courseId
     *
     * @param courseId identifiant de la course
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    /**
     * getter nom
     *
     * @return nom de la course
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     *
     * @param nom de la course
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter priceMoney
     *
     * @return priceMoney de la course
     */
    public BigDecimal getPriceMoney() {
        return priceMoney;
    }
    /**
     * setter priceMoney
     *
     * @param priceMoney de la course
     */

    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }
    /**
     * getter dateDebut
     *
     * @return dateDebut
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    /**
     * getter dateFin
     *
     * @return dateFin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }
    /**
     * setter dateDebut
     *
     * @param dateDebut de la course
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    /**
     * setter dateFin
     *
     * @param dateFin de la course
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    /**
     * getter kmTotal
     *
     * @return kmTotal
     */
    public int getKmTotal() {
        return kmTotal;
    }
    /**
     * setter kmTotal
     *
     * @param kmTotal de la course
     */
    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }
    /**
     * getter liste etapes
     *
     * @return listes des etapes
     */
    public List<Etape> getEtapes() {
        return etapes;
    }
    /**
     * setter liste etapes
     *
     * @param etapes liste des etapes
     */
    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }
    /**
     * getter liste inscrits
     *
     * @return inscrits liste des inscrits
     */
    public List<Coureur> getInscrits() {
        return inscrits;
    }
    /**
     * setter liste inscrits
     *
     * @param inscrits liste des inscrits
     */
    public void setInscrits(List<Coureur> inscrits) {
        this.inscrits = inscrits;
    }
    /**
     * getter liste classement
     *
     * @return classements liste classement
     */
    public List<Classement> getClassements() {
        return classements;
    }
    /**
     * setter liste classements
     *
     * @param classements liste des classements
     */
    public void setClassements(List<Classement> classements) {
        this.classements = classements;
    }
    // Methodes
    /**
     * liste coureur ayant participe a la course
     */
    public List<Object[]> listeCoureursPlaceGain() {
        List<Object[]> resultList = new ArrayList<>();
        for (Classement classement : classements) {
            Coureur coureur = classement.getCoureur();
            int place = classement.getPlace();
            BigDecimal gain = classement.getGain();
            resultList.add(new Object[]{coureur, place, gain});
        }
        return resultList;
    }
    /**
     * total gain octroyé pour course
     * @return gain total
     */
    public BigDecimal gainTotal() {
        BigDecimal totalGain = BigDecimal.ZERO;
        for (Classement classement : classements) {
            totalGain = totalGain.add(classement.getGain());
        }
        return totalGain;
    }
    /**
     * celui qui a la meilleur place
     * @return meilleur place
     */
    public Coureur vainqueur() {
        // On cherche le classement avec la place 1
        for (Classement classement : classements) {
            if (classement.getPlace() == 1) {
                return classement.getCoureur();
            }
        }
        return null; // Aucun vainqueur trouvé
    }
    /**
     * ajout d'un coureur
     * @param coureur coureur à ajouter
     */
    public void addCoureur(Coureur coureur) {
        inscrits.add(coureur);
    }
    /**
     * suppression d'un coureur à la course
     * @param coureur coureur à supprimer
     */
    // Supprime un coureur de la liste des inscrits
    public void supCoureur(Coureur coureur) {
        inscrits.remove(coureur);
    }
    /**
     * resultat coureur
     * @param coureur coureur
     * @param place obtenu
     * @param gain gagné
     */
    public void resultat(Coureur coureur, int place, BigDecimal gain) {
        Classement newClassement = new Classement(1,coureur,place,gain);
        newClassement.setCoureur(coureur);
        newClassement.setPlace(place);
        newClassement.setGain(gain);
        classements.add(newClassement);
    }
    /**
     * modifier le classement coureur
     * @param coureur coureur
     * @param place obtenu
     * @param gain gagné
     */
    public void modif(Coureur coureur, int place, BigDecimal gain) {
        for (Classement classement : classements) {
            if (classement.getCoureur().equals(coureur)) {
                classement.setPlace(place);
                classement.setGain(gain);
                return;
            }
        }
        // Si le coureur n'existe pas dans les classements, on l'ajoute
        resultat(coureur, place, gain);
    }
    /**
     * ajouter une etape
     * @param etape etape
     */
    public void addEtape(Etape etape) {
        etapes.add(etape);
    }
    /**
     * supprimer une etape
     * @param etape etape
     */
    // Supprime une étape de la liste des étapes
    public void supEtape(Etape etape) {
        etapes.remove(etape);
    }
    /**
     * liste des villes
     */
    public List<Ville> listeVilles() {
        List<Ville> villes = new ArrayList<>();
        for (Etape etape : etapes) {
            if (!villes.contains(etape.getVilleDepart())) {
                villes.add(etape.getVilleDepart());
            }
            if (!villes.contains(etape.getVilleArrivee())) {
                villes.add(etape.getVilleArrivee());
            }
        }
        return villes;
    }
    /**
     * vérifie si le classement de tous les coureurs inscrits à la course ont été enregistré
     */
    public boolean classementComplet() {
        for (Coureur coureur : inscrits) {
            boolean hasClassement = false;
            for (Classement classement : classements) {
                if (classement.getCoureur().equals(coureur)) {
                    hasClassement = true;
                    break;
                }
            }
            if (!hasClassement) {
                return false;
            }
        }
        return true;
    }
}

