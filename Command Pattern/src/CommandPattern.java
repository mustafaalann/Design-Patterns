//MUSTAFA ALAN 20180601003

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//THIS IS MY RECIEVER
class Manipulator {
    private String text;

    public String getText() {
        return text;
    }

    public Manipulator(String text) {
        this.text = text;
    }

    //REVERSE FUNCTION
    public void Reverse(){
        String[] charlist = text.split("");
        String newString = "";
        for(int i =(charlist.length-1);i>=0;i--){
            newString += charlist[i];
        }
        this.text = newString;
    }
    public void Upper(){
        this.text = text.toUpperCase(Locale.ROOT);
    }
    public void Clear(){
        text = text.replaceAll(" ","");

    }
}



interface Command{
    void Execute();
    void Display();
}
class CompoundManipulation implements Command{
    Manipulator manipulator;
    ArrayList<Command> subComments = new ArrayList<>();  // I think using an arraylist will be a better representation of composite pattern

    public CompoundManipulation(Manipulator manipulator) {
        this.manipulator = manipulator;
    }


    public void Add(Command command) {
        subComments.add(command);
    }

    @Override
    public void Execute() {
        for(Command cmd:subComments){
            cmd.Execute();
        }
    }

    @Override
    public void Display() {
        System.out.println("---Macro Command List Items---");
        for(Command cmd:subComments){
            cmd.Display();
        }
        System.out.println("------------------------------");
    }
}

class ReverseCommand implements Command{
    Manipulator manipulator;

    public ReverseCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void Execute() {
        manipulator.Reverse();
    }
    public void Display(){
        System.out.println("Reverse Command");
    }
}
class UpperCommand implements Command{
    Manipulator manipulator;

    public UpperCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void Execute() {
        manipulator.Upper();
    }
    public void Display(){
        System.out.println("Upper Command");
    }

}
class ClearCommand implements Command{
    Manipulator manipulator;

    public ClearCommand(Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    @Override
    public void Execute() {
        manipulator.Clear();
    }
    public void Display(){
        System.out.println("Clear Command");
    }


}

//MY INVOKER
class User {
    static ArrayList<Command> commandList = new ArrayList<>();   // To store the commands

    public void ExecuteCommand(Command command){
        commandList.add(command);     //Whenever a command is executed it is stored in the Array List
        command.Execute();
    }
    public void DisplayCommandHistory(){
        for(int i = 0;i<commandList.size();i++){
            System.out.print((i+1)+"th command :");
            commandList.get(i).Display();
        }
    }
}

class CommandPatternMain{
    public static void main(String[] args) {
        Manipulator manipulator = new Manipulator("SE 311 - Software Architecture");
        User user = new User();

        System.out.println("String before manipulation : "+manipulator.getText());

        Command upperCommand = new UpperCommand(manipulator);
        user.ExecuteCommand(upperCommand);
        System.out.println("Upper command control = "+manipulator.getText());

        Command clearCommand = new ClearCommand(manipulator);
        user.ExecuteCommand(clearCommand);
        System.out.println("Clear command control = "+manipulator.getText());

        Command reverseCommand = new ReverseCommand(manipulator);
        user.ExecuteCommand(reverseCommand);
        System.out.println("Reverse command control = "+manipulator.getText());


        System.out.println("\nCommand History :");
        user.DisplayCommandHistory();



        //LETS TRY OUR MACRO COMMAND
        System.out.println("Please enter a String to check the Macro Command : ");
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();  // ASK FOR Input to user
        Manipulator manipulator2 = new Manipulator(inputText);  //Creating new manipulator to test MACRO COMMAND

        CompoundManipulation macroCommand = new CompoundManipulation(manipulator2);  //Creating macro command
        Command clearCommand2= new ClearCommand(manipulator2);      //Creating a second clear command to add into macro
        macroCommand.Add(clearCommand2);
        Command reverseCommand2= new ReverseCommand(manipulator2);      //Creating a second reverse command to add into macro
        macroCommand.Add(reverseCommand2);
        Command upperCommand2= new UpperCommand(manipulator2);      //Creating a second upper command to add into macro
        macroCommand.Add(upperCommand2);

        macroCommand.Display();
        macroCommand.Execute();
        System.out.println("Macro command control = "+manipulator2.getText());    //control the macro if did the 3 jobs ?


    }
}
