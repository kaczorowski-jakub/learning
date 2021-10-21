package io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class FVI extends SimpleFileVisitor<Path> {

	int lvl = 0;
	private static final PathMatcher matcher;
	
	static {
		matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		
		find(file);
		/*print();
		if (attr.isSymbolicLink()) {
			System.out.format("Symbolic link: %s ", file);
		} else if (attr.isRegularFile()) {
			System.out.format("Regular file: %s ", file);
		} else {
			System.out.format("Other: %s ", file);
		}
		System.out.println("(" + attr.size() + "bytes)");*/
		return FileVisitResult.CONTINUE;
	}

	private void print() {
		for (int i = 0; i < lvl; i++)
			System.out.print("-");
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		lvl--;
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if (dir.getFileName().toString().equals("old")) {
			System.out.println("old is skipped");
			return FileVisitResult.SKIP_SIBLINGS;
		}
		lvl++;
		return FileVisitResult.CONTINUE;
	}

	public static void test() {

		try {
			// Files.walkFileTree(Paths.get("D:\\!Muzyka"), new FVI());
			/*Set<FileVisitOption> set = new HashSet<FileVisitOption>();
			set.add(FileVisitOption.FOLLOW_LINKS);
			Files.walkFileTree(Paths.get("D:\\!Muzyka"), set, 2, new FVI());*/
			Files.walkFileTree(Paths.get(""), new FVI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void find(Path p) {
		Path name = p.getFileName();
		if (name != null && matcher.matches(name)) {
			System.out.println(p);
		}
	}

}
