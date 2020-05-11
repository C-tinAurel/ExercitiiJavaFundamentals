public class Person {
    private String name;
    private int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String tranzactieB(int baniDePlatit) {
        if (baniDePlatit > this.money) {
            return "Nu avem destui bani";
        } else {
            this.money -= baniDePlatit;
            return "Mai avem atatia bani " + this.money;
        }

    }

    public String tranzactieM(int baniDePlatit) {
        if (baniDePlatit > this.money) {
            return "Nu avem destui bani";
        } else {
            this.money -= baniDePlatit;
            return "Mai avem atatia bnai " + this.money;
        }
    }
}
