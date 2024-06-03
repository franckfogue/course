import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
package mvc.view;

public class CourseView {
    private Scanner sc = new Scanner(System.in);

    public String getCourseNom() {
        System.out.print("Nom de la course: ");
        return sc.nextLine();
    }

    public BigDecimal getCoursePrix() {
        System.out.print("Prix de la course: ");
        return sc.nextBigDecimal();
    }

    public LocalDate getCourseDateDebut() {
        System.out.print("Date de début (AAAA-MM-JJ): ");
        return LocalDate.parse(sc.next());
    }

    public LocalDate getCourseDateFin() {
        System.out.print("Date de fin (AAAA-MM-JJ): ");
        return LocalDate.parse(sc.next());
    }

    public int getCourseKmTotal() {
        System.out.print("Kilométrage total: ");
        return sc.nextInt();
    }

    public void afficherMessage(String message) {
        System.out.println(message);
    }
}
