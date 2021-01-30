package Crossers;

import java.awt.image.BufferedImage;

public class Dog extends Crosser {

	public Dog(BufferedImage[] image, String name) {
    	this.image = image;
        this.name = name;
        this.setWeight(20);
		this.setCansail(false);
		this.setEatrank(0);
	}
}