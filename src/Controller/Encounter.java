package Controller;

import Model.Enemy;
import Model.Item;
import Model.Player;
import Model.Skill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Encounter  {
    public Player player;
    public Enemy enemy;
    public boolean turnOrder;
    private Random genny;
    private Scanner scan;
    private CombatAction combat;


    public Encounter(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        genny = new Random();
        scan = new Scanner(System.in);
    }

    public void startFight() throws InterruptedException{
        //Roll for who goes first
        turnOrder = determineOrder();

        //Loop until end of fight;
        while(true) {
            printStats();
            if(turnOrder) {
                playerTurn();
                Thread.sleep(4000);
            } else {
                //TODO: More dynamic enemy AI
                enemyTurn();
                Thread.sleep(4000);
            }

            if(isDead())
                break;
            turnOrder = !turnOrder;

            System.out.println(" _____________ TURN END _____________ ");
        }
    }

    private boolean determineOrder() {
        //Roll for player
        int pRoll = (genny.nextInt(20)+ 1) + this.player.AGI;
        //Roll for Model.Enemy
        int eRoll = (genny.nextInt(20)+ 1) + this.enemy.AGI;
        //If Proll > Eroll player goes first
        if(pRoll > eRoll) {
            //Model.Player goes first
            return true;
        } else {
            //Model.Player goes second
            return false;
        }
    }

    private boolean isDead() {
        //is Model.Player 1 Dead?
        if(this.player.HP <= 0) {
            System.out.println("Model.Player has Died");
            return true;
        }
        //is Model.Enemy Dead?
        if(this.enemy.HP <= 0) {
            System.out.println("Model.Enemy Has Died");
            return true;
        }
        return false;
    }

    private void playerTurn() {
        int response;

        do {
            System.out.println("Please enter your command");
            System.out.println("1. Attack \n" + "2. Defend \n3. Items \n4. Skills \n5. Run");
            response = scan.nextInt();
        } while(response > 5 || response < 1);

        switch (response) {

            //Attack
            case 1:
                combat = new CombatAction(0, enemy, null, null);
                break;

            //Defend
            case 2:
                break;

            //Model.ItemContainer
            case 3:
                Item item;
                //List Items for player
                System.out.println(player.listItems());
                //Let Player Choose Model Item
                if((item = player.useItem()) == null)
                    playerTurn();
                else
                    combat = new CombatAction(4, enemy, item, null);
                break;

            //Skills
            case 4:
                //List skills for player
                Skill skill = player.SKILLS.useSkill();
                if(skill == null)
                    playerTurn();
                else
                    combat = new CombatAction(5, enemy, null, skill);
                break;

            //Run
            case 5:
                combat = new CombatAction(6, null, null, null);
                return;
        }

        //Put update() here
        player.updateActiveEffects();
    }

    private void enemyTurn() {
        this.player.affectHP(-1);
    }

    private void printStats() {
        this.player.print();
        this.enemy.print();
    }

}
