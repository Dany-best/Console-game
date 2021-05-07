import items.DroppedItem;
import items.Item;
import items.PlayerInventory;

import java.util.Arrays;

public class Player {
    int health;
    long money;
    PlayerInventory playerInventory = new PlayerInventory();
    Location playerLocation;
    Location location = new Location();

    public Player() {
        playerLocation = location.locations.get(1);
    }

    public void lookAround() {
        System.out.println("Current location is");
        System.out.println(playerLocation);
        System.out.println("Available locations:");
        int []arr = location.getNext(playerLocation);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 +" " + location.locations.get(arr[i]));
        }

    }


    public void go(int id) {
        int []arr = location.getNext(playerLocation);
        boolean check = false;
        int remind = 0;
        for (int i = 0; i < arr.length; i++) {
            if (id == i + 1) {
                check = true;
                remind = arr[i];
            }
        }
        if (!check) {
            System.err.println("Incorrect way choose another one");
        }
        else {
            playerLocation = location.getLocationById(remind);
        }
    }
    public void pickUpItem(Item item) {

    }
    public void dropItem(Item item) {

    }
    public void take(Item item) {
        playerInventory.putIntoInventory(item);
    }
    public void use(Item item) {

    }

}
