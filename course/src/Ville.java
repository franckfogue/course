import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
public class Ville {
    protected int idVille;
    protected String nom;
    protected double latitude;
    protected double longitude;
    protected String pays;
    public  Ville(int idVille,String nom,double latitude,double longitude,String pays)
    {
        this.idVille=idVille;
        this.nom=nom;
        this.latitude=latitude;
        this.longitude=longitude;
        this.pays=pays;
    }
    // Getters et Setters
    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}