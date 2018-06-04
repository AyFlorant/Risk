package Risk;

public class Soldat extends Unite {

    public Soldat() {
        this.type = 1;
        this.cost = 1;
        this.power = new int[]{1, 2, 3, 4, 5, 6};
        this.ATT_prio = 2;
        this.DEF_prio = 1;
        this.MVT_tour = 2;
    }

}
