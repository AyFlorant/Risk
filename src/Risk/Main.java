package Risk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		//Interface fen = new Interface();
        System.out.println("Combien de Joueur (2 à 6) ?");
        Scanner scan = new Scanner(System.in);
        int nbr_joueur = scan.nextInt();


        Game G = new Game(false, nbr_joueur);
        //Créer les joueurs, distribue les pays, place les unités
        G.initialisation(nbr_joueur);

        //Tant que le jeu n'est pas gagné
        while (!G.isVictory()) {
            for (Joueur J : G.joueurs) {
                G.gameTurn(J);
                G.victory(); //Vérifie si un joueur a gagné
            }
        }


    }
}
