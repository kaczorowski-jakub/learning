package tasks;

public class Fibbonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci:");
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i + " -> " + fib(i));
        }
        
        System.out.println("Lucas:");
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i + " -> " + luc(i));
        }
        
        System.out.println("Tribonacci:");
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i + " -> " + tri(i));
        }
        
        System.out.println("Tetranacci:");
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i + " -> " + tet(i));
        }
    }

    private static Integer fib(int pos) {
        return (pos == 0) ? 0 : pos == 1 ? 1 : fib(pos-1) + fib(pos-2);
    }
    
    private static Integer luc(int pos) {
        return (pos == 0) ? 2 : pos == 1 ? 1 : luc(pos-1) + luc(pos-2);
    }
    
    private static Integer tri(int pos) {
        return (pos == 0 || pos == 1) ? 0 : pos == 2 ? 1 : tri(pos-1) + tri(pos-2) + tri(pos-3);
    }
    
    private static Integer tet(int pos) {
        return (pos == 0 || pos == 1 || pos == 2) ? 0 : pos == 3 ? 1 : tet(pos-1) + tet(pos-2) + tet(pos-3) + tet(pos-4);
    }
    
}
