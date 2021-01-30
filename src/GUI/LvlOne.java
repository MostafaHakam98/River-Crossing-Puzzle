package GUI;
import System.GameEngine;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.BufferedImageUtil;

import Interfaces.*;
import Levels.LevelOne;


public class LvlOne extends BasicGameState {
	
	ICrossingStrategy Level =  new LevelOne();
	
	GameEngine Engine;
	
	public String mouse = new String();
	float scale = 0.3f;
	Image undo;
	Image redo;
	Image save;
	Image Farm;
	Image FarmerOnTheRight;
	Image FarmerOnTheLeft;
	float FarmerPosXOnTheLeft=40;
	float FarmerPosYOnTheLeft=720-206;
	float FarmerPosXOnTheLeftBoat=225;
	float FarmerPosYOnTheLeftBoat=720-210;
	float FarmerPosXOnTheRight=1041;
	float FarmerPosYOnTheRight=720-206;
	float FarmerPosXOnTheRightBoat=804;
	float FarmerPosYOnTheRightBoat=720-210;
	
	
	Image CabbageOnTheRight;
	Image CabbageOnTheLeft;
	float CabbageScale = 0.02f;
	float CabbagePosXOnTheLeft=353;
	float CabbagePosYOnTheLeft=720-284;
	float CabbagePosXOnTheLeftBoat=372;
	float CabbagePosYOnTheLeftBoat=720-90;
	float CabbagePosXOnTheRight=800;
	float CabbagePosYOnTheRight=720-284;
	float CabbagePosXOnTheRightBoat=720;
	float CabbagePosYOnTheRightBoat=720-90;
	
	
	Image DogOnTheRight;
	Image DogOnTheLeft;
	float DogPosXOnTheLeft=24;
	float DogPosYOnTheLeft=720-340;
	float DogPosXOnTheLeftBoat=340;
	float DogPosYOnTheLeftBoat=720-160;
	float DogPosXOnTheRight=1062;
	float DogPosYOnTheRight=720-340;
	float DogPosXOnTheRightBoat=717;
	float DogPosYOnTheRightBoat=720-160;
	
	
	Image SheepOnTheRight;
	Image SheepOnTheLeft;
	float SheepPosXOnTheLeft=235;
	float SheepPosYOnTheLeft=720-295;
	float SheepPosXOnTheLeftBoat=349;
	float SheepPosYOnTheLeftBoat=720-130;
	float SheepPosXOnTheRight=867;
	float SheepPosYOnTheRight=720-258;
	float SheepPosXOnTheRightBoat=713;
	float SheepPosYOnTheRightBoat=720-130;
	
	
	Image WolfOnTheRight;
	Image WolfOnTheLeft;
	float WolfPosXOnTheLeft=127;
	float WolfPosYOnTheLeft=720-263;
	float WolfPosXOnTheLeftBoat=332;
	float WolfPosYOnTheLeftBoat=720-142;
	float WolfPosXOnTheRight=966;
	float WolfPosYOnTheRight=720-243;
	float WolfPosXOnTheRightBoat=724;
	float WolfPosYOnTheRightBoat=720-142;
	
	
	Image BoatOnTheLeft;
	float BoatPosXOnTheLeft=184;
	float BoatPosYOnTheLeft=720-123;
	
	
	Image BoatOnTheRight;
	float BoatPosXOnTheRight=655;
	float BoatPosYOnTheRight=720-123;
	
	
	float FarmerPosX = FarmerPosXOnTheLeft;
	float FarmerPosY = FarmerPosYOnTheLeft;
	float WolfPosX = WolfPosXOnTheLeft;
	float WolfPosY = WolfPosYOnTheLeft;
	float SheepPosX = SheepPosXOnTheLeft;
	float SheepPosY = SheepPosYOnTheLeft;
	float CabbagePosX = CabbagePosXOnTheLeft;
	float CabbagePosY = CabbagePosYOnTheLeft;
	float BoatPosX = BoatPosXOnTheLeft;
	float BoatPosY = BoatPosYOnTheLeft;
	
	Image farmer;
	Image boat;
	Image wolf;
	Image cabbage;
	Image sheep;
	Image sailbutton;
	Image back;
	Image inst;
	Image info;

	ICrosser Farmerobj;
	ICrosser Sheepobj;
	ICrosser Cabbageobj;
	ICrosser Wolfobj;
	List<ICrosser> boatCrosser;
	List<ICrosser> leftBank;
	List<ICrosser> rightBank;
	
	int flagmove = 0;
	int flagwin = 0;
	int flagAlert = 0;
	int flaginfo = 0;
	int i;

	
	public LvlOne(int state) {
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		Engine = GameEngine.getInstance();
		i = 0;
		if(leftBank != null) {
			leftBank.clear();
			rightBank.clear();
			boatCrosser.clear();
		}
		
		Engine.newGame(Level);
		Engine.Strategy = Level;
		
		undo = new Image("Images\\Undo.png");
		redo = new Image("Images\\Redo.png");
		save = new Image("Images\\Save.png");
		
		Farmerobj = Level.getInitialCrossers().get(0);
		Sheepobj = Level.getInitialCrossers().get(1);
		Cabbageobj = Level.getInitialCrossers().get(2);
		Wolfobj = Level.getInitialCrossers().get(3);	
		
		boatCrosser = Engine.boat;
		leftBank = Engine.left;
		rightBank = Engine.right;
		
		BufferedImage[] farmerimages = Farmerobj.getImages();
		BufferedImage[] sheepimages = Sheepobj.getImages();
		BufferedImage[] wolfimages = Wolfobj.getImages();
		BufferedImage[] cabbageimages = Cabbageobj.getImages();
		
		try {
			
			Texture text;
			
			text = BufferedImageUtil.getTexture("test", farmerimages[0]);
			FarmerOnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", farmerimages[1]);
			FarmerOnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", sheepimages[0]);
			SheepOnTheLeft= new Image(text);
			text = BufferedImageUtil.getTexture("test", sheepimages[1]);
			SheepOnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", wolfimages[0]);
			WolfOnTheLeft= new Image(text);
			text = BufferedImageUtil.getTexture("test", wolfimages[1]);
			WolfOnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", cabbageimages[0]);
			CabbageOnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", cabbageimages[1]);
			CabbageOnTheRight= new Image(text);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		inst = new Image("Images\\inst.png");
		Farm = new Image("Images\\Farm.jpg");
		sailbutton = new Image("Images\\sailbutton.png");
		back = new Image("Images\\back.png");
		BoatOnTheLeft = new Image("Images\\Boat.png");
		BoatOnTheRight = new Image("Images\\Boat'.png");
		info = new Image("Images\\info.png");

		farmer = FarmerOnTheLeft;
		boat = BoatOnTheLeft;
		sheep = SheepOnTheLeft;
		cabbage = CabbageOnTheRight;
		wolf = WolfOnTheLeft;
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		Farm.draw(0, 0, 0.6f);
		g.drawString(mouse, 25, 720-400);
		farmer.draw(FarmerPosX,FarmerPosY, scale);
		wolf.draw(WolfPosX, WolfPosY, scale);
		cabbage.draw(CabbagePosX, CabbagePosY, CabbageScale);
		boat.draw(BoatPosX, BoatPosY, scale);
		sheep.draw(SheepPosX, SheepPosY, scale);
		sailbutton.draw(1000, 720-689, 0.2f);
		back.draw(20, 20, 0.4f);
		info.draw(1090, 720-681, 0.1f);
		g.setColor(Color.white);	
		redo.draw(1090,720-600,0.4f);
		undo.draw(1009,720-600,0.4f);
		save.draw(50, 720-623, 0.18f);


		
		if(flaginfo == 1) {
			JOptionPane.showMessageDialog(null, Level.getInstructions());
			flaginfo = 0;
		}
		
		if(flagAlert == 1) {
			JOptionPane.showMessageDialog(null, "Unavailable Move!");
			flagAlert = 0;
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int Xpos =Mouse.getX();
		int Ypos = Mouse.getY();
		
		mouse = "Number of sails:" + i + "";

		Input io = gc.getInput();
		
		//back button
		if( (Xpos>30 && Xpos<150) && (Ypos>630 && Ypos<700)) {
			if(io.isMouseButtonDown(0))
				sbg.enterState(0);
		}
		
		//left side movements
		if(( Xpos>40 && Xpos<110 )&&( Ypos>18 && Ypos<207) && Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && FarmerPosX==FarmerPosXOnTheLeft) {
			if(io.isMouseButtonDown(0) && FarmerPosX == FarmerPosXOnTheLeft) {
				FarmerPosX = FarmerPosXOnTheLeftBoat;
				FarmerPosY = FarmerPosYOnTheLeftBoat;
				
				leftBank.remove(Farmerobj);
				boatCrosser.add(Farmerobj);
				
				}
			}
		
			if(( Xpos>226 && Xpos<295 ) && ( Ypos>40 && Ypos<195) && Engine.isBoatOnTheLeftBank() &&FarmerPosX==FarmerPosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					FarmerPosX = FarmerPosXOnTheLeft;
					FarmerPosY = FarmerPosYOnTheLeft;
					
					leftBank.add(Farmerobj);
					boatCrosser.remove(Farmerobj);
				}
			}
			
			if(( Xpos>127 && Xpos<190 ) && ( Ypos>130 && Ypos<260)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 &&WolfPosX==WolfPosXOnTheLeft) {
				if(io.isMouseButtonDown(0) && WolfPosX == WolfPosXOnTheLeft) {
					WolfPosX = WolfPosXOnTheLeftBoat;
					WolfPosY= WolfPosYOnTheLeftBoat;
					
					leftBank.remove(Wolfobj);
					boatCrosser.add(Wolfobj);
				}
			}
			
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank()&& WolfPosX==WolfPosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					WolfPosX = WolfPosXOnTheLeft;
					WolfPosY= WolfPosYOnTheLeft;
					
					leftBank.add(Wolfobj);
					boatCrosser.remove(Wolfobj);
				}
			}
			
			if(( Xpos>245 && Xpos<314 )&&( Ypos>206 && Ypos<300)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && SheepPosX==SheepPosXOnTheLeft) {
				if(io.isMouseButtonDown(0)) {
					SheepPosX = SheepPosXOnTheLeftBoat;
					SheepPosY= SheepPosYOnTheLeftBoat;
					
					leftBank.remove(Sheepobj);
					boatCrosser.add(Sheepobj);
				}
			}
			
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank()&& SheepPosX==SheepPosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					SheepPosX = SheepPosXOnTheLeft;
					SheepPosY= SheepPosYOnTheLeft;
					
					leftBank.add(Sheepobj);
					boatCrosser.remove(Sheepobj);
				}
			}
			
			if(( Xpos>352 && Xpos<404 )&&( Ypos>232 && Ypos<290) && Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && CabbagePosX==CabbagePosXOnTheLeft) {
				if(io.isMouseButtonDown(0) && CabbagePosX == CabbagePosXOnTheLeft) {
					CabbagePosX = CabbagePosXOnTheLeftBoat;
					CabbagePosY= CabbagePosYOnTheLeftBoat;
					
					leftBank.remove(Cabbageobj);
					boatCrosser.add(Cabbageobj);
				}
			}
			
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank()&& CabbagePosX==CabbagePosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					CabbagePosX = CabbagePosXOnTheLeft;
					CabbagePosY= CabbagePosYOnTheLeft;
					
					leftBank.add(Cabbageobj);
					boatCrosser.remove(Cabbageobj);
				}
			}
			
			
			// Right Side Movements
			
			if(( Xpos>1047 && Xpos<1114 )&&( Ypos>20 && Ypos<205) && !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && FarmerPosX==FarmerPosXOnTheRight) {
				if(io.isMouseButtonDown(0) && FarmerPosX == FarmerPosXOnTheRight) {
					FarmerPosX= FarmerPosXOnTheRightBoat;
					FarmerPosY= FarmerPosYOnTheRightBoat;
					
					rightBank.remove(Farmerobj);
					boatCrosser.add(Farmerobj);
					
				}
				
				else if(io.isMousePressed(0)) {
					flagAlert = 1;
					}
				}
			
				if(( Xpos>807 && Xpos<876 )&&( Ypos>39 && Ypos<211)  && !Engine.isBoatOnTheLeftBank()&& FarmerPosX==FarmerPosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						FarmerPosX= FarmerPosXOnTheRight;
						FarmerPosY= FarmerPosYOnTheRight;
						
						rightBank.add(Farmerobj);
						boatCrosser.remove(Farmerobj);	
					}
				}
				
				
				if(( Xpos>968 && Xpos<1031 )&&( Ypos>107 && Ypos<238)  && !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && WolfPosX==WolfPosXOnTheRight) {
					if(io.isMouseButtonDown(0) && WolfPosX == WolfPosXOnTheRight) {
						WolfPosX = WolfPosXOnTheRightBoat;
						WolfPosY= WolfPosYOnTheRightBoat;
						
						rightBank.remove(Wolfobj);
						boatCrosser.add(Wolfobj);
					}
				}
				
				if(( Xpos>721 && Xpos<795 )&&( Ypos>36 && Ypos<140)  && !Engine.isBoatOnTheLeftBank() && WolfPosX==WolfPosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						WolfPosX = WolfPosXOnTheRight;
						WolfPosY= WolfPosYOnTheRight;
						
						rightBank.add(Wolfobj);
						boatCrosser.remove(Wolfobj);
					}
				}
				
				if(( Xpos>880 && Xpos<952 )&&( Ypos>170 && Ypos<260)  && !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2&& SheepPosX==SheepPosXOnTheRight) {
					if(io.isMouseButtonDown(0) && SheepPosX == SheepPosXOnTheRight) {
						SheepPosX = SheepPosXOnTheRightBoat;
						SheepPosY= SheepPosYOnTheRightBoat;
						
						rightBank.remove(Sheepobj);
						boatCrosser.add(Sheepobj);
					}
				}
				
				if(( Xpos>721 && Xpos<795 )&&( Ypos>36 && Ypos<140)  && !Engine.isBoatOnTheLeftBank() && SheepPosX==SheepPosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						SheepPosX = SheepPosXOnTheRight;
						SheepPosY= SheepPosYOnTheRight;
						
						rightBank.add(Sheepobj);
						boatCrosser.remove(Sheepobj);
					}
				}
				
				if(( Xpos>798 && Xpos<853 )&&( Ypos>233 && Ypos<285) && !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 &&CabbagePosX==CabbagePosXOnTheRight) {
					if(io.isMouseButtonDown(0)) {
						CabbagePosX = CabbagePosXOnTheRightBoat;
						CabbagePosY= CabbagePosYOnTheRightBoat;
						
						rightBank.remove(Cabbageobj);
						boatCrosser.add(Cabbageobj);
					}
				}
				
				
				if(( Xpos>721 && Xpos<795 ) && ( Ypos>36 && Ypos<140) && !Engine.isBoatOnTheLeftBank() &&CabbagePosX==CabbagePosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						CabbagePosX = CabbagePosXOnTheRight;
						CabbagePosY= CabbagePosYOnTheRight;
						
						rightBank.add(Cabbageobj);
						boatCrosser.remove(Cabbageobj);
						}
					}
				
				if((Xpos>1002 && Xpos<1071) && (Ypos>620 && Ypos <687)) {
					
					if(io.isMouseButtonDown(0) ) {
							flagmove = 1;
					}
					
					if(Engine.isBoatOnTheLeftBank() && flagmove == 1) {
						
						if(  Level.isValid(Engine.right, Engine.left, boatCrosser)) {
							if(BoatPosX == BoatPosXOnTheLeft && FarmerPosX == FarmerPosXOnTheLeftBoat ) {	
								boat = BoatOnTheRight;
								BoatPosX = BoatPosXOnTheRight;
								BoatPosY = BoatPosYOnTheRight;
								Engine.doMove(boatCrosser,true);
								farmer = FarmerOnTheRight;
								FarmerPosX = FarmerPosXOnTheRight;
								FarmerPosY = FarmerPosYOnTheRight;
								boatCrosser.clear();
								
								if(WolfPosX == WolfPosXOnTheLeftBoat) {	
									leftBank.remove(Wolfobj);
									wolf = WolfOnTheRight;
									WolfPosX = WolfPosXOnTheRight;
									WolfPosY = WolfPosYOnTheRight;
								}
								
								if(CabbagePosX == CabbagePosXOnTheLeftBoat) {	
									CabbagePosX = CabbagePosXOnTheRight;
									CabbagePosY = CabbagePosYOnTheRight;
								}
								
								if(SheepPosX==SheepPosXOnTheLeftBoat){	
									leftBank.remove(Sheepobj);
									sheep = SheepOnTheRight;
									SheepPosX = SheepPosXOnTheRight;
									SheepPosY = SheepPosYOnTheRight;
								}
								i++;
							}					
						}
						else if(io.isMousePressed(0) && !boatCrosser.isEmpty()) {
							flagAlert = 1;
						}
					}
					else if(!Engine.isBoatOnTheLeftBank() && flagmove == 1) {	
						
						if(FarmerPosX == FarmerPosXOnTheRightBoat && BoatPosX == BoatPosXOnTheRight&& Level.isValid(Engine.right, Engine.left, boatCrosser)){
							boat = BoatOnTheLeft;
							BoatPosX = BoatPosXOnTheLeft;
							BoatPosY = BoatPosYOnTheLeft;
							
							Engine.doMove(boatCrosser, false);
							
							farmer = FarmerOnTheLeft;
							FarmerPosX = FarmerPosXOnTheLeft;
							FarmerPosY = FarmerPosYOnTheLeft;
							rightBank.remove(Farmerobj);
							
							boatCrosser.clear();
							if(WolfPosX == WolfPosXOnTheRightBoat){	
								rightBank.remove(Wolfobj);
								wolf = WolfOnTheLeft;
								WolfPosX = WolfPosXOnTheLeft;
								WolfPosY = WolfPosYOnTheLeft;
							}
							if(CabbagePosX == CabbagePosXOnTheRightBoat) {	
								rightBank.remove(Cabbageobj);
								CabbagePosX = CabbagePosXOnTheLeft;
								CabbagePosY = CabbagePosYOnTheLeft;
							}
							
							if(SheepPosX == SheepPosXOnTheRightBoat) {	
								rightBank.remove(Sheepobj);
								sheep = SheepOnTheLeft;
								SheepPosX = SheepPosXOnTheLeft;
								SheepPosY = SheepPosYOnTheLeft;
							}
							i++;
						}
						
						else if(io.isMousePressed(0) && !boatCrosser.isEmpty()) {
							flagAlert = 1;
						}
					}						
					flagmove = 0;
				
			}
			
			if(Engine.getCrossersOnRightBank().size() == 4) {
				flagwin = 1;
			}
			
			if(flagwin == 1) {
				JOptionPane.showMessageDialog(null, "Congratulations, You've Won!!");
				sbg.enterState(0);				
			}
			
			if(Xpos>1095 && Xpos<1135 && Ypos>637 && Ypos<675) {
				if(io.isMousePressed(0)) {
					flaginfo = 1;
				}
			}
		}	

	public int getID() {
		return 1;
	}
}