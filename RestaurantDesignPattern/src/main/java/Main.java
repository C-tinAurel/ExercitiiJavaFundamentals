
public class Main {
    public static void main(String[] args) {
        //exemplificam desing pattern Singleton
        Meniu meniu = Meniu.getInstance();
        Meniu meniu2 = Meniu.getInstance();

        System.out.println("Afisam bauturile din meniu " + meniu.getBauturi());
        System.out.println("Afisam bauturile din meniul 2 " + meniu2.getBauturi());

        meniu.setBauturi("Mirinda,Fanta");
        System.out.println("Afisam bauturile dupa ce le am modificate cu Setter");
        System.out.println("Modificare bauturi " + meniu.getBauturi());
        System.out.println("Modificare bauturi " + meniu2.getBauturi());


    }
}
