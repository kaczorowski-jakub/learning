package serialization;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DontWantSerialClass extends SerialClass {

	private void writeObject(ObjectOutputStream out) throws IOException {
		throw new NotSerializableException("Not today!");
	}

	private void readObject(ObjectInputStream in) throws IOException {
		throw new NotSerializableException("Not today!");
	}

}
