public class Pizzamaker {


    public void makePizzaQuatroStagioni() {
        Pizza quatrostagioni = new PizzaQuatroStagioni();
        quatrostagioni.cook();
    }

    public void makePizzaQuatroFormaggio() {
        Pizza quatroFormaggi = new PizzaQuatroFormaggio();
        quatroFormaggi.cook();
    }

    public void makePizzaCasei() {
        Pizza pizzaCasei = new PizzaCasei();
        pizzaCasei.cook();
    }

    public void makePizzaVegetariana() {
        Pizza pizzaVegetariana = new PizzaVegetariana();
        pizzaVegetariana.cook();
    }
}
