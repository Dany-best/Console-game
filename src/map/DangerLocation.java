package map;

import items.Item;
import items.PlayerInventory;

public class DangerLocation extends Location {


    public void dangerLocationScenario(PlayerInventory playerInventory) {
        System.out.println("На вас напали волки, чем обороняться?");
        playerInventory.printInventoryList();
    }

}
