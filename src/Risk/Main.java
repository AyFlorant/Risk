package Risk;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
		//Interface fen = new Interface();
        //We create a new game
        System.out.println("Combien de Joueur (1 à 6) ?");
        Scanner scan = new Scanner(System.in);
        int nbr_joueur = scan.nextInt();

        Game G = new Game(false, nbr_joueur);
        //Create the players, distribute countries, place the armies
        G.initialisation(nbr_joueur);

        //While the game isn't won...
        while (!G.isVictory()) {
            for (Joueur J : G.joueurs) {
                G.gameTurn(J);
            }

            System.out.println("Jeux en cours");
            G.setVictory(true);
        }

    }
}
