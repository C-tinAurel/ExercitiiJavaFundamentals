import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Aici afisam meniul");
        System.out.println("Alegerea 1 Pizza quatrostagioni");
        System.out.println("Alegerea 2 Pizza quatroformaggi");
        System.out.println("Alegerea 3 Pizza casei");
        System.out.println("Alegerea 4 Pizza vegetariana");
        Pizzamaker pizzamaker = new Pizzamaker();
        Scanner scanner = new Scanner(System.in);
        int optiune = scanner.nextInt();
        if (optiune == 1) {
            pizzamaker.makePizzaQuatroStagioni();
        }
        if (optiune == 2) {
            pizzamaker.makePizzaQuatroFormaggio();
        }
        if (optiune == 3) {
            pizzamaker.makePizzaCasei();
        }
        if (optiune == 4) {
            pizzamaker.makePizzaVegetariana();
        }


    }
}
