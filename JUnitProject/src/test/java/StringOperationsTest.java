import org.junit.*;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringOperationsTest {
    StringOperations stringOperations = new StringOperations();

    @BeforeClass
    public static void intialized() {
        System.out.println("Staring teste at " +System.currentTimeMillis());
    }

    @Before
    public void beforeRunningTest() {
        System.out.println("Testul a inceput la " +System.currentTimeMillis());

    }

    @Test
    public void stringLengthTest() {
        System.out.println("Rulam testul pentru string length");
        String text = "Alex";
        int result = stringOperations.stringLength(text);
        //dam import pentru a importa noua functie assertEquals
        assertEquals(result, 4);

    }

    @Test
    public void stringConcatenareTest() {
        System.out.println("Rulam testul pentru concatenare");
        String text1 = "Ana";
        String text2 = "mere";
        String result = stringOperations.concatenare(text1, text2);
        assertEquals(result, "Anamere");
    }

    @Test
    public void stringContainsTest() {
        System.out.println("Rulam testul de contains");
        String text1 = "Toamna";
        String text2 = "am";
        boolean result = stringOperations.stringContains(text1, text2);
        assertTrue(result);
    }

    @After
    public void afterRunningTest() {
        System.out.println("Ma execut dupa test " +System.currentTimeMillis());
    }

    @AfterClass
    public static void end() {
        System.out.println("Testul sa terminat " +System.currentTimeMillis());
    }
}

