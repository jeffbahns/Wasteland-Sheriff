/**
 * Created by Corey on 1/11/16.
 */
public class Item {

    public String name;
    public String description;
    public char type;
    public int quantity;

    public Item(String name, String description, char type) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.quantity = 1;
    }

    public String toString() {
        String message= "Name: " + this.name + "\n----\n" + "Description:\n" + this.description + "\n---\n"
                + "Type: " + this.type + "\n----\n";

        return message;
    }


}
