package Risk;

public class Cavalier extends Unite {

    public Cavalier() {
        this.type = 2;
        this.cost = 3;
        this.power = new int[]{2,3,4,5,6,7};
        this.ATT_prio = 1;
        this.DEF_prio = 3;
        this.MVT_tour = 3;
    }
}