package Factory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class CrosserImage {
	
    private BufferedImage farmerLeft;
    private BufferedImage farmerRight;

    private BufferedImage wolfLeft;
    private BufferedImage wolfRight;

    private BufferedImage sheepLeft;
    private BufferedImage sheepRight;

    private BufferedImage cabageLeft;
    private BufferedImage cabageRight;
    
    private BufferedImage dogLeft;
    private BufferedImage dogRight;

    public CrosserImage() {
    	
        try{
            farmerLeft = ImageIO.read(new FileInputStream("Images\\Farmer'.png"));
            farmerRight = ImageIO.read(new FileInputStream("Images\\Farmer.png"));            
            
            wolfLeft = ImageIO.read(new FileInputStream("Images\\Wolf.png"));
            wolfRight = ImageIO.read(new FileInputStream("Images\\Wolf'.png"));
            
            cabageLeft = ImageIO.read(new FileInputStream("Images\\Cabbage.png"));
            cabageRight = ImageIO.read(new FileInputStream("Images\\Cabbage'.png"));
            
            sheepLeft = ImageIO.read(new FileInputStream("Images\\Sheep.png"));
            sheepRight = ImageIO.read(new FileInputStream("Images\\Sheep'.png"));

            dogLeft = ImageIO.read(new FileInputStream("Images\\Dog.png"));
            dogRight = ImageIO.read(new FileInputStream("Images\\Dog'.png"));

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public BufferedImage[] getFarmerImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = farmerRight;
        Images[1] = farmerLeft;
        
        return Images;
    }

    public BufferedImage[] getWolfImages(){
        
    	BufferedImage[] Images = new BufferedImage[2];
        
    	Images[0] = wolfLeft;
    	Images[1] = wolfRight;
        
        return Images;
    }

    public BufferedImage[] getSheepImages(){
    	
        BufferedImage[] Images=new BufferedImage[2];
        
        Images[0] = sheepLeft;
        Images[1] = sheepRight;
        
        return Images;
    }

    public BufferedImage[] getCabageImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = cabageLeft;
        Images[1] = cabageRight;
        
        return Images;
    }

    public BufferedImage[] getDogImages(){
    	
        BufferedImage[] Images = new BufferedImage[2];
        
        Images[0] = dogLeft;
        Images[1] = dogRight;
        
        return Images;
    }
}
