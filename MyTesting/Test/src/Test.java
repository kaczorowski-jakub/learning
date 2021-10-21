import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
		
		SerialClass sc = new SerialClass();
		sc.setStr("TEST1");
		sc.setVal(12);
		sc.setVal2(101);
		sc.printClass();
		
		SerialClass sc2;
		System.out.println(385/800);
		FileOutputStream fileOut;
		FileInputStream fileIn;
		try {
			fileOut = new FileOutputStream("serialClass.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(sc);
			out.close();
	        fileOut.close();
	        
	        fileIn = new FileInputStream("serialClass.ser");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        sc2 = (SerialClass) in.readObject();
	        sc2.printClass();
	        in.close();
	        fileIn.close();
	        
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		A a = new ImplB();
		B b;
		//a = b;
		Test t = null;
		t.test();
		
		WithInner.Inner i = new WithInner.Inner();
		
	}
	
	public static void test() {
		
	}
	
	public Test() {
		//this(4);
	}
	public Test(byte var) {
		
	}
	int method(){return 1;}

}
