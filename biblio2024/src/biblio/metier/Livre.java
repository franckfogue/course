package biblio.metier;

import java.time.LocalDate;

public class Livre extends Ouvrage{
    private String isbn;
    private int nbrePages;
    private TypeLivre tl;
    private String resume;



    public Livre(String titre, int ageMin, LocalDate dateParution, TypeOuvrage to, double prixLocation, String langue, String genre, String isbn, int nbrePages, TypeLivre tl, String resume) {
        super(titre, ageMin, dateParution, to, prixLocation, langue, genre);
        this.isbn=isbn;
        this.nbrePages=nbrePages;
        this.tl=tl;
        this.resume=resume;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNbrePages() {
        return nbrePages;
    }

    public void setNbrePages(int nbrePages) {
        this.nbrePages = nbrePages;
    }

    public TypeLivre getTl() {
        return tl;
    }

    public void setTl(TypeLivre tl) {
        this.tl = tl;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
