public class Meniu {

    //pasul 1 constructorul clasei trebuie sa fie privat
    //pasul 2 se instantiaza o variabila privata si statica de tipu Meniu variabila o sa o numim Instance
    // pasul 3 oferim accesul catre instanta noastra printr o metoda de tipul get

    private String bauturi = "pepsi,cola";


    private static Meniu instance = new Meniu();

    private Meniu() {

    }

    public static Meniu getInstance() {
        return instance;
    }

    public String getBauturi() {
        return bauturi;
    }

    public void setBauturi(String bauturi) {
        this.bauturi = bauturi;
    }
}
