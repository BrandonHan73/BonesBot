import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessEntry extends JPanel {

	private JLabel entry_prompt;
	private JTextField entry;

	private ActionListener listener;

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

		listener = e -> {
			if(base.can_continue()) {
				base.next_item();
			} else {
				base.submit_entry(base.get_entry_text());
			}
		};

		entry.addActionListener(listener);

		base.add(this, BorderLayout.SOUTH);
	}

	public String get_text() {
		return entry.getText();
	}

	public void reset() {
		entry.setText("");
	}

}

