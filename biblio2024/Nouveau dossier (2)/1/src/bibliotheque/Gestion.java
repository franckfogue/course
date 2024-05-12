package bibliotheque;

import bibliotheque.metier.*;
import static bibliotheque.metier.TypeOuvrage.*;
import static bibliotheque.metier.TypeLivre.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    Scanner sc = new Scanner(System.in);

    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv= new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon= new ArrayList<>();
    private static List<Location> lloc = new ArrayList<>();


    public void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,"120 min",(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

        a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,"100 min");
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);
        e.setRayon(r);


        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        e.setRayon(r);


        Lecteur lec = new Lecteur("Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lloc.add(loc);
        loc.setDateRestitution(LocalDate.of(2023,2,4));

        lec = new Lecteur ("Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lloc.add(loc);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","fin"));

        do{
            for(int i=0;i<options.size();i++){
                System.out.println((i+1)+"."+options.get(i));
            }

            int choix;
            do {
                System.out.println("choix :");
                choix = sc.nextInt();
                sc.skip("\n");
            } while(choix <1 || choix > options.size());
            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestLocations() {
        // Afficher les ouvrages disponibles
        System.out.println("Liste des exemplaires disponibles : ");
        for (int i = 0; i < lex.size(); i++) {
            System.out.println((i + 1) + ". " + lex.get(i));
        }

        // Sélectionner un exemplaire par sa position dans la liste
        System.out.print("Sélectionnez un exemplaire par sa position : ");
        int choixExemplaire = sc.nextInt();
        Exemplaire exemplaireChoisi = lex.get(choixExemplaire - 1);

        // Afficher les lecteurs disponibles
        System.out.println("Liste des lecteurs : ");
        for (int i = 0; i < llect.size(); i++) {
            System.out.println((i + 1) + ". " + llect.get(i));
        }

        // Sélectionner un lecteur par sa position dans la liste
        System.out.print("Sélectionnez un lecteur par sa position : ");
        int choixLecteur = sc.nextInt();
        Lecteur lecteurChoisi = llect.get(choixLecteur - 1);

        // Créer une nouvelle location avec le lecteur et l'exemplaire choisis
        Location nouvelleLocation = new Location(lecteurChoisi, exemplaireChoisi);
        lloc.add(nouvelleLocation);

        System.out.println("La location a été créée avec succès.");
    }


    private void gestLecteurs() {

        sc.skip("\n");
        System.out.println("nom ");
        String nom=sc.nextLine();
        System.out.println("prénom ");
        String prenom=sc.nextLine();
        System.out.println("date de naissance");
        String[] jma = sc.nextLine().split(" ");
        int j = Integer.parseInt(jma[0]);
        int m = Integer.parseInt(jma[1]);
        int a = Integer.parseInt(jma[2]);
        LocalDate dn= LocalDate.of(a,m,j);
        System.out.println("adresse");
        String adr=sc.nextLine();
        System.out.println("mail");
        String mail=sc.nextLine();
        System.out.println("tel ");
        String tel=sc.nextLine();
        Lecteur lect = new Lecteur(nom,prenom,dn,adr,mail,tel);
        llect.add(lect);
        System.out.println("lecteur créé");
    }

    private void gestRayons() {
        sc.skip("\n");
        System.out.println("Code du rayon : ");
        String codeRayon = sc.nextLine();
        System.out.println("Genre du rayon : ");
        String genre = sc.nextLine();

        Rayon rayon = new Rayon(codeRayon, genre);
        lrayon.add(rayon);
        System.out.println("Rayon créé : " + rayon);
    }


    private void gestExemplaires() {
        if (louv.isEmpty()) {
            System.out.println("Aucun ouvrage disponible. Veuillez d'abord créer des ouvrages.");
            return;
        }

        System.out.println("Liste des ouvrages disponibles : ");
        for (int i = 0; i < louv.size(); i++) {
            System.out.println((i + 1) + ". " + louv.get(i).getTitre());
        }

        System.out.println("Sélectionnez un ouvrage (entrez le numéro correspondant) : ");
        int choixOuvrage = sc.nextInt();
        sc.skip("\n");

        if (choixOuvrage < 1 || choixOuvrage > louv.size()) {
            System.out.println("Choix invalide !");
            return;
        }

        Ouvrage ouvrage = louv.get(choixOuvrage - 1);

        System.out.println("Matricule de l'exemplaire : ");
        String matricule = sc.nextLine();
        System.out.println("Description de l'état : ");
        String descriptionEtat = sc.nextLine();

        Exemplaire exemplaire = new Exemplaire(matricule, descriptionEtat, ouvrage);
        lex.add(exemplaire);
        System.out.println("Exemplaire créé : " + exemplaire);
    }

//commentaire
    private void gestOuvrages() {
        sc.skip("\n");
        System.out.println("Titre de l'ouvrage : ");
        String titre = sc.nextLine();
        System.out.println("Âge minimum recommandé : ");
        int ageMin = sc.nextInt();
        sc.skip("\n");
        System.out.println("Date de parution (AAAA-MM-JJ) : ");
        String[] dateStr = sc.nextLine().split("-");
        LocalDate dateParution = LocalDate.of(Integer.parseInt(dateStr[0]), Integer.parseInt(dateStr[1]), Integer.parseInt(dateStr[2]));
        System.out.println("Prix de location : ");
        double prixLocation = sc.nextDouble();
        sc.skip("\n");
        System.out.println("Langue : ");
        String langue = sc.nextLine();
        System.out.println("Genre : ");
        String genre = sc.nextLine();

        System.out.println("Type d'ouvrage (1: Livre, 2: CD, 3: DVD) : ");
        int type = sc.nextInt();
        sc.skip("\n");

        Ouvrage ouvrage = null;
        switch (type) {
            case 1:
                System.out.println("ISBN : ");
                String isbn = sc.nextLine();
                System.out.println("Nombre de pages : ");
                int nbrePages = sc.nextInt();
                sc.skip("\n");
                System.out.println("Type de livre (ROMAN, NOUVELLE, ESSAI, DOCUMENTAIRE, BIOGRAPHIE) : ");
                TypeLivre typeLivre = TypeLivre.valueOf(sc.nextLine());
                System.out.println("Résumé : ");
                String resume = sc.nextLine();
                ouvrage = new Livre(titre, ageMin, dateParution, prixLocation, langue, genre, isbn, nbrePages, typeLivre, resume);
                break;
            case 2:
                System.out.println("Code : ");
                long codeCD = sc.nextLong();
                sc.skip("\n");
                System.out.println("Nombre de plages : ");
                byte nbrePlages = sc.nextByte();
                sc.skip("\n");
                System.out.println("Durée totale : ");
                String dureeTotaleCD = sc.nextLine();
                ouvrage = new CD(titre, ageMin, dateParution, prixLocation, langue, genre, codeCD, nbrePlages, dureeTotaleCD);
                break;
            case 3:
                System.out.println("Code : ");
                long codeDVD = sc.nextLong();
                sc.skip("\n");
                System.out.println("Durée totale : ");
                String dureeTotaleDVD = sc.nextLine();
                System.out.println("Nombre de bonus : ");
                byte nbreBonus = sc.nextByte();
                sc.skip("\n");
                ouvrage = new DVD(titre, ageMin, dateParution, prixLocation, langue, genre, codeDVD, dureeTotaleDVD, nbreBonus);
                break;
            default:
                System.out.println("Type d'ouvrage non reconnu !");
        }

        if (ouvrage != null) {
            louv.add(ouvrage);
            System.out.println("Ouvrage créé : " + ouvrage);
        }
    }


    private void gestAuteurs() {
        sc.skip("\n");
        System.out.println("Nom de l'auteur : ");
        String nom = sc.nextLine();
        System.out.println("Prénom de l'auteur : ");
        String prenom = sc.nextLine();
        System.out.println("Pays de l'auteur : ");
        String pays = sc.nextLine();

        Auteur auteur = new Auteur(nom, prenom, pays);
        laut.add(auteur);

        System.out.println("Auteur créé : " + auteur);
    }


    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }

      }

