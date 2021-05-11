package items;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerInventory {
    List<Item> items = new ArrayList<>();

    public void putIntoInventory(Item item) {

    }

    public void printInventoryList() {

        Iterator <Item> itemIterator = new Iterator<Item>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public Item next() {
                return items.get(index++);
            }
        };

        for (Item item : items) {
            System.out.println(item);
        }
    }

}
