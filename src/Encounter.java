import java.util.ArrayList;

/**
 * Created by Corey on 1/10/16.
 */
public class Encounter {
    public Player player;
    public Enemy enemy;
    public String[] turnOrder;


    public Encounter( Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean startFight() {

        //Loop until end of fight;
        while(true) {
            //Roll for who goes first
            //TODO: determine turn order



            break;
        }

        return false;
    }

    private void determineOrder() {

    }
}
