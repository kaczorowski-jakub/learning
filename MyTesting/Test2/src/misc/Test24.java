package misc;

public class Test24 {
    public static void parse(String str) {
        try {
            float f = Float.parseFloat(str);
        } catch(NumberFormatException nfe) {
            //f =0;
        } finally {
            //System.out.println(f);
        }
    }
}
