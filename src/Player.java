import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeffbahns on 1/10/16.
 */
public class Player extends Person {
    public ItemContainer Items = new ItemContainer();
    private Scanner scanner = new Scanner(System.in);


    public Player() {
        super("Corey",1, 1, 1, 1, 1, new SkillContainer());
    }

    public Player(String name, int level,  int HP, int ATK, int DEF, int AGI, SkillContainer SKILLS) {
        super(name, level, HP, ATK, DEF, AGI, SKILLS);
    }


    public String listItems() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.Items.size(); i++) {
            str.append((i + 1) + ". " + Items.get(i).name + "\n");
        }

        return str.toString();
    }

    public void useItem() {
        System.out.println("\nPlease select an item from the list above: ");
        //Scans in index of item to get from ITEMS
        String selectedItem = Items.get(scanner.nextInt() - 1).toString();
        //Prints out Item info
        //TODO: Print Item info, and then ask if they want to use it
        System.out.println(selectedItem);
        //TODO: Have Items Affect Persons in Combat

    }
}



