import java.io.*;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, MaximumNumberOfTraneeReached {

        //Inventar
        //avem nevoie de clasele abstracte Person Trainer,tranee,group
        // facem o clasa Eeceptie maximNUmber
        //facem o clasa SoftwareDevelopmentAcademy(singleton) ar contine o colectie de grupe(set de grup)
        //avem nevoie de un fisier care sa contina studentii
        //avem nevoie de un fisier care sa contina Grupele
        //afisam grupele care au numar maxim de studenti
        //afisam  din grupe studenti care au pana in 25 de ani
        // afisam studenti care mai au cunostinte de programare si separata si cei care nu au cunostinte de programare

        try {


            String filePathTrainees = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\ExercitiiJavaAdvanced Coding\\Exercitiu\\FisierTranee.txt";
            String filePathTrainees2 = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\ExercitiiJavaAdvanced Coding\\Exercitiu\\FisierTranee2.txt";
            String filePathTrainees3 = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\ExercitiiJavaAdvanced Coding\\Exercitiu\\FisierTranee3.txt";
            String filePathGroups = "C:\\Users\\C-tin Aurel\\Pictures\\RepositoryCursGalati3\\ExercitiiJavaFundamentals\\ExercitiiJavaAdvanced Coding\\Exercitiu\\FisierGroup.txt";

            FileReader fileReaderTranees = new FileReader(filePathTrainees);
            FileReader fileReaderTrainees2 = new FileReader(filePathTrainees2);
            FileReader fileReaderTrainees3 = new FileReader(filePathTrainees3);
            FileReader fileReaderGroup = new FileReader(filePathGroups);

            BufferedReader bufferedReaderTrainees = new BufferedReader(fileReaderTranees);
            BufferedReader bufferedReaderTrainees2 = new BufferedReader(fileReaderTrainees2);
            BufferedReader bufferedReaderTrainees3 = new BufferedReader(fileReaderTrainees3);
            BufferedReader bufferedReaderGroups = new BufferedReader(fileReaderGroup);

            Set<Trainee> traineesGroup = new HashSet<Trainee>();
            String text = bufferedReaderTrainees.readLine();
            //Aici ne ocupam de studentii din grupa 1
            while (text != null && !(text.isEmpty())) {
                String[] arrayCuvinte = text.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup.size() == 5) {
                    throw new MaximumNumberOfTraneeReached("Nr studentilor din grupa 1 este mai mare decat 5");
                } else {
                    traineesGroup.add(trainee);
                }
                text = bufferedReaderTrainees.readLine();

            }
            System.out.println("Afisam studenti din grupa 1 ");
            for (Trainee trainee : traineesGroup) {
                System.out.println(trainee);
            }
            //ne ocupam de studenti din grupa 2;
            Set<Trainee> traineesGroup2 = new HashSet<Trainee>();
            String text2 = bufferedReaderTrainees2.readLine();
            while (text2 != null && !(text2.isEmpty())) {

                String[] arrayCuvinte = text2.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup2.size() == 5) {
                    throw new MaximumNumberOfTraneeReached("Nr studentilor din grupa 2 este mai mare decat 5");
                } else {
                    traineesGroup2.add(trainee);
                }
                text2 = bufferedReaderTrainees2.readLine();

            }
            System.out.println("Afisam grupa 2 ");
            for (Trainee trainee2 : traineesGroup2) {
                System.out.println(trainee2);
            }
            //Ne ocupam de grupa 3 de studenti
            Set<Trainee> traineesGroup3 = new HashSet<Trainee>();
            String text3 = bufferedReaderTrainees3.readLine();
            while (text3 != null && !text3.isEmpty()) {
                String[] arrayCuvinte = text3.split(";");
                Trainee trainee = new Trainee(arrayCuvinte[0], arrayCuvinte[1], Integer.valueOf(arrayCuvinte[2]), Boolean.valueOf(arrayCuvinte[3]));
                if (traineesGroup3.size() == 5) {
                    throw new MaximumNumberOfTraneeReached("Nr studenti din grupa 3 este mai mare decat 5");
                } else {
                    traineesGroup3.add(trainee);
                }
                text3 = bufferedReaderTrainees3.readLine();
            }

            System.out.println("Afisam grupa 3");
            for (Trainee trainee3 : traineesGroup3) {
                System.out.println(trainee3);
            }
            Set<Group> groups = new HashSet<Group>();
            String text4 = bufferedReaderGroups.readLine();
            while (text4 != null && !text4.isEmpty()) {
                String[] arrayCuvinte = text4.split(";");
                Trainer trainer = new Trainer(arrayCuvinte[1], arrayCuvinte[2], 20, true);
                Group group = new Group(arrayCuvinte[0], trainer);
                if (trainer.getName().equals("Alex")) {
                    group.setGroupTrainees(traineesGroup);
                }
                if (trainer.getName().equals("Ion")) {
                    group.setGroupTrainees(traineesGroup2);
                }
                if (trainer.getName().equals("Lica")) {
                    group.setGroupTrainees(traineesGroup3);
                }
                groups.add(group);
                text4 = bufferedReaderGroups.readLine();
            }

            System.out.println("Afisam grupele");
            for (Group group : groups) {
                System.out.println(group);
            }
            SoftwareDevelopmentAcademy softwareDevelopmentAcademy = SoftwareDevelopmentAcademy.getInstance();
            softwareDevelopmentAcademy.setGroups(groups);
            // aici rezolvam exercitul Afisam grupele care au numar maxim de studenti
            Set<Group> groupsSet = softwareDevelopmentAcademy.getGroups();
            for (Group group : groupsSet) {
                if (group.getGroupTrainees().size() == 5) {
                    System.out.println("Afisam grupa " + group);
                }
            }

            // afisam din toate grupele studenti care au pana in 25 de ani
            Set<Group> groupSet = softwareDevelopmentAcademy.getGroups();
            System.out.println("Varsta studentilor pana in 25 de ani");
            for (Group group : groupSet) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (Year.now().getValue() - trainee.getAge() < 25) {
                        System.out.println(trainee.toString());
                    }
                }
            }

            // afisam toti studenti care mai au cunostinte de programare

            Set<Group> groupSet1 = softwareDevelopmentAcademy.getGroups();
            for (Group group : groupSet1) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (trainee.isKnowProgaming() == true) {
                        System.out.println("Studenti care au cunostinte de programare " + trainee);
                    }
                }
            }

            //pas 1:  trebuie sa numaram studentii fara cunostinte de programare din fiecare grupa
            //pas 2 : trebuie sa departajam fiecare grupa cu numarul de studentii care nu are cunostinte de programare
            //pas 3 : creem o colectie de tipul Map care sa tina grupa si nr studentilor care nu au cunostinte de programare

            Set<Group> groupSet2 = softwareDevelopmentAcademy.getGroups();
            System.out.println("Afisam grupa cu studentii care au mai putine cunostinte de programare");
            Map<Group, Integer> groupMap = new HashMap<Group, Integer>();

            for (Group group : groupSet2) {
                int traineeNumbers = 0;
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (trainee.isKnowProgaming() == false) {
                        traineeNumbers++;
                    }
                }
                groupMap.put(group, traineeNumbers);
            }
            //presupunem prin reducere la absurd ca numarul maxim de studenti fara cunostinte de programare este maximumNumbersOfTrainees este 0
            //si grupa cu numarul maxim de studenti fara cunostinte de programare este un default groupNumberOfTrainees
            Group groupWithMaximNumberOfTrainees = new Group();
            Integer maximumNumbersOfTrainees = 0;
            for (Group group : groupMap.keySet()) {
                Integer currentNumbersOfTrainees = groupMap.get(group);
                //valoarea pentru grupa curenta
                if (currentNumbersOfTrainees > maximumNumbersOfTrainees) {
                    maximumNumbersOfTrainees = currentNumbersOfTrainees;
                    groupWithMaximNumberOfTrainees = group;
                }
            }
            System.out.println("Afisam grupa cu numarul maxim de trainees" + groupWithMaximNumberOfTrainees);

            //sa se afiseze grupa care are cei mai putini studenti sub 20 de ani
            Set<Group> groupSet4 = softwareDevelopmentAcademy.getGroups();
            System.out.println("Varsta studentilor sub 20 de ani");
            for (Group group : groupSet4) {
                for (Trainee trainee : group.getGroupTrainees()) {
                    if (Year.now().getValue() - trainee.getAge() < 20) {
                        System.out.println(trainee.toString());
                    }
                }
            }


        } catch (MaximumNumberOfTraneeReached e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Nu am gasit fisierul " + e.getMessage());
        } catch (IOException e) {
            System.out.println("A aparut o eroare " + e.getMessage());

        }
    }
}
