package bibliotheque.gestion;

import bibliotheque.metier.*;
import bibliotheque.utilitaires.CDFactoryBeta;
import bibliotheque.utilitaires.DVDFactoryBeta;
import bibliotheque.utilitaires.LivreFactoryBeta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;


import static bibliotheque.utilitaires.Utilitaire.choixListe;

public class Gestion {
    Scanner sc = new Scanner(System.in);
//on a ôté static pour les listes qui n'est plus nécessaire
    private List<Auteur> laut = new ArrayList<>();
    private List<Lecteur> llect = new ArrayList<>();
    private List<Ouvrage> louv= new ArrayList<>();
    private List<Exemplaire> lex = new ArrayList<>();
    private List<Rayon> lrayon= new ArrayList<>();
    private List<Location> lloc = new ArrayList<>();


    public void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        a.addOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,LocalTime.of(2,0,0),(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        a.addOuvrage(d);

         a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        a.addOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,LocalTime.of(1,40,0));
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


        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        lloc.add(loc);
        loc.setDateRestitution(LocalDate.of(2023,2,4));

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lloc.add(loc);
    }

    private void menu() {
        List options = new ArrayList<>(Arrays.asList("auteurs","ouvrages","exemplaires","rayons","lecteurs","locations","restitution","fin"));
      do{
        int choix = choixListe(options);

            switch (choix){
                case 1 :gestAuteurs(); break;
                case 2 : gestOuvrages();break;
                case 3 : gestExemplaires();break;
                case 4 : gestRayons();break;
                case 5 : gestLecteurs();break;
                case 6 : gestLocations();break;
                case 7 : gestRestitution();break;
                default:System.exit(0);
            }
        }  while (true);
    }

    private void gestRestitution() {
        // Lister les exemplaires en location
        System.out.println("Exemplaires en location :");
        for (Location location : lloc) {
            System.out.println(location.getExemplaire());
        }

        // Choisir un exemplaire en location pour restitution
        int choix = choixListe(lloc);
        Location location = lloc.get(choix - 1);

        // Enregistrer la restitution
        location.restituer();
        System.out.println("Restitution enregistrée pour l'exemplaire : " + location.getExemplaire());

        // Éventuellement changer l'état de l'exemplaire restitué
        Exemplaire exemplaire = location.getExemplaire();
        if (exemplaire != null) {
            exemplaire.changerEtat("disponible");
            System.out.println("État de l'exemplaire mis à jour : " + exemplaire);
        } else {
            System.out.println("Erreur : aucun exemplaire associé à cette location.");
        }
    }


    private void gestLocations() {
        // Ne lister que les exemplaires libres
        List<Exemplaire> exemplairesLibres = new ArrayList<>();
        for (Exemplaire exemplaire : lex) {
            if (!exemplaire.enLocation()) {
                exemplairesLibres.add(exemplaire);
            }
        }

        // Trier les exemplaires libres par matricule
        exemplairesLibres.sort(Comparator.comparing(Exemplaire::getMatricule));

        // Afficher les exemplaires libres triés par matricule
        System.out.println("Exemplaires libres : ");
        int index = 1;
        for (Exemplaire exemplaire : exemplairesLibres) {
            System.out.println(index + ". " + exemplaire);
            index++;
        }

        // Sélectionner un exemplaire à louer
        System.out.println("Sélectionner un exemplaire à louer : ");
        int choixExemplaire = sc.nextInt();
        Exemplaire exemplaire = exemplairesLibres.get(choixExemplaire - 1);

        // Sélectionner un lecteur
        System.out.println("Sélectionner un lecteur : ");
        int choixLecteur = sc.nextInt();
        Lecteur lecteur = llect.get(choixLecteur - 1);

        // Créer une nouvelle location
        lloc.add(new Location(lecteur, exemplaire));
    }

    private void gestLecteurs() {
        System.out.println("numéro");
        int num=sc.nextInt();
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
        Lecteur lect = new Lecteur(num,nom,prenom,dn,adr,mail,tel);
        llect.add(lect);
        System.out.println("lecteur créé");

    }

    private void gestRayons() {
        System.out.println("code ");
        String code = sc.next();
        System.out.println("genre ");
        String genre = sc.next();
        Rayon r = new Rayon(code, genre);
        System.out.println("rayon créé");
        lrayon.add(r);

        // Attribuer plusieurs exemplaires au rayon
        while (true) {
            System.out.println("Ajouter un exemplaire au rayon (oui/non) ?");
            String reponse = sc.next();
            if (reponse.equalsIgnoreCase("non")) {
                break;
            }

            // Afficher les exemplaires disponibles qui ne sont pas déjà dans ce rayon ou dans un autre rayon
            System.out.println("Exemplaires disponibles : ");
            for (Exemplaire exemplaire : lex) {
                if (!r.contientExemplaire(exemplaire)) {
                    System.out.println(exemplaire);
                }
            }

            // Sélectionner un exemplaire à ajouter
            System.out.println("Sélectionner un exemplaire à ajouter : ");
            int choixExemplaire = sc.nextInt();
            Exemplaire exemplaire = lex.get(choixExemplaire - 1);

            // Ajouter l'exemplaire au rayon
            r.addExemplaire(exemplaire);
            exemplaire.setRayon(r);
        }
    }


    private void gestExemplaires() {
        System.out.println("matricule ");
        String mat = sc.next();
        System.out.println("etat  ");
        String etat = sc.next();
        System.out.println("ouvrage ");
        int choix = choixListe(louv);
        Exemplaire ex = new Exemplaire(mat, etat, louv.get(choix - 1));
        lex.add(ex);
        System.out.println("exemplaire créé");

        // Trie des rayons par ordre de code
        lrayon.sort(Comparator.comparing(Rayon::getCode));

        // Affichage des rayons triés et sélection du rayon
        System.out.println("Choisir un rayon :");
        for (int i = 0; i < lrayon.size(); i++) {
            System.out.println((i + 1) + ". " + lrayon.get(i).getCode() + " - " + lrayon.get(i).getGenre());
        }
        choix = sc.nextInt();
        ex.setRayon(lrayon.get(choix - 1));
    }

    private void gestOuvrages() {
      /*  Ouvrage o = null;
        System.out.println("titre");
        String titre= sc.nextLine();
        System.out.println("age minimum");
        int ageMin= sc.nextInt();
        sc.skip("\n");
        System.out.println("date de parution");

        LocalDate dp= Utilitaire.lecDate();
        System.out.println("prix de location");
        double ploc = sc.nextDouble();
        sc.skip("\n");
        System.out.println("langue");
        String langue=sc.nextLine();
        System.out.println("genre");
        String genre=sc.nextLine();
        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = Utilitaire.choixListe(lto);
        switch (choix){
                case 1 :
                           System.out.println("isbn ");
                           String isbn = sc.next();
                           System.out.println("pages ");
                           int nbrePages = sc.nextInt();
                           sc.skip("\n");
                           TypeLivre[] ttl = TypeLivre.values();
                           List<TypeLivre> ltl = new ArrayList<>(Arrays.asList(ttl));
                            choix = Utilitaire.choixListe(ltl);
                            TypeLivre tl = ttl[choix-1];
                           System.out.println("résumé du livre :");
                           String resume = sc.nextLine();
                           o=new Livre(titre,ageMin,dp,ploc,langue,genre,isbn,nbrePages,tl,resume);
                           ;break;
                case 2 :
                            System.out.println("code : ");
                            long code= sc.nextLong();
                            System.out.println("nombre de plages :");
                            byte nbrePlages= sc.nextByte();
                            LocalTime dureeTotale = Utilitaire.lecTime();
                            o=new CD(titre,ageMin,dp,ploc,langue,genre,code,nbrePlages,dureeTotale);
                            ;break;
                case 3 :
                            System.out.println("code : ");
                            code= sc.nextLong();
                            dureeTotale=Utilitaire.lecTime();
                            byte nbreBonus= sc.nextByte();
                            o=new DVD(titre,ageMin,dp,ploc,langue,genre,code,dureeTotale,nbreBonus);
                            System.out.println("autres langues");
                            List<String> langues = new ArrayList<>(Arrays.asList("anglais","français","italien","allemand","fin"));
                            do{
                                choix=Utilitaire.choixListe(langues);
                                if(choix==langues.size())break;
                                ((DVD)o).getAutresLangues().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set et pas de doublon avec langue d'origine
                            }while(true);
                           System.out.println("sous-titres");
                            do{
                             choix=Utilitaire.choixListe(langues);
                             if(choix==langues.size())break;
                             ((DVD)o).getSousTitres().add(langues.get(choix-1));//TODO vérifier unicité ou utiliser set
                             }while(true);
                            ;break;
            }*/



        TypeOuvrage[] tto = TypeOuvrage.values();
        List<TypeOuvrage> lto = new ArrayList<>(Arrays.asList(tto));
        int choix = choixListe(lto);
        Ouvrage o = null;

     switch(choix) {
            case 1 : o = new LivreFactoryBeta().create();break;
            case 2 : o = new CDFactoryBeta().create();break;
            case 3 : o = new DVDFactoryBeta().create();break;
        }
       /* List<OuvrageFactory> lof = new ArrayList<>(Arrays.asList(new LivreFactory(),new CDFactory(),new DVDFactory()));
        o = lof.get(choix-1).create();*/
        louv.add(o);
        System.out.println("ouvrage créé");
         choix = choixListe(laut);
        Auteur auteur = laut.get(choix - 1);

        // Vérifier si l'auteur est déjà associé à cet ouvrage
        if (o != null && auteur != null && !o.getAuteurs().contains(auteur)) {
            o.addAuteur(auteur);
            System.out.println("Auteur ajouté à l'ouvrage avec succès !");
        } else {
            System.out.println("Erreur lors de l'ajout de l'auteur à l'ouvrage.");
        }
    }

    private void gestAuteurs() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité");
        String nat = sc.nextLine();

        Auteur auteur = new Auteur(nom, prenom, nat);
        laut.add(auteur);
        System.out.println("Écrivain créé");

        // Tri des ouvrages par titre
        louv.sort(Comparator.comparing(Ouvrage::getTitre));

        // Boucle pour attribuer des ouvrages à l'auteur
        for (Ouvrage ouvrage : louv) {
            boolean ouvrageDejaAttribue = auteur.getOuvrages().contains(ouvrage);
            if (!ouvrageDejaAttribue) {
                System.out.println("Voulez-vous attribuer l'ouvrage " + ouvrage.getTitre() + " à cet auteur ? (O/N)");
                String reponse = sc.nextLine();
                if (reponse.equalsIgnoreCase("O")) {
                    auteur.addOuvrage(ouvrage);
                    System.out.println("Ouvrage attribué avec succès à l'auteur.");
                }
            }
        }
    }


    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.populate();
        g.menu();
    }

  
}
