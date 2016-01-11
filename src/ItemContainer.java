import java.util.ArrayList;

/**
 * Created by Corey on 1/11/16.
 */
public class ItemContainer {

    public ArrayList<Item> bin = new ArrayList<Item>();

    public void add(Item itemToAdd){
        this.bin.add(itemToAdd);
    }

    public void remove(Item itemToRemove) {
        this.bin.remove(itemToRemove);
    }

    public int size() {
        return this.bin.size();
    }

    public Item get(int i) {
        return this.bin.get(i);
    }

}
