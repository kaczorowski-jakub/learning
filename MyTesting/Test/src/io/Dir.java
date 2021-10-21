package io;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dir {

	public static void test() {

		// listowanie root'ow - partycji
		System.out.println("Lista ROOT");
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name : dirs) {
			System.out.println(name);
		}

		// tworzenie katalogu
		System.out.println("\nNowe katalogi");
		Path p = Paths.get("src\\dupa\\ala\\ma\\kota\\i\\ma\\jeszcze");
		try {
			Files.createDirectories(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// tworzenie katalogu tymczasowego
		System.out.println("\nKatalog tymczasowy");
		try {
			Path p1 = Files.createTempDirectory("dupa");
			System.out.println(p1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// listowanie zawartosci akatalogow
		System.out.println("\nDirectory content");
		Path dir = Paths.get("src");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}

		// listowanie i filtrowanie zawartosci katalogow przez glob
		System.out.println("\nDirectory content & glob filter");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,class,jar}")) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}
		
		// listowanie i filtrowanie zawartosci katalogow przez wlasny filtr
		System.out.println("\nDirectory content & custom filter");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, new DirectoryStream.Filter<Path>() {
		
			@Override
			public boolean accept(Path entry) throws IOException {
				try {
					if (Files.isDirectory(entry)){
						return true;
					}
					return false;
				} catch(Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		
		})) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}
	}

}
