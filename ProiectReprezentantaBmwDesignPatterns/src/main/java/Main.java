public class Main {
    public static void main(String[] args) {

        Car bmw = new Car("bmw", "X4", "2000", "blue");
        Car bmw2 = bmw.clone();
        bmw2.setColor("white");
        Car bmw3 = bmw.clone();

        Car audi=new Car("audi","a4","2000","red");
        Car audi2= audi.clone();
        audi2.setEngine("3000");

        // Car bmw2 = new Car("bmw", "X4", "2000", "Red");
        //Car bmw3 = new Car("bmw", "X4", "2000", "black");
        //Car bmw4 = new Car("bmw", "X4", "2000", "white");
        //  Car bmw5 = new Car("bmw", "X4", "2000", "green");
        //  Car bmw6 = new Car("bmw", "X4", "2000", "blue");
        //  Car bmw7 = new Car("bmw", "X4", "2000", "blue");
        //Car bmw8 = new Car("bmw", "X4", "2000", "blue");
        //Car bmw9 = new Car("bmw", "X4", "2000", "green");
        //Car bmw10 = new Car("bmw", "X4", "2000", "green");
        //Car bmw11 = new Car("bmw", "X4", "2000", "green");


    }
}
