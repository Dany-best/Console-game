import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to start game");
        if (scanner.nextLine().length() != 0)
            return ;
        Player player = new Player();
        player.lookAround();

        while (true) {
            System.out.println("What would you like to do? ");
            System.out.println("1: Go somewhere");
            System.out.println("2: Pickup item");
            System.out.println("3: Look around");
            int check;

            try {
                check = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect parameter\n");
                scanner = new Scanner(System.in);
                continue;
            }
            if (check > 3 || check <= 0) {
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
            else if (check == 3) {
                player.lookAround();
            }
            check = 0;
        }

    }
}
