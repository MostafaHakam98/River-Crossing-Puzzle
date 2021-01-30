package Crossers;

import java.awt.image.BufferedImage;

public class Farmer extends Crosser {

	public Farmer(double weight, BufferedImage[] image, String name) {
    	this.image = image;
        this.name = name;
        this.weight = weight;
		this.setCansail(true);
		this.setEatrank(0);
	}
	
	public Farmer(BufferedImage[] image, String name) {
		this.image = image;
        this.name = name;
        this.weight = 0;
		this.setCansail(true);
		this.setEatrank(8);
	}
}
