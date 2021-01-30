package Levels;
import java.util.ArrayList;
import java.util.List;

import Factory.CrosserFactory;
import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;

public class LevelTwo implements ICrossingStrategy {
	
    private ICrosser farmer1;
    private ICrosser farmer2;
    private ICrosser farmer3;
    private ICrosser farmer4;
    private ICrosser dog;

    public LevelTwo(){
    	
        CrosserFactory factory=new CrosserFactory();
        
        farmer1 = factory.createCrosseer("F", 90.0);
        farmer2 = factory.createCrosseer("F", 80.0);
        farmer3 = factory.createCrosseer("F", 60.0);
        farmer4 = factory.createCrosseer("F", 40.0);
        dog = factory.createCrosseer("D", 20.0);
    }


    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        
        Boolean flag = false;

    	
    	//Boat Empty
    	if(boatRiders.isEmpty()){
            return false;
        }
    	
    	//No Farmer in Boat
    	for(ICrosser crosser : boatRiders){
            if (crosser.canSail()){
                flag = true;
                break;
            }
        }
        if(!flag){
            return false;
        }

        //Number of Riders on boat
        double weight = 0;
        for (ICrosser crosser : boatRiders) {
			weight = weight + crosser.getWeight();
			
			if(weight > 100)
				return false;
			else
				flag = true;
		}
        
        return flag;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
    	
        List<ICrosser> initialCrossers = new ArrayList<>();
        
        initialCrossers.add(farmer1);
        initialCrossers.add(farmer2);
        initialCrossers.add(farmer3);
        initialCrossers.add(farmer4);
        initialCrossers.add(dog);
        
        return initialCrossers;
    }

    @Override
    public String[] getInstructions() {
    	
    	List<String> instruct = new ArrayList<String>();
		
		String[] inst = null;
		
		instruct.add("- Try to move All Charecters from the left side of the river to the right side.");
		instruct.add("- The boat cannot bear a load heavier than 100 kg.");
		instruct.add("- The boat can carry atmost 2 passengers at a time.");
		instruct.add("- The farmer is the only passenger who can sail the boat.");
		instruct.add("- Good Luck :)");
		
		inst = instruct.toArray(new String[0]);
		
		return inst;
    }
}
