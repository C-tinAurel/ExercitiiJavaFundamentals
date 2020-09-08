import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArrayOperationsTest {
    ArraysOperations arraysOperations = new ArraysOperations();

    @Test
    public void lungimeaArrayTest() {
        System.out.println("Test lungime array");
        int[] numere = {2, 1, 3, 4};
        int result = arraysOperations.lungimeArray(numere);
        assertEquals(result, 4);
    }

    @Test
    public void numereMaiMariTest(){
        System.out.println("Test numere mai mari ca 5");
        int[] numere={2,6,1,10,7};
        int result= arraysOperations.numereMaiMari(numere);
        assertEquals(result,3);
    }


}
