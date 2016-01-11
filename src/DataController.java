/**
 * Created by Corey on 1/11/16.
 */
public class DataController {

    Player player;
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
        this.player = new Player("Corey", 1, 10, 3, 3, 3);
        this.enemy = new Enemy("Gobby", 1, 10, 3, 3, 3, "Goblin");

        player.Items.add(new Item("Horn of Eld", "Blow this and unleash the wrath of the ancient gunslinger Arthur of Eld", 'o'));
    }


    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }


}
