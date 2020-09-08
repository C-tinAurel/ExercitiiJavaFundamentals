public abstract class Product {
    protected String productName;
    protected int productPrice;
    protected int productQuantity;

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getProductName() {
        return productName;
    }
}
