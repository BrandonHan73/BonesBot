import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ItemDisplay extends JLabel {

	Item item;

	private BonesBotBase base;

	public ItemDisplay(BonesBotBase b) {
		base = b;
		item = null;

		base.add(this, BorderLayout.CENTER);
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

}

