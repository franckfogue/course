package designpatterns.composite;
public class Course implements Component, Subject {


    @Override
    public void afficherDetails() {
        System.out.println("Course : " + nom);
        for (Etape etape : etapes) {
            etape.afficherDetails();
        }
    }
}
