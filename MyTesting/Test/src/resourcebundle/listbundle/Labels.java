package resourcebundle.listbundle;

import java.util.ListResourceBundle;

public class Labels extends ListResourceBundle {

	Object[][] contents = { { "label1", "mouse" }, { "label2", "keybord" }, {"label3", new Double(0.99)} };

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

}
