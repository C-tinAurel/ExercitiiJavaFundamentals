public class Employee {
    private String name;
    private String surname;
    private String departament;

    public Employee() {

    }

    public Employee(String name, String surname, String departament) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
    }

    public String getDepartament() {
        return departament;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + " " + this.surname + " " + this.departament;
    }

    public boolean equals(Employee obj) {
        if (this.name.equals(obj.getName()) && this.surname.equals(obj.getSurname()) && this.departament.equals(obj.getDepartament())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.name.length() + this.surname.length() + this.departament.length();
    }
}
