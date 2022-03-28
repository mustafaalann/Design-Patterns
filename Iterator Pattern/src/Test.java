public class Test {
    public static void main(String[] args) {

        Orchestra orchestra = new Orchestra("Orchestra");

        orchestra.addInstrument(new Strings("String Player1"));
        orchestra.addInstrument(new Strings("String Player2"));
        orchestra.addInstrument(new Keyboards("Keyboard Player3"));
        orchestra.addInstrument(new Keyboards("Keyboard Player4"));
        orchestra.addInstrument(new Brass("Brass Player5"));
        orchestra.addInstrument(new Brass("Brass Player6"));

        System.out.println("-----------------------------------------");
        System.out.println("Orchestra List :");
        System.out.println("Number of instruments :"+Instruments.getNoOfInstruments());
        orchestra.play();
        System.out.println("-----------------------------------------");

        OrchestraIterator orchestraIterator = new OrchestraIterator(orchestra);
        BrassIterator brassIterator = new BrassIterator(orchestra);

        System.out.println("-----------------------------------------");
        System.out.println("Orchestra Iterator is Playing REVERSE");
        orchestra.play2(orchestraIterator);
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Brass Iterator is Playing Just Brasses");
        orchestra.play2(brassIterator);
        System.out.println("-----------------------------------------");


    }
}
