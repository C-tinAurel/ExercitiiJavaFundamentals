public class Student {
    private String name;
    private String surname;
    private String group;
    private String optional;


    public Student(String name, String surname, String group, String optional) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.optional = optional;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public String getOptional() {
        return optional;
    }

    public String toString() {
        return this.name + " " + this.surname + " " + this.group + " " + this.optional;
    }
}
