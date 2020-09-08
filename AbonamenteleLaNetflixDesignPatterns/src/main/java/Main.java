import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // sa se afiseze un meniu pentru bussnies apasati tasta 1 pentru premium 2 si pentru standard 3
        //in functie de optiunea aleasa sa se afiseze un mesaj cu optiunea aleasa si pretul abonamentului

        System.out.println("Meniu principal abonmanent Netflix");

        System.out.println("Optiunea 1 este  Standard");
        System.out.println("Optiunea 2 este Bussnies");
        System.out.println("Optiunea 3 este Premium");

        Scanner scanner = new Scanner(System.in);
        int optiune = scanner.nextInt();
        SubscriptonFactory subscriptonFactory = new SubscriptonFactory();

        if (optiune == 1) {
            Standard standardSubscripton = (Standard) subscriptonFactory.getSubscripton("Standard");
            System.out.println("Ati ales abonamentul de tip Standard si va costa " + standardSubscripton.getPrice());
        }if (optiune == 2) {
            Bussnies bussniesSubscripton = (Bussnies) subscriptonFactory.getSubscripton("Bussnies");
            System.out.println("Ati ales abonamentu de tip Business si va costa " + bussniesSubscripton.getPrice());

        }if(optiune==3){
            Premium premiumSubscripton= (Premium) subscriptonFactory.getSubscripton("Premium");
            System.out.println("Ati ales abonamentul de tip Premium si va va costa " + premiumSubscripton.getPrice());

        }else{
            System.out.println("Nu mai sunt abonamente");
        }

        // sa se documenteze si sa se faca un exemplu folosind Design Patterns Abstract Factory

    }
}
