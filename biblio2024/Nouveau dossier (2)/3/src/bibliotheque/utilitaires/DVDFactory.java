package bibliotheque.utilitaires;

import bibliotheque.metier.DVD;
import bibliotheque.metier.Ouvrage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

public class DVDFactory extends OuvrageFactory {
    public Ouvrage addDetail(String titre, int ageMin, LocalDate dateParution, double prixLocation, String langue, String genre) {
        System.out.println("code : ");
        long code = sc.nextLong();
        LocalTime dureeTotale = Utilitaire.lecTime();
        byte nbreBonus = sc.nextByte();
        DVD dvd = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, code, dureeTotale, nbreBonus);

        System.out.println("autres langues");
        Set<String> langues = new HashSet<>(Arrays.asList("anglais", "français", "italien", "allemand"));
        do {
            int choix = Utilitaire.choixListe(langues);
            if (choix == langues.size()) break;
            String langueAjoutee = langues.toArray(new String[0])[choix - 1];
            if (!langueAjoutee.equals(langue)) {
                dvd.getAutresLangues().add(langueAjoutee);
            } else {
                System.out.println("Langue identique à la langue d'origine.");
            }
        } while (true);

        System.out.println("sous-titres");
        Set<String> sousTitres = new HashSet<>(Arrays.asList("anglais", "français", "italien", "allemand"));
        do {
            int choix = Utilitaire.choixListe(sousTitres);
            if (choix == sousTitres.size()) break;
            String sousTitreAjoute = sousTitres.toArray(new String[0])[choix - 1];
            dvd.getSousTitres().add(sousTitreAjoute);
        } while (true);

        return dvd;
    }
}
