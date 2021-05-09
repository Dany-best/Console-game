package items;

import map.Location;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    String name;
    int weight;
    int cost;
    public ArrayList <Item[]> items = new ArrayList<>();

    public Item() {}
    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
