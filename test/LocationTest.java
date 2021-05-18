import items.Item;
import items.ItemGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.*;
import player.Player;
import processor.*;

import static org.junit.Assert.assertEquals;


public class LocationTest {

    private static ChooseItem chooseItem;
    private  static ChooseLocation chooseLocation;
    private static Input input;
    private static Processor processor;
    private static UseItem useItem;
    private static Player player;

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
    public void inventoryTest() {
        player.playerInventory.putIntoInventory(new Item("first"));
        player.playerInventory.putIntoInventory(new Item("second"));
        player.playerInventory.putIntoInventory(new Item("third"));
        player.playerInventory.putIntoInventory(new Item("fourth"));



    }

}
