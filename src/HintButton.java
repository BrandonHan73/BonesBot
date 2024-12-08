import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HintButton extends JButton {

	private ActionListener listener;

	private BonesBotBase base;
	private Sidebar container;

	public HintButton(BonesBotBase b, Sidebar s) {
		base = b;
		container = s;

		listener = e -> {
			String hint = base.use_hint();
			if(hint == null) {
				base.message(generate_text());
			} else {
				base.message(hint);
			}
		};

		setText("Hint");
		addActionListener(listener);

		container.add(this);
	}

	public static String generate_text() {
		String[] choices = new String[] {
			"Bro I can't help you more than that",
			"No data remaining",
			"Just do better",
			"Get a brain",
			"Figure it out",
			"No"
		};

		int N = choices.length;
		int index = (int) (Math.random() * N);
		return choices[index];
	}

}

