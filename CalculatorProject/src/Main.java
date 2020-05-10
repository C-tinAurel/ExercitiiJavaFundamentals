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


        CalculatorStiintific computer = new CalculatorStiintific();
        System.out.println("Adunare este " + computer.adunare(2, 2));
        System.out.println("Scaderea este " + computer.scadere(5, 5));
        System.out.println("Inmultirea este " + computer.inmultire(7, 5));
        System.out.println("Impartirea este " + computer.impartire(64, 8));
        System.out.println("Ridicarea la putere " + computer.ridicareaLaPutere(2, 2));
        System.out.println("Radical dintr un numar " + computer.radicalDintrunNUmar(15));
        System.out.println("Logaritm in baza 10 " + computer.logaritmInBaza10(5));
        System.out.println("Logaritm dintr un numar " + computer.logaritmDintrunNumar(2));
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Va rugam introduceti primul numar pentru ridicare la putere");
        primulNumar = scanner1.nextInt();
        System.out.println("Va rugam introduceti al doilea numar pentru ridicare la putere ");
        alDoileaNumar = scanner1.nextInt();
        System.out.println("Rezultatul ridicari la putere al numerelor " + computer.ridicareaLaPutere(primulNumar, alDoileaNumar));

        System.out.println("Va rugam introduceti numarul pentru calcularea radicalului");
        primulNumar = scanner.nextInt();
        System.out.println("Rezultatul calculari radicalului numarului " + primulNumar + "este" + computer.radicalDintrunNUmar(primulNumar));

        System.out.println("va rugam introduceti numarul pentru calcularea logaritmului in baza 10");
        primulNumar = scanner1.nextInt();
        System.out.println("rezultatul calculari lograitmului in baza 10 a numarului " + primulNumar + "este " + computer.logaritmInBaza10(primulNumar));

        System.out.println("va rugam introduceti  numarl pentru calcularea logaritmului a numarului ");
        primulNumar = scanner1.nextInt();
        System.out.println("rezultatului calcularii logaritmului numarului " + primulNumar + "este" + computer.radicalDintrunNUmar(primulNumar));


        //Introduceti doua numere
        Scanner sc = new Scanner(System.in);
        System.out.println("Va rugam introduceti cele doua numere");

        //Afisam numerele
        primulNumar = sc.nextInt();
        alDoileaNumar = sc.nextInt();
        System.out.println("Numerele introduse sunt " + primulNumar + " si " + alDoileaNumar);

        //sa se afiseze meniul
        System.out.println("Meniu");

        //1.Adunare
        System.out.println("1.Adunare");

        //2.Inmultire
        System.out.println("2.Inmultire");

        //3.Radical
        System.out.println("3.Radical");

        //4.Scadere
        System.out.println("4.Scadere");

        //Afisam un mesaj va rugam alegeti o optiune
        System.out.println("Va rugam alegeti o optiune");

        //In functie de optiunea aleasa se realizeaza operatia respectiva,daca operatia presupune folosirea unui singur numar
        // facem operatia si pentru al doilea numar
        //Afisam rezultatul

        int optiune = 0;
        optiune = sc.nextInt();//--->utilizatorul introduce un numar la tastatura

        //daca utilizatorul introduce orice numar inafara de 9
        while (optiune != 9) {
            if (optiune == 1) {
                System.out.println("Ati ales optiunea adunare");
                System.out.println("Rezultatul adunari este " + computer.adunare(primulNumar, alDoileaNumar));
            } else if (optiune == 2) {
                System.out.println("Ati ales optiunea inmultire");
                System.out.println("Rezultatul inmultiri este " + computer.inmultire(primulNumar, alDoileaNumar));
            } else if (optiune == 3) {
                System.out.println("Ati ales optiunea radical");
                System.out.println("Rezultatul radicalului primului numar este " + computer.radicalDintrunNUmar(primulNumar));
                System.out.println("rezultatul radicalului celui de al doilea numar " + computer.radicalDintrunNUmar(alDoileaNumar));
            } else if (optiune == 4) {
                System.out.println("Ati ales optiunea scadere");
                System.out.println("Rezultatul scadere este " + computer.scadere(primulNumar, alDoileaNumar));
            } else {
                System.out.println("Nu gasim optiunea aleasa de  dumneavoastra!");
            }
            optiune = sc.nextInt();
        }
        System.out.println("Ne pare rau.Ati apasat tasta 9 am iesit din program.O zi buna");


        Scanner string = new Scanner(System.in);
        System.out.println("Va rugam introduceti primul string");
        String primulString = string.nextLine();
        System.out.println("Ati introdus primul string: " + primulString);
        System.out.println("Va rugam introduceti al doilea string");
        String alDoileaString = string.nextLine();
        System.out.println("Ati introdus al doilea string" + alDoileaString);
        CalculatorString calculatorString = new CalculatorString();

        System.out.println("Concatenarea stringurilor este: " +calculatorString.concatenare(primulString,alDoileaString));

        System.out.println("Verificam daca stringul contine un anumit caracter " +calculatorString.contineCaracter(primulString,'v'));

        System.out.println("Adunarea celor doua stringuri este: " +calculatorString.adunareStringuri(primulString,alDoileaString));

        System.out.println("Verificam daca lungima unui string este par sau impar " +calculatorString.stringParImpar(primulString));

        char[] sirCaractere= calculatorString.sirCaractere(primulString);
        for(int cursor=0;cursor<sirCaractere.length;cursor++){
            System.out.println("Afisam caracterele stringului " +sirCaractere[cursor]);
        }

        System.out.println("Verificam daca stringul incepe cu o vocala " +calculatorString.vocala(primulString));

        System.out.println("Numaram spatiile dintr-un string " +calculatorString.spatiiString(alDoileaString));

    }
    //Sa se reprezinte un calculator care face operatii simple (adunare, scadere,..), operatiile stiintifice dar si urmatoarele operatii cu stringuri:
    // --concateneaza 2 stringuri
    // -- verifica daca stringul contine un anumit caracter
    // -- aduna lungimea a 2 stringuri
    // -- verifica daca lungimea unui string este numar par sau impar
    // -- transforma un string intr-un sir de caractere
    // -- verifica daca stringul incepe cu o vocala
    // -- numara spatiile dintr-un string


}
