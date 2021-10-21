package applets;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class MyApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014293186825044745L;
	StringBuilder sb = new StringBuilder();

	@Override
	public void init() {
		sb.append("INIT");
		// Execute a job on the event-dispatching thread; creating this applet's
		// GUI.
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}

	@Override
	public void start() {
		sb.append("\nSTART");
	}

	@Override
	public void stop() {
		sb.append("\nSTOP");
	}

	@Override
	public void destroy() {
		sb.append("\nDESTROY");
		System.out.println(sb);
	}

	private void createGUI() {
		// Create and set up the content pane.
		DynamicTreePanel newContentPane = new DynamicTreePanel();
		newContentPane.setOpaque(true);
		setContentPane(newContentPane);
	}
}
