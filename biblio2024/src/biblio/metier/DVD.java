package biblio.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DVD extends Ouvrage{

    private long code;
    private String dureeTotale;
    private byte nbreBonus;
    private List<String> autresLangues=new ArrayList<>();
    private List<String> sousTitres=new ArrayList<>();
    public DVD(String titre, int ageMin, LocalDate dateParution, TypeOuvrage to, double prixLocation, String langue, String genre, long code, String dureeTotale, byte nbreBonus) {
        super(titre, ageMin, dateParution, to, prixLocation, langue, genre);
        this.code=code;
        this.dureeTotale=dureeTotale;
        this.nbreBonus=nbreBonus;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDureeTotale() {
        return dureeTotale;
    }

    public void setDureeTotale(String dureeTotale) {
        this.dureeTotale = dureeTotale;
    }

    public byte getNbreBonus() {
        return nbreBonus;
    }

    public void setNbreBonus(byte nbreBonus) {
        this.nbreBonus = nbreBonus;
    }

    public List<String> getAutresLangues() {
        return autresLangues;
    }

    public void setAutresLangues(List<String> autresLangues) {
        this.autresLangues = autresLangues;
    }

    public List<String> getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(List<String> sousTitres) {
        this.sousTitres = sousTitres;
    }
