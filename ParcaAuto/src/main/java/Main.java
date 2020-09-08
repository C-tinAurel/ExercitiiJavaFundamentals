import java.io.*;

public class Main {

    public static void main(String[] args) {

        // sa se modeleze un prc auto
        // masinile vor fi citie dintrun fisier
        // in fis vom avea model, culoare, pret, combustibil, data fabricare (separate cu virgula)
        // 3 tipuri masini: nemtesti, frantuzesti, altele

        //citim din fisier masinile
        // daca sunt nemtesti le scriem in fisier nemtesti, etc...

        // masinile au comportament:
        // - pot fi vandute in leasing - o sa luam numarul de rate si cat valoreaza
        // - la leasing trebuie sa avem avans, care se scade din pretul total.
        // - masinile pot fi comparate (calitate = anul de fabricatie)

        // masinile au atribut vandut, scrise in fisier separat
        // la final afisam toate masinile.
        // masinile vandute o sa fie cele nemtesti negre si cu benzina


        // Avem nevoie de clasa Car, cu atributele: marca, model, culoare, pret, combustibil, data fabricatiie, camp de vanzare
        // Avem nevoie de o interfata Leasing cu comportamentele: installments + value
        // Avem nevoie de implementare interfata Comparable
        // Avem nevoie de fisier de unde sa citim masinile, apoi le sortam pe fisierele respective, in functie de tipul masinii.
        // Cand le vindem le adaugam intr-un alt fisier cu masini vandute.


        try {
            String carsInitial = "D:\\Java Projects\\Files for use in exercises\\Parc Auto\\masiniInitial.txt";
            FileReader carsIntitialReader = new FileReader(carsInitial);
            BufferedReader carsInitialBuffer = new BufferedReader(carsIntitialReader);

            String carsGerman = "D:\\Java Projects\\Files for use in exercises\\Parc Auto\\masiniNemtesti.txt";
            FileWriter carsGermanWriter = new FileWriter(carsGerman);
            BufferedWriter carsGermanBuffer = new BufferedWriter(carsGermanWriter);

            String carsFrench = "D:\\Java Projects\\Files for use in exercises\\Parc Auto\\masiniFrantuzesti.txt";
            FileWriter carsFrenchWriter = new FileWriter(carsFrench);
            BufferedWriter carsFrenchBuffer = new BufferedWriter(carsFrenchWriter);

            String carsOther = "D:\\Java Projects\\Files for use in exercises\\Parc Auto\\masiniAltele.txt";
            FileWriter carsOtherWriter = new FileWriter(carsOther);
            BufferedWriter carsOtherBuffer = new BufferedWriter(carsOtherWriter);

            String carsSold = "D:\\Java Projects\\Files for use in exercises\\Parc Auto\\masiniVandute.txt";
            FileWriter carsSoldWriter = new FileWriter(carsSold);
            BufferedWriter carsSoldBuffer = new BufferedWriter(carsSoldWriter);

            String text = carsInitialBuffer.readLine();
            while (text != null) {
                String[] textArray = text.split(",");
                Car car = new Car(textArray[0], textArray[1], textArray[2], Integer.valueOf(textArray[3]), textArray[4], Integer.valueOf(textArray[5]));
                System.out.println("Rata lunara pentru " + car.getMake() + " " + car.getModel() + " este: " + car.payRate() + " euro.");

                if (car.getSold() == true) {
                    carsSoldBuffer.write(text);
                    carsSoldBuffer.newLine();
                    carsSoldBuffer.flush();
                } else if (car.getMake().equals("BMW") || car.getMake().equals("Audi") || car.getMake().equals("VW") || car.getMake().equals("Opel")) {
                    carsGermanBuffer.write(text);
                    carsGermanBuffer.newLine();
                    carsGermanBuffer.flush();
                } else if (car.getMake().equals("Peugeot") || car.getMake().equals("Renault") || car.getMake().equals("Citroen")) {
                    carsFrenchBuffer.write(text);
                    carsFrenchBuffer.newLine();
                    carsFrenchBuffer.flush();
                } else {
                    carsOtherBuffer.write(text);
                    carsOtherBuffer.newLine();
                    carsOtherBuffer.flush();
                }
                text = carsInitialBuffer.readLine();
            }
            carsSoldBuffer.close();
            carsGermanBuffer.close();
            carsFrenchBuffer.close();
            carsOtherBuffer.close();

        } catch (IOException e) {
            System.out.println("Avem exceptie IO: " + e.getMessage());
        }
    }
}
