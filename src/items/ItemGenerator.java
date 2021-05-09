package items;

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

    public void generateItems() {
        for (int i = 0; i < 6; i++) {
            int rand = new Random().nextInt(arr_items.length);
            Item []arr = new Item[rand];
            for (int j = 0; j < rand; j++) {
                int secondRand = new Random().nextInt(arr_items.length);
                arr[j] = arr_items[secondRand];
            }
            items.add(arr);
        }
    }

    public String getItemArray(int index) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < items.get(index).length; i++) {
            stringBuilder.append(items.get(i)).append(", ");
        }
        return stringBuilder.toString();
    }
    public String printList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.get(i).length; j++) {
                stringBuilder.append(items.get(i)[j]).append(", ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
