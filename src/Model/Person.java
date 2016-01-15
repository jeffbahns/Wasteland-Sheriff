package Model;


import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

// This is the base class for NPC's, enemies, etc
public class


        Person {

    public String name;
    public int level;
    public int MAX_HP;
    public int HP;
    public int TRUE_ATK;
    public int ATK;
    public int TRUE_DEF;
    public int DEF;
    public int TRUE_AGI;
    public int AGI;
    public int MAX_SP;
    public int SP;
    public SkillContainer SKILLS;

    //For handling active effects on PLayers/NPC's
    private PriorityQueue<ActiveEffect> activeEffects;
    private PriorityQueue<ActiveEffect> tempActiveEffects;
    //Iterator for activeEffects
    Iterator<ActiveEffect> activeEffectIterator;
    Iterator<ActiveEffect> tempActiveEffectIterator;
    //Preconstructed activeEffect to reuse
    ActiveEffect ae;

    // default constructor
    Person( String name, int level, int HP, int ATK, int DEF, int AGI, SkillContainer SKILLS) {

        this.name = name;
        this.level = level;
        this.MAX_HP = HP;
        this.HP = this.MAX_HP;
        this.TRUE_ATK = this.ATK;
        this.ATK = ATK;
        this.TRUE_DEF = this.DEF;
        this.DEF = DEF;
        this.TRUE_AGI = this.AGI;
        this.AGI = AGI;
        this.SKILLS = SKILLS;
        this.MAX_SP = 0;
        this.SP = this.MAX_SP;
        //Will be contacted by CombatAction when a Skill or Item is used to affect the stats of Player/NPC
        ActiveEffectComparator comp = new ActiveEffectComparator();
        this.activeEffects = new PriorityQueue<>(10, comp);
        this.tempActiveEffects = activeEffects;
        this.activeEffectIterator = activeEffects.iterator();
        this.tempActiveEffectIterator = tempActiveEffects.iterator();
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

    //Prints Formatted Information
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

    //Updates all information for character invovled
    public void updateActiveEffects() {
        if(this.activeEffects.size() != 0) {
            ActiveEffect tempAE;
            while (tempActiveEffectIterator.hasNext()) {
                //Gets ConcurrentModificationException
                tempAE = tempActiveEffectIterator.next();
                this.ae = getAEForID(tempAE.id);
                if (tempAE.duration == 1) {
                    removeFromActiveEffects(ae);
                } else {
                    if (tempAE.eot)
                        affectStat(ae, true);
                    // Call affect Stat
                    ae.duration--;
                }
            }
        }
    }

    //addToActiveEffects
    public void addToActiveEffects(ActiveEffect ae) {
        //Place effect on Player/Enemy
        this.affectStat(ae, true);

        //If item's duration is zero upon adding, the item is of immediate affect with no lasting affect
        if(ae.duration != 0) {
            activeEffects.add(ae);
        }
    }

    //removeFromActiveEffects
    public void removeFromActiveEffects(ActiveEffect ae) {
        //Remove whatever effect on Player/Enemy unless its an effect over time stat
        if(!ae.eot) {
            this.affectStat(ae, false);
        }

        activeEffects.remove(ae);
    }

    //Inner Comparator Class for ActiveEffects Queue
    public class ActiveEffectComparator implements Comparator<ActiveEffect> {
        @Override
        public int compare(ActiveEffect o1, ActiveEffect o2) {
            return o1.duration - o2.duration;
        }
    }

    public void affectStat(ActiveEffect ae, boolean effect /*Is the change adding the effect or removing it*/) {
        switch(ae.statTarget) {
            case "HP":
                this.HP += effect ? ae.statValue : -ae.statValue;
                if(HP < 0)
                    HP = 0;
                System.out.println(name + "'s HP was affected by " + ae.statValue + "!");
                break;
            case "ATK":
                this.ATK += effect ? ae.statValue : -ae.statValue;
                if(ATK < 0)
                    ATK = 0;
                System.out.println(name + "'s HP was affected by " + ae.statValue + "!");
                break;
            case "DEF":
                this.DEF += effect ? ae.statValue : -ae.statValue;
                if(DEF < 0)
                    DEF = 0;
                System.out.println(name + "'s HP was affected by " + ae.statValue + "!");
                break;
            case "AGI":
                this.AGI += effect ? ae.statValue : -ae.statValue;
                if(AGI < 0)
                    AGI = 0;
                System.out.println(name + "'s HP was affected by " + ae.statValue + "!");
                break;
        }
    }

    public ActiveEffect getAEForID(String id) {
        ActiveEffect tempAe;
        while (activeEffectIterator.hasNext()) {
            tempAe = activeEffectIterator.next();
            if(id.equals(tempAe.id)){
                return tempAe;
            }
        }

        return null;
    }



}
