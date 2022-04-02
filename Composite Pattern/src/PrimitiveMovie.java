public class PrimitiveMovie implements ComponentMovie{
    private String name;
    private String directorName;
    private String year;

    public PrimitiveMovie(String name, String directorName, String year) {
        this.name = name;
        this.directorName = directorName;
        this.year = year;
    }

    @Override
    public void Add(ComponentMovie movie) {
        System.out.println("Cannot add to Primitive Element.");
    }

    @Override
    public void Remove(ComponentMovie movie) {
        System.out.println("Cannot remove from Primitive Element");
    }

    @Override
    public void Display(int indent) {
        for(int i = 1;i <= indent;i++) 	System.out.print("-");
        System.out.println(" "  + name+ " ("+directorName+" "+year+")");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
