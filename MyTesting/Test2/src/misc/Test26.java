package misc;

public class Test26 {
    
    public enum MyColor {
        RED(0xff0000),GREEN(0x00ff00),BLUE(0x0000ff);
        
        private final int rgb;
        MyColor(int rgb) {
            this.rgb = rgb;
        }
    }
    
    public static void main(String[] args) {
        MyColor skyColor = MyColor.BLUE;
    }
}
