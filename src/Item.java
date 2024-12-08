import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Item {

	String cat, name;
	BufferedImage img;
	ArrayList<String> hints;

	public Item(File file) throws IOException {
		String file_data = file.getName();

		String[] parse = file_data.split("-");
		cat = parse[0];
		name = parse[1];

		hints = new ArrayList<>();
		for(int i = 3; i < parse.length; i++) {
			hints.add(parse[i]);
		}
		hints.add(name.length() + " characters long");

		img = ImageIO.read(file);
	}

	@Override
	public String toString() {
		return cat + ":" + name;
	}

}

