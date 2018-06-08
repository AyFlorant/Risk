package Risk;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.floor;

public class Game {

    public boolean victory;
    public static int nbr_joueur;
    protected ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
    protected ArrayList<Country> countriesLeft = new ArrayList<Country>();
    ;

    public Game(boolean victory, int nbr_joueur) {
        this.victory = victory;
        this.nbr_joueur = nbr_joueur;
        this.joueurs = new ArrayList<Joueur>();
        this.countriesLeft = new ArrayList<Country>();
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void initialisation(int nbr_joueur) {

        int i = 1;
        Scanner scan = new Scanner(System.in);
        //We create players
        while (i <= nbr_joueur) {
            System.out.println("Nom du joueur ?");
            String name = scan.nextLine();
            ajouterJoueur(new Joueur(name, i, null, null));
            i += 1;
        }
        create_world();
        distributeCountries();
        distributeUnites();
        for (Joueur J : joueurs) {
            //Auto placement of 1 soldat on every countries
            for (Country C : J.ownedCountries) {
                J.placement(1, 1, C.country_id);
            }
            System.out.println(" ");
            System.out.println("C'est au tour de " + J.player_name + " de jouer : ");
            //Players place their armies
            while (J.unites.size() != 0) {
                J.placeUnites();
            }
            System.out.println(" ");
            System.out.println("-> Vous avez placé toutes vos armées !");
            System.out.println(" ");
            System.out.println("--- Joueur suivant ---");
        }
    }

    public void distributeUnites() {
        int nbr_unites = 50 - 5 * nbr_joueur;
        for (Joueur J : joueurs) {
            for (int k = 0; k < nbr_unites; k++) {
                J.ajouterUnite(new Soldat());
                //System.out.println("Unite_type" + J.unites.get(k).getType());
            }
        }
    }

    public void create_world() {
        for (int i = 1; i <= 42; i++) {
            countriesLeft.add(new Country(i));
        }
    }

    public void distributeCountries() {
        while (true) {
            for (Joueur J : joueurs)
                if (!(countriesLeft.isEmpty())) {
                    ArrayList<Country> playersCountries = J.getOwnedCountries();
                    int randomNumber = ThreadLocalRandom.current().nextInt(0, countriesLeft.size());
                    playersCountries.add(countriesLeft.get(randomNumber));
                    J.setOwnedCountries(playersCountries);
                    countriesLeft.remove(countriesLeft.get(randomNumber));
                }
            if (countriesLeft.isEmpty()) {
                break;
            }
        }
    }

    public void ajouterJoueur(Joueur J) {
        joueurs.add(J);
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void gameTurn(Joueur J) {
        //Reçoit des nouvelles unités
        System.out.println("C'est au tour de " + J.player_name + " de jouer : ");
        System.out.println(" ");
        double receivedUnites = floor(J.ownedCountries.size() / 3) + J.Renfort_region();
        for (int i = 0; i < J.countriesWonLastTurn; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 2);
            if (randomNumber == 2) {
                receivedUnites++;
            }
        }
        //System.out.println("receivedUnites" + receivedUnites);
        if (receivedUnites < 2) receivedUnites = 2;
        J.ajouterUnite_choice(receivedUnites);
        //Place les unités
        while (J.unites.size() != 0) {
            J.placeUnites();
        }
        int action = 1;
        Scanner scan = new Scanner(System.in);
        while (action == 1) {
            System.out.println(" ");
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1 - Déplacement");
            System.out.println("2 - Attaque");
            System.out.println("0 - Arrêter le tour");
            action = scan.nextInt();
            if (action == 1) {
                J.choixDeplacement();
            } else if (action == 2) {
                choixAttack(J);
            }
        }
    }

    public void choixAttack(Joueur J) {
        Scanner scan = new Scanner(System.in);

        //Choix de payx
        int action = 0;
        while (action == 0) {
            System.out.println("Depuis quel territoire (id) voulez-vous attaquer ?");
            int country_id_origin = scan.nextInt();
            //Vérification
            if (!J.playerPossessCountry(country_id_origin)) {
                System.out.println("Ce territoire n'est pas à vous !");
            } else {
                System.out.println("Quel territoire voulez-vous attaquer ?");
                int country_id_desti = scan.nextInt();
                //Vérification
                if (J.playerPossessCountry(country_id_desti)) {
                    System.out.println("Vous ne pouvez pas attaquer votre propre territoire !");
                } else {
                    int[] unite_id = {0, 0, 0};
                    System.out.println("- Vous pouvez choisir jusqu'à 3 unités pour l'attaque -");
                    for (Country C : J.ownedCountries) {
                        if (C.country_id == country_id_origin) {
                            C.afficherUnites();
                            System.out.println("Quels unités voulez-vous ?");
                            System.out.println("1 - Soldat");
                            System.out.println("2 - Cavalier");
                            System.out.println("3 - Canon");
                            System.out.println("0 - Stop");
                            int i = 0;
                            for (i = 0; i < 3; i++) {
                                System.out.println("-> ");
                                int id = scan.nextInt();
                                if (id == 0) break;
                                else unite_id[i] = id;
                            }
                            //Vérification possession et territoire non vide
                            int error = 0;
                            for (int j = 0; j < 3; j++) {
                                if (unite_id[j] == 1 && J.countrySoldatNumber(C) == 0) {
                                    error = 1;
                                } else if (unite_id[j] == 2 && J.countryCavalierNumber(C) == 0) {
                                    error = 1;
                                } else if (unite_id[j] == 3 && J.countryCanonNumber(C) == 0) {
                                    error = 1;
                                } else if (C.unitesOnLand.size() <= i) {
                                    error = 2;
                                }
                            }
                            if (error == 1) {
                                System.out.println("Vous n'avez pas les unités requises");
                            } else if (error == 2) {
                                System.out.println("Impossible, il faut qu'il y ait toujours une unité sur le territoire");
                            } else if ((error == 0)) {
                                System.out.println("Parfait ! Passons à l'attaque");
                                for (Joueur J2 : joueurs) {
                                    for (Country C2 : J2.ownedCountries) {
                                        if (C2.country_id == country_id_desti) {
                                            Attack A = new Attack();
                                            A.attack(unite_id, country_id_origin, country_id_desti, J, J2);
                                        }
                                    }
                                }
                                action = 1;
                            }
                        }
                    }
                }
            }
        }
    }


    public void victory() {
        for (Joueur J : joueurs) {
            if (J.ownedCountries.size() == 42) { //Vérifie si un joueur possède tous les pays
                setVictory(true);
                System.out.println(" ");
                System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
                System.out.println("Victoire de " + J.player_name + " par capture de tous les territoires");
                System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --");
            }
        }
    }
}