public class Test {
    public static void main(String[] args) {
        Part parts[] = new Part[3];
        PricePolicy pricePolicy1 = new PricePolicy();
        pricePolicy1.setFactor(1.5);
        Part memory = new Memory();
        memory.setPricePolicy(pricePolicy1);
        memory.setPrice(20);
        parts[0] = memory;

        PricePolicy pricePolicy2 = new PricePolicy();
        pricePolicy2.setFactor(2);
        Part motherboard = new Motherboard();
        motherboard.setPricePolicy(pricePolicy2);
        motherboard.setPrice(30);
        parts[1] = motherboard;

        PricePolicy pricePolicy3 = new PricePolicy();
        pricePolicy3.setFactor(2.5);
        Part hardDisk = new HardDisk();
        hardDisk.setPricePolicy(pricePolicy3);
        hardDisk.setPrice(10);
        parts[2] = hardDisk;

        System.out.println(totalPrice(parts));

    }
    public static double totalPrice(Part parts[]){
        double totalprice = 0;
        for(Part part: parts){
            totalprice += part.getPrice();
        }
        return totalprice;
    }
}
