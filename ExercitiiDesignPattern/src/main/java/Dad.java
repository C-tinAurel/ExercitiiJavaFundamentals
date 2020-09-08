public class Dad extends Person {



    private Dad(String name,String surname,String age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    private static Dad instance= new Dad("Popescu","Adrian","45");

    public static Dad getInstance() {
        return instance;
    }
}
