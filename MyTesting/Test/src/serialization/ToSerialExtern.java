package serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToSerialExtern implements Externalizable {
	
	String a;
	int i; int c;

	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		int b;
		String txt = "";
		while ((b = arg0.read()) > 0) {
			txt += (char)b;
		}
		String[] t = txt.split(",");
		this.a = (String)t[0].replace("a:","");
		this.i = Integer.parseInt(t[1].replace("i:",""));

	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {

		StringBuilder sb = new StringBuilder();
		sb.append("a:" + a);
		sb.append(",i:" + i);
		arg0.write(sb.toString().getBytes());

	}

}
