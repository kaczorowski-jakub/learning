package io;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pth {

	public static void test() {

		// tworzenie
		Path p1 = Paths.get("D:\\CCA", "test");
		Path p2 = Paths.get(URI.create("file://ala/ma/kota.txt"));
		Path p3 = FileSystems.getDefault().getPath("/users/sally");
		Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");

		// odzczytywanie informacji
		Path path = p5;
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(3): %s%n", path.getName(3));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		System.out.format("%n");

		Path path2 = Paths.get("test\\to\\jest\\a.txt");
		System.out.format("toString: %s%n", path2.toString());
		System.out.format("getFileName: %s%n", path2.getFileName());
		System.out.format("getName(3): %s%n", path2.getName(3));
		System.out.format("getNameCount: %d%n", path2.getNameCount());
		System.out.format("subpath(0,2): %s%n", path2.subpath(0, 2));
		System.out.format("getParent: %s%n", path2.getParent());
		System.out.format("getRoot: %s%n", path2.getRoot());
		System.out.format("%n");

		// konwertowanie sciezek
		Path p12 = Paths.get("/home/logfile");
		Path path3 = Paths.get("src//test.xml");

		System.out.format("%s%n", p12.toUri());
		System.out.format("%s%n", Paths.get("../albert/test.txt").toAbsolutePath().normalize());

		try {
			System.out.format("%s%n", path3.toRealPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.format("%n");

		// laczenie sciezek
		Path abc = Paths.get("test", "ala", "ma", "kota");
		System.out.format("toString: %s%n", abc.toString());
		System.out.format("toString - abs: %s%n", abc.toAbsolutePath());
		System.out.format("toString - abs - res: %s%n", abc.toAbsolutePath().resolve("iglo"));
		System.out.format("%n");

		// przemieszczanie sie po elementach
		for (Path abcd : abc.toAbsolutePath().resolve("iglo")) {
			System.out.println(abcd.toString());
		}
	}

}
