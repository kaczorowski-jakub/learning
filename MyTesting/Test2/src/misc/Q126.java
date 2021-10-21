package misc;

public class Q126 implements Runnable 
{ 
    private int x; 
    private int y; 

    public static void main(String [] args) 
    { 
        Q126 that = new Q126(); 
        (new Thread(that)).start( ); /* Line 8 */
        (new Thread(that)).start( ); /* Line 9 */
        long y = (byte)100;
        byte z = (byte)100L;
        byte x = (byte)1000L;
        int w = (int)888.8;
    } 
    public synchronized void run( ) /* Line 11 */
    { 
        int [ ][ ] scores = {{2,7,6}, {9,3,45}};
        int x=20;
        String sup = (x < 15) ? "small" : (x < 22)? "tiny" : "huge";
        System.out.println(sup);
        for (;;) /* Line 13 */
        { 
            x++; 
            y++; 
            System.out.println("x = " + x + "y = " + y); 
        } 
        
    } 
}