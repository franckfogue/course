package biblio.metier;
import java.time.LocalDate;
import java.util.List;
public class Ouvrage {
    protected String titre;
    protected  byte agemin;
    protected  LocalDate dateparution;
    protected TypeOuvrage typeOuvrage;
    protected double prixLocation;
    protected String langue;
    protected String genre;
    protected List<Auteur> auteur;

}
