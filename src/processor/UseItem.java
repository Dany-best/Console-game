package processor;

import exceptions.handling.ScannerException;
import player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseItem implements ScannerException {

    public boolean checkUsableItemsRange(int itemIndex, Player player) {
        if (itemIndex > player.playerInventory.getNumberOfUsableItems() ||
        itemIndex < 0) {
            System.out.println("Неверный параметр\n");
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

    }
}
