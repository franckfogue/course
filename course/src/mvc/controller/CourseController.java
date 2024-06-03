package mvc.controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
package mvc.controller;

public class CourseController {
    private Course model;
    private CourseView view;
    private Connection dbConnect;

    public CourseController(Course model, CourseView view, Connection dbConnect) {
        this.model = model;
        this.view = view;
        this.dbConnect = dbConnect;
    }

    public void ajouterCourse() {
        try {
            String nom = view.getCourseNom();
            BigDecimal prix = view.getCoursePrix();
            LocalDate dateDebut = view.getCourseDateDebut();
            LocalDate dateFin = view.getCourseDateFin();
            int kmTotal = view.getCourseKmTotal();

            String query = "INSERT INTO APICOURSE (nom, priceMoney, dateDebut, dateFin, kmTotal) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setString(1, nom);
                pstm.setBigDecimal(2, prix);
                pstm.setDate(3, Date.valueOf(dateDebut));
                pstm.setDate(4, Date.valueOf(dateFin));
                pstm.setInt(5, kmTotal);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    view.afficherMessage("La course a été ajoutée avec succès !");
                } else {
                    view.afficherMessage("Erreur lors de l'ajout de la course.");
                }
            } catch (SQLException e) {
                view.afficherMessage("Erreur SQL lors de l'ajout de la course : " + e.getMessage());
            }
        } catch (Exception e) {
            view.afficherMessage("Erreur lors de la saisie des données de la course : " + e.getMessage());
        }
    }

    public void afficherEtapes() {
        for (Etape etape : model.listeEtape()) {
            view.afficherMessage("Étape " + etape.getNumero() + ": " + etape.getVilleDepart() + " -> " + etape.getVilleArrivee());
        }
    }
}
