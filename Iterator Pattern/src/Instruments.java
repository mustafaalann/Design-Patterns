public abstract class Instruments {
    public Instruments(String name) {
        noOfInstruments++;
        this.name = name;
    }

    protected String name;
    protected static int noOfInstruments = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNoOfInstruments() {
        return noOfInstruments;
    }

    public static void setNoOfInstruments(int noOfInstruments) {
        Instruments.noOfInstruments = noOfInstruments;
    }

    public abstract void sound();
}
