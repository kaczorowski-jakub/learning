package regexp;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Test {

	public static void main(String[] args) throws IOException {

		parse("ma", "Ala ma kota i jeszcze ma cos tam");
		parse("\\$", "Ala <ma> $<> kota i jeszcze ma cos <> tam");
		parse("\\Q$<>\\E", "Ala <ma> $<> kota i jeszcze ma cos <> tam");

		parse("[A-C]", "Ala <ma> $<> kota i jeszcze ma cos <> tam ZBA");
		parse("[^A-Ya-z]", "AlatamZBA");
		parse("[A-Ba-b]", "AlatamZBA");
		parse("[A-B[a-b]]", "AlatamZBA");
		parse("[crb]at", "cat rat hat bat");
		parse("[^crb]at", "cat rat hat bat");
		parse("num[1-5]", "num1 num2 num3 number4 num5 num6 num7");
		parse("num[a-z][a-z][a-z][1-5]", "num1 num2 num3 number4 num5 num6 num7");

		parse("\\d", "1");
		parse("\\d", "a");
		parse("\\D", "1");
		parse("\\D", "das232ds");

		parse("ala+", "Ala ma kota");
		parse("ala?", "ala ma kota");
		parse("ala*", "ala ma kota");
		parse("ala+", "ala ma kota");
		parse("\\d+[A-Z]+[a-z]+", "Ala ma1kota");
		parse("", "Ala ma1kota");
		parse("a?", "a");
		parse("a*", "a");
		parse("a+", "a");
		parse("a?", "ababaaaaab");
		parse("a*", "ababaaaaab");
		parse("a+", "ababaaaaab");
		parse("a{3}", "aaaaaa");
		parse("a{3,}", "aaaaaa");
		parse("[A-Z]+[a-z]+[0-9]+", "Aabadaa0");

		// kod pocztowy
		parse("[0-9]{2}-[0-9]{3}", "12-323");
		parse("[0-9]{2}-[0-9]{3}", "12-33");
		parse("\\d{2}-\\d{3}", "12-323");
		parse("\\d{2}-\\d{3}", "12-32");

		parse("(0-9){3}", "0-90-90-9");
		parse("(ala){2}", "alaala ma kota i ala ma psa");

		Pattern pattern = Pattern.compile("((A)(B(C)))");
		Matcher matcher = pattern.matcher("Ala ma kota");
		System.out.println(matcher.groupCount());

		parse("(ala)|(lal)", "ala");
		parse("\\w\\W", "a ");

		parse("^dupa$", "dupa ");
		parse("^dupa$", "dupa");

		// na poczatku duza litera, pozniej nie slowo dowolna ilosc i koniec to
		// jedno slowo
		parse("^[A-Z]\\W*\\w$", "dupa ");
		parse("^[A-Z]\\W*\\w$", "D 		d");

		parse("\\bdupa\\b", "to wszystko jest dupa i kamieni kupa");
		parse("\\bdupa\\b", "to wszystko jest dupajasiu i kamieni kupa");
		parse("\\bdupa\\B", "to wszystko jest dupajasiu i kamieni kupa");
		parse("\\Gdupa", "dupa dupa");

		Pattern p1 = Pattern.compile("^ala*", Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher("ALa ma kota");
		System.out.println(m1.find());

		Pattern p2 = Pattern.compile("^ala*", Pattern.CASE_INSENSITIVE);
		Matcher m2 = p2.matcher("La ma kota");
		System.out.println(m2.find());

		Pattern p3 = Pattern.compile(".");
		Matcher m3 = p3.matcher("\n");
		System.out.println(m3.find());

		Pattern p4 = Pattern.compile(".", Pattern.DOTALL);
		Matcher m4 = p4.matcher("\n");
		System.out.println(m4.find());

		Pattern p5 = Pattern.compile("\\d");
		for (String s : p5.split("one9two34six2five"))
			System.out.println(s);

		System.out.println("foo vs matches and vs lokkingAt:");
		Pattern p6 = Pattern.compile("foo");
		Matcher m6 = p6.matcher("fooooooo");
		System.out.println(m6.matches());
		System.out.println(m6.lookingAt());

		System.out.println("\nReplace");
		Pattern p7 = Pattern.compile("abc");
		Matcher m7 = p7.matcher("abc to ostatnie litery alfabetu");
		System.out.println(m7.replaceAll("xyz"));

		try {
			Pattern p8 = Pattern.compile("?i");
			Matcher m8 = p8.matcher("DUPA");
			System.out.println(m8.lookingAt());
		} catch (PatternSyntaxException pse) {
			System.out.format("There is a problem" + " with the regular expression!%n");
			System.out.format("The pattern in question is: %s%n", pse.getPattern());
			System.out.format("The description is: %s%n", pse.getDescription());
			System.out.format("The message is: %s%n", pse.getMessage());
			System.out.format("The index is: %s%n", pse.getIndex());
		}
	}

	private static void parse(String p, String i) {

		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(i);
		System.out.format("Pattern: %s%nInput: %s%n", p, i);
		boolean found = false;
		while (matcher.find()) {
			System.out.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
					matcher.group(), matcher.start(), matcher.end());
			found = true;
		}
		if (!found) {
			System.out.format("No match found.%n");
		}
		System.out.println("---");

	}

}
