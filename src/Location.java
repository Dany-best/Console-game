import java.util.*;

public class Location {
    int id;
    String name;
    String description;
    List <Location> locations;

    public Location(int id, String name, String description, LocationType locationType) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Location() {
        locations = new ArrayList<>(Arrays.asList(
                new Location(1, "Опушка леса", "рядом есть торговец", LocationType.SELLER),
                new Location(2, "Протоптанная дорога", "здесь ничего", LocationType.NOTHING),
                new Location(3, "Чаща", "тут есть что то интересное", LocationType.LOOT),
                new Location(4, "Опасная тропа", "ведет к грибному месту", LocationType.DANGER),
                new Location(5, "Родник", "а здесь спокойно", LocationType.NOTHING),
                new Location(6, "Грибное место", "здесь можно собрать грибы", LocationType.LOOT)
        ));
    }

    public Location getLocationById (int id) {
        return locations.get(id);
    }

    public int[] getNext(Location location) {
        switch (location.id) {
            case 1:
            case 3: return new int[]{1};
            case 2: return new int[]{0, 2, 3, 4};
            case 5: return new int[]{1, 2};
            case 4: return new int[]{1, 5};
            case 6: return new int[]{2};
            default: return new int[]{0};
        }
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
    enum LocationType {
        LOOT, DANGER, NOTHING, SELLER;
    }
}
