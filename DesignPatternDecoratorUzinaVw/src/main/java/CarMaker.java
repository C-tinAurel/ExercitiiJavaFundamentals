public class CarMaker {


    public void makeVolswagen(){
       Car volswagen= new Volswagen();
       volswagen.build();
    }
    public void makeSeat(){
        Car seat=new Seat();
        seat.build();
    }
    public void makeAudi(){
        Car audi = new Audi();
        audi.build();
    }

}
