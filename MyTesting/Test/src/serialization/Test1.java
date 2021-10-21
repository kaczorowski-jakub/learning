package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1 {

	public static void main(String[] args) {

//		// serialization by implementing externalizable
//		ToSerialExtern tse = new ToSerialExtern();
//		try {
//			FileOutputStream fos = new FileOutputStream("D:\\test_extern.ser");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(tse);
//			oos.close();
//		} catch (Exception io) {
//			io.printStackTrace();
//		}
		
		// deserialization by implementing externalizable
		ToSerialExtern tse2 = new ToSerialExtern();
		try {
			FileInputStream fis = new FileInputStream("D:\\test_extern.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			tse2 = (ToSerialExtern) ois.readObject();
			ois.close();
		} catch (Exception io) {
			io.printStackTrace();
		}

	}

}
