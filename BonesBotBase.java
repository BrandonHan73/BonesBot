
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BonesBotBase extends JPanel {

	private BotChat chat;
	private ItemDisplay display;
	private GuessEntry entry;
	private Sidebar sidebar;

	private int hint_count;
	private Item active_item;

	private ArrayList<Item> items;

	private boolean can_continue;

	public BonesBotBase(ArrayList<Item> i) {
		setLayout(new BorderLayout());

		chat = new BotChat(this);
		display = new ItemDisplay(this);
		entry = new GuessEntry(this);
		sidebar = new Sidebar(this);

		items = i;

		can_continue = false;
	}

	public int get_hint_count() {
		return hint_count;
	}
	public void use_hint() {
		hint_count++;
	}

	public Item get_active_item() {
		return active_item;
	}

	public void clear_message() {
		chat.reset_log();
	}
	public void message(String txt) {
		chat.log(txt);
	}

	public String get_entry_text() {
		return entry.get_text();
	}

	public void enable_continue() {
		can_continue = true;
	}
	public void next_item() {
		if(can_continue) {
			randomize();
			entry.reset();
			clear_message();
			can_continue = false;
		} else {
			message(ContinueButton.generate_stop_text());
		}
	}
	public void randomize() {
		int N = items.size();
		int index = (int) (N * Math.random());

		active_item = items.get(index);
		display.setItem(active_item);
	}

	public void submit_entry(String ans) {
		if(ans.equals(active_item.name)) {
			message(CheckButton.generate_happy_text());
			enable_continue();
		} else {
			message(CheckButton.generate_angry_text());
		}
	}

}

