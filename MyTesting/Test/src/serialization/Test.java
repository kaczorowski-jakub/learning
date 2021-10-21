package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {

		ToSerialWrong ts = new ToSerialWrong();
		ts.a = "ADSAD";
		ts.b = "12LAT";
		ts.abc = 3232;

		try {
			FileOutputStream fos = new FileOutputStream("D:\\test_wrong.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(ts);
			oos.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
		// serialization ok - implements seriali
		ToSerialOk tso = new ToSerialOk();
		tso.a = "ADSAD";
		tso.b = "12LAT";
		tso.abc = 3232;
		
		try {
			FileOutputStream fos = new FileOutputStream("D:\\test_ok.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tso);
			oos.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
		// inherited class
		// serialization
		ToSerialInher tsi = new ToSerialInher();
		tsi.a = 12;
		tsi.b = "A";
		tsi.c = 99;
		tsi.d = "B";
		try {
			FileOutputStream fos = new FileOutputStream("D:\\test_inher.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tsi);
			oos.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
		// deserialiation
		try {
			ToSerialInher tsi2 = new ToSerialInher();
			FileInputStream fis = new FileInputStream("D:\\test_inher.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			tsi2 = (ToSerialInher) ois.readObject();
			System.out.println(tsi2.a);
			ois.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
		// serialization by implementing externalizable
		ToSerialExtern tse = new ToSerialExtern();
		try {
			FileOutputStream fos = new FileOutputStream("D:\\test_extern.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(tse);
			oos.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
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
		
		// subclass inherits Serializable with its superclass
		DontWantSerialClass dwsc = new DontWantSerialClass();
		
		try {
			FileOutputStream fos = new FileOutputStream("D:\\test_dontwant.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dwsc);
			oos.close();
		} catch (Exception io) {
			io.printStackTrace();
		}
		
		
	}

}
