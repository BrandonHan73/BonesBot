import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SkipButton extends JButton {

	private ActionListener listener;

	private BonesBotBase base;
	private Sidebar container;

	public SkipButton(BonesBotBase b, Sidebar s) {
		base = b;
		container = s;

		listener = e -> {
			base.message("Answer was " + base.get_active_item().name + " (" + base.get_active_item().cat + ")");
			base.enable_continue();
		};

		setText("Give up");
		addActionListener(listener);

		container.add(this);
	}

}

