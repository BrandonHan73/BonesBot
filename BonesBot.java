import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BonesBot {

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
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BonesBotBase base = new BonesBotBase(items);
		window.add(base);

		JLabel title = new JLabel("Apples are great!");
		base.add(title, BorderLayout.NORTH);

		window.setVisible(true);

		base.clear_message();
		base.randomize();

	}

}

