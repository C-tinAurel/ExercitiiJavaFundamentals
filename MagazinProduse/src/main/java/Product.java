public class Product {
    private String category;
    private String nameProduct;
    private String section;
    private String price;
    private String discount;




    public Product(String category, String nameProduct, String section, String price, String discounnt) {
        this.category = category;
        this.discount = discounnt;
        this.nameProduct = nameProduct;
        this.price = price;
        this.section = section;


    }

    public String getCategory() {
        return category;
    }

    public String getDiscount() {
        return discount;
    }

    public String getPrice() {
        return price;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String toString() {
        return this.category + ";" + this.section + ";" + this.nameProduct + ";" + this.price + ";" + this.discount;
    }

}
