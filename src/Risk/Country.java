package Risk;

import java.util.ArrayList;

public class Country {

    protected int country_id;
    protected ArrayList<Unite> unitesOnLand = new ArrayList<Unite>();
    protected ArrayList<Country> borderedCountries = new ArrayList<Country>();


    public Country(int country_id) {
        this.country_id = country_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public ArrayList<Unite> getUnitesOnLand() {
        return unitesOnLand;
    }

    public void setUnitesOnLand(ArrayList<Unite> unitesOnLand) {
        this.unitesOnLand = unitesOnLand;
    }

    public ArrayList<Country> getBorderedCountries() {
        return borderedCountries;
    }

    public void setBorderedCountries(ArrayList<Country> borderedCountries) {
        this.borderedCountries = borderedCountries;
    }

    public void afficherUnites() {
        int nbr_soldat = 0;
        int nbr_cavalier = 0;
        int nbr_canon = 0;
        for (Unite U : unitesOnLand) {
            if (U.type == 1) {
                nbr_soldat++;
            }
            else if (U.type == 2) {
                nbr_cavalier++;
            }
            else if (U.type == 3){
                nbr_canon++;
            }
        }
        System.out.println("Sur le territoire id = "+country_id+" il y a : ");
        System.out.println("Nbr_soldat (id1) = " + nbr_soldat);
        System.out.println("Nbr_cavalier (id2) = " + nbr_cavalier);
        System.out.println("Nbr_canon (id3) = " + nbr_canon);
    }

}
