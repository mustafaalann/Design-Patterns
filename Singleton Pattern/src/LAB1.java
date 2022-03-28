import java.util.ArrayList;
import java.util.HashMap;

class Singleton {
    static HashMap<String,Singleton> hashmap = new HashMap<>();
    String name;
    public static void registerInstances(ArrayList<String> names) throws Exception {
        for(int i = 0; i<names.size(); i++){
            if(i == 3){
                throw new Exception("Sorry we cant add more than 3 values into hashmap");
            }
            System.out.println(i);
            hashmap.put(names.get(i),new Singleton(names.get(i)));
        }
    }
    public static Singleton getInstance(String name){
       return hashmap.get(name);
    }
    private Singleton(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class TEST {
    public static void main(String[] args) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        names.add("no1");
        names.add("no2");
        names.add("no3");
        Singleton.registerInstances(names);
        Singleton single = Singleton.getInstance("no1");
        System.out.println(single);
    }

}
