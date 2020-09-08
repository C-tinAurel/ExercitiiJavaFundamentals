import javax.imageio.IIOException;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Sa se citeasca dintr-un fisier informatii despre angajati unei companii
        //Nume,prenume,departament(it si vanzari)
        //dupa ce i-am citit o sa imi punem in doua set-uri separete un set it si un set vanzare
        //afisam cele doua seturi

        Set<Employee> itSet = new HashSet<Employee>();
        Set<Employee> saleSet = new HashSet<Employee>();

        try {

            String filePath = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\fisierAngajati.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text = bufferedReader.readLine();
            while (text != null) {
                System.out.println("Primul angajat este " + text);
                String[] cuvinteArray = text.split(",");
                Employee employee = new Employee(cuvinteArray[0], cuvinteArray[1], cuvinteArray[2]);
                if (employee.getDepartament().equals("IT")) {
                    itSet.add(employee);
                } else if (employee.getDepartament().equals("Vanzari")) {
                    saleSet.add(employee);
                }

                text = bufferedReader.readLine();
            }
            System.out.println("Primul set este : " );
            for(Employee employee: itSet){
                itSet.add(employee);
                System.out.println("Angajatul din departamentul IT este : " +employee);
            }
            System.out.println("Al doilea set este : ");
            for (Employee employee :saleSet){
                saleSet.add(employee);
                System.out.println("Angajatul din departamentul de vanzari este : " +employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("A aparut eroare " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

