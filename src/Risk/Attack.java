package Risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Attack {

        public void attack ( int[] unite_id_attack, int country_id_origin, int country_id_desti, Joueur J1, Joueur J2){
            //Choix de la défense
            int[] unite_id_defense = {0, 0};
            for (Country C : J2.ownedCountries) {
                if (C.country_id == country_id_desti) {
                    int i = 0;
                    System.out.println("Check0");
                    for (Unite U : C.unitesOnLand) {
                        System.out.println("Check1");
                        if (U.type == 1) {
                            System.out.println("Check2");
                            if (i < 2) {
                                unite_id_defense[i] = 1;
                                System.out.println("Check1");
                                i++;
                            }
                        }
                    }
                    if (i < 2) {
                        for (Unite U : C.unitesOnLand) {
                            if (U.type == 2) {
                                if (i < 2) {
                                    unite_id_defense[i] = 2;
                                    System.out.println("Check2");
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
                                    System.out.println("Check3");
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("Le joueur " + J2.player_name + " défend avec les armées suivantes : ");
            System.out.println("id1 = " + unite_id_defense[0]);
            System.out.println("id2 = " + unite_id_defense[1]);
            //Calcul des scores
            ArrayList<Integer> unite_power_attack = getScores(unite_id_attack);
            ArrayList<Integer> unite_power_defense = getScores(unite_id_defense);
            //Conséquences de la victoire

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
            System.out.println("---Test tri unite power---");
            for (Integer I : unite_power) {
                System.out.println("Power : " + I);
            }
            return unite_power;
        }


    }