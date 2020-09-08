public class Trainee extends Person {
    private boolean knowProgaming;

    public Trainee(String name, String surname, int age, boolean knowProgaming) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.knowProgaming = knowProgaming;
    }

    public boolean isKnowProgaming() {
        return knowProgaming;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.age;
    }

    public int getAge() {
        return age;
    }
}
