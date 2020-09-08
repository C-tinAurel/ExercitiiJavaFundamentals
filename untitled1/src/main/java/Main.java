import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {


            String filePathtoWrite = "C:\\Users\\C-tin Aurel\\Desktop\\Fisier.text";
            FileWriter fileWriter = new FileWriter(filePathtoWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String liniDeScris = "Afara ploua";
            String liniDeScris2 = "Afara numai ploua";
            bufferedWriter.write(liniDeScris);
            bufferedWriter.newLine();
            bufferedWriter.write(liniDeScris2);
            //Cu flush impinge textul catre fisier
            bufferedWriter.flush();
            //cu close salvam textul pe fisier

            bufferedWriter.close();


        } catch (IOException e) {
            System.out.println("A aparut o eroare " + e.getMessage());
        }


    }
}


