package Factory;

import Crossers.*;
import Interfaces.ICrosser;
import Factory.CrosserImage;

public class CrosserFactory {
	
    private CrosserImage crosserImage;

    public CrosserFactory(){
        crosserImage = new CrosserImage();
    }

    public ICrosser createCrosseer(String type, double weight){

        switch (type) {
            case "F": return new Farmer (weight, crosserImage.getFarmerImages(), Double.toString(weight));
            case "D": return new Dog (crosserImage.getDogImages(), "20");
                    
            default: return null;
        }
    }

    public ICrosser createCrosseer(String type){

        switch (type) {
            case "F": return new Farmer (crosserImage.getFarmerImages(), "Farmer");
            case "S": return new Sheep (crosserImage.getSheepImages(), "Sheep");
            case "W": return new Wolf (crosserImage.getWolfImages(), "Wolf");
            case "C": return new Cabage (crosserImage.getCabageImages(), "Cabbage");

            default: return null;
        }
    }
}
