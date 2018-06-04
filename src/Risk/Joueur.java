package Risk;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {

    protected int reinforcement;
    protected String player_name;
    protected int player_id;
    protected ArrayList<Unite> unites = new ArrayList<Unite>();
    protected ArrayList<Country> ownedCountries = new ArrayList<Country>();
    //protected Mission mission;
    //protected COLOR color;
    protected int countriesWonLastTurn;

    public Joueur(String player_name, int player_id) {
        this.player_name = player_name;
        this.player_id = player_id;
        this.ownedCountries = new ArrayList<Country>();
        this.unites = new ArrayList<Unite>();
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void ajouterUnite(Unite U) {
        unites.add(U);
    }

    public void ajouterUnite_choice(double nbr_unite) {
        Scanner scan = new Scanner(System.in);
        while (nbr_unite != 0) {
            //Choice
            System.out.println("Vous avez " + nbr_unite + " crédit(s) restant(s)");
            System.out.println("Quel type d'unité (id) voulez-vous ?");
            int unite_id = scan.nextInt();
            System.out.println("Combien ?");
            int unite_number = scan.nextInt();
            //Check
            if (unite_id == 1) {
                if (nbr_unite < 1 * unite_number) {
                    System.out.println("Pas assez de crédits");
                } else {
                    for (int k = 0; k < unite_number; k++) {
                        ajouterUnite(new Soldat());
                        nbr_unite -= 1;
                    }
                }
            } else if (unite_id == 2) {
                if (nbr_unite < 3 * unite_number) {
                    System.out.println("Pas assez de crédits");
                } else {
                    for (int k = 0; k < unite_number; k++) {
                        ajouterUnite(new Cavalier());
                        nbr_unite -= 3;
                    }
                }
            } else if (unite_id == 3) {
                if (nbr_unite < 7 * unite_number) {
                    System.out.println("Pas assez de crédits");
                } else {
                    for (int k = 0; k < unite_number; k++) {
                        ajouterUnite(new Canon());
                        nbr_unite -= 7;
                    }
                }
            } else {
                System.out.println("Doesn't exist");
            }
        }

    }


    public ArrayList<Country> getOwnedCountries() {
        return ownedCountries;
    }

    public void setOwnedCountries(ArrayList<Country> ownedCountries) {
        this.ownedCountries = ownedCountries;
    }

    public ArrayList<Unite> getUnites() {
        return unites;
    }

    public void setUnites(ArrayList<Unite> unites) {
        this.unites = unites;
    }

    public void placeUnites() {
        Scanner scan = new Scanner(System.in);
        //Country choice
        while (true) {
            System.out.println("Sur quel territoire (id) voulez-vous placer des unites ?");
            int country_id = scan.nextInt();
            //Possession check
            if (!playerPossessCountry(country_id)) {
                System.out.println("You don't possess this country... Choose another one !");
            } else {
                //Unite choice
                displayPossessUnites();
                System.out.println("Quels unites (id) voulez-vous placer ?");
                int unite_id = scan.nextInt();
                System.out.println("Combien ?");
                int unite_number = scan.nextInt();
                //Possession check
                if (unite_id == 1) {
                    if (playerSoldatNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerSoldatNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        Placement(unite_id, unite_number, country_id);
                        break;
                    }
                } else if (unite_id == 2) {
                    if (playerCavalierNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerCavalierNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        Placement(unite_id, unite_number, country_id);
                        break;
                    }
                } else if (unite_id == 3) {
                    if (playerCanonNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerCanonNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        Placement(unite_id, unite_number, country_id);
                        break;
                    }
                } else {
                    System.out.println("Doesn't exist");
                }
            }
        }

    }

    public boolean playerPossessCountry(int country_id) {
        boolean playerPossess = false;
        for (Country C : ownedCountries) {
            if (C.country_id == country_id) {
                playerPossess = true;
            }
        }
        return playerPossess;
    }


    public ArrayList ownedCountries_id() {
        ArrayList ownedCountries_id = new ArrayList();
        for (Country C : ownedCountries) {
            ownedCountries_id.add(C.country_id);
        }
        return ownedCountries_id;
    }

    public int Renfort_region() {
        int regionPossessed = 0;
        ArrayList ownedCountries_id = ownedCountries_id();
        if (ownedCountries_id.contains(1) && ownedCountries_id.contains(2) && ownedCountries_id.contains(3) && ownedCountries_id.contains(4)
                && ownedCountries_id.contains(5) && ownedCountries_id.contains(6) && ownedCountries_id.contains(7)) {
            System.out.println("Europe");
            regionPossessed += 3;
        }
        if (ownedCountries_id.contains(8) && ownedCountries_id.contains(9) && ownedCountries_id.contains(10) && ownedCountries_id.contains(11)
                && ownedCountries_id.contains(12) && ownedCountries_id.contains(13) && ownedCountries_id.contains(14) && ownedCountries_id.contains(15)
                && ownedCountries_id.contains(16) && ownedCountries_id.contains(17) && ownedCountries_id.contains(18) && ownedCountries_id.contains(19)) {
            System.out.println("Asie");
            regionPossessed += 6;
        }
        if (ownedCountries_id.contains(20) && ownedCountries_id.contains(21) && ownedCountries_id.contains(22) && ownedCountries_id.contains(23)
                && ownedCountries_id.contains(24) && ownedCountries_id.contains(25) && ownedCountries_id.contains(26) && ownedCountries_id.contains(27)
                && ownedCountries_id.contains(28)) {
            System.out.println("Amérique du Nord");
            regionPossessed += 4;
        }
        if (ownedCountries_id.contains(29) && ownedCountries_id.contains(30) && ownedCountries_id.contains(31) && ownedCountries_id.contains(32)) {
            System.out.println("Amérique du Sud");
            regionPossessed += 2;
        }
        if (ownedCountries_id.contains(33) && ownedCountries_id.contains(34) && ownedCountries_id.contains(35) && ownedCountries_id.contains(36)
                && ownedCountries_id.contains(37) && ownedCountries_id.contains(38)) {
            System.out.println("Afrique");
            regionPossessed += 3;
        }
        if (ownedCountries_id.contains(39) && ownedCountries_id.contains(40) && ownedCountries_id.contains(41) && ownedCountries_id.contains(42)) {
            System.out.println("Australie");
            regionPossessed += 2;
        }
        return regionPossessed;
    }

    public int playerSoldatNumber() {
        int soldatNumber = 0;
        for (Unite U : unites) {
            if (U.type == 1) {
                soldatNumber++;
            }
        }
        return soldatNumber;
    }

    public int playerCavalierNumber() {
        int cavalierNumber = 0;
        for (Unite U : unites) {
            if (U.type == 2) {
                cavalierNumber++;
            }
        }
        return cavalierNumber;
    }

    public int playerCanonNumber() {
        int canonNumber = 0;
        for (Unite U : unites) {
            if (U.type == 3) {
                canonNumber++;
            }
        }
        return canonNumber;
    }

    public void displayPossessUnites() {
        int nbr_soldat = playerSoldatNumber();
        int nbr_cavalier = playerCavalierNumber();
        int nbr_canon = playerCanonNumber();
        System.out.println("Nbr_soldat (id1) = " + nbr_soldat);
        System.out.println("Nbr_cavalier (id2) = " + nbr_cavalier);
        System.out.println("Nbr_canon (id3) = " + nbr_canon);
    }

    public void Placement(int unite_id, int unite_number, int country_id) {
        int i = 0;
        ArrayList<Unite> bufferUnites = new ArrayList<Unite>();
        for (Country C : ownedCountries) {
            if (C.country_id == country_id) {
                for (Unite U : unites) {
                    if (U.type == unite_id && i < unite_number) {
                        //We put the unit into a temporary list
                        bufferUnites.add(U);
                        C.unitesOnLand.add(U);
                        i++;
                    }
                }
                unites.removeAll(bufferUnites);
            }
        }
    }
}


