package resourcebundle;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {

		// default
		ResourceBundle rs = ResourceBundle.getBundle("resourcebundle.MyResource");
		System.out.println(rs.getString("a"));

		// z uzyciem locale 1
		Locale locale1 = new Locale("pl");
		ResourceBundle rs1 = ResourceBundle.getBundle("resourcebundle.MyResource", locale1);
		System.out.println(rs1.getString("a"));

		// z uzyciem locale
		Locale locale2 = new Locale("en", "GB");
		ResourceBundle rs2 = ResourceBundle.getBundle("resourcebundle.MyResource", locale2);
		System.out.println(rs2.getString("a"));

		// uzycie innego niz properties pliku - klasa
		ResourceBundle rs3 = ResourceBundle.getBundle("resourcebundle.MyClassResource");
		System.out.println(rs3.getString("a"));

		// uzycie listbundle
		ResourceBundle rs4 = ResourceBundle.getBundle("resourcebundle.listbundle.Labels");
		System.out.println(rs4.getString("label1"));
		System.out.println((Double) rs4.getObject("label3"));

		// kastom do ladowania resourceBundel
		ResourceBundle rs5 = ResourceBundle.getBundle("resourcebundle.listbundle.Labels", new ResourceBundle.Control() {

			@Override
			public List<Locale> getCandidateLocales(String baseName, Locale locale) {

				if (baseName == null)
					throw new NullPointerException();

				if (locale.equals(new Locale("zh", "HK"))) {
					return Arrays.asList(locale, Locale.TAIWAN,	Locale.ROOT);
				} else if (locale.equals(Locale.TAIWAN)) {
					return Arrays.asList(locale, Locale.ROOT);
				}

				return super.getCandidateLocales(baseName, locale);
			}
			
		});
		
		MessageFormat formatter = new MessageFormat("Ala ma kota {0}");
		Object[] o = {"ALA"};
		System.out.println(formatter.format(o));
	}

}
