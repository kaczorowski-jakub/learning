import javax.naming.Context;
import javax.naming.InitialContext;

public class XYZ {
	
	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			//ctx.addToEnvironment("test", "ala");
			//System.out.println(ctx.lookup("test"));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
