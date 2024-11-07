import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessEntry extends JPanel {

	private JLabel entry_prompt;
	private JTextField entry;

	private BoxLayout layout;

	private BonesBotBase base;

	public GuessEntry(BonesBotBase b) {
		base = b;
		entry_prompt = new JLabel("Guess: ");
		entry = new JTextField();
		layout = new BoxLayout(this, BoxLayout.X_AXIS);

		entry.setToolTipText("Enter your answer here");

		setLayout(layout);
		add(entry_prompt);
		add(entry);

		base.add(this, BorderLayout.SOUTH);
	}

	public String get_text() {
		return entry.getText();
	}

	public void reset() {
		entry.setText("");
	}

}

