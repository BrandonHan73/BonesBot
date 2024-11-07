import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Sidebar extends JPanel {

	private HintButton hint_button;
	private SkipButton skip_button;
	private CheckButton check_button;
	private ContinueButton continue_button;

	private BoxLayout layout;

	private BonesBotBase base;

	public Sidebar(BonesBotBase b) {
		base = b;

		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		hint_button = new HintButton(base, this);
		skip_button = new SkipButton(base, this);
		check_button = new CheckButton(base, this);
		continue_button = new ContinueButton(base, this);

		base.add(this, BorderLayout.WEST);
	}

}

