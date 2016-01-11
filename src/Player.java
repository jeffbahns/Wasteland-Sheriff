import java.util.ArrayList;

/**
 * Created by jeffbahns on 1/10/16.
 */
public class Player extends Person {
    ArrayList<String> ITEMS = new ArrayList<>();

    public Player() {
        super("Corey", 1, 1, 1, 1);
    }

    public Player(String name, int HP, int ATK, int DEF, int AGI) {
        super(name, HP, ATK, DEF, AGI);
    }
}
