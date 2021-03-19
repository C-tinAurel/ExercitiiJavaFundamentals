public class CalculatorStiintific extends Calculator{


    public CalculatorStiintific() {

    }

    //Math ne ajuta sa executam un calculator stiintific
    public double ridicareaLaPutere(int a, int b) {
        return Math.pow(a, b);
    }

    public double radicalDintrunNUmar(int a) {
        return Math.sqrt(a);
    }

    public double logaritmInBaza10(int a) {
        return Math.log10(a);
    }

    public double logaritmDintrunNumar(int a) {
        return Math.log(a);

    }
}
