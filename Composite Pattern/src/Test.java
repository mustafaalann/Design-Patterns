public class Test {
    public static void main(String[] args) {
        CompositeMovie root = new CompositeMovie("Movies");

        CompositeMovie  type1 =new CompositeMovie("Action");

        CompositeMovie series1 = new CompositeMovie("James Bond");
        PrimitiveMovie movie1 = new PrimitiveMovie("Casino Royale","Ian Fleming","2010");
        PrimitiveMovie movie2 = new PrimitiveMovie("No Time To Die","Ian Fleming","2022");

        CompositeMovie series2 = new CompositeMovie("John Wick");
        PrimitiveMovie movie3 = new PrimitiveMovie("John Wick2","Chad Stahelski","2015");
        PrimitiveMovie movie4 = new PrimitiveMovie("John Wick Parabellum","Chad Stahelski","2019");

        series1.Add(movie1);
        series1.Add(movie2);
        series2.Add(movie3);
        series2.Add(movie4);
        type1.Add(series1);
        type1.Add(series2);
        root.Add(type1);

        CompositeMovie  type2 =new CompositeMovie("Fantasy & Science Fiction");


        CompositeMovie series3 = new CompositeMovie("Marvel MCU");
        PrimitiveMovie movie5 = new PrimitiveMovie("Avengers End Game","Stan Lee","2003");
        PrimitiveMovie movie6 = new PrimitiveMovie("Spiderman No Way Home","Stan Lee","2021");

        CompositeMovie series4 = new CompositeMovie("Star Wars");
        PrimitiveMovie movie7 = new PrimitiveMovie("A New Hope","George Lucas","2000");
        PrimitiveMovie movie8 = new PrimitiveMovie("Return Of The Jedi","George Lucas","2018");

        series3.Add(movie5);
        series3.Add(movie6);
        series4.Add(movie7);
        series4.Add(movie8);
        type2.Add(series3);
        type2.Add(series4);
        root.Add(type2);

        root.Display(1);

        System.out.println("Children number of \"Fantasy & Science Fiction\": "+root.find("Fantasy & Science Fiction"));
    }
}
