package processor;

import exceptions.handling.ScannerException;
import items.ItemGenerator;
import player.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseItem implements ScannerException {

    public void start() {
        System.out.println("Какой предмет вы хотите взять?");
        System.out.println("0: назад");
    }

    public int initItemIndex(ItemGenerator itemGenerator, Player player, Scanner scanner) {
        System.out.println("Какой предмет вы хотите взять?\n" +
                "0: назад\n");
        System.out.println(itemGenerator.getItemArray(player.playerLocation.id - 1));
        return this.isInputCorrect(scanner);
    }

    public boolean checkAvailableItems(ItemGenerator itemGenerator, Player player) {
        if (itemGenerator.getItemsArrayLen(player.playerLocation.id -1) == 0) {
            System.out.println("На данной локации нет доступных вещей\n");
            return false;
        }
        return true;
    }

    public boolean checkItemsRange(int itemIndex, Player player, ItemGenerator itemGenerator) {
        if (itemIndex == -1) {
            printMessage("Неверный параметр\n");
            return false;
        }
        if (itemIndex > itemGenerator.getItemsArrayLen(player.playerLocation.id - 1) ||
        itemIndex < 0) {
            printMessage("Неверный параметр\n");
            return false;
        }
        return true;
    }

    @Override
    public int isInputCorrect(Scanner scanner) {
        int itemIndex;

        try {
            itemIndex = scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
        return itemIndex;
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
