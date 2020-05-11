import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Sa se modeleze o benzinarie
        //Obiectele :
        //Gass station
        //O sa aiba
        //motorina
        //benzina
        //rep prin cantitate
        //pret pe litru
        //pentru benzina
        //pentru motorina
        //de fiecare data scadem din catitate
        //cand cantitatea este mai mica de cat 10 litri afisam un mesaj
        //cand cineva cumpara calculam pretul
        //obiect person cu o suma de bani
        //el o sa poata sa plateasca pentru benzina sau motorina
        //suma platita scade din suma de bani
        //persoana poate sa plateasca cu o suma rotunda si benzinaria trebuia sa ii dea rest
        //daca utilizatorul nu are destui bani afisam un mesaj


        GasStation omv = new GasStation(50, 5, 50, 6);
        Scanner persoana = new Scanner(System.in);
        System.out.println("Introduceti numele persoanei");

        String name = persoana.nextLine();
        Person cumparator = new Person(name, 300);
        Scanner meniu = new Scanner(System.in);
        System.out.println("Va rugam alegeti o optiune,");
        System.out.println("1.Motorina");
        System.out.println("2.Benzina");
        int optiune = 0;
        optiune = meniu.nextInt();
        Scanner cantitate = new Scanner(System.in);
        System.out.println("Introduceti cantitatea");
        int litri = cantitate.nextInt();
        System.out.println("Ati introdus cantitatea : " + litri);

        while (optiune != 9) {
            if (optiune == 1) {
                System.out.println("Ati ales sa cumparati motorina");
                int pretTotal = omv.sellM(litri);
                System.out.println("Aveti de platit : " + pretTotal);
                String rezultatTranzactie = cumparator.tranzactieM(pretTotal);
                if (rezultatTranzactie.startsWith("Nu avem destui bani")) {
                    String incasare = omv.incaseazaBani(pretTotal / 2, pretTotal);
                    System.out.println("Rezultatul tranzactiei este : " + incasare);
                } else {
                    String incasare = omv.incaseazaBani(pretTotal, pretTotal);
                    System.out.println("Rezultatul tranzactiei este : " + incasare);
                    System.out.println("A mai ramas atata motorina " + omv.getMotorina());

                }

            } else if (optiune == 2) {
                System.out.println("Ati ales sa cumparati benzina");
                int pretTotal = omv.sellB(litri);
                System.out.println("Aveti de platit : " + pretTotal);
                String rezultatTranzactie = cumparator.tranzactieB(pretTotal);
                if (rezultatTranzactie.startsWith("Nu avem destui bani")) {
                    String incasare = omv.incaseazaBani(pretTotal / 2, pretTotal);
                    System.out.println("Rezultatul tranzactiei este : " + incasare);

                } else {
                    String incasare = omv.incaseazaBani(pretTotal, pretTotal);
                    System.out.println("Rezultatul tranzactiei este : " + incasare);
                    System.out.println("A mai ramas atata benzina  " + omv.getBenzina());
                }

            } else {
                System.out.println("Nu gasim optiunea");
            }


            optiune = meniu.nextInt();
        }


    }
}

