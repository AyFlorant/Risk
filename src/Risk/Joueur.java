package Risk;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Joueur {

    protected int reinforcement;
    protected String player_name;
    protected int player_id;
    protected ArrayList<Unite> unites = new ArrayList<Unite>();
    protected ArrayList<Country> ownedCountries = new ArrayList<Country>();
    //protected Mission mission;
    //protected COLOR color;
    protected int countriesWonLastTurn;

    public Joueur(String player_name, int player_id, int[] unites, int[] ownedcountries) {
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
            //Choix
            System.out.println(" ");
            System.out.println("Vous avez " + nbr_unite + " crédit(s) restant(s)");
            System.out.println("Quel type d'unité (id) voulez-vous ?");
            int unite_id = scan.nextInt();
            System.out.println("Combien ?");
            int unite_number = scan.nextInt();
            ////Vérification
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
        //Choix pays
        while (true) {
            System.out.println(" ");
            System.out.println("Sur quel territoire (id) voulez-vous placer des unites ?");
            int country_id = scan.nextInt();
            ////Vérification
            if (!playerPossessCountry(country_id)) {
                System.out.println("Ce territoire n'est pas à vous !");
                System.out.println(" ");
            } else {
                //Choix unités
                System.out.println(" ");
                System.out.println("Vous avez en réserve...");
                displayPossessUnites();
                System.out.println(" ");
                System.out.println("Quels unites (id) voulez-vous placer ?");
                int unite_id = scan.nextInt();
                System.out.println("Combien ?");
                int unite_number = scan.nextInt();
                ////Vérification
                if (unite_id == 1) {
                    if (playerSoldatNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerSoldatNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        placement(unite_id, unite_number, country_id);
                        break;
                    }
                } else if (unite_id == 2) {
                    if (playerCavalierNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerCavalierNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        placement(unite_id, unite_number, country_id);
                        break;
                    }
                } else if (unite_id == 3) {
                    if (playerCanonNumber() == 0)
                        System.out.println("Vous n'avez pas ce type d'unite");
                    else if (playerCanonNumber() < unite_number)
                        System.out.println("Vous n'avez pas assez d'unite");
                    else {
                        placement(unite_id, unite_number, country_id);
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

    public int countrySoldatNumber(Country C) {
        int soldatNumber = 0;
        for (Unite U : C.getUnitesOnLand()) {
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

    public int countryCavalierNumber(Country C) {
        int cavalierNumber = 0;
        for (Unite U : C.getUnitesOnLand()) {
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

    public int countryCanonNumber(Country C) {
        int canonNumber = 0;
        for (Unite U : C.getUnitesOnLand()) {
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
        System.out.println(nbr_soldat+ " Soldat(s)");
        System.out.println(nbr_cavalier+ " Cavalier(s)");
        System.out.println(nbr_canon+ " Canon(s)");
    }

    public void placement(int unite_id, int unite_number, int country_id) {
        int i = 0;
        ArrayList<Unite> bufferUnites = new ArrayList<Unite>();
        for (Country C : ownedCountries) {
            if (C.country_id == country_id) {
                for (Unite U : unites) {
                    if (U.type == unite_id && i < unite_number) {
                        //Liste temporaire
                        bufferUnites.add(U);
                        C.unitesOnLand.add(U);
                        i++;
                    }
                }
                unites.removeAll(bufferUnites);
                C.afficherUnites();
            }
        }
    }

    public void choixDeplacement() {
        Scanner scan = new Scanner(System.in);
        //Choix pays
        int action = 0;
        while (action == 0) {
            System.out.println("Depuis quel territoire (id) voulez-vous déplacer des unites ?");
            int country_id_origin = scan.nextInt();
            //Vérification
            if (!playerPossessCountry(country_id_origin)) {
                System.out.println("Ce territoire n'est pas à vous !");
            } else {
                System.out.println("Sur quel territoire (id) voulez-vous déplacer des unites ?");
                int country_id_desti = scan.nextInt();
                //Vérification
                if (!playerPossessCountry(country_id_desti)) {
                    System.out.println("Ce pays n'est pas à vous !");
                } else {
                    for (Country C : ownedCountries) {
                        if (C.country_id == country_id_origin) {
                            //Choix unités
                            C.afficherUnites();
                            System.out.println(" ");
                            System.out.println("Quels unites (id) voulez-vous déplacer ?");
                            int unite_id = scan.nextInt();
                            System.out.println("Combien ?");
                            int unite_number = scan.nextInt();
                            //Vérification
                            if (C.unitesOnLand.size() <= unite_number) {
                                System.out.println("Impossible, il faut qu'il y ait toujours une unité sur le territoire");
                            } else if (unite_id == 1) {
                                if (countrySoldatNumber(C) == 0)
                                    System.out.println("Vous n'avez pas ce type d'unite");
                                else if (countrySoldatNumber(C) < unite_number)
                                    System.out.println("Vous n'avez pas assez d'unite");
                                else {
                                    deplacement(unite_id, unite_number, country_id_origin, country_id_desti);
                                    action = 1;
                                }
                            } else if (unite_id == 2) {
                                if (countryCavalierNumber(C) == 0)
                                    System.out.println("Vous n'avez pas ce type d'unite");
                                else if (countryCavalierNumber(C) < unite_number)
                                    System.out.println("Vous n'avez pas assez d'unite");
                                else {
                                    deplacement(unite_id, unite_number, country_id_origin, country_id_desti);
                                    action = 1;
                                }
                            } else if (unite_id == 3) {
                                if (countryCanonNumber(C) == 0)
                                    System.out.println("Vous n'avez pas ce type d'unite");
                                else if (countryCanonNumber(C) < unite_number)
                                    System.out.println("Vous n'avez pas assez d'unite");
                                else {
                                    deplacement(unite_id, unite_number, country_id_origin, country_id_desti);
                                    action = 1;
                                }
                            } else {
                                System.out.println("Doesn't exist");
                            }
                        }
                    }
                }
            }
        }
    }

    public void deplacement(int unite_id, int unite_number, int country_id_origin, int country_id_desti) {
        int i = 0;
        ArrayList<Unite> bufferUnites = new ArrayList<Unite>();
        for (Country C : ownedCountries) {
            if (C.country_id == country_id_origin) {
                for (Unite U : C.unitesOnLand) {
                    if (U.type == unite_id && i < unite_number) {
                        //Liste temporaire
                        bufferUnites.add(U);
                        i++;
                    }
                }
                C.unitesOnLand.removeAll(bufferUnites);
                C.afficherUnites();
            }

        }
        ArrayList<Unite> bufferUnites2 = new ArrayList<Unite>();
        for (Country C : ownedCountries) {
            if (C.country_id == country_id_desti) {
                for (Unite U : bufferUnites) {
                    C.unitesOnLand.add(U);
                    bufferUnites2.add(U);
                    bufferUnites2.add(U);
                    i++;
                }
                bufferUnites.removeAll(bufferUnites2);
                C.afficherUnites();
            }
        }
    }

}

