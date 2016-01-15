package Controller;

import Model.*;

import java.util.Random;

/**
 * Created by Corey on 1/11/16.
 */
public class CombatAction {
    final String[] COMBAT_ACTION_TYPE = {"P_ATTACK", "E_ATTACK", "P_DEFEND", "E_DEFEND", "ITEM", "P_SKILL", "E_SKILL", "RUN"};
    DataController dataController = DataController.getInstance();
    Player player = dataController.getPlayer();
    Enemy enemy;
    Item item;
    Skill skill;
    Random genny;


    public CombatAction(int typeOfCombat, Enemy enemy, Item item, Skill skill) {
        //TODO: Implement rest of CombatAction Types
        this.genny = new Random();
        this.enemy = enemy;
        //Attack
        if(COMBAT_ACTION_TYPE[typeOfCombat].equals("P_ATTACK")) {
            System.out.println("Attack CombatAction");
            //call method for attack
            pAttack();
        }
        if(COMBAT_ACTION_TYPE[typeOfCombat].equals("E_ATTACK")) {
            System.out.println("Attack CombatAction");
            //call method for attack
            eAttack();
        }
        //P_Defense
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("P_DEFEND")) {
            System.out.println("Defense CombatAction");
        }
        //E_Defense
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("P_DEFEND")) {
            System.out.println("Defense CombatAction");
        }
        //Item
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("ITEM")) {
            System.out.println("Item CombatAction");
            this.item = item;
            item();
        }
        //pSkill
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("P_SKILL")) {
            System.out.println("Skill CombatAction");
            this.skill = skill;
            pSkill();
        }//eSkill
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("E_SKILL")) {
            System.out.println("Skill CombatAction");
            this.skill = skill;
            eSkill();
        }
        //Run
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("RUN")) {
            run();
        }
    }

    private void pAttack() {
        //Basic Player Attack: Roll on Weapon Dmg + Player's Atk stat - Enemy's Def stat
        int damage = (genny.nextInt(3) + 4) + player.ATK - enemy.DEF;
        System.out.println(player.name + " attacks for " + damage + " damage");
        enemy.HP-= damage;
    }

    private void eAttack() {
        //Basic Enemy Roll
        int damage = (genny.nextInt(3) + 4) + player.ATK - enemy.DEF;
        System.out.println(enemy.name + " attacks for " + damage + " damage");
        player.HP-= damage;
    }

    private void pDefend() {



    }

    private void eDefend() {

    }

    private void item() {
        Person target;
        if (item.target == 'p') {
            player.addToActiveEffects(item.ae);
        } else {
            enemy.addToActiveEffects(item.ae);
        }
    }
    private void pSkill() {
        if(skill.TYPE == 'O') {
            System.out.println("Casting " + skill.name + " at " + enemy.name);
            enemy.addToActiveEffects(skill.ae);
        } else {
            System.out.println(player.name + "casts " + skill.name + " on self");
            player.addToActiveEffects(skill.ae);
        }
    }

    private void eSkill() {
        if(skill.TYPE == 'O') {
            System.out.println("Casting " + skill.name + " at " + player.name);
            player.addToActiveEffects(skill.ae);
        } else {
            System.out.println(player.name + "casts " + skill.name + " on self");
            enemy.addToActiveEffects(skill.ae);
        }

    }

    private void run() {

    }

}
