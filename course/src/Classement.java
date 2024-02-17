import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
public class Classement {
    protected int idClassement;
    protected Coureur coureur;
    protected int place;
    protected BigDecimal gain;
    public Classement(int idClassement,Coureur coureur, int place,BigDecimal gain)
    {
        this.idClassement=idClassement;
        this.coureur=coureur;
        this.place=place;
        this.gain=gain;
    }

    // Getters et Setters
    public int getIdClassement() {
        return idClassement;
    }

    public void setIdClassement(int idClassement) {
        this.idClassement = idClassement;
    }

    public Coureur getCoureur() {
        return coureur;
    }

    public void setCoureur(Coureur coureur) {
        this.coureur = coureur;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public BigDecimal getGain() {
        return gain;
    }

    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }


}

