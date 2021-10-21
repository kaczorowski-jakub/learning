package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Scnr {
	
	public static void test() {
		
		Scanner s = null;
		
		try {
			s = new Scanner(new BufferedReader(new FileReader("example.txt")));
			s.useDelimiter("\n");
			while (s.hasNext()) {
				if (s.hasNextInt()) {
					System.out.println("INT: " + s.nextInt());
				}
				else {
					System.out.println(s.next());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (s != null) {
                s.close();
            }
        }
				
		
	}
	
}
