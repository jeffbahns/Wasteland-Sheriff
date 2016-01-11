import java.util.ArrayList;

/**
 * Created by jeffbahns on 1/10/16.
 */
public class Player extends Person {
    ArrayList<String> ITEMS = new ArrayList<>();

    public Player() {
        super("Corey",1, 1, 1, 1, 1, new SkillContainer());
    }

    public Player(String name, int level,  int HP, int ATK, int DEF, int AGI, SkillContainer SKILLS) {
        super(name, level, HP, ATK, DEF, AGI, SKILLS);
    }
}
