/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.observer;


public class Coureur {
    private String nom;

    public Coureur(String nom) {
        this.nom = nom;
    }

    public void update(Course course) {
        System.out.println(nom + " est notifié de la course : " + course.getNom());
        // Réagir à la notification de la course
    }

    // Autres méthodes spécifiques à la classe Coureur
}
