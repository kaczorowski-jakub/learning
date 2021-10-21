package misc;

import java.util.Date;

import javax.swing.text.DateFormatter;

public class A1 {
    private A11 a11bis;
    
    public void s(A11 a11) {
        this.a11bis = a11;
    }
    public A11 g() {
        return this.a11bis;
    }
    public static void main(String[] args) {
        A1 a1 = new A1();
        A11 a11 = new A11();
        a1.s(a11);
        a11 = null;
        
        System.out.println(a1.g());
        //int d = Math.abs(5L);
        System.out.println(Math.sqrt(-4D));
        String a = "dsadas";
        Date d = new Date(2011343412345L);
        DateFormatter df = new DateFormatter();
       
    }
}
