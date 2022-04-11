import java.util.ArrayList;
import java.util.Iterator;

public class CompositeMovie implements ComponentMovie{
    private String name;
    private ArrayList<ComponentMovie> myList = new ArrayList<>();

    public CompositeMovie(String name) {
        this.name = name;
    }

    @Override
    public void Add(ComponentMovie movie) {
        myList.add(movie);
    }

    @Override
    public void Remove(ComponentMovie movie) {
        for(int i = 0;i<myList.size();i++){
            if(myList.get(i).getName().equals(movie.getName())){
                myList.remove(i);
            }
        }
    }

    @Override
    public void Display(int indent) {
        for (int i = 0 ; i<indent;i++) System.out.print("-");
        System.out.print("+");
        System.out.println(getName());
        // Display each child element on this node
        for (int i= 0; i< myList.size(); i++) {
            myList.get(i).Display(indent+2);
        }
    }
    public int find(String name) {
        for(ComponentMovie movie : myList){
            if(movie instanceof CompositeMovie){
                if(movie.getName().equals(name)){
                    return movie.getMyList().size();
                }
                else {
                    int returnValue = ((CompositeMovie) movie).find(name);
                    if (returnValue>0){
                        return returnValue;
                    }
                }
            }
        }
        return 0;
    }

    public ArrayList<ComponentMovie> getMyList() {
        return myList;
    }

    @Override
    public String getName() {
        return name;
    }
}
