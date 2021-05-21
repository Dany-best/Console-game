package items;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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
            Stream.iterate(0, x -> x + 1).limit(items.size()).forEach(x ->
                    System.out.println(x + 1 + ": " + items.get(x)));
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
            items.stream()
                    .filter(x -> x.usable)
                    .forEach(usableItems::add);
        }
        return usableItems;
    }

    public void printUsableItems() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        items.stream().
                filter(item -> item.usable)
                .peek(x -> atomicInteger.getAndIncrement())
                .forEach(res -> System.out.println(atomicInteger + " " + res));
    }

    public int getNumberOfUsableItems () {
        if (getInventorySize() == 0) {
            System.out.println("В инвентаре нет вещей\n");
        }
        else {
            return (int)items.stream()
                    .filter(item -> item.usable)
                    .count();
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

    public static Item getItemByName(Item item) {
        for (int i = 0; i < ItemGenerator.arr_items.length; i++) {
            if (item.getName().equals(ItemGenerator.arr_items[i].getName()))
                return ItemGenerator.arr_items[i];
        }
        return null;
    }

    public int getInventorySize() {
        return items.size();
    }

}
