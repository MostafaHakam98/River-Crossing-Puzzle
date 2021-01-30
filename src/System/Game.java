package System;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;

public class Game {
	
	private List<ICrosser> rightCrossers;
	private List<ICrosser> leftCrossers;
	private List<ICrosser> boatRiders;
	
	private ICrossingStrategy strategy;
	
	public static int score;
	private boolean boatOnLeft;
	
	private fileLoader file;
	
	public Game() {
		rightCrossers = new ArrayList<>();
		leftCrossers = new ArrayList<>();
		boatRiders = new ArrayList<>();
		boatOnLeft = false;
		score = 0;
		file = new fileLoader();
	}

	public ICrossingStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ICrossingStrategy strategy) {
		this.strategy = strategy;
	}

	public void save() {
		file.saveGame(this);
	}

	public void load() {
		
		Game gameLoaded = file.loadGame();
		
		this.setStrategy(gameLoaded.getStrategy());
		this.setLeftBankCrossers(gameLoaded.getLeftCrossers());
		this.setRightBankCrossers(gameLoaded.getRightCrossers());
		this.setBoatRiders(gameLoaded.getBoatRiders());
		this.setBoatOnTheLeftBank(gameLoaded.getBoatOnTheLeftBank());
	}

	public List<ICrosser> getRightCrossers() {
		return rightCrossers;
	}

	public void setRightBankCrossers(List<ICrosser> rightCrossers) {
		this.rightCrossers = rightCrossers;
	}

	public List<ICrosser> getLeftCrossers() {
		return leftCrossers;
	}

	public void setLeftBankCrossers(List<ICrosser> leftCrossers) {
		this.leftCrossers = leftCrossers;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		this.boatRiders = boatRiders;
	}

	public boolean getBoatOnTheLeftBank() {
		return boatOnLeft;
	}

	public void setBoatOnTheLeftBank(boolean boatOnTheLeftBank) {
		boatOnLeft = boatOnTheLeftBank;
	}

	public void addLeftCrosser(ICrosser crosser) {
		leftCrossers.add(crosser);
	}

	public void removeLeftCrosser(ICrosser crosser) {
		leftCrossers.remove(crosser);
	}

	public void addRightCrosser(ICrosser crosser) {
		rightCrossers.add(crosser);
	}

	public void removeRightCrosser(ICrosser crosser) {
		rightCrossers.remove(crosser);
	}

	public void addRider(ICrosser crosser) {
		boatRiders.add(crosser);
	}

	public void removeRider(ICrosser crosser) {
		boatRiders.remove(crosser);
	}

	public void clearBoatRiders() {
		boatRiders.clear();
	}

	public void clearLeftBank() {
		leftCrossers.clear();
	}

	public void clearRightBank() {
		rightCrossers.clear();
	}
}