package processor;

import exceptions.handling.ScannerException;
import map.Location;
import player.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input implements ScannerException {
    int input;

    public Input() {

    }

    public int getInput (Scanner scanner) {
        this.input = isInputCorrect(scanner);
//        if (input == -1) {
//            incorrectParamMessage();
//        }
        return input;
    }

    public boolean isCheckInRange(int check, Location location) {
        if (location.id == 1 && check <= 7 && check >= 1) {
            return true;
        }
        else {
            return check <= 6 && check >= 1;
        }
    }


    @Override
    public int isInputCorrect(Scanner scanner) {
        int check;
        try {
            check = scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
        return check;
    }

    public void incorrectParamMessage() {
        printMessage("Неверный параметр");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
