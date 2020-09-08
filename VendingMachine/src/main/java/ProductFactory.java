public class ProductFactory {

    public ProductFactory() {

    }
    //facem metoda de Factory
    public Product getProduct(String productName) {
        if (productName.equals("Cola")) {
            return new Cola();
        }
        if (productName.equals("Fanta")) {
            return new Fanta();
        }
        if (productName.equals("Apa")) {
            return new Apa();
        }
        if (productName.equals("Cappuccino")) {
            return new Cappuccino();
        }
        if (productName.equals("Americano")) {
            return new Americano();
        }
        if (productName.equals("Espresso")) {
            return new Espresso();
        }
        if (productName.equals("Chips")) {
            return new Chips();
        }
        if (productName.equals("ChocolateBAr")) {
            return new ChocolateBar();
        }
        if (productName.equals("Croissant")) {
            return new Croissant();
        } else {
            return null;
        }


    }
}