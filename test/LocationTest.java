import org.junit.*;
import player.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
//
//import static junit.framework.TestCase.fail;



public class LocationTest {
    private static final PrintStream originalOut = System.out;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static Player player;

    private void print(String output) {
        System.out.println(output);
    }

    @BeforeClass
    public static void createNewPlayer() {
        System.setOut(originalOut);
        player = new Player();
    }
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        print("Hello Baeldung Readers!!");
        Assert.assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString().trim());
    }
    }

