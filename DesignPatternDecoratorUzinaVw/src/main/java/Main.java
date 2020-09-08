import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Aici afisam Masiniile");
        System.out.println("1 Volswagen");
        System.out.println("2 Seat");
        System.out.println("3 Audi");

        CarMaker carMaker=new CarMaker();
        Scanner scanner=new Scanner(System.in);
         int optiune= scanner.nextInt();


         if(optiune==1){
             carMaker.makeVolswagen();
             
         }if(optiune==2){
             carMaker.makeSeat();
        }if(optiune==3) {
             carMaker.makeAudi();
        }



    }
}
