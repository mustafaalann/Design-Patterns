
public class OrchestraIterator extends AbstractIterator {
    private int index;
    private Orchestra orchestra ;
    public OrchestraIterator(Orchestra orchestra) {
        this.orchestra = orchestra;
        this.index = 0;
    }

    @Override
    void First() {
        index = orchestra.getInstruments().size()-1;
    }

    @Override
    void Next() {
        index--;
    }

    @Override
    boolean IsDone() {
        return 0>index;
    }

    @Override
    Instruments CurrentInstrument() {
        return orchestra.getInstruments().get(index);
    }
}
