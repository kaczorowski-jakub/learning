package misc;

class Tree { } 
class Pine extends Tree { } 
class Oak extends Tree { } 

public class TEst17 {
    public static void main(String[] args) {
        Boolean b1 = new Boolean("false");
        boolean b2;
        b2 = b1.booleanValue();
        if (!b2) 
        {
            b2 = true;
            System.out.print("x ");
        }
        if (b1 & b2) /* Line 13 */
        {
            System.out.print("y ");
        }
        System.out.println("z");
        
        Tree tree = new Pine(); 
        if( tree instanceof Pine ) 
            System.out.println ("Pine"); 
        else if( tree instanceof Tree ) 
            System.out.println ("Tree"); 
        else if( tree instanceof Oak ) 
            System.out.println ( "Oak" ); 
        else 
            System.out.println ("Oops ");
        
        String d = "bookkeeper";
        d.substring(1,7);
        d = "w" + d;
        //d.append("woo");  /* Line 4 */
        System.out.println(d);
        
        String a = "ABCD"; 
        String b = a.toLowerCase(); 
        b.replace('a','d'); 
        b.replace('b','c'); 
        System.out.println(b);
        
        switch (a) {
            case "ABCD": System.out.println("1");
            default: System.out.println("2");
            case "A": System.out.println("3");
        }
        
        Object [][] theDogs = new Object[3][];
        System.out.println(theDogs[2][0].toString());
        
        assert b.equals("abcd") : a.isEmpty() ? "test" : "ala";
        assert b.equals("aaa") : "TEST";
    }
}
