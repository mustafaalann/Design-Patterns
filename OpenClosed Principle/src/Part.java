public class Part {
    private double price;
    private PricePolicy pricePolicy;
    public void setPricePolicy(PricePolicy pricePolicy){
        this.pricePolicy = pricePolicy;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice() {
        return pricePolicy.getPrice(price);
    }
}
