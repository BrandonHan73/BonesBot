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
			switch(base.get_hint_count()) {
				case 0:
				base.message(base.get_active_item().name.length() + " characters long");
				break;
				case 1:
				base.message("Category is " + base.get_active_item().cat);
				break;
				default:
				base.message(generate_text());
			}
			base.use_hint();
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

