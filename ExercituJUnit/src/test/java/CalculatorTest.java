import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void adunareTest() {
        System.out.println("Testam adunarea");
        int a = 3;
        int b = 5;
        int sum = calculator.adunare(a, b);
        assertEquals(sum, 8);
    }

    @Test
    public void scadereTest() {
        System.out.println("Testam scaderea");
        int a = 3;
        int b = 2;
        int scadere = calculator.scadere(a, b);
        assertEquals(scadere, 1);
    }

    @Test
    public void inmultireTest() {
        System.out.println("Testam inmultirea");
        int a = 2;
        int b = 1;
        int inmultire = calculator.inmultire(a, b);
        assertEquals(inmultire, 2);

    }

    @Test
    public void impartire() {
        System.out.println("Testam impartirea");
        int a = 4;
        int b = 2;
        int impartire = calculator.impartire(a, b);
        assertEquals(impartire, 2);
    }
}
