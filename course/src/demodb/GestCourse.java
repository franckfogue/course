package demodb;

import myconnections.DBConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.math.BigDecimal;


public class GestCourse {

    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("Connexion établie");
        do {
            System.out.println("1. Ajout\n2. Recherche\n3. Modification\n4. Suppression\n5. Tous\n6. Fin");
            System.out.print("Choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (true);
    }

    public void ajout() {
        try {
            // Saisie des données pour la nouvelle course
            System.out.print("Nom de la course : ");
            String nom = sc.nextLine();
            System.out.print("Prix de la course : ");
            BigDecimal prix = sc.nextBigDecimal();
            System.out.print("Date de début (AAAA-MM-JJ) : ");
            LocalDate dateDebut = LocalDate.parse(sc.next());
            System.out.print("Date de fin (AAAA-MM-JJ) : ");
            LocalDate dateFin = LocalDate.parse(sc.next());
            System.out.print("Kilométrage total : ");
            int kmTotal = sc.nextInt();

            // Requête d'insertion dans la base de données
            String query = "INSERT INTO APICOURSE (nom, priceMoney, dateDebut, dateFin, kmTotal) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setString(1, nom);
                pstm.setBigDecimal(2, prix);
                pstm.setDate(3, Date.valueOf(dateDebut));
                pstm.setDate(4, Date.valueOf(dateFin));
                pstm.setInt(5, kmTotal);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("La course a été ajoutée avec succès !");
                } else {
                    System.out.println("Erreur lors de l'ajout de la course.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de l'ajout de la course : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie des données de la course : " + e.getMessage());
        }
    }


    public void recherche() {
        try {
            System.out.print("Entrez l'ID de la course à rechercher : ");
            int courseId = sc.nextInt();
            String query = "SELECT * FROM APICOURSE WHERE courseId = ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, courseId);
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    System.out.println("ID : " + rs.getInt("courseId"));
                    System.out.println("Nom : " + rs.getString("nom"));
                    System.out.println("Prix : " + rs.getBigDecimal("priceMoney"));
                    System.out.println("Date de début : " + rs.getDate("dateDebut"));
                    System.out.println("Date de fin : " + rs.getDate("dateFin"));
                    System.out.println("Kilométrage total : " + rs.getInt("kmTotal"));
                } else {
                    System.out.println("Aucune course trouvée avec l'ID " + courseId);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de la recherche de la course : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'ID de la course : " + e.getMessage());
        }
    }

    public void modification() {
        try {
            System.out.print("Entrez l'ID de la course à modifier : ");
            int courseId = sc.nextInt();
            System.out.print("Entrez le nouveau prix de la course : ");
            BigDecimal nouveauPrix = sc.nextBigDecimal();
            String query = "UPDATE APICOURSE SET priceMoney = ? WHERE courseId = ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setBigDecimal(1, nouveauPrix);
                pstm.setInt(2, courseId);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("La course a été modifiée avec succès !");
                } else {
                    System.out.println("Aucune course trouvée avec l'ID " + courseId);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de la modification de la course : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'ID de la course : " + e.getMessage());
        }
    }

    public void suppression() {
        try {
            System.out.print("Entrez l'ID de la course à supprimer : ");
            int courseId = sc.nextInt();
            String query = "DELETE FROM APICOURSE WHERE courseId = ?";
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, courseId);
                int result = pstm.executeUpdate();
                if (result > 0) {
                    System.out.println("La course a été supprimée avec succès !");
                } else {
                    System.out.println("Aucune course trouvée avec l'ID " + courseId);
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL lors de la suppression de la course : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la saisie de l'ID de la course : " + e.getMessage());
        }
    }

    public void tous() {
        String query = "SELECT * FROM APICOURSE";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("courseId"));
                System.out.println("Nom : " + rs.getString("nom"));
                System.out.println("Prix : " + rs.getBigDecimal("priceMoney"));
                System.out.println("Date de début : " + rs.getDate("dateDebut"));
                System.out.println("Date de fin : " + rs.getDate("dateFin"));
                System.out.println("Kilométrage total : " + rs.getInt("kmTotal"));
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de la récupération de toutes les courses : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestCourse gc = new GestCourse();
        gc.gestion();
    }
}
