public class PricePolicy {
    private double factor;

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public double getPrice(double price) {
        return factor*price;
    }
}
