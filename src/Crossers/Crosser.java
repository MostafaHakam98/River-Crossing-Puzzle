package Crossers;
import java.awt.image.BufferedImage;

import Interfaces.ICrosser;

public abstract class Crosser implements ICrosser{
	
	protected String name;
	protected double weight;
	protected int eatrank;
	protected boolean cansail;
	BufferedImage[] image;
	
	public void setCansail(boolean cansail) {
		this.cansail = cansail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getEatingRank() {
		return eatrank;
	}
	public void setEatrank(int eatrank) {
		this.eatrank = eatrank;
	}
	
	
	@Override
	public boolean canSail(){
		return this.cansail;
	}

	@Override
	public BufferedImage[] getImages() {
		return image;
	}

	@Override
	public ICrosser makeCopy() {
		return null;
	}

	@Override
	public void setLabelToBeShown(String label) {
		name = label;
	}

	@Override
	public String getLabelToBeShown() {
		return name;
	}
	
}
