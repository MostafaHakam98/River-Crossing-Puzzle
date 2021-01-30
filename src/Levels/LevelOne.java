package Levels;

import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;

import java.util.ArrayList;
import java.util.List;

import Factory.CrosserFactory;

public class LevelOne implements ICrossingStrategy {
	
	private ICrosser farmer;
	private ICrosser cabage;
	private ICrosser sheep;
	private ICrosser wolf;

	public LevelOne() {
		
		CrosserFactory factory = new CrosserFactory();
		farmer = factory.createCrosseer("F");
		cabage = factory.createCrosseer("C");
		sheep = factory.createCrosseer("S");
		wolf = factory.createCrosseer("W");
		
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

		int i;
		boolean flag = false;
		
		//Boat Empty
		if (boatRiders.isEmpty()) {
			return false;
		}
		
		//No Farmer in Boat
		for (ICrosser crosser : boatRiders) {
			if (crosser.canSail()) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return false;
		}
		
		//Farmer in Boat and a crossers with one level higher than another on the Left Bank
		for (i = 0; i < leftBankCrossers.size(); i++) {
			ICrosser temp1 = leftBankCrossers.get(i);
			for (int j = 0; j < leftBankCrossers.size(); j++) {
				ICrosser temp2 = leftBankCrossers.get(j);
				if (temp1.getEatingRank() == temp2.getEatingRank() + 1) {
					return false;
				}
			}
		}
	
		//Farmer in Boat and a crossers with one level higher than another on the Right Bank
		for (i = 0; i < rightBankCrossers.size(); i++) {
			ICrosser temp1 = rightBankCrossers.get(i);
			for (int j = 0; j < rightBankCrossers.size(); j++) {
				ICrosser temp2 = rightBankCrossers.get(j);
				if (temp1.getEatingRank() == temp2.getEatingRank() + 1) {
					return false;
				}
			}
		}
		return true;
		}
	

	@Override
	public List<ICrosser> getInitialCrossers() {
		
		List<ICrosser> initialCrossers = new ArrayList<ICrosser>();
		
		initialCrossers.add(farmer);
		initialCrossers.add(sheep);
		initialCrossers.add(cabage);
		initialCrossers.add(wolf);
		
		return initialCrossers;

	}

	@Override
	public String[] getInstructions() {
		
		List<String> instruct = new ArrayList<String>();
		
		String[] inst = null;
		
		instruct.add("- Try to move All Charecters from the left side of the river to the right side.");
		instruct.add("- The boat can carry atmost 2 passengers at a time.");
		instruct.add("- The farmer is the only passenger who can sail the boat.");
		instruct.add("- You shouldn't leave any 2 crosser that can eat each other on the same side as the wolf eats the sheep and the sheep eats the cabage.");
		instruct.add("- Good Luck :)");
		
		inst = instruct.toArray(new String[0]);
		
		return inst;
	}
}
