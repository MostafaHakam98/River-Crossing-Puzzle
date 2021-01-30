package Crossers;

import java.awt.image.BufferedImage;

public class Sheep extends Crosser {

	public Sheep (BufferedImage[] image, String name) {
		
		this.image = image;
		this.setName(name);
		this.setEatrank(2);
		this.setWeight(0);
		this.setCansail(false);
	}
}
