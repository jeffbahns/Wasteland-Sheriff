/**
 * Created by jeffbahns on 1/10/16.
 */
public class Enemy extends Person {
    String type;

    public Enemy() {
        super("Bob", 1,1,1,1);
        this.type = "Goblin";
    }

    public Enemy(String name, int HP, int ATK, int DEF, int AGI, String type) {
        super(name, HP, ATK, DEF, AGI);
        this.type = type;
    }
}
