package items;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    public List<Item> items = new ArrayList<>();

    public void putIntoInventory(Item item) {
        items.add(item);
    }
    public void printLatestItemFromInventory() {
            System.out.println(items.get(items.size() - 1) + "\n");
    }
    public void printInventoryList() {
        if (getInventorySize() == 0) {
            System.out.println("В инвентаре нет вещей\n");
        }
        else {
            int count = 1;
            for (Item item : items) {
                System.out.println(count++ + ": " + item);
            }
        }
    }
    public Item getItemByIndex(int index) {
        return items.get(index);
    }

    public ArrayList<Item> getUsableItems() {
        ArrayList <Item> usableItems = new ArrayList<>();

        if (getInventorySize() == 0) {
            System.out.println("В инвентаре нет вещей\n");
        }
        else {
            for (Item item : items) {
                if (item.usable) {
                    usableItems.add(item);
                }
            }
        }
        return usableItems;
    }

    public void printUsableItems() {
        if (getInventorySize() == 0) {
            System.out.println("В инвентаре нет вещей\n");
        }
        else {
            int count = 1;
            for (Item item : items) {
                if (item.usable) {
                    System.out.println(count++ + " " + item);
                }
            }
        }
    }

    public int getNumberOfUsableItems () {
        if (getInventorySize() == 0) {
            System.out.println("В инвентаре нет вещей\n");
        }
        else {
            int count = 0;
            for (Item item : items) {
                if (item.usable) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    public boolean findInventoryItem(String itemName) {
        for (int i = 0; i < getInventorySize(); i++) {
            if (itemName.equals(items.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public void deleteItemFromInventory(Item item) {
        for (int i = 0; i < getInventorySize(); i++) {
            if (item.getName().equals(items.get(i).getName())) {
                items.remove(i);
                return;
            }
        }
    }

    public int getInventorySize() {
        return items.size();
    }

}
