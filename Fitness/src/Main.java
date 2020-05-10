import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//cerinte:
        // sa se modeleze o sedinta de personal training
        //vom avea:Trainee
        //Trainee(student)
        //Stamina
        //Strength
        //Nume
        //o sa se antrenese Lunea Miercurea si Vinerea
        //o sa porneasca cu stamina 1000
        //de fiecare data stamina o sa ii scade
        //de fiecare data cand face un exercitiu puterea o sa ii creasca
        //porneste cu puterea 50
        //Lunea cardio
        //Ati ars 300 calorii
        //Miercuri body pump
        //Ati ars 500 calorii
        //Vineri box
        //Ati ars 250 calorii
        //Cardio ii scade stamina cu 30
        //Body pump ii scade stamina cu 50
        //Boxul in scade stamina 70
        //Stamina >0
        // puterea o sa ii creasca cu 10
        Scanner name = new Scanner(System.in);
        System.out.println("Va rugam introduceti numele trainee-ului");
        String nume = name.nextLine();

        Trainee ion = new Trainee("Ion");

        Scanner zi = new Scanner(System.in);

        System.out.println("Introduceti ziua curenta");
        String ziCurenta = zi.nextLine();
        while ((ziCurenta.equals("Luni") || ziCurenta.equals("Miercuri") || ziCurenta.equals("Vineri")) && ion.getStamina() > 0) {
            switch (ziCurenta) {
                case "Luni":
                    ion.cardio();
                    System.out.println("Stamina a ajuns la " + ion.getStamina());
                    break;
                case "Miercuri":
                    ion.bodyPump();
                    System.out.println("Stamina a ajuns la " + ion.getStamina());
                    break;
                case "Vineri":
                    ion.box();
                    System.out.println("Stamina a ajuns la " + ion.getStamina());
                    break;
                default:
                    System.out.println("Nu am gasit ziua curenta");
                    break;
            }
            ziCurenta = zi.nextLine();
        }

        //! in fata equals =not equals
        if (!ziCurenta.equals("Luni") || !ziCurenta.equals("Miercuri") || !ziCurenta.equals("Vineri")) {
            System.out.println("Ati introdus o zi in care nu se antreneaza " + ziCurenta);
        }
        if (ion.getStamina() <= 0) {
            System.out.println("Trainee ul " + ion.getName() + " a obosit ");
        }
        System.out.println("Puterea trainee-ului " + ion.getName() + " a ajuns la " + ion.getStrength());
    }
//
}