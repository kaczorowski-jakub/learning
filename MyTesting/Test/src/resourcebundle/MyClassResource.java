package resourcebundle;

import java.util.ListResourceBundle;

public class MyClassResource extends ListResourceBundle {

	static final Object[][] contents = { { "a", "ClassRB" }, { "b", "CLASS_RB" }, };

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
