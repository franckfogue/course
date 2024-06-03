package designpatterns.builder;

import mvc.observer.Subject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
package designpatterns.builder;

public class Course implements Subject {
    private String nom;
    private BigDecimal prix;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int kmTotal;
    private List<Etape> etapes;
    private List<Observer> observers;

    private Course(CourseBuilder builder) {
        this.nom = builder.nom;
        this.prix = builder.prix;
        this.dateDebut = builder.dateDebut;
        this.dateFin = builder.dateFin;
        this.kmTotal = builder.kmTotal;
        this.etapes = builder.etapes;
        this.observers = new ArrayList<>();
    }

    public static class CourseBuilder {
        private String nom;
        private BigDecimal prix;
        private LocalDate dateDebut;
        private LocalDate dateFin;
        private int kmTotal;
        private List<Etape> etapes = new ArrayList<>();

        public CourseBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public CourseBuilder setPrix(BigDecimal prix) {
            this.prix = prix;
            return this;
        }

        public CourseBuilder setDateDebut(LocalDate dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public CourseBuilder setDateFin(LocalDate dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public CourseBuilder setKmTotal(int kmTotal) {
            this.kmTotal = kmTotal;
            return this;
        }

        public CourseBuilder addEtape(Etape etape) {
            this.etapes.add(etape);
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }



    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
