package bibliotheque.metier;
import bibliotheque.metier.Exemplaire;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Rayon {
    private String codeRayon;
    private String genre;
    private String code;
    private List<Exemplaire> lex = new ArrayList<>();
    //TODO remplacer par set
    /*private Set<Exemplaire> lex = new HashSet<>();
    private Set<Exemplaire> exemplaires = new HashSet<>();*/
    private Set<Exemplaire> exemplaires = new HashSet<>();
    public Rayon(String codeRayon, String genre) {
        this.codeRayon = codeRayon;
        this.genre = genre;
        this.exemplaires = exemplaires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rayon rayon = (Rayon) o;
        return Objects.equals(codeRayon, rayon.codeRayon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeRayon);
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "codeRayon='" + codeRayon + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
    public void addExemplaire(Exemplaire e){
        lex.add(e);
        e.setRayon(this);
    }

    public void remove(Exemplaire e){
        lex.remove(e);
        e.setRayon(null);
    }
    public String getCodeRayon() {
        return codeRayon;
    }

    public void setCodeRayon(String codeRayon) {
        this.codeRayon = codeRayon;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Exemplaire> getLex() {
        return lex;
    }

    public void setLex(List<Exemplaire> lex) {
        this.lex = lex;
    }

    public List<Exemplaire>listerExemplaires(){
        return lex;
    }

    public boolean contientExemplaire(Exemplaire exemplaire) {
        return exemplaires.contains(exemplaire);
    }
    public String getCode() {
        return code;
    }
}
