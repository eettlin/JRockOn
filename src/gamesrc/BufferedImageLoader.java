package gamesrc;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	public BufferedImage loadImage(String pathToImage) throws IOException{
		URL url = getClass().getResource(pathToImage);
		BufferedImage image = ImageIO.read(url);
		return image;
	}

}
