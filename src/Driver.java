import java.util.Scanner;

/**
 * Created by Corey on 1/10/16.
 */
public class Driver {

    public static void main(String[] args) {
        //TODO: Have a segment to load save files
        //
        //Calls Method that begins perpetual game loop
        runGame();
        System.out.println("Game has finished");

    }

    public static void runGame() {
        Scanner scan = new Scanner( System.in);

        int commandNum; //Variable that determines state of game

        while(true) {
            //TODO: Enter list of options for movement at every iteration
            System.out.print("Please enter in action>>  ");
            commandNum = scan.nextInt();
            switch (commandNum) {
                case 1: //Exit Game
                    return;
                case 2: // Join Encounter
                    break;
            }
        }

    }


}
