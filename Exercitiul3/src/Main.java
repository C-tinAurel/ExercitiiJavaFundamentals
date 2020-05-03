public class Main {
    public static void main(String[] args) {
        //Se da un text,sa se numere cuvintele care au lungimea impara si se termina cu litera "e"
        String text = "Stau câteodată și-mi aduc aminte ce vremi și ce oameni mai erau";
        int cuvinteImpare = numarCuvinte(text);
        System.out.println("Numarul cuvintelor impare terminate cu e sunt: " + cuvinteImpare);

    }

    public static int numarCuvinte(String text) {
        int numarCuvinte = 0;
        String[] rezultatSplit = text.split(" ");
        for (int cursor = 0; cursor < rezultatSplit.length; cursor++) {
            if (rezultatSplit[cursor].length() % 2 != 0 && rezultatSplit[cursor].endsWith("e")) {
                numarCuvinte++;
            }

        }
        return numarCuvinte;
    }


}
