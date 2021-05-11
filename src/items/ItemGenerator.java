package items;

import java.util.ArrayList;
import java.util.Random;

public class ItemGenerator extends Item {

    static Item[] arr_items = {
            new Item("Поганка", 2, 1),
            new Item("Белый гриб", 4, 10),
            new Item("Драгоценность", 10, 100),
            new Item("Бинт", 5, 40),
            new Item("Мухомор", 3, 1),
            new Item("Шампиньонs", 5, 5),
            new Item("Монеты", 0, 1),
            new Item("Нож", 10, 80)
    };


    public int getArrItemsLength() {
        return arr_items.length;
    }

    public int getItemListSize() {
        return items.size();
    }

    public void generateItems() {
        for (int i = 0; i < 6; i++) {
            int rand = new Random().nextInt(arr_items.length);
            ArrayList<Item> arr = new ArrayList<>();
//            Item []arr = new Item[rand];
            for (int j = 0; j < rand; j++) {
                int secondRand = new Random().nextInt(arr_items.length);
                arr.add(j, arr_items[secondRand]);
            }
            items.add(arr);
        }
    }

    public String getItemArray(int index) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < items.get(index).size(); i++) {
            stringBuilder.append(i + 1).append(": ").append(items.get(index).get(i)).append('\n');
        }
        return stringBuilder.toString();
    }

    public Item getItemFromArray(int arrayIndex, int itemIndex) {
        return items.get(arrayIndex).get(itemIndex);
    }

    public void removeItemFromMap(int arrayIndex, int itemIndex) {
        items.get(arrayIndex).remove(itemIndex);
    }

    public void printList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.get(i).size(); j++) {
                stringBuilder.append(items.get(i).get(j)).append(", ");
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder.toString());
    }
}
