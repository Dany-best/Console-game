package player;

import items.Item;
import items.PlayerInventory;
import map.Location;

public class Player {
    int health = 100;
    public int hunger = 100;
    public int numberOfAvailableLocations;
    long gold;
    public PlayerInventory playerInventory = new PlayerInventory();
    public Location playerLocation;
    Location location = new Location();

    public Player() {
        playerLocation = location.locations.get(1);
    }

    public void lookAround() {
        System.out.println("Ваша локация:");
        System.out.println(playerLocation);
        System.out.println("Доступные локации:");
        int []arr = location.getNext(playerLocation);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 +" " + location.locations.get(arr[i]));
        }
        System.out.println("Здоровье: " + health);
        System.out.println("Сытость: " + hunger);
        System.out.println("Монеты: " + gold);
        System.out.println();
    }

    public void printAvailableLocations() {
        numberOfAvailableLocations = 0;
        int []arr = location.getNext(playerLocation);
        System.out.println("Доступные локации:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 +" " + location.locations.get(arr[i]));
            numberOfAvailableLocations++;
        }
        System.out.println();
    }

    public void printCurrentLocation() {
        System.out.println("Текущая локация" + playerLocation + "\n");
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
            System.err.println("Неверный путь, выберите другой");
        }
        else {
            playerLocation = location.getLocationById(remind);
        }
        System.out.println();
    }

    public void damageHealth(int damage) {
        health -= damage;
        checkHealth();
    }

    public void checkHealth() {
        if (health <= 0) {
            System.out.println("Your health is " + health + "\nGame over");
            System.exit(0);
        }
    }

    public void useItem(Item item) {
        switch (item.getName()) {
            case "Поганка":
                hunger += 10; health -= 10; break;
            case "Белый гриб":
                hunger += 10; health += 10; break;
            case "Бинт":
                health += 30; break;
            case "Мухомор":
                hunger += 20; health -= 20; break;
            case "Шампиньонs" :
                hunger += 15; break;
        }
        playerInventory.deleteItemFromInventory(item);
        checkHealth();
    }

    public void addGold(int itemCost) {
        gold += itemCost;
    }
}
