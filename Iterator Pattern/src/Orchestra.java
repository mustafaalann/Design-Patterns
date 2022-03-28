import java.util.ArrayList;

public class Orchestra{
    private String name;
    private ArrayList<Instruments> instruments = new ArrayList<>();

    public void play(){
        for(Instruments instrument : instruments){
            instrument.sound();
        }
    }
    public void play2(AbstractIterator iterator){
        iterator.First();
        while (!iterator.IsDone()){
            iterator.CurrentInstrument().sound();
            iterator.Next();
        }
    }
    public void addInstrument(Instruments instrument){
        instruments.add(instrument);
    }

    public Orchestra(String name) {
        this.name = name;
    }

    public ArrayList<Instruments> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instruments> instruments) {
        this.instruments = instruments;
    }
}
