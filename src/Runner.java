import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Player player = new Player();
        player.lookAround();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int check = scanner.nextInt();
            player.go(check);
            player.lookAround();
        }

    }
}
