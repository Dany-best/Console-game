import items.*;
import map.*;
import player.Player;
import processor.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    static Scanner createScanner() {
        return new Scanner(System.in);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChooseLocation chooseLocation = new ChooseLocation();
        ChooseItem chooseItem = new ChooseItem();
        UseItem useItem = new UseItem();
        System.out.println("Нажмите 'enter', чтобы начать");
        if (scanner.nextLine().length() != 0)
            return ;
        Player player = new Player();
        Input input = new Input();
        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
        player.lookAround();

        int way;
        while (true) {
            int check;
            if (DangerLocation.isLocationDanger(player)) {
                DangerLocation dangerLocation = new DangerLocation();
                dangerLocation.startDangerLocationScenario(player);
                continue;
            }

            Processor.printAvailableToDos(player.playerLocation);
            check = new Input().getInput(scanner);

            if (check == -1 || !input.isCheckInRange(check, player.playerLocation)) {
                input.incorrectParamMessage();
                scanner = createScanner();
                continue;
            }

            if (check == 1) {
                chooseLocation.start(player);
                way = chooseLocation.isInputCorrect(scanner);
                if (!chooseLocation.chooseLocation(way, player) || way == 0) {
                    scanner = createScanner();
                    continue;
                }
                player.go(way);
                System.out.println("Ваша локация: " + player.playerLocation + '\n');
            }
            else if (check == 2) {
                int itemIndex;

                if (!chooseItem.checkAvailableItems(itemGenerator, player)) {
                    continue;
                }

                itemIndex = chooseItem.initItemIndex(itemGenerator, player, scanner);

                if (!chooseItem.checkItemsRange(itemIndex, player, itemGenerator) || itemIndex == 0) {
                    scanner = createScanner();
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
                itemIndex = useItem.isInputCorrect(scanner);
                if (itemIndex == -1) {
                    scanner = createScanner();
                    continue;
                }
                if (itemIndex == 0)
                    continue;
                if (!useItem.checkUsableItemsRange(itemIndex, player))
                    continue;
                player.useItem(usableItems.get(itemIndex - 1));
            }
            else if (check == 6) {
                return;
            }
            else if (check == 7) {
                Seller seller = new Seller();
                seller.sellerLocationScenario(player);
            }
        }
    }
}
