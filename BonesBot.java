import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class BonesBot {

	public static class ItemDisplay extends JLabel {
		Item item;

		public ItemDisplay() {
			item = null;
		}

		public void setItem(Item i) {
			item = i;

			int label_width = Math.max(100, getWidth());
			int label_height = Math.max(100, getHeight());

			int img_width = Math.min(
				label_width,
				label_height * item.img.getWidth() / item.img.getHeight()
			);
			int img_height = Math.min(
				label_height,
				label_width * item.img.getHeight() / item.img.getWidth()
			);
			setIcon(new ImageIcon(item.img.getScaledInstance(
				img_width, img_height, Image.SCALE_SMOOTH
			)));
		}

		public void randomize(ArrayList<Item> items) {
			int N = items.size();
			int index = (int) (Math.random() * N);
			setItem(items.get(index));
		}
	}

	public static class DebugDisplay extends JLabel {
		String text;
		boolean complete;
		int count;

		public DebugDisplay() {
			reset_log();
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

	public static class Item {
		String cat, name;
		BufferedImage img;

		public Item(File file) throws IOException {
			String file_data = file.getName();

			String[] parse = file_data.split("-");
			cat = parse[0];
			name = parse[1];

			img = ImageIO.read(file);
		}

		@Override
		public String toString() {
			return cat + ":" + name;
		}
	}

	public static void main(String[] args) throws IOException {

		File folder = new File("./files");

		ArrayList<Item> items = new ArrayList<>();

		if(folder.isDirectory()) {
			for(File file : folder.listFiles()) {
				items.add(new Item(file));
			}
		}

		for(Item i : items) {
			System.out.println(i);
		}

		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		window.add(panel);

		DebugDisplay debug = new DebugDisplay();
		panel.add(debug, BorderLayout.EAST);

		ItemDisplay picture = new ItemDisplay();
		panel.add(picture, BorderLayout.CENTER);

		JPanel bottom_entry = new JPanel();
		BoxLayout bottom_layout = new BoxLayout(bottom_entry, BoxLayout.X_AXIS);
		bottom_entry.setLayout(bottom_layout);
		panel.add(bottom_entry, BorderLayout.SOUTH);

		JLabel entry_prompt = new JLabel("Guess: ");
		bottom_entry.add(entry_prompt);

		JTextField entry = new JTextField();
		bottom_entry.add(entry);

		JPanel sidebar = new JPanel();
		BoxLayout sidebar_layout = new BoxLayout(sidebar, BoxLayout.Y_AXIS);
		sidebar.setLayout(sidebar_layout);
		panel.add(sidebar, BorderLayout.WEST);

		Button hint_button = new Button("Hint");
		hint_button.addActionListener(e -> {
			switch(debug.count) {
				case 0:
				debug.log(picture.item.name.length() + " characters long");
				break;
				case 1:
				debug.log("Category is " + picture.item.cat);
				break;
				default:
				debug.log(hint_text());
			}
			debug.tally();
		});
		sidebar.add(hint_button);

		Button skip_button = new Button("Give up");
		sidebar.add(skip_button);
		skip_button.addActionListener(e -> {
			debug.log("Answer was " + picture.item.name);
			debug.log("Category " + picture.item.cat);
			debug.finish();
		});

		Button check_button = new Button("Check");
		sidebar.add(check_button);
		check_button.addActionListener(e -> {
			String guess = entry.getText();
			if(guess.equals(picture.item.name)) {
				debug.log(happy_text());
				debug.finish();
			} else {
				debug.log(angry_text());
			}
		});

		Button continue_button = new Button("Continue");
		sidebar.add(continue_button);
		continue_button.addActionListener(e -> {
			if(debug.complete) {
				picture.randomize(items);
				entry.setText("");
				debug.reset_log();
			} else {
				debug.log(stop_text());
			}
		});

		JLabel title = new JLabel("Apples are great!");
		panel.add(title, BorderLayout.NORTH);

		window.setVisible(true);

		debug.reset_log();
		picture.randomize(items);

	}

	public static String happy_text() {
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

	public static String angry_text() {
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

	public static String stop_text() {
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

	public static String hint_text() {
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

