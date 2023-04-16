public class Counter implements AutoCloseable {
    private static int counter;

    static {
        counter = 0;
    }

    public static int getCounter() {
        return counter;
    }

    public static void add() {
        counter++;
    }    

    @Override 
    public void close() throws Exception { 
    // close your resource in the appropriate way 
    } 
}
