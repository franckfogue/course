package bibliotheque.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


public class Exemplaire {

    private String matricule;
    private String descriptionEtat;

    private Ouvrage ouvrage;
    private Rayon rayon;

    private List<Location> lloc= new ArrayList<>();


    public Exemplaire(String matricule, String descriptionEtat,Ouvrage ouvrage) {
        this.matricule = matricule;
        this.descriptionEtat=descriptionEtat;
        this.ouvrage = ouvrage;
        this.ouvrage.getLex().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplaire that = (Exemplaire) o;
        return Objects.equals(matricule, that.matricule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule);
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDescriptionEtat() {
        return descriptionEtat;
    }

    public void setDescriptionEtat(String descriptionEtat) {
        this.descriptionEtat = descriptionEtat;
    }

     public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        if(this.rayon!=null) this.rayon.getLex().remove(this);
        this.rayon=rayon;
        this.rayon.getLex().add(this);
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "matricule='" + matricule + '\'' +
                ", descriptionEtat='" + descriptionEtat + '\'' +
                ", ouvrage=" + ouvrage +
                ", rayon=" + rayon +
                '}';
    }

    public void modifierEtat(String etat) {
        this.descriptionEtat = etat;
    }


    public Lecteur lecteurActuel() {
        for (Location location : lloc) {
            if (location.getExemplaire().equals(this) && location.getDateRestitution() == null) {
                return location.getLoueur();
            }
        }
        return null;
    }

    public List<Lecteur> lecteurs() {
        List<Lecteur> lecteurs = new ArrayList<>();
        for (Location location : lloc) {
            if (location.getExemplaire().equals(this)) {
                lecteurs.add(location.getLoueur());
            }
        }
        return lecteurs;
    }


    public void envoiMailLecteurActuel(Mail mail) {
        Lecteur lecteur = lecteurActuel();
        if (lecteur != null) {
            // Envoyer le mail au lecteur
            System.out.println("Mail envoyé au lecteur actuel: " + mail.toString());
        } else {
            System.out.println("Aucun lecteur actuellement en possession de cet exemplaire.");
        }
    }

    public void envoiMailLecteurs(Mail mail) {
        List<Lecteur> lecteurs = lecteurs();
        if (!lecteurs.isEmpty()) {
            // Envoyer le mail à tous les lecteurs
            for (Lecteur lecteur : lecteurs) {
                System.out.println("Mail envoyé au lecteur " + lecteur.getNom() + ": " + mail.toString());
            }
        } else {
            System.out.println("Aucun lecteur n'a emprunté cet exemplaire.");
        }
    }


    public boolean enRetard() {
        for (Location location : lloc) {
            if (location.getExemplaire().equals(this) && location.getDateRestitution() != null &&
                    location.getDateRestitution().isAfter(LocalDate.now())) {
                return true;
            }
        }
        return false;
    }


    public int joursRetard() {
        for (Location location : lloc) {
            if (location.getExemplaire().equals(this) && location.getDateRestitution() != null &&
                    location.getDateRestitution().isAfter(LocalDate.now())) {
                return (int) ChronoUnit.DAYS.between(location.getDateRestitution(), LocalDate.now());
            }
        }
        return 0;
    }



    public boolean enLocation() {
        for (Location location : lloc) {
            if (location.getExemplaire().equals(this) && location.getDateRestitution() == null) {
                return true;
            }
        }
        return false;
    }



    public boolean estEnLocation() {
        return !lloc.isEmpty();
    }
}
