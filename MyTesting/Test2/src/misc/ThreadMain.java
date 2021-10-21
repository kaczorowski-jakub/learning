package misc;

public class ThreadMain {
    
    public static void main(String[] args) {
        
        ThreadChecking tc1 = new ThreadChecking();
        ThreadChecking tc2 = new ThreadChecking();
        tc1.start();
        tc2.start();
    }
    
}
