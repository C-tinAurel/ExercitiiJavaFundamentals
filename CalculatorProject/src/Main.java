import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Calculatoru sa fie reprezentat folosind programare orientata obiect
        //sa se modeleze comportamentul unui calculator simplu(adunare,scadere,inmultire,impartire)
        //calculator=constuctor
        Calculator calculator = new Calculator();

        System.out.println("Suma este " + calculator.adunare(8, 10));

        System.out.println("Scaderea este " + calculator.scadere(4, 8));

        int inmultire = calculator.inmultire(5, 8);
        System.out.println("Produsul este " + inmultire);

        int impartire = calculator.impartire(12, 2);
        System.out.println("Catul este " + impartire);


        // De aici citim valorile de la tastatura
        //obiectul care ne ajuta sa facem asta se numeste  "Scanner"

        //instantare
        Scanner scanner = new Scanner(System.in);
        //citeste primul numar de la tastatura
        System.out.println("Va rugam introduceti primul numar: ");
        int primulNumar = scanner.nextInt();
        //citeste al doilea numar de la tastatura
        System.out.println("Va rugam introduceti al doilea numar: ");
        int alDoileaNumar = scanner.nextInt();
        System.out.println("Numerele introduse sunt " + primulNumar + " " + alDoileaNumar);

        int adunare = calculator.adunare(primulNumar, alDoileaNumar);
        System.out.println("Rezultat adunare: " + adunare);
        int scadere = calculator.scadere(primulNumar, alDoileaNumar);
        System.out.println("Rezultatul scaderii: " + scadere);
        inmultire = calculator.inmultire(primulNumar, alDoileaNumar);
        System.out.println("Rezultat inmultire " + inmultire);
        impartire = calculator.impartire(primulNumar, alDoileaNumar);
        System.out.println("Rezultat impartire " + impartire);


        CalculatorStiintific computer= new CalculatorStiintific();
        System.out.println("Ridicarea la putere " +computer.ridicareaLaPutere(2,2));
        System.out.println("Radical dintr un numar " +computer.radicalDintrunNUmar(15));
        System.out.println("Logaritm in baza 10 " +computer.logaritmInBaza10(5));
        System.out.println("Logaritm dintr un numar " +computer.logaritmDintrunNumar(2));

    }
}
