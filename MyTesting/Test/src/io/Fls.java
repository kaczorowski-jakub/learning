package io;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Fls {

	public static void test() {

		Path p5 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");
		System.out.format("%s%n", "Non-existing file:");
		System.out.println("isReagularFile: " + Files.isRegularFile(p5));
		System.out.println("isReadable: " + Files.isReadable(p5));
		System.out.println("isExecutable: " + Files.isExecutable(p5));
		System.out.println("isDirectory: " + Files.isDirectory(p5));

		try {
			Path path3 = Paths.get("src//test.xml").toRealPath();
			System.out.format("%n%s%n", "Existing file:");
			System.out.println("isReagularFile: " + Files.isRegularFile(path3));
			System.out.println("isReadable: " + Files.isReadable(path3));
			System.out.println("isExecutable: " + Files.isExecutable(path3));

			System.out.println("isSameFile p5 and path3: " + Files.isSameFile(p5, path3));
		} catch (Exception e) {
			// e.printStackTrace();
		}

		System.out.format("%n%s%n", "Existing direcotry:");
		Path p1 = Paths.get(System.getProperty("user.home"));
		System.out.println("isReagularFile: " + Files.isRegularFile(p1));
		System.out.println("isReadable: " + Files.isReadable(p1));
		System.out.println("isExecutable: " + Files.isExecutable(p1));
		System.out.println("isDirectory: " + Files.isDirectory(p1));

		// kopiowanie katalogu
		Path pathF = Paths.get("2COPY");
		Path pathT = Paths.get("2COPYTMP");
		try {
			Files.copy(pathF, pathT, REPLACE_EXISTING);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// kopiowanie pliku
		Path pathFF = Paths.get("2COPY\\2bedelete.txt");
		Path pathFT = Paths.get("2bedelete.txt");
		try {
			Files.copy(pathFF, pathFT);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// usuwanie pliku
		try {
			Path path1 = Paths.get("2bedelete.txt");
			Files.delete(path1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// usuwanie pliku o ile istnieje
		try {
			Path path1 = Paths.get("2bedelete.txt");
			Files.deleteIfExists(path1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// przenoszenie pliku
		try {
			Path m1 = Paths.get("example_data.txt");
			Path m2 = Paths.get("2COPYTMP\\example_data.txt");
			Files.move(m1, m2, StandardCopyOption.REPLACE_EXISTING);
			Files.move(m2, m1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// metadata
		Path m1 = Paths.get("example_data.txt");
		try {
			System.out.format("%n%s%n", "Metadata:");
			System.out.println(Files.size(m1));
			System.out.println(Files.getLastModifiedTime(m1));
			System.out.println(Files.getOwner(m1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// atrybuty - basic
		System.out.format("%n%s%n", "Attributes - BASIC:");
		try {
			BasicFileAttributes attr = Files.readAttributes(m1, BasicFileAttributes.class);
			System.out.println("creationTime: " + attr.creationTime());
			System.out.println("lastAccessTime: " + attr.lastAccessTime());
			System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

			System.out.println("isDirectory: " + attr.isDirectory());
			System.out.println("isOther: " + attr.isOther());
			System.out.println("isRegularFile: " + attr.isRegularFile());
			System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
			System.out.println("size: " + attr.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// atrybuty - DOS
		System.out.format("%n%s%n", "Attributes - DOS:");
		try {
			DosFileAttributes attr = Files.readAttributes(m1, DosFileAttributes.class);
			System.out.println("isReadOnly is " + attr.isReadOnly());
			System.out.println("isHidden is " + attr.isHidden());
			System.out.println("isArchive is " + attr.isArchive());
			System.out.println("isSystem is " + attr.isSystem());
		} catch (UnsupportedOperationException | IOException x) {
			System.err.println("DOS file" + " attributes not supported:" + x);
		}

		// POSIX - blad pod windows
		/*
		 * System.out.format("%n%s%n", "Attributes - POSIX:"); try {
		 * PosixFileAttributes attr; attr = Files.readAttributes(m1,
		 * PosixFileAttributes.class); System.out.format("%s %s %s%n",
		 * attr.owner().getName(), attr.group().getName(),
		 * PosixFilePermissions.toString(attr.permissions())); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		UserDefinedFileAttributeView view = Files.getFileAttributeView(m1, UserDefinedFileAttributeView.class);
		try {
			view.write("user.mimetype", Charset.defaultCharset().encode("text/html"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// opcje otwierania
		System.out.format("%n%s%n", "Opcje otwierania:");
		try {
			byte[] b = new byte[5];
			b[0] = 12;
			b[1] = 2;
			b[2] = 3;
			b[3] = 4;
			b[4] = 5;
			Files.write(Paths.get("example_data_out1.txt"), b, StandardOpenOption.APPEND);
			// Files.write(Paths.get("example_data_out2.txt"), b,
			// StandardOpenOption.CREATE_NEW); // istnieje
			Files.write(Paths.get("example_data_out3.txt"), b, StandardOpenOption.CREATE,
					StandardOpenOption.DELETE_ON_CLOSE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// otwieranie pliku, czytanie i zapis
		System.out.format("%n%s%n", "Male pliki:");
		try {
			byte[] arr = Files.readAllBytes(m1);
			for (byte b : arr) {
				System.out.print((char) b);
			}
			Files.write(Paths.get("example_data_out.txt"), arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pliki teksowe
		System.out.format("%n%n%s%n", "Pliki tekstowe:");
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("example_data_out10.txt"), charset)) {
			writer.write("DSADSADA");
			writer.flush();
			writer.write("DSADSADA - kldakldasdsad");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("example_data_out10.txt"), charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

		// Defaults to READ
		System.out.format("%n%n%s%n", "Channel:");
		try (SeekableByteChannel sbc = Files.newByteChannel(m1)) {
			ByteBuffer buf = ByteBuffer.allocate(10);

			// Read the bytes with the proper encoding for this platform. If
			// you skip this step, you might see something that looks like
			// Chinese characters when you expect Latin-style characters.
			String encoding = System.getProperty("file.encoding");
			while (sbc.read(buf) > 0) {
				buf.rewind();
				System.out.print(Charset.forName(encoding).decode(buf));
				buf.flip();
			}
		} catch (IOException x) {
			System.out.println("caught exception: " + x);
		}

		try {
			Path tempFile = Files.createTempFile(Paths.get(""), ".myapp", "test");
			System.out.format("The temporary file" + " has been created: %s%n", tempFile);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

	}

}
