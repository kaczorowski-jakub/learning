package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Useful {

	public static void test() {
		
		// MIME
		try {
			Path filename = Paths.get("example.txt");
		    String type = Files.probeContentType(filename);
		    if (type == null) {
		        System.err.format("'%s' has an" + " unknown filetype.%n", filename);
		    } else if (type.equals("text/plain")) {
		        System.err.format("'%s' is" + " a plain text file.%n", filename);
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
		
	}

}
