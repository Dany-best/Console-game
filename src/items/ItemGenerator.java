package items;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class ItemGenerator extends Item {

    static Item[] arr_items = {
            new Item("Поганка", 2, 1, true),
            new Item("Белый гриб", 4, 10, true),
            new Item("Драгоценность", 10, 100, false),
            new Item("Бинт", 5, 40, true),
            new Item("Мухомор", 3, 1, true),
            new Item("Шампиньонs", 5, 5, true),
            new Item("Монеты", 0, 1, false),
            new Item("Нож", 10, 80, false)
    };


    /*
        random item generation for locations according to type location
     */
    private int getRandom(int arrayPosition) {
        switch (arrayPosition) {
            case 0: return 2;
            case 1: return 1;
            case 2: return 3;
            case 4: return 5;
            case 5: return 8;
            default: return 4;
        }
    }

    public void generateItems() {
        for (int i = 0; i < 6; i++) {
            int rand = getRandom(i);
            ArrayList<Item> arr = new ArrayList<>();
            for (int j = 0; j < rand; j++) {
                int secondRand = new Random().nextInt(arr_items.length) ;
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

    public int getItemsArrayLen(int index) {
        return items.get(index).size();
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
