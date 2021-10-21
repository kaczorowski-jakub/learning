package exception;

import java.io.IOException;

public interface I2 {
	
	public void m1() throws NullPointerException;
	
	public void m2() throws Throwable;
	
	public void m3() throws CustomExc;
	
	public void m4() throws Exception;
	
}
