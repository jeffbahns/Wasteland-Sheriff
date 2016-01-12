package Model;

/**
 * Created by Corey on 1/11/16.
 */
public class Item {

    public String name;
    public String description;
    //What Stat it targets
    public String statTarget;
    //Amount statTarget affects stat for
    public int statValue;
    public char type;
    public char target;
    public int quantity;

    public Item(String name, String description, String statTarget, int statValue, char type, char target) {
        this.name = name;
        this.description = description;
        this.statTarget = statTarget;
        this.statValue = statValue;
        this.type = type;
        this.target = target;
        this.quantity = 1;
    }

    public String toString() {

        String message= "Name: " + this.name + "\n----\n" + "Description:\n" + this.description + "\n---\n"
                + "Type: " + typeHelper() + "\n----\n";

        return message;
    }

    private String typeHelper() {
        if(type == 'o')
            return "Offense";
        if(type == 'd')
            return "Defense";
        if(type == 'u')
            return "Utility";
        if(type == 'r')
            return "Recovery";

        return null;
    }


}
