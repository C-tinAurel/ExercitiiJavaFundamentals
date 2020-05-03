public class Main {
    public static void main(String[] args) {
        //Se da un text:
        //sa se afiseze toate cuvinte care incep cu litera "S" sau cu litera "D"
        //sa se afiseze litera de la pozitia 3 din fiecare cuvant
        String text5 = "Stau câteodată și-mi aduc aminte ce vremi și ce oameni mai erau în părțile noastre pe când începusem și eu drăgăliță-Doamne a mă ridica băiețaș la casa părinților mei în satul Humulești din târg drept peste apa Neamțului sat mare și vesel împărțit în trei părți care se țin tot de una: Vatra satului Delenii și Bejenii";
        cuvintecuSSiD(text5);
        literaPozitie3(text5);
    }
    public static void cuvintecuSSiD(String text5){

        String[] spatiuText= text5.split(" ");
        for(int coursor=0;coursor<spatiuText.length; coursor++){
            spatiuText[coursor]= spatiuText[coursor].toLowerCase();
            if(spatiuText[coursor].startsWith("s") || spatiuText[coursor].startsWith("d")){
                System.out.println("Sa se afisez cuvintele: " +spatiuText[coursor]);
            }
        }

    }

    public static void literaPozitie3(String text5){
        String[] spatiuText = text5.split(" ");
        for(int corusor=0;corusor<spatiuText.length;corusor++){
            if(spatiuText[corusor].length() > 3){
          System.out.println("Litera de la pozitia 3 a cuvantului: " +spatiuText[corusor]+  " este "  +spatiuText[corusor].charAt(3));


        }
    }
}
}