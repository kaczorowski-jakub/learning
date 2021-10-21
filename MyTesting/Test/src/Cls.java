import java.io.Closeable;
import java.io.IOException;

public class Cls implements Closeable {
	
	@Override
	public void close() throws IOException {
		System.out.println("CLS close");
		
	}
	
	public static void main(String[] args) {

	}
	
}
