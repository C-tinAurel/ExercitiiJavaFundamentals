import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorStiintificTest {
    CalculatorStiintific calculatorStiintific = new CalculatorStiintific();

    @Test
    public void ridicareaLaPutereTest() {
        System.out.println("Aici afisa ridicarea la putere");
        double a = 2;
        double b = 2;
        double ridicarePutere = calculatorStiintific.ridicareLaPutere(a, b);

        assertEquals(ridicarePutere, 4, 0.1);
    }

    @Test
    public void radicalDintrunNumarTest() {
        System.out.println("Testam radical dintr-un numar");
        int a = 9;
        double radical = calculatorStiintific.radicalDintrunNumar(a);
        assertEquals(radical, 3, 0.1);
    }


}
