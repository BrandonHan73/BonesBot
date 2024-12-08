import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CheckButton extends JButton {

	private ActionListener listener;

	private BonesBotBase base;
	private Sidebar container;

	public CheckButton(BonesBotBase b, Sidebar s) {
		base = b;
		container = s;

		listener = e -> {
			base.submit_entry(base.get_entry_text());
		};

		setText("Check");
		addActionListener(listener);

		container.add(this);
	}

	public static String generate_happy_text() {
		String[] choices = new String[] {
			"Correct!", 
			"Which is right!", 
			"Congrats!", 
			"Someone studied!", 
			"Brain too big", 
			"You're not dumb... for now", 
			"Nice job!", 
			"'Actually cooking' or whatever you weirdos say", 
			"I see the brain cell is visiting", 
			"Positive comment" 
		};

		int N = choices.length;
		int index = (int) (Math.random() * N);
		return choices[index];
	}

	public static String generate_angry_text() {
		String[] choices = new String[] {
			"Dumb", 
			"Bruh get it right", 
			"Smooth brain", 
			"Bruhh....", 
			"Did you even study?", 
			"Why are you still dumb", 
			"Do better", 
			"Bruh this is the easy one", 
			"Why", 
			"I'm disappointed" 
		};

		int N = choices.length;
		int index = (int) (Math.random() * N);
		return choices[index];
	}

}

