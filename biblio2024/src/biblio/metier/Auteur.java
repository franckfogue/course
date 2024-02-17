package biblio.metier;

import java.util.List;

public class Auteur {
    private String nom;
    private String prenom;
    private String nationalite;
    protected List<Ouvrage> ouvrage;
    public Auteur(String nom,String prenom,String nationalite)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.nationalite=nationalite;

    }

}
