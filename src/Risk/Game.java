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
            ajouterJoueur(new Joueur(name, i,null,null));
            i += 1;
        }
        create_world();
        distributeCountries();
        distributeUnites();
        for (Joueur J : joueurs) {
            //Auto placement of 1 soldat on every countries
            for (Country C : J.ownedCountries) {
                J.Placement(1, 1, C.country_id);
            }
            //Players place their armies
            while (J.unites.size() != 0) {
                J.placeUnites();
            }
            System.out.println("-> Vous avez placé toutes vos armées !");
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
        int w = 0; //Check country_id
        while (true) {
            for (Joueur J : joueurs)
                if (!(countriesLeft.isEmpty())) {
                    ArrayList<Country> playersCountries = J.getOwnedCountries();
                    int randomNumber = ThreadLocalRandom.current().nextInt(0, countriesLeft.size());
                    playersCountries.add(countriesLeft.get(randomNumber));
                    J.setOwnedCountries(playersCountries);
                    countriesLeft.remove(countriesLeft.get(randomNumber));

                    System.out.println("J.player_id" + J.player_id);
                    //System.out.println("J.ownedCountries.size()" + J.ownedCountries.size());
                    //System.out.println("countriesLeft.size()" + countriesLeft.size());
                    System.out.println("Country_id" + J.ownedCountries.get(w).getCountry_id());
                }
            w++; //check country_id
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
        //Receive new unites
        System.out.println("J.player_id" + J.player_id);
        double receivedUnites = floor(J.ownedCountries.size()/3) + J.Renfort_region();
        System.out.println("receivedUnites" + receivedUnites);
        for (int i = 0; i < J.countriesWonLastTurn; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 2);
            if (randomNumber == 2) {
                receivedUnites++;
            }
        }
        System.out.println("receivedUnites" + receivedUnites);
        if (receivedUnites < 2) receivedUnites = 2;
        J.ajouterUnite_choice(receivedUnites);
        //Placing them
        while (J.unites.size() != 0) {
            J.placeUnites();
        }
        //Attacking

    }
}
