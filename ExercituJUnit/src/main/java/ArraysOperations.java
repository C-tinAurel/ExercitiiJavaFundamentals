public class ArraysOperations {

    public int lungimeArray(int[] numereIntregi) {
        return numereIntregi.length;

    }

    public int numereMaiMari(int[] numereMari) {
        int numere = 0;
        for (int x = 0; x < numereMari.length; x++) {
            if (numereMari[x] > 5) {
                numere++;
            }
        }
        return numere;
    }



}
