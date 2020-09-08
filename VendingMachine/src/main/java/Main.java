import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Inventar:
        //avem nevoie de 3 fisiere
        //clasa abstracta Produs:contine nume, pret si cantitate
        //clasa VendingMachine(singleton),ProductFactory(folosim factorymethod) si alte 3 clase bauturi,snacks-uri si cafea
        //clasele Cola Fanta si Apa mostenesc Bauturi
        //clasele capuccino americano si expresso mostenesc Cafea
        // clasele croissant ,chips si chocolateBar mostenesc Snack
        //clase exceptii :AmoungNotAcceptedException  daca numarul introdus este 0 si  NotEnoughQuantityException daca nu este cantitatea
        //si Eception NotEnoughMoney cand nu avem bani suficienti
        //clasa User (care cumpar)

        try {
            String fileDrink = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\VendingMachine\\fisier\\Drink.txt";
            String fileCoffee = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\VendingMachine\\fisier\\Coffee.txt";
            String fileSnack = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\VendingMachine\\fisier\\Snack.txt";

            FileReader fileReaderDrink = new FileReader(fileDrink);
            FileReader fileReaderCoffee = new FileReader(fileCoffee);
            FileReader fileReaderSnack = new FileReader(fileSnack);

            BufferedReader bufferedReaderDrink = new BufferedReader(fileReaderDrink);
            BufferedReader bufferedReaderCoffee = new BufferedReader(fileReaderCoffee);
            BufferedReader bufferedReaderSnack = new BufferedReader(fileReaderSnack);

            String text = bufferedReaderDrink.readLine();
            VendingMachine vendingMachine = VendingMachine.getInstance();
            while (text != null && !text.isEmpty()) {
                String[] arrayCuvinte = text.split(";");
                if (arrayCuvinte[0].equals("Cola")) {
                    Cola cola = new Cola(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setColaProduct(cola);
                }
                if (arrayCuvinte[0].equals("Fanta")) {
                    Fanta fanta = new Fanta(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setFantaProduct(fanta);
                }
                if (arrayCuvinte[0].equals("Apa")) {
                    Apa apa = new Apa(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setApaProduct(apa);
                }

                text = bufferedReaderDrink.readLine();
            }
            String text2 = bufferedReaderCoffee.readLine();

            while (text2 != null && !text2.isEmpty()) {
                String[] arrayCuvinte = text2.split(";");
                if (arrayCuvinte[0].equals("Cappuccino")) {
                    Cappuccino cappuccino = new Cappuccino(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setCappuccinoProduct(cappuccino);
                }
                if (arrayCuvinte[0].equals("Americano")) {
                    Americano americano = new Americano(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setAmericanoProduct(americano);
                }
                if (arrayCuvinte[0].equals("Espresso")) {
                    Espresso espresso = new Espresso(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setEspressoProduct(espresso);
                }
                text2 = bufferedReaderCoffee.readLine();

            }
            String text3 = bufferedReaderSnack.readLine();

            while (text3 != null && !text3.isEmpty()) {
                String[] arrayCuvinte = text3.split(";");
                if (arrayCuvinte[0].equals("Croissant")) {
                    Croissant croissant = new Croissant(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setCroissantProduct(croissant);
                }
                if (arrayCuvinte[0].equals("Chips")) {
                    Chips chips = new Chips(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setChipsProduct(chips);
                }
                if (arrayCuvinte[0].equals("ChocolateBar")) {
                    ChocolateBar chocolateBar = new ChocolateBar(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setChocolateBarProduct(chocolateBar);
                }
                text3 = bufferedReaderSnack.readLine();
            }
            System.out.println("Afisam cantitatea de cola " + vendingMachine.getColaProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de fanta " + vendingMachine.getFantaProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de apa " + vendingMachine.getApaProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de cappuccino " + vendingMachine.getCappuccinoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de americano " + vendingMachine.getAmericanoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de espresso " + vendingMachine.getEspressoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de croissant " + vendingMachine.getCroissantProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de chips " + vendingMachine.getChipsProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de chocolate bar " + vendingMachine.getChocolateBarProduct().getProductQuantity());

            System.out.println("Meniu");
            System.out.println("Optiunea 1 este Cola");
            System.out.println("Optiunea 2 este Fanta");
            System.out.println("Optiunea 3 este Apa");
            System.out.println("Optiunea 4 este Cappuccino");
            System.out.println("Optiunea 5 este Americano");
            System.out.println("Optiunea 6 este Espresso");
            System.out.println("Optiunea 7 este Croissant");
            System.out.println("Optiunea 8 este Chips");
            System.out.println("Optiunea 9 este Chocolate Bar");
            Scanner scanner = new Scanner(System.in);
            int optiune = scanner.nextInt();
            ProductFactory productFactory = new ProductFactory();
            if (optiune == 1) {
                Cola colaProduct = (Cola) productFactory.getProduct("Cola");
                System.out.println("Ati ales Cola " + colaProduct.getProductName());
            }
            if (optiune == 2) {
                Fanta fantaProduct = (Fanta) productFactory.getProduct("Fanta");
                System.out.println("Ati ales Fanta " + fantaProduct.getProductName());
            }
            if (optiune == 3){
                Apa apaProduct=(Apa) productFactory.getProduct("Apa");
                System.out.println("Ati ales Apa " + apaProduct.getProductName());
            }if(optiune==4){
                Croissant croissantProduct= (Croissant) productFactory.getProduct("Croissant");
                System.out.println("Ati ales Croissant " + croissantProduct.getProductName());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}