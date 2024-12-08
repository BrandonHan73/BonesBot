import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ContinueButton extends JButton {

	private ActionListener listener;

	private BonesBotBase base;
	private Sidebar container;

	public ContinueButton(BonesBotBase b, Sidebar s) {
		base = b;
		container = s;

		listener = e -> {
			base.next_item();
		};

		setText("Continue");
		addActionListener(listener);

		container.add(this);
	}

	public static String generate_stop_text() {
		String[] choices = new String[] {
			"You shall not pass", 
			"Get it right first",
			"I'll let you pass if you give up",
			"You're not done",
			"Who said you can leave?"
		};

		int N = choices.length;
		int index = (int) (Math.random() * N);
		return choices[index];
	}

}

