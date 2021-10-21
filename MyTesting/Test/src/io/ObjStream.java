package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjStream implements Serializable{
	
	
	String a = "ADSSAD";
	
	public static void test() {
		
		ObjStream o = new ObjStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("example_obj.txt"));
			oos.writeObject(o);
			o.a = "DUPA";
			oos.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		ObjStream o1;
		ObjStream o2;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("example_obj.txt"));
			o1 = (ObjStream) ois.readObject();
			o2 = (ObjStream) ois.readObject();
			
			if (o1 == o2){
				System.out.println("Same obj");
			}
			System.out.println(o1.a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
