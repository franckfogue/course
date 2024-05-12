package designpatterns.builder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;


public class CourseBuilder {
    private String nom;
    private BigDecimal prix;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int kmTotal;

    public CourseBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public CourseBuilder withPrix(BigDecimal prix) {
        this.prix = prix;
        return this;
    }

    public CourseBuilder withDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public CourseBuilder withDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public CourseBuilder withKmTotal(int kmTotal) {
        this.kmTotal = kmTotal;
        return this;
    }

    public Course build() {
        return new Course(nom, prix, dateDebut, dateFin, kmTotal);
    }
}
