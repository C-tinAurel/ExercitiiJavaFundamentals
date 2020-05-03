public class Main {
    public static void main(String[] args) {


        //Cerinte:
        //Se da un text
        //Sa se numere toate cuvintele care au lungimea mai mare decat 2,contin caracterul "i", si caracterul se afla pe o pozitie para
        String text = "a mă ridica băiețaș la casa părinților mei, în satul Humulești";
        int cuvinte = numarareCuvinte(text);
        System.out.println("Numerele sunt: " + cuvinte);
    }

    public static int numarareCuvinte(String text) {
        int numar = 0;
        String[] cuvinet = text.split(" ");
        for (int cursor = 0; cursor < cuvinet.length; cursor++) {
            if (cuvinet[cursor].length() > 2 && cuvinet[cursor].indexOf("i") % 2 == 0) {
                numar++;
            }
        }
        return numar;
    }

}
