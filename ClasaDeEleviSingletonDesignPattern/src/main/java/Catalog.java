public class Catalog {
    private String name;
    private static Catalog instance = new Catalog();

    private Catalog() {

    }

    public static Catalog getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
