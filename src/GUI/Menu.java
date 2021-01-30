package GUI;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	
	private Music music;
	
	public String mouse = new String();

	Image background;
	Image Load;
	Image LevelOne;
	Image LevelTwo;
	
	public Menu(int state) {
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("Images\\Mainmenu.jpg");
		Load = new Image("Images\\Loadgame.png");
		LevelOne = new Image("Images\\Levelone.png");
		LevelTwo = new Image("Images\\Leveltwo.png");
		
		music = new Music("Images\\Music.ogg");
		music.setVolume(0.5f);
		music.loop();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0, 0.8f);
		Load.draw(900, 350, 0.7f);
		LevelOne.draw(100, 200, 0.7f);
		LevelTwo.draw(450, 200, 0.7f);
		
		g.drawString(mouse, 50, 50);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
				
		if( (posX > 130 && posX < 420) && (posY > 200 && posY <520) )
			if(Mouse.isButtonDown(0))
			{
				sbg.addState(new LvlOne(Game.levelOne));
				sbg.getState(Game.levelOne).init(gc, sbg);
				sbg.enterState(1);
			}
		
		if( (posX > 500 && posX < 750) && (posY > 200 && posY <520) )
			if(Mouse.isButtonDown(0)) {
				sbg.addState(new LvlTwo(Game.levelTwo));
				sbg.getState(Game.levelTwo).init(gc, sbg);
				sbg.enterState(2);
			}
		
		if( (posX > 920 && posX < 1030) && (posY > 200 && posY <320) )
			if(Mouse.isButtonDown(0))
			{
				sbg.addState(new LvlOne(Game.levelOne));
				sbg.getState(Game.levelOne).init(gc, sbg);
				sbg.enterState(1);
			}
		}

	public int getID() {
		return 0;
	}

}
