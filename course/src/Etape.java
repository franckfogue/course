import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
public class Etape {
    protected int idEtape;
    protected int numero;
    protected String description;
    protected LocalDate dateEtape;
    protected int km;
    protected Ville villeDepart;
    protected Ville villeArrivee;
    protected Course course;
    public Etape(int idEtape,int numero,String description,LocalDate dateEtape,int km,Ville villeDepart, Ville villeArrivee,Course course)
    {
        this.idEtape=idEtape;
        this.numero=numero;
        this.description=description;
        this.dateEtape=dateEtape;
        this.km=km;
        this.villeDepart=villeDepart;
        this.villeArrivee=villeArrivee;
        this.course=course;

    }
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

    public void setDateEtape(LocalDate dateEtape) {
        this.dateEtape = dateEtape;
    }

    public LocalDate getDateEtape() {
        return dateEtape;
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

}
