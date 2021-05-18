package processor;

import exceptions.handling.ScannerException;
import player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseLocation implements ScannerException {

    public void start(Player player) {
        System.out.println("Выберите локацию");
        player.printAvailableLocations();
        System.out.println("0: Назад");
    }

    public boolean chooseLocation(int way, Player player) {
        if (way == -1 || !checkLocationRange(way, player)) {
            printMessage("Неверный параметр\n");
            return false;
        }
        return true;
    }

    public boolean checkLocationRange(int way, Player player) {
        return player.numberOfAvailableLocations >= way && way >= 0;
    }

    @Override
    public int isInputCorrect(Scanner scanner) {
        int way;

        try {
            way = scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
        return way;
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
