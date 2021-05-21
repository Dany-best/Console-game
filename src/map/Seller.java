package map;

import player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Seller extends Location{
    public void sellerLocationScenario(Player player) throws InputMismatchException {
        System.out.println("Что вы хотите продать?\n0: Назад\n");

        player.playerInventory.printInventoryList();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0)
            return;
        if (choice > player.playerInventory.getInventorySize() || choice < 0) {
            System.out.println("Введен неверный параметр\n");
            return ;
        }
        player.addGold(player.playerInventory.getItemByIndex(choice - 1).getCost());
        System.out.println();
        player.increaseInventoryCapacity(player.playerInventory.getItemByIndex(choice - 1));
        player.playerInventory.deleteItemFromInventory(player.playerInventory.getItemByIndex(choice - 1));
    }
}
