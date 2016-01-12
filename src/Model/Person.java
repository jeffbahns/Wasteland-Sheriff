package Model;



// This is the base class for NPC's, enemies, etc
public class


        Person {

    public String name;
    public int level;
    public int HP;
    public int ATK;
    public int DEF;
    public int AGI;
    public int SP;
    public SkillContainer SKILLS;

    // default constructor
    Person( String name, int level, int HP, int ATK, int DEF, int AGI, SkillContainer SKILLS ) {

        this.name = name;
        this.level = level;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.AGI = AGI;
        this.SKILLS = SKILLS;
        System.out.println("A person was created");
    }

    // changes HP, can be +/- change
    public void affectHP( int change ) {
        this.HP += change;
        if(HP < 0)
            HP = 0;
        System.out.println(name + "'s HP was affected by " + change + "!");
    }

    // changes ATK, can be +/- change
    public void affectATK( int change ) {
        this.ATK += change;
        if(ATK < 0)
            ATK = 0;
        System.out.println(name + "'s ATK was affected by " + change + "!");
    }

    // changes DEF, can be +/- change
    public void affectDEF( int change ) {
        this.DEF += change;
        if(DEF < 0)
            DEF = 0;
        System.out.println(name + "'s DEF was affected by " + change + "!");
    }

    // changes AGI, can be +/- change
    public void affectAGI( int change ) {
        this.AGI += change;
        if(AGI < 0)
            AGI = 0;
        System.out.println(name + "'s AGI was affected by " + change + "!");
    }

    // changes SP, can be +/- change
    public void affectSP( int change ) {
        this.SP += change;
        if(SP < 0)
            SP = 0;
        System.out.println(name + "'s SP was affected by " + change + "!");
    }

    public void print() {
        System.out.println("---------");
        System.out.println(name);
        System.out.println("- - -");
        System.out.println("HP : " + HP);
        System.out.println("ATK : " + ATK);
        System.out.println("DEF : " + DEF);
        System.out.println("AGI : " + AGI);
        System.out.println("SP : " + SP);
        System.out.println("---------");
    }

}
