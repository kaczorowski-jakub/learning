package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Link {
	
	public static void test() {
		
		try {
			Files.createLink(Paths.get("link"), Paths.get("D:\\putty.exe"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
