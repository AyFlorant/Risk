package Risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Attack {

    public void attack(int[] unite_id_attack, int country_id_origin, int country_id_desti, Joueur J1, Joueur J2) {
        //Choix de la défense
        int[] unite_id_defense = {0, 0};
        for (Country C : J2.ownedCountries) {
            if (C.country_id == country_id_desti) {
                int i = 0;
                for (Unite U : C.unitesOnLand) {
                    if (U.type == 1) {
                        if (i < 2) {
                            unite_id_defense[i] = 1;
                            i++;
                        }
                    }
                }
                if (i < 2) {
                    for (Unite U : C.unitesOnLand) {
                        if (U.type == 2) {
                            if (i < 2) {
                                unite_id_defense[i] = 2;
                                i++;
                            }
                        }
                    }
                }
                if (i < 2) {
                    for (Unite U : C.unitesOnLand) {
                        if (U.type == 3) {
                            if (i < 2) {
                                unite_id_defense[i] = 3;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(" ");
        System.out.println("Le joueur " + J2.player_name + " défend avec les unités suivantes : ");
        System.out.println("1 - " + uniteName(unite_id_defense[0]));
        System.out.println("2 - " + uniteName(unite_id_defense[1]));
        System.out.println(" ");
        //Calcul des scores
        ArrayList<Integer> unite_power_attack = getScores(unite_id_attack);
        ArrayList<Integer> unite_power_defense = getScores(unite_id_defense);
        System.out.println("---Puissance de l'Attaque ---");
        for (Integer I : unite_power_attack) {
            System.out.println("Power : " + I);
        }
        System.out.println(" ");
        System.out.println("---Puissance de la défense ---");
        for (Integer I : unite_power_defense) {
            System.out.println("Power : " + I);
        }
        //Conséquences de la victoire
        int[] victoire = {1, 1, 1};
        for (int i = 0; i < unite_power_defense.size(); i++) {
            if (unite_power_attack.get(i) > unite_power_defense.get(i)) {
                //Victoire de l'attaque
                victoire[i] = 1;

            } else if (unite_power_attack.get(i) < unite_power_defense.get(i)) {
                //Victoire de la défense
                victoire[i] = 2;
                System.out.println("i = " + i);
                System.out.println("La défense gagne");
            }
        }
        int victoireDefense = 0;
        for (int j = 0; j < 3; j++) {
            if (victoire[j] == 2) {
                victoireDefense = 1;
            }
        }
            if (victoireDefense == 1) {
                System.out.println("La défense gagne la bataille !");
            } else {
                System.out.println("L'attaque gagne la bataille !");
            }
        }

        public ArrayList getScores ( int[] unite_id){
            ArrayList<Integer> unite_power = new ArrayList<Integer>();
            for (int i = 0; i < unite_id.length; i++) {
                if (unite_id[i] == 1) {
                    int randomNumber = ThreadLocalRandom.current().nextInt(1, 7);
                    unite_power.add(randomNumber);
                } else if (unite_id[i] == 2) {
                    int randomNumber = ThreadLocalRandom.current().nextInt(2, 8);
                    unite_power.add(randomNumber);
                } else if (unite_id[i] == 3) {
                    int randomNumber = ThreadLocalRandom.current().nextInt(4, 10);
                    unite_power.add(randomNumber);
                }
            }
            Collections.sort(unite_power, Collections.reverseOrder());
            return unite_power;
        }


        public String uniteName ( int unite_id){
            if (unite_id == 1) {
                return "Soldat";
            } else if (unite_id == 2) {
                return "Cavalier";
            } else if (unite_id == 3) {
                return "Canon";
            } else {
                return " ";
            }
        }
    }