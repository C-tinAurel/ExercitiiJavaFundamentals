public class VendingMachine {
    private Cola colaProduct;
    private Fanta fantaProduct;
    private Apa apaProduct;
    private Cappuccino cappuccinoProduct;
    private Americano americanoProduct;
    private Espresso espressoProduct;
    private Croissant croissantProduct;
    private ChocolateBar chocolateBarProduct;
    private Chips chipsProduct;

    private static VendingMachine instance = new VendingMachine();


    public VendingMachine() {

    }


    public static VendingMachine getInstance() {
        return instance;
    }

    public Cola getColaProduct() {
        return colaProduct;
    }

    public void setColaProduct(Cola colaProduct) {
        this.colaProduct = colaProduct;
    }

    public Fanta getFantaProduct() {
        return fantaProduct;
    }

    public void setFantaProduct(Fanta fantaProduct) {
        this.fantaProduct = fantaProduct;
    }

    public Apa getApaProduct() {
        return apaProduct;
    }

    public void setApaProduct(Apa apaProduct) {
        this.apaProduct = apaProduct;
    }

    public Cappuccino getCappuccinoProduct() {
        return cappuccinoProduct;
    }

    public void setCappuccinoProduct(Cappuccino cappuccinoProduct) {
        this.cappuccinoProduct = cappuccinoProduct;
    }

    public Americano getAmericanoProduct() {
        return americanoProduct;
    }

    public void setAmericanoProduct(Americano americanoProduct) {
        this.americanoProduct = americanoProduct;
    }

    public Espresso getEspressoProduct() {
        return espressoProduct;
    }

    public void setEspressoProduct(Espresso espressoProduct) {
        this.espressoProduct = espressoProduct;
    }

    public Croissant getCroissantProduct() {
        return croissantProduct;
    }

    public void setCroissantProduct(Croissant croissantProduct) {
        this.croissantProduct = croissantProduct;
    }

    public void setChipsProduct(Chips chipsProduct) {
        this.chipsProduct = chipsProduct;
    }

    public void setChocolateBarProduct(ChocolateBar chocolateBarProduct) {
        this.chocolateBarProduct = chocolateBarProduct;
    }

    public Chips getChipsProduct() {
        return chipsProduct;
    }

    public ChocolateBar getChocolateBarProduct() {
        return chocolateBarProduct;
    }

    public void setInstance(VendingMachine instance) {
        this.instance = instance;
    }

}
