package applets;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DynamicTreePanel extends JPanel {
	private int newNodeSuffix = 1;
	private static String ADD_COMMAND = "add";
	private static String REMOVE_COMMAND = "remove";
	private static String CLEAR_COMMAND = "clear";

	public DynamicTreePanel() {
		super(new BorderLayout());

		JButton addButton = new JButton("Add");
		addButton.setActionCommand(ADD_COMMAND);

		JButton removeButton = new JButton("Remove");

		JButton clearButton = new JButton("Clear");

		JPanel panel = new JPanel(new GridLayout(0, 3));
		panel.add(addButton);
		panel.add(removeButton);
		panel.add(clearButton);
		add(panel, BorderLayout.SOUTH);
	}

}
