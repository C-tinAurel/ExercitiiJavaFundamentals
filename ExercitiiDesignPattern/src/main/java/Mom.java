public class Mom extends Person {


    private Mom(String name,String surname,String age) {
    this.name=name;
    this.surname=surname;
    this.age=age;
    }

    private static Mom instance=new Mom("Popescu","Mariana","42");


    public static Mom getInstance() {
        return instance;
    }
}
