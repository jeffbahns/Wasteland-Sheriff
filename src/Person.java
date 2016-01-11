/**
 * Created by jeffbahns on 1/10/16.
 */

// This is the base class for NPC's, enemies, etc
public class Person {

    public String name;
    public int level;
    public int HP;
    public int ATK;
    public int DEF;
    public int AGI;

    // default constructor
    Person( String name, int level, int HP, int ATK, int DEF, int AGI ) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.AGI = AGI;

        System.out.println("A person was created");
    }

    // changes HP, can be +/- change
    public void affectHP( int change ) {
        this.HP += change;
    }

    // changes ATK, can be +/- change
    public void affectATK( int change ) {
        this.ATK += change;
    }

    // changes DEF, can be +/- change
    public void affectDEF( int change ) {
        this.DEF += change;
    }

    // changes AGI, can be +/- change
    public void affectAGI( int change ) {
        this.AGI += change;
    }
}
