/**
 * Created by jeffbahns on 1/10/16.
 */
public class Enemy extends Person {
    String type;


    public Enemy() {
        super("Bob",1, 1,1,1,1, new SkillContainer());
        this.type = "Goblin";
    }

    public Enemy(String name, int level, int HP, int ATK, int DEF, int AGI, String type, SkillContainer SKILLS) {
        super(name, level, HP, ATK, DEF, AGI, SKILLS);
        this.type = type;
    }
}
