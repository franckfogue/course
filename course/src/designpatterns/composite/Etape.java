package designpatterns.composite;
public class Etape implements Component {
    private int numero;
    private String depart;
    private String arrivee;

    public Etape(int numero, String depart, String arrivee) {
        this.numero = numero;
        this.depart = depart;
        this.arrivee = arrivee;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Étape " + numero + " : " + depart + " -> " + arrivee);
    }
}
