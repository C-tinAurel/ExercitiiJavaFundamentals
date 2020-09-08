public class Main {
    public static void main(String[] args) {

        //inceput de clasa a 9-a
        Group group = Group.getInstance();
        Catalog catalog = Catalog.getInstance();

        group.setClasa("Clasa a 9 B");
        catalog.setName("Catalogul clasei a 9 B");

        Group group2 = Group.getInstance();
        Catalog catalog2 = Catalog.getInstance();

        System.out.println("Grupul 1 " + group.getClasa());
        System.out.println("Grupul 2 " + group2.getClasa());
        System.out.println("Catalog 1 " + catalog.getName());
        System.out.println("Catalog 2 " + catalog2.getName());

        group.setClasa("Clasa a 10 b");
        catalog.setName("Catalogul clasei a 10 b");

        System.out.println("Clasa a 10 a " + group.getClasa());
        System.out.println("Catalogul a 10 este " + catalog.getName());
        System.out.println("Clasa 2 a 10 b " + group2.getClasa());
        System.out.println("Catalogul 2 10 este " +catalog2.getName());



    }
}
