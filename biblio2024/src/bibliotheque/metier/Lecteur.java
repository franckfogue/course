package bibliotheque.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
public class Lecteur {
    private int numlecteur;
    private  String nom,prenom;
    private LocalDate dn;
    private String adresse;
    private String mail;
    private String tel;

    private List<Location> lloc=new ArrayList<>();

    public Lecteur(int numlecteur, String nom, String prenom, LocalDate dn, String adresse, String mail, String tel) {
        this.numlecteur = numlecteur;
        this.nom = nom;
        this.prenom = prenom;
        this.dn = dn;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
    }

    public int getNumlecteur() {
        return numlecteur;
    }

    public void setNumlecteur(int numlecteur) {
        this.numlecteur = numlecteur;
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

    public LocalDate getDn() {
        return dn;
    }

    public void setDn(LocalDate dn) {
        this.dn = dn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Location> getLloc() {
        return lloc;
    }

    public void setLloc(List<Location> lloc) {
        this.lloc = lloc;
    }

    @Override
    public String toString() {
        return "Lecteur{" +
                "numlecteur=" + numlecteur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dn=" + dn +
                ", adresse='" + adresse + '\'' +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecteur lecteur = (Lecteur) o;
        return numlecteur == lecteur.numlecteur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numlecteur);
    }

    public List<Exemplaire> listerExemplairesEnLocation(){
        List<Exemplaire> lex = new ArrayList<>();
        for(Location loc : lloc){
            if(loc.getDateRestitution()!=null)lex.add(loc.getExemplaire());
        }
        return lex;
    }

    public List<Exemplaire> listerExemplairesLoues() {
        List<Exemplaire> lex = new ArrayList<>();
        Set<Exemplaire> exemplairesAjoutes = new HashSet<>(); // Ensemble pour empêcher les doublons

        for (Location loc : lloc) {
            Exemplaire exemplaire = loc.getExemplaire();
            // Vérifier si l'exemplaire a déjà été ajouté à la liste
            if (!exemplairesAjoutes.contains(exemplaire)) {
                lex.add(exemplaire);
                exemplairesAjoutes.add(exemplaire); // Ajouter l'exemplaire à l'ensemble
            }
        }

        return lex;
    }
}
