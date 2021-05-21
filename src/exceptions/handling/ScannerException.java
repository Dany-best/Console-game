package exceptions.handling;

import java.util.Scanner;


public interface ScannerException {
    public int isInputCorrect(Scanner scanner);
    public void printMessage (String message);
}
