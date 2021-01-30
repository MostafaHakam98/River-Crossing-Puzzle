package GUI;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	
	public static final String gameName = "River Crossing Puzzle";
	public static final int mainMenu = 0;
	public static final int levelOne = 1;
	public static final int levelTwo = 2;

	public Game(String gameName) {
		super(gameName);
		this.addState(new Menu(mainMenu));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.enterState(mainMenu);
	}
	
	public static void main(String[] args) {
		
		try {
			AppGameContainer appgc = new AppGameContainer(new Game(gameName));
			appgc.setDisplayMode(1152, 720, false);
			appgc.start();
			
		} catch (SlickException e) {
			System.out.println("Slick Exception FoundS");
		}
	}
}