import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Andrei", "Vasiliu", "Domneasca 30");
        Student student1 = new Student("Gheorghe", "Robert", "Bulevardul Dunarea");
        Student student2 = new Student("Gheorghe", "Robert", "Bulevardul Dunarea");

        System.out.println("Afisam studentul: " + student);
        System.out.println("Acesta este cel de al doilea elev: " + student1);
        if (student1.equals(student2)) {
            System.out.println("Afisam ca sunt la fel");
        } else {
            System.out.println("Nu sunt la fel");
        }

        Car car = new Car("Fiat", "Punto", 5);
        Car car1=new Car("Skoda","Octavia",4);
        System.out.println("Prima masina " +car);
        System.out.println("A doua masina " +car1);
        if(car.equals(car1)){
            System.out.println("Masinile sunt la fel");
        }else{
            System.out.println("Masinile nu sunt la fel");
        }


    }
}
