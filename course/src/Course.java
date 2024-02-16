import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Course {
    protected int courseId;
    protected String nom;
    protected BigDecimal priceMoney;
    protected Date dateDebut;
    protected Date dateFin;
    protected int kmTotal;
    protected List<Etape> etapes;
    protected List<Coureur> inscrits;
    protected List<Classement> classements;
    public Course() {
        this.etapes = new ArrayList<>();
        this.inscrits = new ArrayList<>();
        this.classements = new ArrayList<>();
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getKmTotal() {
        return kmTotal;
    }

    public void setKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<Etape> etapes) {
        this.etapes = etapes;
    }

    public List<Coureur> getInscrits() {
        return inscrits;
    }

    public void setInscrits(List<Coureur> inscrits) {
        this.inscrits = inscrits;
    }
    public List<Classement> getClassements() {
        return classements;
    }

    public void setClassements(List<Classement> classements) {
        this.classements = classements;
    }
    // Methodes
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

    public BigDecimal gainTotal() {
        BigDecimal totalGain = BigDecimal.ZERO;
        for (Classement classement : classements) {
            totalGain = totalGain.add(classement.getGain());
        }
        return totalGain;
    }
    public Coureur vainqueur() {
        // On cherche le classement avec la place 1
        for (Classement classement : classements) {
            if (classement.getPlace() == 1) {
                return classement.getCoureur();
            }
        }
        return null; // Aucun vainqueur trouvé
    }
    public void addCoureur(Coureur coureur) {
        inscrits.add(coureur);
    }

    // Supprime un coureur de la liste des inscrits
    public void supCoureur(Coureur coureur) {
        inscrits.remove(coureur);
    }
    public void resultat(Coureur coureur, int place, BigDecimal gain) {
        Classement newClassement = new Classement();
        newClassement.setCoureur(coureur);
        newClassement.setPlace(place);
        newClassement.setGain(gain);
        classements.add(newClassement);
    }

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
    public void addEtape(Etape etape) {
        etapes.add(etape);
    }

    // Supprime une étape de la liste des étapes
    public void supEtape(Etape etape) {
        etapes.remove(etape);
    }
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

