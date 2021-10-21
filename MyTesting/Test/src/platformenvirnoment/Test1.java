package platformenvirnoment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class Test1 {

	public static void main(String[] args) {
		
		//test1();
		test2();
		
	}
	
	public static void test2() {
		
		// system default properties
		Properties p = System.getProperties();
		
		// custom properties
		try (InputStream is = new FileInputStream("app.properties")) {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printSysVar();
	}
	
	private static void printSysVar() {
		for (Object o : System.getProperties().keySet()) {
			System.out.println(o + " = " + System.getProperty(o.toString()));
		}
	}
	
	public static void test1() {
		
		Properties def = new Properties();
		Properties app = new Properties();

		try (InputStream is = new FileInputStream("default.properties")) {
			def.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (InputStream is = new FileInputStream("app.properties")) {
			app.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		app.setProperty("TMP", "VA");
		save("app.properties", app);

		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}
		
	}
	
	private static void save(String file, Properties p) {

		try (OutputStream os = new FileOutputStream(file)) {
			p.store(os, "COMM");
		} catch (IOException e) {

		}
	}

}
