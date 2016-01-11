package Controller;

import Controller.DataController;
import Controller.Encounter;

import java.util.Scanner;

/**
 * Created by Corey on 1/10/16.
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {

        //TODO: Have a segment to load save files
        //
        //Calls Method that begins perpetual game loop
        runGame();
        System.out.println("Game has finished");

    }

    // initial state of game
    public static void runGame() {
        //Create instance of Datacontroller for sample data
        DataController dataController = DataController.getInstance();
        Encounter encounter;
        Scanner scan = new Scanner( System.in);

        int commandNum; //Variable that determines state of game

        while(true) {
            //TODO: Enter list of options for movement at every iteration
            System.out.println("Please enter your command");
            System.out.println("1. Exit Game\n2. Enter Combat\n3. Items");
            commandNum = scan.nextInt();

            switch (commandNum) {
                case 1: //Exit Game
                    return;
                case 2: // Join Controller.Encounter
                    encounter = new Encounter(dataController.getPlayer(),dataController.getEnemy());
                    try {
                        encounter.startFight();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3: // View Menu TODO: create menu class

            }
        }
    }

}
