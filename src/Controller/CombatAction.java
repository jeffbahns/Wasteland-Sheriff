package Controller;

import Model.*;

import java.util.Random;

/**
 * Created by Corey on 1/11/16.
 */
public class CombatAction {
    final String[] COMBAT_ACTION_TYPE = {"P_ATTACK", "E_ATTACK", "P_DEFEND", "E_DEFEND", "ITEM", "P_SKILL", "E_SKILL"};
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
        //Defense
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("DEFENCE")) {
            System.out.println("Defense CombatAction");
        }
        //Item
        else if(COMBAT_ACTION_TYPE[typeOfCombat].equals("ITEM")) {
            System.out.println("Item CombatAction");
            this.item = item;
            item();
        }
        //Skill
        else {
            System.out.println("Skill CombatAction");
            this.skill = skill;
        }
    }

    private void pAttack() {
        //Basic Player Attack: Roll on Weapon Dmg + Player's Atk stat - Enemy's Def stat
        int damage = (genny.nextInt(3) + 4) + player.ATK - enemy.DEF;
        System.out.println(player.name + " attacks for " + damage + " damage");
        enemy.HP-= damage;
    }

    private void item() {
        Person target;
        if(item.target == 'p') {
            target = player;
        } else {
            target = enemy;
        }

        switch(item.statTarget) {
            case "HP":
                target.HP += item.statValue;
                break;
            case "ATK":
                target.ATK += item.statValue;
                break;
            case "DEF":
                target.DEF += item.statValue;
                break;
            case "AGI":
                target.AGI += item.statValue;
                break;
        }
    }



}
