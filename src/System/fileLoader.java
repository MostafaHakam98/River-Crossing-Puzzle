package System;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class fileLoader {

	Game game;

	public void saveGame(Game Game){

		try {
			
			File inputFile = new File("database\\SavedGame.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public Game loadGame() {
		
		try{

			File inputFile = new File("database\\SavedGame.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return game;
	}
}