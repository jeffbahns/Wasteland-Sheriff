package Controller;

import Model.Enemy;
import Model.Item;
import Model.Player;
import Model.SkillContainer;

/**
 * Created by Corey on 1/11/16.
 */
public class DataController {


    Player mainPlayer;
    Enemy enemy;
    private static DataController instance = null;

    protected DataController(){}

    public static DataController getInstance() {
        if(instance == null) {
            instance = new DataController();
            instance.start();
        }
        return instance;
    }


    public void start() {
        //Sample Skills
        SkillContainer SKILLS = new SkillContainer();
        SKILLS.addSkill("Frost Dick", "Sends a snowy frostball straight to the enemy's foreskin", 'O', "HP", -5, 3, 1, false);
        SKILLS.addSkill("6 Shootin' Madness", "Unload all 6 bullets of your six shooter onto any Godless sack of shit who crosses your path", 'O', "HP", -6, 4, 1, false);
        SKILLS.addSkill("Huddle like a bitch", "Assume fetal position and hope you don't take too much damage", 'D', "DEF", 2, 1, 1, false);

        //Sample Persons
        this.mainPlayer = new Player("Corey", 1, 10, 3, 3, 3, SKILLS);
        this.enemy = new Enemy("Gobby", 1, 10, 3, 3, 3, "Goblin", SKILLS);

        mainPlayer.Items.add(new Item("Horn of Eld", "Blow this and unleash the wrath of the ancient gunslinger Arthur of Eld", "HP", -1000, 'o', 'e', 0, true));
        mainPlayer.Items.add(new Item("Dirty Bomb", "Deals Poison damage to target over 3 turns", "HP", -1, 'o', 'e', 3, true));

    }


    public Player getPlayer() {
        return mainPlayer;
    }

    public Enemy getEnemy() {
        return enemy;
    }


}
