package Crossers;

import java.awt.image.BufferedImage;

public class Cabage extends Crosser {

	public Cabage(BufferedImage[] image, String name) {
		
		this.image = image;
		this.setName(name);
		this.setWeight(0);
		this.setEatrank(1);
		this.setCansail(false);
	}
	
}