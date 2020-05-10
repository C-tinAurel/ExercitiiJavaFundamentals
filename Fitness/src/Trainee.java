public class Trainee {

    private int stamina=1000;
    private int strength=50;
    private String name;


    public Trainee() {

    }

    public Trainee(String name) {
        this.name = name;

    }

    public void cardio() {
        System.out.println("Am inceput cardio");
        System.out.println("Ard 300 calorii");
        stamina -= 30;
        strength += 10;
    }

    public void bodyPump() {
        System.out.println("Am inceput body pummp");
        System.out.println("Ard 500 calorii");
        stamina -= 50;
        strength += 10;
    }

    public void box() {
        System.out.println("Am inceput boxul");
        System.out.println("Ard 250 calorii");
        stamina -= 70;
        strength += 10;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }
}
