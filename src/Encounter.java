import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Corey on 1/10/16.
 */
public class Encounter {
    public Player player;
    public Enemy enemy;
    public boolean turnOrder;
    private Random genny;
    private Scanner scan;


    public Encounter(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        genny = new Random();
        scan = new Scanner(System.in);
    }

    public void startFight() {
        //Roll for who goes first
        turnOrder = determineOrder();

        //Loop until end of fight;
        while(true) {
            printStats();
            if(turnOrder) {
                playerTurn();
            } else {
                //TODO: More dynamic enemy AI
                enemyTurn();
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
        //Roll for Enemy
        int eRoll = (genny.nextInt(20)+ 1) + this.enemy.AGI;
        //If Proll > Eroll player goes first
        if(pRoll > eRoll) {
            //Player goes first
            return true;
        } else {
            //Player goes second
            return false;
        }
    }

    private boolean isDead() {
        //is Player 1 Dead?
        if(this.player.HP <= 0) {
            System.out.println("Player has Died");
            return true;
        }
        //is Enemy Dead?
        if(this.enemy.HP <= 0) {
            System.out.println("Enemy Has Died");
            return true;
        }
        return false;
    }

    private void playerTurn() {
        int response;

        do {
            System.out.println("Please enter your command");
            System.out.println("1. Attack \n2. Defend \n3. Run");
            response = scan.nextInt();
        } while(response > 3 || response < 1);

        switch (response) {

            //Attack
            case 1:
                System.out.println("Attacks for 1");
                this.enemy.affectHP(-3);
                break;

            //Defend
            case 2:
                break;

            //Items
            case 3:
                break;

            //Run
            case 4:
                break;
        }
    }

    private void enemyTurn() {
        this.player.affectHP(-1);
    }

    private void printStats() {
        this.player.print();
        this.enemy.print();
    }

}
