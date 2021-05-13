import items.Item;
import items.ItemGenerator;

import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Нажмите 'enter', чтобы начать");
        if (scanner.nextLine().length() != 0)
            return ;
        Player player = new Player();
        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
        player.lookAround();

        int way;
        while (true) {
            int check;

            System.out.println("Что вы хотите сделать?\n" +
                    "1: Идти\n" +
                    "2: Взять предмет\n" +
                    "3: Осмотреться\n" +
                    "4: Посмотреть инвентарь\n" +
                    "5: Воспользоваться предметом\n" +
                    "6: Выход\n");
            try {
                check = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Неверный параметр\n");
                scanner = new Scanner(System.in);
                continue;
            }
            if (check > 6 || check <= 0) {
                System.err.println("Неверный параметр\n");
                continue;
            }
            if (check == 1) {
                System.out.println("Выберите локацию");
                player.printAvailableLocations();
                System.out.println("0: Назад");
                try {
                    way = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Неверный параметр\n");
                    scanner = new Scanner(System.in);
                    continue;
                }
                if (way == 0) {
                    continue;
                }
                player.go(way);
                player.lookAround();

            }
            else if (check == 2) {
                int itemIndex;
                player.playerInventory.printInventoryList();
                System.out.println("Какой предмет вы хотите взять?");
                System.out.println("0: назад");

                if (itemGenerator.getItemsArrayLen(player.playerLocation.id -1) == 0) {
                    System.out.println("На данной локации нет доступных вещей\n");
                    continue;
                }
                System.out.println(itemGenerator.getItemArray(player.playerLocation.id - 1));

                try {
                    itemIndex = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Неверный параметр\n");
                    scanner = new Scanner(System.in);
                    continue;
                }
                if (itemIndex == 0)
                    continue;
                if (itemIndex > itemGenerator.getItemsArrayLen(player.playerLocation.id - 1) ||
                itemIndex < 0) {
                    System.err.println("Неверный параметр\n");
                    continue;
                }
                player.playerInventory.putIntoInventory(itemGenerator.getItemFromArray(player.playerLocation.id - 1,
                        itemIndex - 1));
                itemGenerator.removeItemFromMap(player.playerLocation.id - 1, itemIndex - 1);
                System.out.print("Вы взяли: ");
                player.playerInventory.printLatestItemFromInventory();
            }
            else if (check == 3) {
                player.lookAround();
            }
            else if (check == 4) {
                player.playerInventory.printInventoryList();
            }
            else if (check == 5) {
                int itemIndex;
                System.out.println("Выберите предмет:");
                System.out.println("0: Назад");
                player.playerInventory.printUsableItems();
                ArrayList <Item> usableItems = player.playerInventory.getUsableItems();
                try {
                    itemIndex = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Неверный параметр\n");
                    scanner = new Scanner(System.in);
                    continue;
                }
                if (itemIndex == 0)
                    continue;
//                if (itemIndex > player.playerInventory.getInventorySize() - 1 ||
//                        itemIndex < 0) {
//                    System.err.println("Неверный параметр\n");
//                    continue;
//                }
                player.useItem(usableItems.get(itemIndex - 1));
            }
            else if (check == 6) {
                return ;
            }
        }
    }
}
