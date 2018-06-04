package Risk;

import java.util.ArrayList;

public class Country {

    protected int country_id;
    protected ArrayList<Unite> unitesOnLand = new ArrayList<Unite>();



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
}
