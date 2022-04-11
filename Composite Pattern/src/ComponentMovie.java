import java.util.ArrayList;

public interface ComponentMovie {
    public void Add(ComponentMovie movie);
    public void Remove(ComponentMovie movie);
    public void Display(int indent);
    public ArrayList getMyList();
    public String getName();
}
