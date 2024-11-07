import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {

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

