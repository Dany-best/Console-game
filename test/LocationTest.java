import items.Item;
import items.ItemGenerator;
import jdk.jfr.StackTrace;
import org.w3c.dom.ls.LSOutput;

public class LocationTest {

    public static void main(String[] args) {
        ItemGenerator itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
        System.out.println(itemGenerator.printList());
    }

}
