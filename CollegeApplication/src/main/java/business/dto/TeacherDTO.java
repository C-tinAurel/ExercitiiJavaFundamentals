package business.dto;

public class TeacherDTO {
    private String name;
    private String surname;
    private String subject;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String surname,String subject) {
        this.name = name;
        this.surname = surname;
        this.subject=subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
