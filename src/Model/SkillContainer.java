package Model;

import java.util.ArrayList;

/**
 * Created by jeffbahns on 1/11/16.
 */
public class SkillContainer {
    public ArrayList<Skill> SKILLS;

    public SkillContainer() {
        SKILLS = new ArrayList<>();
    }

    public void addSkill(String name, String DESCRIPTION, char TYPE, int ATK, int DEF, int SP_COST, int DURATION) {
        SKILLS.add(new Skill(name, DESCRIPTION, TYPE, ATK, DEF, SP_COST, DURATION));
    }

    public int numSkills() {
        return SKILLS.size();
    }

    public void print() {
        for(int i = 0; i < SKILLS.size(); i++) {
            Skill skill = SKILLS.get(i);
            System.out.println(i+1 + " : " + skill.name + " , " + skill.SP_COST + " SP");
        }
    }

}
