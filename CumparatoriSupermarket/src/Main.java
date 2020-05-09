import java.util.Date;
import java.util.Scanner;

public class Main {


    //Sa se modeleze cosul de cumparaturi dintr-un supermarket
    //Fiecare produs sa fie reprezentat de un obiect care sa contina nume si pret, ex mere 5 lei, pere 7 lei, cirese 100 lei
    //Cosul de cumparaturi va fi reprezentat de un array de produse
    //Sa se afiseze un meniu cu produsele dorite
    //Bazat pe ce se introduce la tastatura adaugam in cosul de cumparaturi
    //Sa se calculeze costul total al cosului de cumparaturi
    //Simulam plata pentru cosul de cumparaturi

    public static void main(String[] args) {

        Produs[] cosDeCumparaturi = new Produs[10];
        System.out.println("Meniu cumparaturi");
        System.out.println("1. Mere ");
        System.out.println("2. Matura");
        System.out.println("3. Set de Farfurii");
        System.out.println("4. Mustar");
        System.out.println("5. Apa");
        System.out.println("6. Bere");
        System.out.println("7. Suc");
        System.out.println("Va rugam alegeti produsele dorite:");
        Scanner scanner = new Scanner(System.in);
        int optiune = scanner.nextInt();

        while (optiune != 0) {
            if (optiune == 1) {
                System.out.println("Ati adaugat in cosul de cumparaturi mere");
                Produs mere = new Produs("Mere", 5);
                cosDeCumparaturi[0] = mere;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[0].getNume() + " si " + cosDeCumparaturi[0].getPret());
            } else if (optiune == 2) {
                System.out.println("Ati adaugat in cosul de cumparaturi o matura");
                Produs matura = new Produs("Matura", 6);
                cosDeCumparaturi[1] = matura;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[1].getNume() + " si " + cosDeCumparaturi[1].getPret());
            } else if (optiune == 3) {
                System.out.println("Ati adaugat in cosul de gunoi un set de farfurii");
                Produs farfurii = new Produs("Farfurii", 10);
                cosDeCumparaturi[2] = farfurii;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[2].getNume() + " si " + cosDeCumparaturi[2].getPret());
            } else if (optiune == 4) {
                System.out.println("Ati adaugat in cosul de cumparaturi un mustar");
                Produs mustar = new Produs("Mustar", 4);
                cosDeCumparaturi[3] = mustar;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[3].getNume() + " si " + cosDeCumparaturi[3].getPret());
            } else if (optiune == 5) {
                System.out.println("Ati adaugat in cosul de cumparaturi o apa");
                Produs apa = new Produs("Apa", 3);
                cosDeCumparaturi[4] = apa;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[4].getNume() + " si " + cosDeCumparaturi[4].getPret());
            } else if (optiune == 6) {
                System.out.println("Ati adaugat in cosul de cumparaturi o bere");
                Produs bere = new Produs("Bere", 8);
                cosDeCumparaturi[5] = bere;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[5].getNume() + " si " + cosDeCumparaturi[5].getPret());
            } else if (optiune == 7) {
                System.out.println("Ati adaugat in cosul de cumparaturi un suc");
                Produs suc = new Produs("Suc", 5);
                cosDeCumparaturi[6] = suc;
                System.out.println("Afisam adaugarea: " + cosDeCumparaturi[6].getNume() + " si " + cosDeCumparaturi[6].getPret());
            } else {
                System.out.println("Optiunea introdusa nu exista");
            }

            optiune = scanner.nextInt();
        }
        System.out.println("Ati apasat tasta 0, programul se inchide. O zi buna.");

        System.out.println("Lungimea cosului de cumparaturi este: " + cosDeCumparaturi.length);

        System.out.println("Ati cumparat:");

        for (int cursor = 0; cursor < cosDeCumparaturi.length; cursor++) {

            if (cosDeCumparaturi[cursor] != null) {
                //In acest fel afisam numele si pretul fiecarui produs din array
                System.out.println("Produsul este: " + cosDeCumparaturi[cursor].getNume() + " la pretul de " + cosDeCumparaturi[cursor].getPret());
            }
        }

        //declaram variabila pentru stocarea pretului in afara buclei for deoarece nu dorim resetarea variabilei
        int pretTotal = 0;

        for (int cursor = 0; cursor < cosDeCumparaturi.length; cursor++) {
            if (cosDeCumparaturi[cursor] != null) {
                //In acest fel adaugam pretul produselor la pretul Total
                pretTotal += cosDeCumparaturi[cursor].getPret();
            }
        }

        System.out.println("Pretul total este:" + pretTotal);

        System.out.println("S-a platit suma necesara.");
        pretTotal = 0;

        //Sa se reprezinte si produse perisabile, acestea vor avea in plus data expirarii
        //Sa se simuleze din nou un cos de cumparaturi
        //Daca utilizatorul cumpara un produs perisabil si data de expirare este depasita, se va afisa un mesaj "Produs expirat" si nu il vom mai adauga in cos
        //Adaugam alergeni si cand afisam cosul de cumparaturi sa afisam si alergenii
        //Un cos de cumparaturi pentru produse non-alimentare si un cos pentru produsele alimentare

        Date dataAstazi = new Date(2020, 5, 9);
        int pretTotalAlimente = 0;
        int pretTotalNonAlimente = 0;

        ProduseAlimentare[] cosAlimentare = new ProduseAlimentare[10];
        Produs[] cosNonAlimentare = new Produs[10];

        System.out.println("Meniu produse");
        System.out.println("1. Mere");
        System.out.println("2. Carne");
        System.out.println("3. Lapte");
        System.out.println("4. Matura");
        System.out.println("5. Bec");
        System.out.println("6. Pronto");

        optiune = scanner.nextInt();

        while (optiune != 0) {
            if (optiune == 1) {
                System.out.println("Ati ales mere");
                ProduseAlimentare mere = new ProduseAlimentare("Mere", 6, "zaharoza", null);
                cosAlimentare[0] = mere;
            } else if (optiune == 2) {
                System.out.println("Ati ales carne");
                ProduseAlimentare carne = new ProduseAlimentare("Carne", 11, "condimente", new Date(2020, 3, 1));
                cosAlimentare[1] = carne;
            } else if (optiune == 3) {
                System.out.println("Ati ales lapte");
                ProduseAlimentare lapte = new ProduseAlimentare("Lapte", 4, "lactoza", new Date(2020, 6, 1));
                cosAlimentare[2] = lapte;
            } else if (optiune == 4) {
                System.out.println("Ati ales matura");
                Produs matura = new Produs("Matura", 11);
                cosNonAlimentare[0] = matura;
            } else if (optiune == 5) {
                System.out.println("Ati ales becul");
                Produs bec = new Produs("Bec", 3);
                cosNonAlimentare[1] = bec;
            } else if (optiune == 6) {
                System.out.println("Ati ales Pronto");
                Produs pronto = new Produs("Pronto", 8);
                cosNonAlimentare[2] = pronto;
            } else {
                System.out.println("Numarul introdus nu exista!");
            }

            optiune = scanner.nextInt();
        }
        System.out.println("Acestea sunt produsele non alimentare din cos: ");
        for (int cursor = 0; cursor < cosNonAlimentare.length; cursor++) {
            if (cosNonAlimentare[cursor] != null) {
                System.out.println("Produsul este: " + cosNonAlimentare[cursor].getNume() + " iar pretul este: " + cosNonAlimentare[cursor].getPret());
            }

        }

        System.out.println("Acestea sunt produsele alimentare din cos: ");


        for (int cursor = 0; cursor < cosAlimentare.length; cursor++) {
            if (cosAlimentare[cursor] != null) {
                System.out.println("Produsul este: " + cosAlimentare[cursor].getNume() + " cu pretul de " + cosAlimentare[cursor].getPret() + ". Alergeni: " + cosAlimentare[cursor].getAlergeni() + "Data expirare: " + cosAlimentare[cursor].getDataExpirare());
                if (cosAlimentare[cursor].getDataExpirare().before(dataAstazi)) {
                    System.out.println("Produsul este expirat si va fi scos din cos");
                    cosAlimentare[cursor] = null;
                }
            }
        }

        for (int cursor = 0; cursor < cosAlimentare.length; cursor++) {
            if (cosAlimentare[cursor] != null) {
                pretTotalAlimente += cosAlimentare[cursor].getPret();

            }
        }

        System.out.println("Pretul total pentru alimente este: " + pretTotalAlimente);

        for (int cursor = 0; cursor < cosNonAlimentare.length; cursor++) {
            if (cosNonAlimentare[cursor] != null) {
                pretTotalNonAlimente += cosNonAlimentare[cursor].getPret();
            }
        }
        System.out.println("Pretul total pentru non-alimentare este: " + pretTotalNonAlimente);
        System.out.println("Pretul total este: " + (pretTotalAlimente + pretTotalNonAlimente));
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
