import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Etape {
    protected int idEtape;
    protected int numero;
    protected String description;
    protected Date dateEtape;
    protected int km;
    protected Ville villeDepart;
    protected Ville villeArrivee;

    public int getIdEtape() {
        return idEtape;
    }

    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEtape() {
        return dateEtape;
    }

    public void setDateEtape(Date dateEtape) {
        this.dateEtape = dateEtape;
    }

    public int getKm() {
        return km;
    }
   public void setkm(int km)
   {
       this.km=km;
   }
    public Ville getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(Ville villeDepart) {
        this.villeDepart = villeDepart;
    }

    public Ville getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(Ville villeArrivee) {
        this.villeArrivee = villeArrivee;
    }
    // Les autres attributs et méthodes restent inchangés
}
