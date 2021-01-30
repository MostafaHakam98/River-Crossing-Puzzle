package System;

import java.util.ArrayList;
import java.util.List;


import Command.LoadGame;
import Command.SaveGame;
import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;
import Interfaces.IRiverCrossingController;
import Memento.CareTaker;
import Memento.Originator;

public class GameEngine implements IRiverCrossingController {
	
	public List<ICrosser> left = new ArrayList<ICrosser>();
	public List<ICrosser> right = new ArrayList<ICrosser>();
	public List<ICrosser> boat = new ArrayList<ICrosser>();
	
	private Game model;
	
	private Originator originator = new Originator();
	private CareTaker careTaker = new CareTaker();
	
	private LoadGame loadGame;
	private SaveGame saveGame;
	public ICrossingStrategy Strategy;
	String[] Instructions;
	boolean isboatonleft;
	int counter;
	
	
	//Singleton
	
	private static GameEngine instance;
	
	public static GameEngine getInstance() {
		if (instance == null)
			instance = new GameEngine();
		return instance;
	}

	@Override
	public void newGame (ICrossingStrategy gameStrategy) {
		left.clear();
		left.addAll(gameStrategy.getInitialCrossers());
		right.clear();
		boat.clear();
		isboatonleft = true;
	}

	@Override
	public void resetGame() {
		left.addAll(Strategy.getInitialCrossers());
		right.clear();
		boat.clear();
	}

	@Override
	public String[] getInstructions() {
		Instructions = Strategy.getInstructions();
		return Instructions;
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return right;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return left;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		if(isboatonleft)
			return true;
		else
			return false;
	}

	@Override
	public int getNumberOfSails() {
		return counter;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		return Strategy.isValid(right, left, crossers);
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if(canMove(crossers, fromLeftToRightBank)) {
			left.removeAll(crossers);
			right.addAll(crossers);
		}
		else {
			right.removeAll(crossers);
			left.addAll(crossers);
		}	
		
		isboatonleft = !isboatonleft;
	}

	@Override
	public boolean canUndo() {
		if (careTaker.getFromUndo().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean canRedo() {
		if (careTaker.getFromRedo().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void undo() {
		if (canUndo()) {
			careTaker.addToRedo(originator.saveGameMemento());
			Game Game = originator.getGameMemento(careTaker.popUndo());
			model = Game;
		}		
	}

	@Override
	public void redo() {
		if (canRedo()) {
			careTaker.addToUndo(originator.saveGameMemento());
			Game Game = originator.getGameMemento(careTaker.popRedo());
			model = Game;
		}
	}

	@Override
	public void saveGame() {
		saveGame = new SaveGame(model);
		saveGame.execute();
	}

	@Override
	public void loadGame() {
		loadGame = new LoadGame(model);
		loadGame.execute();
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		return null;
	}

}
