package Model;


import java.util.ArrayList;
import java.util.Scanner;

public class SkillContainer {
    public ArrayList<Skill> SKILLS;
    private Scanner scanner = new Scanner(System.in);

    public SkillContainer() {
        SKILLS = new ArrayList<>();
    }

    public void addSkill(String name, String DESCRIPTION, char TYPE, String STAT_TARGET, int STAT_VALUE, int SP_COST, int DURATION) {
        this.SKILLS.add(new Skill(name, DESCRIPTION, TYPE, STAT_TARGET, STAT_VALUE, SP_COST, DURATION));
    }

    public int numSkills() {
        return this.SKILLS.size();
    }

    public Skill useSkill() {
        char choice;
        print();
        System.out.println("Please select an skill from the list above: ");
        Skill selectedSkill = SKILLS.get(scanner.nextInt() - 1);
        selectedSkill.print();
        do {
            System.out.println("Would you like to use " + selectedSkill.name + "? [(y)es/(n)o]");
            choice = scanner.next().toLowerCase().charAt(0);
            if(choice == 'n') {
                return null;
            }
        }while(choice != 'y' && choice != 'n');
        return selectedSkill;
    }

    public void print() {
        for(int i = 0; i < SKILLS.size(); i++) {
            Skill skill = SKILLS.get(i);
            System.out.println(i+1 + " : " + skill.name + " , " + skill.SP_COST + " SP");
        }
    }

}
