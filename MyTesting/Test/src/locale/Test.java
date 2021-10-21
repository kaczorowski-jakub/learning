package locale;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {

		Locale l1 = new Locale.Builder().setLanguage("fr").setRegion("FR").build();

		Locale l21 = new Locale("en");
		Locale l22 = new Locale("en", "CA");
		Locale l23 = new Locale("en", "CA", "UNIX");

		Locale l3 = Locale.forLanguageTag("en-US");

		Locale l4 = Locale.JAPAN;

		String outputString = new String();
		Locale[] thaiLocale = { new Locale("th"), new Locale("th", "TH"), new Locale("th", "TH", "TH") };

		for (Locale locale : thaiLocale) {
			NumberFormat nf = NumberFormat.getNumberInstance(locale);
			outputString = outputString + locale.toString() + ": ";
			outputString = outputString + nf.format(573.34) + "\n";
		}
		System.out.println(outputString);

		/*
		 * Locale list[] = DateFormat.getAvailableLocales(); for (Locale aLocale
		 * : list) { System.out.println(aLocale.getDisplayName()); }
		 */

	}

}
