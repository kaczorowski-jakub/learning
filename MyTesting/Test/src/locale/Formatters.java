package locale;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Formatters {

	public static void main(String[] args) {

		test();
		// test2();
		// test3();
		//test4();
		//test5();
		
		// abc(new String[]{"A","B"});
		// abc("A","B");
		// cba("A","B");
		//abc();

	}
	
	
	/**
	 * Compound messages
	 */
	private static void test5() {
		
		ResourceBundle rs = ResourceBundle.getBundle("locale.Compound");
		
		MessageFormat mf = new MessageFormat(rs.getString("template"));
		System.out.println(mf.format(new Object[] {"Mars", new Integer(7), new Date(), new Double(12.323)}));
		
	}
	/**
	 * Custom DATY
	 */
	private static void test4() {

		DateFormatSymbols dfs = new DateFormatSymbols();
		dfs.setAmPmStrings(new String[] { "Foo", "Bar", "Baz" });
		dfs.setShortWeekdays(new String[] { "A", "B", "C", "D", "E", "F", "G" });
		DateFormat df = new SimpleDateFormat("a E", dfs);
		System.out.println(df.format(new Date()));
	}

	/**
	 * Custom DATY
	 */
	private static void test3() {

		DateFormat df = new SimpleDateFormat("EEE S s W w a", Locale.CANADA);
		System.out.println(df.format(new Date()));

	}

	/**
	 * DATY
	 */
	private static void test2() {

		for (Locale l : DateFormat.getAvailableLocales()) {

			DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, l);
			DateFormat tf = DateFormat.getTimeInstance(DateFormat.FULL, l);
			Date d = new Date();
			System.out.println(l + " :\n " + df.format(d) + "\n" + tf.format(d));

		}
	}

	/**
	 * LICZBY
	 */
	private static void test() {

		System.out.println(Locale.getDefault());

		Integer quantity = new Integer(123456);
		Double amount = new Double(345987.246);
		NumberFormat numberFormatter;
		NumberFormat currencyFormatter;
		NumberFormat percentFormatter;
		String quantityOut;
		String amountOut;

		/*
		 * Locale list[] = NumberFormat.getAvailableLocales(); for (Locale l :
		 * list) { numberFormatter = NumberFormat.getNumberInstance(l);
		 * currencyFormatter = NumberFormat.getCurrencyInstance();
		 * percentFormatter = NumberFormat.getPercentInstance(l); quantityOut =
		 * numberFormatter.format(quantity); amountOut =
		 * numberFormatter.format(amount); System.out.println(l);
		 * System.out.println(quantityOut); System.out.println(amountOut);
		 * System.out.println(currencyFormatter.format(amount));
		 * System.out.println(percentFormatter.format(0.75));
		 * System.out.println("-----"); }
		 */
		printFormatter("###,##.##", 12121.323);
		printFormatter("$##,##.###", 12121.323);
		printFormatter("0000000000.###", 12121.323);

	}

	private static void printFormatter(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		try {
			Number output2 = myFormatter.parse(Double.toString(value));
			System.out.println("parse: " + value + " " + pattern + " " + output2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("format: " + value + " " + pattern + " " + output);
		}
	}

	private static void abc(String... strings) {
		System.out.println("A");
	}

	private static void abc() {
		System.out.println("B");
	}

	/*
	 * private static void abc(String[] a) {
	 * 
	 * }
	 */
	private static void cba(String[] a) {

	}
}
