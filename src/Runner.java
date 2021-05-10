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

        while (true) {
            int check;
            int rand;

            System.out.println("What would you like to do?\n" +
                    "1: Go somewhere\n" +
                    "2: Pickup item\n" +
                    "3: Look around\n" +
                    "4: Close game\n");
            try {
                check = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect parameter\n");
                scanner = new Scanner(System.in);
                continue;
            }
            if (check > 4 || check <= 0) {
                System.err.println("Incorrect parameter\n");
                continue;
            }
            if (check == 1) {
                System.out.println("Where would you like to go?");
                player.printAvailableLocations();
                int way = scanner.nextInt();
                player.go(way);
                player.lookAround();
            }
            else if (check == 2) {
                rand = new Random().nextInt(itemGenerator.getItemListSize() - 1);
                System.out.println(itemGenerator.getItemArray(rand));
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
