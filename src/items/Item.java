package items;

import map.Location;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    String name;
    int weight;
    int cost;
    boolean usable;
    public ArrayList <ArrayList<Item>> items = new ArrayList<>();

    public Item() {}
    public Item(String name) {
        this.name = name;
    }
    public Item(String name, int weight, int cost, boolean usable) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.usable = usable;
    }
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name +
                ", вес = " + weight +
                ", стоимость = " + cost;
    }
}
