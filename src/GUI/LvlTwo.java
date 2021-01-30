package GUI;
import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;
import Levels.LevelTwo;
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


public class LvlTwo extends BasicGameState{
	ICrossingStrategy Level =  new LevelTwo();
	
	GameEngine Engine;
	public String mouse = new String();
	float scale = 0.3f;
	Image Farm;
	Image undo;
	Image redo;
	Image save;
	Image Farmer90OnTheRight;
	Image Farmer90OnTheLeft;
	float Farmer90PosXOnTheLeft=40;
	float Farmer90PosYOnTheLeft=720-206;
	float Farmer90PosXOnTheLeftBoat=225;
	float Farmer90PosYOnTheLeftBoat=720-210;
	float Farmer90PosXOnTheRight=1041;
	float Farmer90PosYOnTheRight=720-206;
	float Farmer90PosXOnTheRightBoat=804;
	float Farmer90PosYOnTheRightBoat=720-210;
	Image Farmer40OnTheRight;
	Image Farmer40OnTheLeft;
	float Farmer40Scale = 0.02f;
	float Farmer40PosXOnTheLeft=353;
	float Farmer40PosYOnTheLeft=720-320;
	float Farmer40PosXOnTheLeftBoat=372;
	float Farmer40PosYOnTheLeftBoat=720-133;
	float Farmer40PosXOnTheRight=800;
	float Farmer40PosYOnTheRight=720-284;
	float Farmer40PosXOnTheRightBoat=720;
	float Farmer40PosYOnTheRightBoat=720-133;
	Image DogOnTheRight;
	Image DogOnTheLeft;
	float DogPosXOnTheLeft=24;
	float DogPosYOnTheLeft=720-340;
	float DogPosXOnTheLeftBoat=340;
	float DogPosYOnTheLeftBoat=720-160;
	float DogPosXOnTheRight=1040;
	float DogPosYOnTheRight=720-340;
	float DogPosXOnTheRightBoat=717;
	float DogPosYOnTheRightBoat=720-160;
	Image Farmer60OnTheRight;
	Image Farmer60OnTheLeft;
	float Farmer60PosXOnTheLeft=250;
	float Farmer60PosYOnTheLeft=720-328;
	float Farmer60PosXOnTheLeftBoat=349;
	float Farmer60PosYOnTheLeftBoat=720-162;
	float Farmer60PosXOnTheRight=867;
	float Farmer60PosYOnTheRight=720-258;
	float Farmer60PosXOnTheRightBoat=713;
	float Farmer60PosYOnTheRightBoat=720-162;
	Image Farmer80OnTheRight;
	Image Farmer80OnTheLeft;
	float Farmer80PosXOnTheLeft=127;
	float Farmer80PosYOnTheLeft=720-263;
	float Farmer80PosXOnTheLeftBoat=332;
	float Farmer80PosYOnTheLeftBoat=720-172;
	float Farmer80PosXOnTheRight=966;
	float Farmer80PosYOnTheRight=720-243;
	float Farmer80PosXOnTheRightBoat=724;
	float Farmer80PosYOnTheRightBoat=720-172;
	Image BoatOnTheLeft;
	float BoatPosXOnTheLeft=184;
	float BoatPosYOnTheLeft=720-123;
	Image BoatOnTheRight;
	float BoatPosXOnTheRight=655;
	float BoatPosYOnTheRight=720-123;
	float Farmer90PosX ;
	float Farmer90PosY ;
	float Farmer80PosX ;
	float Farmer80PosY ;
	float Farmer60PosX ;
	float Farmer60PosY ;
	float Farmer40PosX ;
	float Farmer40PosY ;
	float DogPosX ;
	float DogPosY ;
	float BoatPosX ;
	float BoatPosY ;
	Image Farmer90;
	Image Boat;
	Image Farmer80;
	Image Farmer40;
	Image Farmer60;
	Image Dog;
	Image sailbutton;
	Image back;
	Image win;
	Image info;
	
	
	List<ICrosser> boatCrosser;
	List<ICrosser> leftBank;
	List<ICrosser> rightBank;
	
	
	int flagmove = 0;
	int flagwin = 0;
	int flaginfo = 0;
	int flagAlert = 0;
	
	ICrosser Farmer90obj;
	ICrosser Farmer80obj;
	ICrosser Farmer60obj;
	ICrosser Farmer40obj;
	ICrosser Dogobj;
	int i;
	
	Image inst;
	
	public LvlTwo(int state) {
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		Engine = GameEngine.getInstance();

		i=0;
		
		if(leftBank != null) {
			leftBank.clear();
			rightBank.clear();
			boatCrosser.clear();
		}
		Engine.newGame(Level);
		Engine.Strategy = Level;
		Farm = new Image("Images\\Farm.jpg");
		Farmer90obj=Level.getInitialCrossers().get(0);
		Farmer80obj=Level.getInitialCrossers().get(1);
		Farmer60obj=Level.getInitialCrossers().get(2);
		Farmer40obj=Level.getInitialCrossers().get(3);
		Dogobj=Level.getInitialCrossers().get(4);
		
		boatCrosser = Engine.boat;
		leftBank = Engine.left;
		rightBank = Engine.right;
		
		undo = new Image("Images\\Undo.png");
		redo = new Image("Images\\Redo.png");
		save = new Image("Images\\Save.png");
		
		BufferedImage[] farmer90images = Farmer90obj.getImages();
		BufferedImage[] farmer80images = Farmer80obj.getImages();
		BufferedImage[] farmer60images = Farmer60obj.getImages();
		BufferedImage[] farmer40images = Farmer40obj.getImages();
		BufferedImage[] dogimages = Dogobj.getImages();
		
		try {
			
			Texture text;
			
			text = BufferedImageUtil.getTexture("test", farmer90images[0]);
			Farmer90OnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer90images[1]);
			Farmer90OnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer80images[0]);
			Farmer80OnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer80images[1]);
			Farmer80OnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer60images[0]);
			Farmer60OnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer60images[1]);
			Farmer60OnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer40images[0]);
			Farmer40OnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", farmer40images[1]);
			Farmer40OnTheRight= new Image(text);
			text = BufferedImageUtil.getTexture("test", dogimages[0]);
			DogOnTheLeft = new Image(text);
			text = BufferedImageUtil.getTexture("test", dogimages[1]);
			DogOnTheRight= new Image(text);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		inst = new Image("Images\\inst.png");
		win = new Image("Images\\win.png");
		info = new Image("Images\\info.png");
		sailbutton = new Image("Images\\sailbutton.png");
		BoatOnTheLeft= new Image("Images\\boat.png");
		BoatOnTheRight= new Image("Images\\boat'.png");
		back = new Image("Images\\back.png");
		
		Farmer90 = Farmer90OnTheLeft;
		Boat = BoatOnTheLeft;
		Farmer60 = Farmer60OnTheLeft;
		Farmer40 = Farmer40OnTheLeft;
		Farmer80 = Farmer80OnTheLeft;
		Dog = DogOnTheLeft;
		Farmer90PosX = Farmer90PosXOnTheLeft;
		Farmer90PosY = Farmer90PosYOnTheLeft;
		Farmer80PosX = Farmer80PosXOnTheLeft;
		Farmer80PosY = Farmer80PosYOnTheLeft;
		Farmer60PosX = Farmer60PosXOnTheLeft;
		Farmer60PosY = Farmer60PosYOnTheLeft;
		Farmer40PosX = Farmer40PosXOnTheLeft;
		Farmer40PosY = Farmer40PosYOnTheLeft;
		DogPosX = DogPosXOnTheLeft;
		DogPosY = DogPosYOnTheLeft;
		BoatPosX = BoatPosXOnTheLeft;
		BoatPosY = BoatPosYOnTheLeft;		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		Farm.draw(0,0,0.6f);
		g.setColor(Color.white);	 
		g.drawString(mouse, 25, 720-400);
		g.drawString(""+Farmer90obj.getWeight()+ " KGS", Farmer90PosX,Farmer90PosY-15);
		g.drawString(""+Farmer80obj.getWeight()+ " KGS", Farmer80PosX, Farmer80PosY-15);
		g.drawString(""+Farmer60obj.getWeight()+ " KGS", Farmer60PosX, Farmer60PosY-15);
		g.drawString(""+Farmer40obj.getWeight()+ " KGS", Farmer40PosX, Farmer40PosY-15);
		g.drawString(""+Dogobj.getWeight()+ " KGS", DogPosX, DogPosY-15);
		Farmer90.draw(Farmer90PosX,Farmer90PosY, 0.3f);
		Farmer80.draw(Farmer80PosX, Farmer80PosY, 0.25f);
		Farmer40.draw(Farmer40PosX,Farmer40PosY, 0.15f);
		redo.draw(1090,720-600,0.4f);
		undo.draw(1009,720-600,0.4f);
		save.draw(50, 720-623, 0.18f);
		
		Boat.draw(BoatPosX, BoatPosY, scale);
		
		Farmer60.draw(Farmer60PosX, Farmer60PosY, 0.2f);
		
		sailbutton.draw(1000, 720-689, 0.2f);
		
		Dog.draw(DogPosX,DogPosY,scale);
		
		back.draw(20, 20, 0.4f);
		
		info.draw(1090, 720-681, 0.1f);
		
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
		mouse = "Number of sails:"+i+"";
		Input io = gc.getInput();
		
		
		//back button
		if( (Xpos>30 && Xpos<150) && (Ypos>630 && Ypos<700)) {
			if(io.isMouseButtonDown(0))
				sbg.enterState(0);
		}
		
		//left side movements
		if(flagwin == 0) {
			
		if( (Xpos>40 && Xpos<110) && (Ypos>18 && Ypos<207) && Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer90PosX == Farmer90PosXOnTheLeft) {
			
			if(io.isMouseButtonDown(0)) {
				
				Farmer90PosX = Farmer90PosXOnTheLeftBoat;
				Farmer90PosY = Farmer90PosYOnTheLeftBoat;
				
				leftBank.remove(Farmer90obj);
				boatCrosser.add(Farmer90obj);
				}
			}
		
		
			if(( Xpos>226 && Xpos<295 )&&( Ypos>40 && Ypos<195)&& Engine.isBoatOnTheLeftBank() &&Farmer90PosX==Farmer90PosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					Farmer90PosX = Farmer90PosXOnTheLeft;
					Farmer90PosY = Farmer90PosYOnTheLeft;
					
					boatCrosser.remove(Farmer90obj);
					leftBank.add(Farmer90obj);
				}
			}
			
			if(( Xpos>127 && Xpos<190 )&&( Ypos>130 && Ypos<260)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer80PosX==Farmer80PosXOnTheLeft) {
				if(io.isMouseButtonDown(0)) {
					Farmer80PosX = Farmer80PosXOnTheLeftBoat;
					Farmer80PosY= Farmer80PosYOnTheLeftBoat;
					
					boatCrosser.add(Farmer80obj);
					leftBank.remove(Farmer80obj);

				}
			}
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank() &&Farmer80PosX==Farmer80PosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					Farmer80PosX = Farmer80PosXOnTheLeft;
					Farmer80PosY = Farmer80PosYOnTheLeft;
					
					boatCrosser.remove(Farmer80obj);
					leftBank.add(Farmer80obj);

				}
			}
			
			if(( Xpos>248 && Xpos<301 )&&( Ypos>208 && Ypos<326)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer60PosX==Farmer60PosXOnTheLeft) {
				if(io.isMouseButtonDown(0)) {
					Farmer60PosX = Farmer60PosXOnTheLeftBoat;
					Farmer60PosY = Farmer60PosYOnTheLeftBoat;
					
					boatCrosser.add(Farmer60obj);
					leftBank.remove(Farmer60obj);

				}
			}
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank() &&Farmer60PosX==Farmer60PosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					Farmer60PosX = Farmer60PosXOnTheLeft;
					Farmer60PosY = Farmer60PosYOnTheLeft;
					
					boatCrosser.remove(Farmer60obj);
					leftBank.add(Farmer60obj);

				}
			}
			
			if(( Xpos>352 && Xpos<391 )&&( Ypos>230 && Ypos<320)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer40PosX==Farmer40PosXOnTheLeft) {
				if(io.isMouseButtonDown(0)) {
					Farmer40PosX = Farmer40PosXOnTheLeftBoat;
					Farmer40PosY = Farmer40PosYOnTheLeftBoat;
					
					boatCrosser.add(Farmer40obj);
					leftBank.remove(Farmer40obj);

				}
			}
			
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank() &&Farmer40PosX==Farmer40PosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					Farmer40PosX = Farmer40PosXOnTheLeft;
					Farmer40PosY = Farmer40PosYOnTheLeft;
					
					boatCrosser.remove(Farmer40obj);
					leftBank.add(Farmer40obj);

				}
			}
			
			if(( Xpos>25 && Xpos<130 )&&( Ypos>215 && Ypos<340)&& Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && DogPosX==DogPosXOnTheLeft) {
				if(io.isMouseButtonDown(0)) {
					DogPosX = DogPosXOnTheLeftBoat;
					DogPosY = DogPosYOnTheLeftBoat;
					
					boatCrosser.add(Dogobj);
					leftBank.remove(Dogobj);

				}
			}
			
			if(( Xpos>330 && Xpos<400 )&&( Ypos>22 && Ypos<140)&& Engine.isBoatOnTheLeftBank() &&DogPosX==DogPosXOnTheLeftBoat) {
				if(io.isMouseButtonDown(0)) {
					DogPosX = DogPosXOnTheLeft;
					DogPosY = DogPosYOnTheLeft;
					
					boatCrosser.remove(Dogobj);
					leftBank.add(Dogobj);

				}
			}
			
			
			// Right Side Movements

			if(( Xpos>1047 && Xpos<1114 )&&( Ypos>20 && Ypos<205)&& !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer90PosX==Farmer90PosXOnTheRight) {				
				if(io.isMouseButtonDown(0)) {
					Farmer90PosX = Farmer90PosXOnTheRightBoat;
					Farmer90PosY = Farmer90PosYOnTheRightBoat;
					
					boatCrosser.add(Farmer90obj);
					rightBank.remove(Farmer90obj);

					}
				}
			
			
				if(( Xpos>807 && Xpos<876 )&&( Ypos>39 && Ypos<211)&& !Engine.isBoatOnTheLeftBank() && Farmer90PosX==Farmer90PosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						Farmer90PosX = Farmer90PosXOnTheRight;
						Farmer90PosY = Farmer90PosYOnTheRight;
						
						boatCrosser.remove(Farmer90obj);
						rightBank.add(Farmer90obj);

					}
				}
				
				
				if(( Xpos>968 && Xpos<1031 )&&( Ypos>107 && Ypos<238)&& !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer80PosX==Farmer80PosXOnTheRight) {
					if(io.isMouseButtonDown(0)) {
						Farmer80PosX = Farmer80PosXOnTheRightBoat;
						Farmer80PosY = Farmer80PosYOnTheRightBoat;
						
						boatCrosser.add(Farmer80obj);
						rightBank.remove(Farmer80obj);

					}
				}
				
				
				if(( Xpos>721 && Xpos<795 )&&( Ypos>36 && Ypos<140)&& !Engine.isBoatOnTheLeftBank() && Farmer80PosX==Farmer80PosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						Farmer80PosX = Farmer80PosXOnTheRight;
						Farmer80PosY = Farmer80PosYOnTheRight;
						
						boatCrosser.remove(Farmer80obj);
						rightBank.add(Farmer80obj);

					}
				}
				
				if(( Xpos>880 && Xpos<952 )&&( Ypos>170 && Ypos<260)&& !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer60PosX==Farmer60PosXOnTheRight) {
					if(io.isMouseButtonDown(0)) {
						Farmer60PosX = Farmer60PosXOnTheRightBoat;
						Farmer60PosY = Farmer60PosYOnTheRightBoat;
						
						boatCrosser.add(Farmer60obj);
						rightBank.remove(Farmer60obj);

					}
				}
				
				
				if(( Xpos>721 && Xpos<795 )&&( Ypos>36 && Ypos<140)&& !Engine.isBoatOnTheLeftBank() && Farmer60PosX==Farmer60PosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						Farmer60PosX = Farmer60PosXOnTheRight;
						Farmer60PosY = Farmer60PosYOnTheRight;
					
						boatCrosser.remove(Farmer60obj);
						rightBank.remove(Farmer60obj);

					}
				}
				
				if(( Xpos>798 && Xpos<853 )&&( Ypos>233 && Ypos<285)&& !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && Farmer40PosX==Farmer40PosXOnTheRight) {
					if(io.isMouseButtonDown(0)) {
						Farmer40PosX = Farmer40PosXOnTheRightBoat;
						Farmer40PosY = Farmer40PosYOnTheRightBoat;
						
						boatCrosser.add(Farmer40obj);
						rightBank.remove(Farmer40obj);

					}
				}
				
				
				if(( Xpos>721 && Xpos<795 )&&( Ypos>36 && Ypos<140)&& !Engine.isBoatOnTheLeftBank() && Farmer40PosX==Farmer40PosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						Farmer40PosX = Farmer40PosXOnTheRight;
						Farmer40PosY= Farmer40PosYOnTheRight;
						
						boatCrosser.remove(Farmer40obj);
						rightBank.add(Farmer40obj);

					}
				}
				
				if(( Xpos>1040 && Xpos<1140 )&&( Ypos>217 && Ypos<341)&& !Engine.isBoatOnTheLeftBank() && boatCrosser.size()<2 && DogPosX==DogPosXOnTheRight) {
					if(io.isMouseButtonDown(0)) {
						DogPosX = DogPosXOnTheRightBoat;
						DogPosY = DogPosYOnTheRightBoat;
						
						boatCrosser.add(Dogobj);
						rightBank.remove(Dogobj);

					}
				}
				
				
				if( Xpos>721 && Xpos<795 && Ypos>36 && Ypos<140&& !Engine.isBoatOnTheLeftBank() && DogPosX==DogPosXOnTheRightBoat) {
					if(io.isMouseButtonDown(0)) {
						DogPosX = DogPosXOnTheRight;
						DogPosY= DogPosYOnTheRight;
						
						rightBank.add(Dogobj);
						boatCrosser.remove(Dogobj);
					}
				}
				
				if((Xpos>1000&&Xpos<1070)&&(Ypos>620 && Ypos <685)) {
						if(io.isMouseButtonDown(0)) {
							flagmove = 1;
						}
				
						if(Engine.isBoatOnTheLeftBank() && flagmove == 1) {
							
							if( Engine.canMove(boatCrosser, Engine.isBoatOnTheLeftBank())) {	
							Boat = BoatOnTheRight;
							BoatPosX = BoatPosXOnTheRight;
							BoatPosY = BoatPosYOnTheRight;
							Engine.doMove(boatCrosser, true);
							
							
							boatCrosser.clear();
							if(Farmer90PosX == Farmer90PosXOnTheLeftBoat) {	
								
								Farmer90 = Farmer90OnTheRight;
								Farmer90PosX = Farmer90PosXOnTheRight;
								Farmer90PosY = Farmer90PosYOnTheRight;
							}
							
							if(Farmer80PosX == Farmer80PosXOnTheLeftBoat) {
								Farmer80 = Farmer80OnTheRight;
								Farmer80PosX = Farmer80PosXOnTheRight;
								Farmer80PosY = Farmer80PosYOnTheRight;
							}
							
							if(Farmer60PosX == Farmer60PosXOnTheLeftBoat) {	
								Farmer60 = Farmer60OnTheRight;
								Farmer60PosX = Farmer60PosXOnTheRight;
								Farmer60PosY = Farmer60PosYOnTheRight;
							}
							
							if(Farmer40PosX == Farmer40PosXOnTheLeftBoat) {	
								Farmer40 = Farmer40OnTheRight;
								Farmer40PosX = Farmer40PosXOnTheRight;
								Farmer40PosY = Farmer40PosYOnTheRight;
							}
							
							if(DogPosX == DogPosXOnTheLeftBoat) {	
								Dog = DogOnTheRight;
								DogPosX = DogPosXOnTheRight;
								DogPosY = DogPosYOnTheRight;
							}
							i++;
						}
						else if (io.isMousePressed(0) && !boatCrosser.isEmpty()) {
							flagAlert = 1;
						}
					}
						
					else if(!Engine.isBoatOnTheLeftBank() && flagmove == 1) {
						if( Engine.canMove(boatCrosser, Engine.isBoatOnTheLeftBank())){
							Boat = BoatOnTheLeft;
							BoatPosX = BoatPosXOnTheLeft;
							BoatPosY = BoatPosYOnTheLeft;
							Engine.doMove(boatCrosser, false);
							
							boatCrosser.clear();
							
							if(Farmer90PosX==Farmer90PosXOnTheRightBoat) {	
								Farmer90 = Farmer90OnTheLeft;
								Farmer90PosX = Farmer90PosXOnTheLeft;
								Farmer90PosY = Farmer90PosYOnTheLeft;
							}
							
							if(Farmer80PosX == Farmer80PosXOnTheRightBoat){	
								Farmer80 = Farmer80OnTheLeft;
								Farmer80PosX = Farmer80PosXOnTheLeft;
								Farmer80PosY = Farmer80PosYOnTheLeft;
							}
							
							if(Farmer60PosX == Farmer60PosXOnTheRightBoat) {	
								Farmer60 = Farmer60OnTheLeft;
								Farmer60PosX = Farmer60PosXOnTheLeft;
								Farmer60PosY = Farmer60PosYOnTheLeft;
							}
							
							if(Farmer40PosX == Farmer40PosXOnTheRightBoat) {		
								Farmer40 = Farmer40OnTheLeft;
								Farmer40PosX = Farmer40PosXOnTheLeft;
								Farmer40PosY = Farmer40PosYOnTheLeft;
							}
							
							if(DogPosX == DogPosXOnTheRightBoat) {	
								Dog = DogOnTheLeft;
								DogPosX = DogPosXOnTheLeft;
								DogPosY = DogPosYOnTheLeft;
							}
							i++;
						}
						
						else if(io.isMousePressed(0) && !boatCrosser.isEmpty()) {
							flagAlert = 1;
						}
					}
					flagmove = 0;
			}
		}
		
		if(DogPosX == DogPosXOnTheRight && Farmer40PosX == Farmer40PosXOnTheRight && Farmer60PosX == Farmer60PosXOnTheRight && Farmer80PosX == Farmer80PosXOnTheRight && Farmer90PosX == Farmer90PosXOnTheRight) {
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
		return 2;
	}
}
