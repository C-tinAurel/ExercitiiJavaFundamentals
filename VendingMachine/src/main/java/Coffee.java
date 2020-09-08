import java.util.Collections;

public abstract class Coffee extends Product {

    public Coffee(String productName, int productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

    }

    public Coffee() {

    }
}
