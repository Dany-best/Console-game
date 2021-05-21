package processor;

import items.ItemGenerator;
import map.Location;
import player.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processor {
    public static void printAvailableToDos(Location location) {
        System.out.println("Что вы хотите сделать?\n" +
                "1: Идти\n" +
                "2: Взять предмет\n" +
                "3: Осмотреться\n" +
                "4: Посмотреть инвентарь\n" +
                "5: Воспользоваться предметом\n" +
                "6: Выход");
        if (location.id == 1) {
            System.out.println("7: Продать вещи");
        }
    }
    public static void itemTakeProcessor(ItemGenerator itemGenerator, Player player, int itemIndex) {
        player.playerInventory.putIntoInventory(itemGenerator.getItemFromArray(player.playerLocation.id - 1,
                itemIndex - 1));
        itemGenerator.removeItemFromMap(player.playerLocation.id - 1, itemIndex - 1);
        System.out.print("Вы взяли: ");
        player.playerInventory.printLatestItemFromInventory();
    }
    public static void useItemProcessor(Player player) {
        System.out.println("Выберите предмет:");
        System.out.println("0: Назад");
        player.playerInventory.printUsableItems();
    }
 }
