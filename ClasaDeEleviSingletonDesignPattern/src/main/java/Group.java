public class Group {
    private String clasa;

    private static Group instance = new Group();

    private Group() {

    }

    public static Group getInstance() {
        return instance;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

}
