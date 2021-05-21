import org.junit.*;
import player.Player;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import items.Item;
import items.ItemGenerator;
import java.util.Scanner;
import processor.*;
import static org.junit.Assert.assertEquals;


public class LocationTest {

    private static ChooseItem chooseItem;
    private static ChooseLocation chooseLocation;
    private static Input input;
    private static Processor processor;
    private static UseItem useItem;
    private static Player player;
    private static ItemGenerator itemGenerator;
    private static ByteArrayOutputStream outContent;
    private static ByteArrayOutputStream errContent;
    private static PrintStream originalOut;
    private static PrintStream originalErr;

    @BeforeClass
    public static void createObjects() {
        chooseItem = new ChooseItem();
        chooseLocation = new ChooseLocation();
        input = new Input();
        processor = new Processor();
        useItem = new UseItem();
        player = new Player();
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalErr = System.err;
        itemGenerator = new ItemGenerator();
        itemGenerator.generateItems();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @After
    public void clearList() {
        player.playerInventory.items.clear();
    }

    @Test
    public void incorrectLocationInputShouldReturnMinusOne() {
        assertEquals(-1, chooseLocation.isInputCorrect(
                new Scanner("incorrect input")));
    }

    @Test
    public void incorrectChooseItemShouldRetirnMinusOne() {
        assertEquals(-1, chooseItem.isInputCorrect(
                new Scanner("incorrect input")));
    }

    @Test
    public void incorrectInputShouldReturnMinusOne() {
        assertEquals(-1, input.isInputCorrect(
                new Scanner("incorrect input")
        ));
    }

    @Test
    public void incorrectUseItemShouldReturnMinusOne() {
        assertEquals(-1, useItem.isInputCorrect(
                new Scanner("incorrect input")
        ));
    }

    @Test
    public void lastItemShouldBeFourth() {
        player.playerInventory.putIntoInventory(new Item("first"));
        player.playerInventory.putIntoInventory(new Item("second"));
        player.playerInventory.putIntoInventory(new Item("third"));
        player.playerInventory.putIntoInventory(new Item("fourth"));
        player.playerInventory.printLatestItemFromInventory();
        assertEquals(player.playerInventory.items.get(3).toString(),
                outContent.toString().trim());
    }

    @Test
    public void dangerLocationNumberOfItemsShouldBeEight() {
        int len = itemGenerator.getItemsArrayLen(5);
        assertEquals(8, len);
    }

    @Test
    public void itemCostShouldBeRightAdded() {
        player.playerInventory.putIntoInventory(ItemGenerator.arr_items[2]);
        int gold = player.playerInventory.getItemByIndex(0).getCost();
        assertEquals(1, player.playerInventory.items.size());
        assertEquals(100, gold);
    }

    @Test
    public void playerGoShouldBeEqualToHisLocation() {
        assertEquals("Протоптанная дорога",
                player.playerLocation.getLocationName());
        player.go(2);
        assertEquals("Чаща", player.playerLocation.getLocationName());
        player.go(1);
        assertEquals("Протоптанная дорога",
                player.playerLocation.getLocationName());
        player.go(4);
        assertEquals("Родник",
                player.playerLocation.getLocationName());
        player.go(1);
        assertEquals("Протоптанная дорога",
                player.playerLocation.getLocationName());
        player.go(3);
        assertEquals("Опасная тропа",
                player.playerLocation.getLocationName());
        player.go(5);
        assertEquals("Опасная тропа",
                player.playerLocation.getLocationName());
    }

    @Test
    public void emptyInventoryShouldPrintNoItemsInInventory() {
        player.playerInventory.getNumberOfUsableItems();
        assertEquals("В инвентаре нет вещей",
                outContent.toString().trim());
    }
}

