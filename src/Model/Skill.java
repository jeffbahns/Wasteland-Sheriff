package Model;

/**
 * Created by jeffbahns on 1/11/16.
 */
public class Skill {
    public String name;
    public String DESCRIPTION;
    public char TYPE;
    public int ATK;
    public int DEF;
    public int SP_COST;

    Skill(String name, String DESCRIPTION, char TYPE, int ATK, int DEF, int SP_COST) {
        this.name = name;
        this.DESCRIPTION = DESCRIPTION;
        this.TYPE = TYPE;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SP_COST = SP_COST;
    }

    public void castSkill() {

    }

    public void print() {
        System.out.println("---------");
        System.out.println(name);
        System.out.println("- - -");
        System.out.println("DESCRIPTION : " + DESCRIPTION);
        System.out.println("TYPE : " + TYPE);
        System.out.println("ATK : " + ATK);
        System.out.println("DEF : " + DEF);
        System.out.println("SP : " + SP_COST);
        System.out.println("---------");
    }

}
