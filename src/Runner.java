import items.ItemGenerator;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to start game");
        if (scanner.nextLine().length() != 0)
            return ;
        Player player = new Player();
        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
        player.lookAround();

        int way = 0;
        while (true) {
            int check;
            int rand;

            System.out.println("Что вы хотите сделать?\n" +
                    "1: Идти\n" +
                    "2: Взять предмет\n" +
                    "3: Осмотреться\n" +
                    "4: Выход\n");
            try {
                check = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Неверный параметр\n");
                scanner = new Scanner(System.in);
                continue;
            }
            if (check > 4 || check <= 0) {
                System.err.println("Неверный параметр\n");
                continue;
            }
            if (check == 1) {
                System.out.println("Выберите локацию");
                player.printAvailableLocations();
                System.out.println("0: Назад");
                way = scanner.nextInt();
                if (way == 0) {
                    continue;
                }
                player.go(way);
                player.lookAround();
            }
            else if (check == 2) {
//                rand = new Random().nextInt(itemGenerator.getItemListSize() - 1);
                System.out.println("Какой предмет вы хотите взять?");
                System.out.println(itemGenerator.getItemArray(player.playerLocation.id - 1));

            }
            else if (check == 3) {
                player.lookAround();
            }
            else if (check == 4) {
                return ;
            }
        }

    }
}
