public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 3, 4, 5, 5, 8, 9, 10};
        for (int coursor = 0; coursor < array.length-1; coursor++) {
            for (int coursor1 =coursor+1;coursor1<array.length-1;coursor1++) {
                if(array[coursor]==array[coursor1]){
                    System.out.println("Afisam duplicatele " +array[coursor1]);
                }
            }
        }
    }
}
