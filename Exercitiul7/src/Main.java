public class Main {
    //se da un array de 7 cuvinte
    //sa se concateneze cuvintele de pe pozitiile divizibile cu 3 si mai mari decat 0
    public static void main(String[] args) {
        String[] cuvinte = new String[7];
        cuvinte[0] = "uneltele";
        cuvinte[1] = "ocupatiile";
        cuvinte[2] = "organizarea";
        cuvinte[3] = "oamenilor";
        cuvinte[4] = "creatiile";
        cuvinte[5] = "artistice";
        cuvinte[6] = "credinte";
concatenareSiAfisare(cuvinte);

    }

    public static void concatenareSiAfisare(String[] cuvinte) {
        String cuvintee ="";
        for (int cursor = 1; cursor < cuvinte.length; cursor++) {
    if(cursor % 3 == 0){
       cuvintee = cuvintee.concat(cuvinte[cursor]);

    }
        }
        System.out.println("Rezultat: " +cuvintee);

    }
}
