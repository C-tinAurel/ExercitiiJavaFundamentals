public class Main {

    //Se da un array de caractere sa se afiseze in ordine inversa
    public static void main(String[] args) {
        char[] arrayCaractere = new char[10];
        arrayCaractere[0] = 'a';
        arrayCaractere[1] = 'b';
        arrayCaractere[2] = 'c';
        arrayCaractere[3] = 'd';
        arrayCaractere[4] = 'e';
        arrayCaractere[5] = 'f';
        arrayCaractere[6] = 'g';
        arrayCaractere[7] = 'h';
        arrayCaractere[8] = 'j';
        arrayCaractere[9] = 'k';

        arrayCaractere(arrayCaractere);
    }

    public static void arrayCaractere(char[] arrayCaractere) {
        for (int cursor = arrayCaractere.length-1; cursor >= 0; cursor--) {
            System.out.println(arrayCaractere[cursor]);
        }

    }
}
