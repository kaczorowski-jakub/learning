package io;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class Test {

	public static void main(String[] args) {

		// test1();
		// test2();
		//BufferedStrm.test();
		//Scnr.test();
		//Frmtr.test();
		//DataStream.test();
		//ObjStream.test();
		//Pth.test();
		//Fls.test();
		//RandomAccess.test();
		//Dir.test();
		//Link.test();
		//FVI.test();
		//Watcher.test();
		Useful.test();

	}

	/**
	 * Test strumieni bajtow
	 */
	public static void test1() {

		InputStream is = null;

		try {
			is = new FileInputStream("example.txt");
			int i;
			while ((i = is.read()) != -1) {
				out.println((char) i);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}

		OutputStream os = null;

		try {
			os = new FileOutputStream("example_out.txt");
			os.write(123);
			os.write(435);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}

	}

	/*
	 * Test strumieni string
	 */
	public static void test2() {

		Reader fr = null;
		Writer fw = null;

		try {
			fr = new FileReader("example.txt");
			int i;
			while ((i = fr.read()) != -1) {
				out.println((char) i);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}

		try {
			fw = new FileWriter("example_out2.txt");
			fw.write("This is test");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException exc) {
					exc.printStackTrace();
				}
			}
		}
	}
}
