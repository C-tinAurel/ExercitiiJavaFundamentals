public class Main {
    //Cerinta:
    //care este cel mai mare numar dintr-un vector
    //Avem un vector cu 10 elemente int,returnam cel mai mare numar
    public static void main(String[] args) {


        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        array[6] = 30;
        array[7] = 7;
        array[8] = 8;
        array[9] = 9;
        int numarMare = celMaiMareNumar(array);
        System.out.println("Cel mai mare numar este: " + numarMare);
    }

    public static int celMaiMareNumar(int[] array) {
        int celMaiMareNumar = array[0];

        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor] > celMaiMareNumar) {
                celMaiMareNumar = array[cursor];

            }
        }
        return celMaiMareNumar;
    }
}
