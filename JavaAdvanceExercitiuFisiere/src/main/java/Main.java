import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Sa se citeasca dintr un fisier linie cu linie
        //Sa se scrie in alt fisier liniile din primul fisier care au nr par de cuvinte

        try {


            // Prima data decaram calea
            String textCitit = "C:\\Users\\C-tin Aurel\\Pictures\\fisiere\\Fisier1.txt";
            String textScris = "C:\\Users\\C-tin Aurel\\Pictures\\fisiere\\fisierflush.txt";
            FileReader fileReader = new FileReader(textCitit);
            FileWriter fileWriter = new FileWriter(textScris);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text = bufferedReader.readLine();
            while (text != null) {
                String[] split = text.split(" ");
                if (split.length % 2 == 0) {
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                text = bufferedReader.readLine();

            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("A aparut eroarea " + e.getMessage());
        }
    }
}
