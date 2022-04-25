public class Test {
    public static void main(String[] args) {
        SonyFactory sonyFactory = SonyFactory.createSonyFactory();
        sonyFactory.CreateConsole();
        sonyFactory.CreateJoyPad();

        NintendoFactory nintendoFactory = NintendoFactory.CreateNintendoFactory();
        nintendoFactory.CreateConsole();
        nintendoFactory.CreateJoyPad();


        MicrosoftFactory microsoftFactory = MicrosoftFactory.CreateMicrosoftFactory();
        microsoftFactory.CreateConsole();
        microsoftFactory.CreateJoyPad();

        System.out.println("\nTrying General Factory :");
        GeneralFactory generalFactory = new GeneralFactory();
        generalFactory.CreateAnyConsole(0);
        generalFactory.CreateAnyController(0);

    }
}
abstract class Product{
    abstract double getPrice();
    abstract String getName();
}
class Console extends Product{
    protected double price;
    protected String name;
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
class PS5Console extends Console{
    public PS5Console(double p) {
        price = p;
        name = "PS5 Console";
        System.out.println(name +" is Created");
    }
}
class SwitchConsole extends Console{
    public SwitchConsole(double p) {
        price = p;
        name = "Switch Console";
        System.out.println(name +" is Created");
    }
}
class XBoxOne extends Console{
    public XBoxOne(double p) {
        price = p;
        name = "XBoxOne";
        System.out.println(name +" is Created");
    }
}


class Joypad extends Product{
    protected double price;
    protected String name;
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
class PS5Controller extends Joypad{
    public PS5Controller(double p) {
        price = p;
        name = "PS5 Controller";
        System.out.println(name +" is Created");
    }
}
class JoyCon extends Joypad{
    public JoyCon(double p) {
        price = p;
        name = "JoyCon";
        System.out.println(name +" is Created");
    }
}
class XBoxController extends Joypad{
    public XBoxController(double p) {
        price = p;
        name = "XBoxController";
        System.out.println(name +" is Created");
    }
}



abstract class ConsoleFactory{
    abstract Console CreateConsole();
    abstract Joypad CreateJoyPad();
    abstract Console CreateAnyConsole(int i);
    abstract Joypad CreateAnyController(int i);

}

class SonyFactory extends ConsoleFactory{
    private static final SonyFactory instance = new SonyFactory();
    private SonyFactory() {

    }
    public static SonyFactory createSonyFactory(){
        return instance;
    }

    @Override
    public PS5Console CreateConsole() {
        return new PS5Console(1000);
    }

    @Override
    public PS5Controller CreateJoyPad() {
        return new PS5Controller(200);
    }

    @Override
    Console CreateAnyConsole(int i) {
        return new PS5Console(1000);
    }

    @Override
    Joypad CreateAnyController(int i) {
        return new PS5Controller(200);
    }
}
class NintendoFactory extends ConsoleFactory{
    private static final NintendoFactory instance = new NintendoFactory();
    private NintendoFactory(){

    }
    public static NintendoFactory CreateNintendoFactory(){
        return instance;
    }


    @Override
    public SwitchConsole CreateConsole() {
        return new SwitchConsole(900);
    }

    @Override
    public JoyCon CreateJoyPad() {
        return new JoyCon(150);
    }

    @Override
    Console CreateAnyConsole(int i) {
        return new SwitchConsole(900);
    }

    @Override
    Joypad CreateAnyController(int i) {
        return new JoyCon(150);
    }
}
class MicrosoftFactory extends ConsoleFactory{
    private static final MicrosoftFactory instance = new MicrosoftFactory();
    private MicrosoftFactory(){

    }
    public static MicrosoftFactory CreateMicrosoftFactory(){
        return instance;
    }

    @Override
    XBoxOne CreateConsole() {
        return new XBoxOne(1200);
    }

    @Override
    XBoxController CreateJoyPad() {
        return new XBoxController(250);
    }

    @Override
    Console CreateAnyConsole(int i) {
        return new XBoxOne(1200);
    }

    @Override
    Joypad CreateAnyController(int i) {
        return new XBoxController(250);
    }
}
class GeneralFactory extends ConsoleFactory{

    @Override
    Console CreateConsole() {
        return null;
    }

    @Override
    Joypad CreateJoyPad() {
        return null;
    }

    @Override
    Console CreateAnyConsole(int i) {
        if(i == 0) {
            return new PS5Console(1000);
        }
        else if(i==1){
            return new SwitchConsole(900);
        }
        else if(i==2){
            return new XBoxOne(1200);
        }
        else {
            return null;
        }
    }

    @Override
    Joypad CreateAnyController(int i) {
        if(i==0){
            return new PS5Controller(200);
        }
        else if(i==1){
            return new JoyCon(150);
        }
        else if(i==2){
            return new XBoxController(250);
        }
        else {
            return null;
        }
    }
}
