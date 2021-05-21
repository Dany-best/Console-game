package map;

import items.Item;
import items.PlayerInventory;
import player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DangerLocation extends Location {

    public boolean dangerLocationScenario(Player player) throws InputMismatchException {
        int choice;
        int damage;

        while (true) {
            System.out.println("На вас напали дикие кабаны, защищаться ножом?\n1: да\n" +
                    "2: отбиться как есть\n" +
                    "3: отступить");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if (choice == 1) {
                damage = 20;
                if (player.playerInventory.findInventoryItem("Нож")) {
                    player.playerInventory.deleteItemFromInventory(new Item("Нож"));
                    System.out.println("Урон: " + damage);
                    player.damageHealth(damage);
                    return true;
                }
                else {
                    System.out.println("В инвентаре нет ножа");
                }
            }
            else if (choice == 2) {
                String message = "Это была мощная схватка, удалось ли вам выжить? Урон: ";
                defenceWithoutKnife(80, message, player);
                return true;
            }
            else {
                String message = "Вам удалось убежать, но вас немного потрепало. Урон: ";
                defenceWithoutKnife(30, message, player);
                return false;
            }
        }
    }

    public void startDangerLocationScenario(Player player) {

            if (dangerLocationScenario(player)) {
                player.playerLocation = new Location().getLocationById(5);
                System.out.println("Вы на локации грибное место! Соберите нужные вещи!");
            }
            else {
                player.playerLocation = new Location().getLocationById(1);
            }
    }

    public static boolean isLocationDanger(Player player) {
        return player.playerLocation.id == 4;
    }

    public void defenceWithoutKnife(int damage, String message, Player player) {
        System.out.println(message + damage);
        player.damageHealth(damage);
    }

}
