public class Car {
    private String marca;
    private String model;
    private int nrUsi;

    public Car() {

    }

    public Car(String marca, String model, int nrUsi) {
        this.marca = marca;
        this.model = model;
        this.nrUsi = nrUsi;
    }

    public String getMarca() {
        return marca;
    }

    public int getNrUsi() {
        return nrUsi;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return this.marca + " " + this.marca + " " + this.nrUsi;
    }
    public boolean equals(Car obj){
       if(this.model.equals(obj.getModel()) && this.marca.equals(obj.getMarca()) && this.nrUsi==obj.getNrUsi()){
           return true;
       }else{
           return false;
       }
    }
}
