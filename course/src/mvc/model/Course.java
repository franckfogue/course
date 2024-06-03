import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

package mvc.model;
public class Course {
    private String nom;
    private BigDecimal prix;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int kmTotal;
    private List<Etape> etapes;

    public Course(String nom, BigDecimal prix, LocalDate dateDebut, LocalDate dateFin, int kmTotal) {
        this.nom = nom;
        this.prix = prix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.kmTotal = kmTotal;
        this.etapes = new ArrayList<>();
    }

    // Getters et setters

    public List<Etape> listeEtape() {
        return etapes;
    }

    public void ajouterEtape(Etape etape) {
        etapes.add(etape);
    }
}
