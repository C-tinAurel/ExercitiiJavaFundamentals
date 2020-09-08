import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        //Sa se citeasca dintr-un fisier de pe fiecare rand  numele, prenumele, clasa si un optional
        // sa se grupeze in coletii diferite elevii in functie de clasa care fac parte elevii si in functie de optional
        //atributele vor fi separate prin ;

        try {
            String filePath = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\fisiere\\ColectiiMap\\fisierElevi.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String text = bufferedReader.readLine();

            //am creat map-ul

            Map<String, ArrayList<Student>> groupMap = new HashMap<String, ArrayList<Student>>();
            Map<String, ArrayList<Student>> optionalMap = new HashMap<String, ArrayList<Student>>();

            //pregatim map-ul
            //key-ul este clasa
            groupMap.put("10", new ArrayList<Student>());
            groupMap.put("11", new ArrayList<Student>());
            groupMap.put("12", new ArrayList<Student>());


            //key ul este optionalul
            optionalMap.put("Germana", new ArrayList<Student>());
            optionalMap.put("Informatica", new ArrayList<Student>());
            optionalMap.put("MatematicaAplicata", new ArrayList<Student>());

            while (text != null) {
                System.out.println("Prima linie citita este " + text);
                String[] arraySplit = text.split(";");

                //aici umrea sa creem studentul in functie de atribute din text
                Student student = new Student(arraySplit[0], arraySplit[1],arraySplit[2] ,arraySplit[3]);

                //am citit studentul urmeaza sa il grupam in functie de group si vor fi adaugati in groupMap

                //am pus conditiile

                if (student.getGroup().equals("10")) {
                    //am adaugat key in student
                    groupMap.get("10").add(student);//acesta este sintaxa cu care separam elevi in functie de grup

                } else if (student.getGroup().equals("11")) {
                    groupMap.get("11").add(student);

                } else if (student.getGroup().equals("12")) {
                    groupMap.get("12").add(student);

                }


                //Aici grupam studentul in functie de optional si vor fi adaugati in optionalMap
                if (student.getOptional().equals("Informatica")) {
                    optionalMap.get("Informatica").add(student);
                } else if (student.getOptional().equals("Germana")) {
                    optionalMap.get("Germana").add(student);
                } else if (student.getOptional().equals("MatematicaAplicata")) {
                    optionalMap.get("MatematicaAplicata").add(student);
                }


                text = bufferedReader.readLine();

            }
            //Afisam studenti de la informatica
            ArrayList<Student> studentInfo = optionalMap.get("Informatica");
            for(Student student1:studentInfo){
                System.out.println("Afisam studenti de la informatica " +student1);
            }


            //Afisam toti studenti din clasa a 11-a
            ArrayList<Student> studentClasa11= groupMap.get("11");
            for(Student student2 :studentClasa11){
                System.out.println("Aici afisam studenti din clasa a 11-a " +student2);
            }

            //Afisam studenti de la matematica aplicata
            ArrayList<Student>  studentMate = optionalMap.get("MatematicaAplicata");
            for(Student studentMateAplicata :studentMate){
                System.out.println("Studenti de la matematica aplicata sunt " +studentMateAplicata);
            }
            //afisam studenti din clasa a 10
            ArrayList<Student> student10= groupMap.get("10");
            for(Student students10:student10){
                System.out.println("Elevi din clasa a 10 a " +student10);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
