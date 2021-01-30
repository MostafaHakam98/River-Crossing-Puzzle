package Crossers;

import java.awt.image.BufferedImage;

public class Wolf extends Crosser{

	public Wolf (BufferedImage[] image, String name) {
		
		this.image = image;
		this.setName(name);
		this.setEatrank(3);
		this.setWeight(0);
		this.setCansail(false);
	}
}
