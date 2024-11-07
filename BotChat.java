import java.awt.BorderLayout;

import javax.swing.JLabel;

public class BotChat extends JLabel {

	String text;
	boolean complete;
	int count;

	private BonesBotBase base;

	public BotChat(BonesBotBase b) {
		base = b;

		reset_log();
		base.add(this, BorderLayout.EAST);
	}

	public void reset_log() {
		text = "Bones Bot :/";
		complete = false;
		count = 0;
		setText("<html>" + text + "</html>");
	}

	public void finish() {
		complete = true;
	}

	public void tally() {
		count++;
	}

	public void log(String txt) {
		text += "<br> - " + txt;
		setText("<html>" + text + "</html>");
	}

}

