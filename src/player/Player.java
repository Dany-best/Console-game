package player;

import items.Item;
import items.ItemGenerator;
import items.PlayerInventory;
import map.Location;

public class Player {
    int health = 100;
    int hunger = 100;
    int inventoryCapacity = 10;
    public int numberOfAvailableLocations;
    long gold;
    public PlayerInventory playerInventory = new PlayerInventory();
    public Location playerLocation;
    Location location = new Location();

    public Player() {
        playerLocation = location.locations.get(1);
    }

    public int getInventoryCapacity() {
        return inventoryCapacity;
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
        System.out.println("Размер инвентаря: " + inventoryCapacity);
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
            if (hunger < 80 && hunger > 50)
                health -= 5;
            else if (hunger < 50)
                health -= 10;
            hunger -= 10;
            checkHealth();
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
                System.out.println("Сытость: +10, Здоровье -10");
                hunger += 10; health -= 10; inventoryCapacity += ItemGenerator.arr_items[0].getWeight(); break;
            case "Белый гриб":
                System.out.println("Сытость: +10, Здоровье +10");
                hunger += 10; health += 10; inventoryCapacity += ItemGenerator.arr_items[1].getWeight(); break;
            case "Бинт":
                System.out.println("Здоровье +30");
                health += 30; inventoryCapacity += ItemGenerator.arr_items[3].getWeight(); break;
            case "Мухомор":
                System.out.println("Сытость: +20, Здоровье -20");
                hunger += 20; health -= 20; inventoryCapacity += ItemGenerator.arr_items[4].getWeight(); break;
            case "Шампиньонs" :
                System.out.println("Сытость: +15");
                hunger += 15; inventoryCapacity += ItemGenerator.arr_items[5].getWeight(); break;
        }
        if (hunger > 100) {
            hunger = 100;
        }
        if (health > 100) {
            health = 100;
        }
        playerInventory.deleteItemFromInventory(item);
        checkHealth();
    }

    public void increaseInventoryCapacity(Item item) {
        inventoryCapacity += item.getWeight();
    }
    public void decreaseInventoryCapacity(Item item) {
        inventoryCapacity -= item.getWeight();
    }

    public void addGold(int itemCost) {
        gold += itemCost;
    }
}
