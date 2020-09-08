public class Trainer extends Person{
    private boolean isAuthorized;



    public Trainer(String name,String surname,int age,boolean isAuthorized){
        this.isAuthorized=isAuthorized;
        this.name=name;
        this.surname=surname;
        this.age=age;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " +this.surname;
    }

}
