import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // sa se citeasca dintr un fisier produsele aflate la vanzare intr un magazin
        //pe fiecare rand vom avea categoria (alimentare,curatenie si auto),numele raionul pretul si reducerea
        // sa se grupeze produsele in colectii in functie de categorie ,pretul mai mic de 100 ron,mai mic de 50 ron si mai are decat 100 lei
        //vom avea 3 colectii ptr categorii ,pt pret ,pt reducere 10 %,mai mare 20% si 30%
        //sa se scrie produsele in functie de colectia din care fac parte in fisiere separate
        try {
            String filePath = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\MagazinProduse\\MagazinProduse.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String text = bufferedReader.readLine();


            //creeam map-urile

            Map<String, ArrayList<Product>> categoryProductMap = new HashMap<String, ArrayList<Product>>();
            Map<String, ArrayList<Product>> priceProductMap = new HashMap<String, ArrayList<Product>>();
            Map<String, ArrayList<Product>> discountProductMap = new HashMap<String, ArrayList<Product>>();


            //instantiem map-urile pentru categorii
            categoryProductMap.put("Alimentare", new ArrayList<Product>());
            categoryProductMap.put("Curatenie", new ArrayList<Product>());
            categoryProductMap.put("Auto", new ArrayList<Product>());

            //pregatim map-ul pentru price
            priceProductMap.put("Lower100", new ArrayList<Product>());
            priceProductMap.put("Lower50", new ArrayList<Product>());
            priceProductMap.put("Greater100", new ArrayList<Product>());

            //pregatim map ul pentru discount
            discountProductMap.put("10", new ArrayList<Product>());
            discountProductMap.put("20", new ArrayList<Product>());
            discountProductMap.put("30", new ArrayList<Product>());


            while (text != null) {
                System.out.println("Afisam prima linie din text " + text);
                String[] arraySplit = text.split(";");

                Product product = new Product(arraySplit[0], arraySplit[1], arraySplit[2], arraySplit[3], arraySplit[4]);

                if (product.getCategory().equals("Alimentare")) {
                    categoryProductMap.get("Alimentare").add(product);
                } else if (product.getCategory().equals("Curatenie")) {
                    categoryProductMap.get("Curatenie").add(product);
                } else if (product.getCategory().equals("Auto")) {
                    categoryProductMap.get("Auto").add(product);
                }

                if (Integer.valueOf(product.getPrice()) < 100) {
                    priceProductMap.get("Lower100").add(product);
                } else if (Integer.valueOf(product.getPrice()) < 50) {
                    priceProductMap.get("Lower50").add(product);
                } else if (Integer.valueOf(product.getPrice()) > 100) {
                    priceProductMap.get("Greater100").add(product);
                }

                if (product.getDiscount().equals("10")) {
                    discountProductMap.get("10").add(product);
                } else if (product.getDiscount().equals("20")) {
                    discountProductMap.get("20").add(product);
                } else if (product.getDiscount().equals("30")) {
                    discountProductMap.get("30").add(product);
                }


                text = bufferedReader.readLine();
            }
            //Afisam in fisiere separtate
            String fileWriteCategorie = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\MagazinProduse\\FisierCategorie.txt";
            String fileWritePret = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\MagazinProduse\\FisierPret.txt";
            String fileWriteReducere = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\MagazinProduse\\FisierReducere.txt";

            FileWriter fileWriterCategorie = new FileWriter(fileWriteCategorie);
            FileWriter fileWriterPret = new FileWriter(fileWritePret);
            FileWriter fileWriterReducere = new FileWriter(fileWriteReducere);

            BufferedWriter bufferedWriterCategoria = new BufferedWriter(fileWriterCategorie);
            BufferedWriter bufferedWriterPret = new BufferedWriter(fileWriterPret);
            BufferedWriter bufferedWriterReducere = new BufferedWriter(fileWriterReducere);


            //Scriem in colectia categorie
            ArrayList<Product> productAlimentarList = categoryProductMap.get("Alimentare");
            for (Product productAlimentar : productAlimentarList) {
                bufferedWriterCategoria.write(productAlimentar.toString());
                bufferedWriterCategoria.newLine();
            }
            ArrayList<Product> productCuratenieList = categoryProductMap.get("Curatenie");
            for (Product productCuratenie : productCuratenieList) {
                bufferedWriterCategoria.write(productCuratenie.toString());
                bufferedWriterCategoria.newLine();
            }
            ArrayList<Product> productAutoList = categoryProductMap.get("Auto");
            for (Product productAuto : productAutoList) {
                bufferedWriterCategoria.write(productAuto.toString());
                bufferedWriterCategoria.newLine();
            }

            bufferedWriterCategoria.flush();
            bufferedWriterCategoria.close();


            //scriem din colectia Pricein fisier
            ArrayList<Product> productPretLow100 = priceProductMap.get("Lower100");
            for (Product productLow100 : productPretLow100) {
                bufferedWriterPret.write(productLow100.toString());
                bufferedWriterPret.newLine();
            }
            ArrayList<Product> productPretLow50 = priceProductMap.get("Lower50");
            for (Product productLow50 : productPretLow50) {
                bufferedWriterPret.write(productLow50.toString());
                bufferedWriterPret.newLine();
            }
            ArrayList<Product> productGreater100 = priceProductMap.get("Greater100");
            for (Product productGreat100 : productGreater100) {
                bufferedWriterPret.write(productGreat100.toString());
                bufferedWriterPret.newLine();
            }
            bufferedWriterPret.flush();
            bufferedWriterPret.close();

            //Scriem in colectia Reducere
            ArrayList<Product> productReducere10 = discountProductMap.get("10");
            for (Product product10 : productReducere10) {
                bufferedWriterReducere.write(product10.toString());
                bufferedWriterReducere.newLine();
            }
            ArrayList<Product> productReducere20 = discountProductMap.get("20");
            for (Product product20 : productReducere20) {
                bufferedWriterReducere.write(product20.toString());
                bufferedWriterReducere.newLine();
            }
            ArrayList<Product> productReducere30 = discountProductMap.get("30");
            for (Product product30 : productReducere30) {
                bufferedWriterReducere.write(product30.toString());
                bufferedWriterReducere.newLine();
            }

            bufferedWriterReducere.flush();
            bufferedWriterReducere.flush();


        } catch (FileNotFoundException e) {
            System.out.println("Eroare" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare" + e.getMessage());
        }


    }
}
