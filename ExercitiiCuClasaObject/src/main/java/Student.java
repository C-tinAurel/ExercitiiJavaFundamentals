public class Student {
    private String nume;
    private String prenume;
    private String adresa;


    public Student() {

    }


    public Student(String nume, String prenume, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String toString() {
        return this.nume + " " + this.prenume + " " + this.adresa;
    }

    public boolean equals(Student obj) {
        if (this.nume.equals(obj.getNume()) && this.prenume.equals(obj.getPrenume()) && this.adresa.equals(obj.getAdresa())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.nume.length() + this.prenume.length() + this.adresa.length();
    }
}
