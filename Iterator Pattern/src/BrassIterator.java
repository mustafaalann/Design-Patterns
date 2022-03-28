public class BrassIterator extends AbstractIterator{
    private int index;
    private Orchestra orchestra ;
    public BrassIterator(Orchestra orchestra) {
        this.orchestra = orchestra;
        this.index = 0;
    }

    @Override
    void First() {
        index = 0;
        while(!(orchestra.getInstruments().get(index) instanceof Brass)){
            index++;
        }
    }

    @Override
    void Next() {
        index++;
        if (!IsDone()){
            while(!(orchestra.getInstruments().get(index) instanceof Brass)){
                index++;
            }
        };

    }

    @Override
    boolean IsDone() {
        return orchestra.getInstruments().size()<=index;
    }

    @Override
    Instruments CurrentInstrument() {
        return orchestra.getInstruments().get(index);
    }

}
