package Model;

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
        str.append("---ITEMS LIST---\n");
        for(int i = 0; i < this.Items.size(); i++) {
            str.append((i + 1) + ". " + Items.get(i).name + "\n");
        }

        return str.toString();
    }

    public void useItem() {
        char choice;
        System.out.println("Please select an item from the list above: ");
        //Scans in index of item to get from ITEMS
        String selectedItem = Items.get(scanner.nextInt() - 1).toString();
        //Prints out Model.Item info
        System.out.println(selectedItem);
        do {
            System.out.println("Would you like to use this Item? [(y)es/(n)o]");
            //Scan for yes or no
            choice = scanner.next().toLowerCase().charAt(0);
            //TODO: Have Items Affect Persons in Combat

        }while(choice != 'y' && choice != 'n');

    }

    //TODO: Special Item usage method
    public void useItemWorldState() {}
}



