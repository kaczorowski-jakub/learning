package exception;

import java.io.IOException;

public class C2 implements I2 {
	
	@Override
	//public void m1() throws Exception {
	public void m1() throws NullPointerException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void m2() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	//public void m3() throws Exception {	zle bo Exception jest klasa bazowo dla CustomExc
	public void m3() throws Error {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void m4() throws CustomExc {
		// TODO Auto-generated method stub
		
	}
	
}
