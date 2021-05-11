package items;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerInventory {
    List<Item> items = new ArrayList<>();

    public void putIntoInventory(Item item) {
        items.add(item);
    }

    public void printInventoryList() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

}
