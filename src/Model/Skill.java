package Model;

public class Skill {
    public String name;
    public String DESCRIPTION;
    public char TYPE;
    public String STAT_TARGET;
    public int STAT_VALUE;
    public int SP_COST;
    public int DURATION;
    public boolean eot;
    public ActiveEffect ae;


    Skill(String name, String DESCRIPTION, char TYPE, String STAT_TARGET, int STAT_VALUE, int SP_COST, int duration, boolean eot) {
        this.name = name;
        this.DESCRIPTION = DESCRIPTION;
        this.TYPE = TYPE;
        this.STAT_TARGET = STAT_TARGET;
        this.STAT_VALUE = STAT_VALUE;
        this.SP_COST = SP_COST;
        this.DURATION = duration;
        this.eot = eot;
        this.ae = new ActiveEffect(STAT_VALUE, STAT_TARGET, duration, eot);
    }

    public void castSkill() {

    }

    public void print() {
        System.out.println("---------");
        System.out.println(name);
        System.out.println("- - -");
        System.out.println("DESCRIPTION : " + DESCRIPTION);
        System.out.println("TYPE : " + TYPE);
        System.out.println("STAT TARGET " + STAT_TARGET);
        System.out.println("STAT_VALUE " + STAT_VALUE);
        System.out.println("SP : " + SP_COST);
        System.out.println("---------");

    }

}
