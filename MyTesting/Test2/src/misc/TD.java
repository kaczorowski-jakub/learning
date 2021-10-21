package misc;

public class TD implements DS {
    
    public static void main(String[] args) {
        int x = 5;
        new TD().doStuff(++x);
    }
    
    @Override
    public void doStuff(int s) {
        
        s += EASY + ++s;
        System.out.println("s: " + s);
        
        
    }

}
