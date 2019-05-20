import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  public void mirrorVerticalRightToLeft() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = width -1; col > width /2 ; col--)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels.length;
	    for (int row = 0; row < pixels.length/2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[width-1-row][col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
	  
  }
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels.length;
	    for (int row = 0; row < pixels.length/2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        leftPixel = pixels[width-1-row][col];
	        rightPixel = pixels[row][col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
	  
  }
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels.length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < row; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[col][row];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorArms() {
	  int mirrorPoint = 194;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 163; row < mirrorPoint; row++)
	    {
	      
	      for (int col = 103; col < 291; col++)
	      {
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[mirrorPoint-row+mirrorPoint]                 
	                         [col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
  }
  public void mirrorGull() {
		 int mirrorPoint = 344;
		    Pixel leftPixel = null;
		    Pixel rightPixel = null;
		
		    Pixel[][] pixels = this.getPixels2D();
		    
		    // loop through the rows
		    for (int row = 234; row < 321; row++)
		    {
		      // loop from 13 to just before the mirror point
		      for (int col = 239; col < mirrorPoint; col++)
		      {
		       
		    	  leftPixel = pixels[row][col];      
		          rightPixel = pixels[row]                       
		                           [mirrorPoint - col + mirrorPoint];
		        rightPixel.setColor(leftPixel.getColor());
		      }
		    }

		  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  public void blur(int x, int y, int w, int h){
	  Pixel[][] pixels = this.getPixels2D();
	  for(int r=y; r<y+h; r++){
		  for(int c=x; c<x+w; c++){	
			  Pixel pixelObj = pixels[r][c];
			  int avgRed = ((
			  		  pixels[r-1][c-1].getRed() 
			  		+ pixels[r-1][c  ].getRed()
			  		+ pixels[r-1][c+1].getRed()
			  		+ pixels[r  ][c-1].getRed() 
			  		+ pixels[r  ][c+1].getRed()
			  		+ pixels[r+1][c-1].getRed()
			  		+ pixels[r+1][c  ].getRed() 
			  		+ pixels[r+1][c+1].getRed()
			  		)/8);
			  int avgGreen = ((
			  		  pixels[r-1][c-1].getGreen() 
			  		+ pixels[r-1][c  ].getGreen()
			  		+ pixels[r-1][c+1].getGreen()
			  		+ pixels[r  ][c-1].getGreen() 
			  		+ pixels[r  ][c+1].getGreen()
			  		+ pixels[r+1][c-1].getGreen()
			  		+ pixels[r+1][c  ].getGreen() 
			  		+ pixels[r+1][c+1].getGreen()
			  		)/8);
			  int avgBlue = ((
			  		  pixels[r-1][c-1].getBlue() 
			  		+ pixels[r-1][c  ].getBlue()
			  		+ pixels[r-1][c+1].getBlue()
			  		+ pixels[r  ][c-1].getBlue() 
			  		+ pixels[r  ][c+1].getBlue()
			  		+ pixels[r+1][c-1].getBlue()
			  		+ pixels[r+1][c  ].getBlue() 
			  		+ pixels[r+1][c+1].getBlue()
			  		)/8);
			  pixelObj.setRed(avgRed);
			  pixelObj.setGreen(avgGreen);
			  pixelObj.setBlue(avgBlue);
		  }
	  }
 }
 
  public void copyPartial(Picture fromPic, int startRow, int startCol,
			int fromRowStart, int fromColStart, int fromRowEnd, int fromColEnd)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		if (fromRowStart < 0 || fromRowStart > fromPixels.length) {
			fromRowStart = 0;
		}
		if (fromColStart < 0 || fromColStart > fromPixels[0].length) {
			fromColStart = 0;
		}
		if (fromRowEnd < 0 || fromRowEnd > fromPixels.length) {
			fromRowEnd = fromPixels.length;
		}
		if (fromColEnd < 0 || fromColEnd > fromPixels[0].length) {
			fromColEnd = fromPixels[0].length;
		}
		for (int fromRow = fromRowStart, toRow = startRow; fromRow < fromRowEnd
				&& toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = fromColStart, toCol = startCol; fromCol < fromColEnd
					&& toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("C:\\Users\\0yong\\Documents\\GitHub\\Lee_Jason_apcsa-p33\\Unit16\\src\\images\\flower1.jpg");
    Picture flower2 = new Picture("C:\\Users\\0yong\\Documents\\GitHub\\Lee_Jason_apcsa-p33\\Unit16\\src\\images\\flower2.jpg");
    this.copy(flower1,0,0);
   this.copy(flower2,100,0);
    this.copy(flower1,200,0);
   Picture flowerNoBlue = new Picture(flower2);
  flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
   this.copy(flower2,500,0);
   this.mirrorVertical();
    this.write("C:\\Users\\0yong\\Documents\\GitHub\\Lee_Jason_apcsa-p33\\Unit16\\src\\images\\7inX95in.jpg");
  }
  
  public void myCollage() {
	   Picture cater1 = new Picture("C:\\Users\\0yong\\Documents\\GitHub\\Lee_Jason_apcsa-p33\\Unit16\\src\\images\\barbaraS.jpg");
	   cater1.mirrorHorizontalBotToTop();
	    Picture cater2 = new Picture("C:\\Users\\0yong\\Documents\\GitHub\\Lee_Jason_apcsa-p33\\Unit16\\src\\images\\barbaraS.jpg");
	    cater2.negate();
	    this.copy(cater1,0,0);
	    this.copy(cater2,100,0);
	    this.copy(cater1,200,0);
	    Picture caterNoBlue = new Picture(cater2);
	    caterNoBlue.zeroBlue();
	    this.copy(caterNoBlue,300,0);
	    this.copy(cater1,400,0);
	    this.copy(cater2,500,0);
	    this.mirrorVertical();
 }
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel BotPixel = null;
   
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color BotColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        BotPixel = pixels[row+1][col];
        BotColor = BotPixel.getColor();
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else if(leftPixel.colorDistance(BotColor) > edgeDist)
        	leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  public void keepOnlyRed() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  public void keepOnlyGreen() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setBlue(0);
	      }
	    }
  }
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(255-pixelObj.getRed());
	        pixelObj.setBlue(255-pixelObj.getBlue());
	        pixelObj.setGreen(255-pixelObj.getGreen());
	      }
	    }
  }
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	 
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        int gray = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed())/3;
	    	pixelObj.setRed(gray);
	        pixelObj.setGreen(gray);
	        pixelObj.setBlue(gray);
	      }
	    }
  }
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
		 
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	pixelObj.setRed(pixelObj.getRed()+55);
	    	pixelObj.setBlue(pixelObj.getBlue()-55); 
	    	pixelObj.setGreen(pixelObj.getGreen()-55); 
	          
	      } 
	    }
  }
  
  
  public void encode(Picture messageImage) {
	  Pixel[][] pixels=this.getPixels2D();
	  Pixel[][] messagePixels = messageImage.getPixels2D();
	  
	  
	  int tempVal=0;
	  int counter = 0;
	  
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  
	  
	  
	  for(int row = 0; row< this.getHeight(); row++ ) {
		 for(int col = 0; col<this.getWidth(); col++) {
			 currPixel = pixels[row][col];
			 tempVal = currPixel.getBlue()%10;
			 currPixel.setBlue(currPixel.getBlue()-tempVal + counter);
			 counter++;
			 if(counter==7) {
				 counter = 0;
			 }
			 messagePixel = messagePixels[row][col];
			 
			 if (messagePixel.colorDistance(Color.BLACK)<50) {
				 currPixel.setBlue(currPixel.getBlue() +1);
			 }
			 
			 
			 
		 }
		  
	  }
	  
	  
  }
  
  public void decode() {
	   Pixel[][]pixels = this.getPixels2D();
	   
	   int height = this.getHeight();
	   int width = this.getWidth();
	   int tempVal = 0;
	   
	 
	   

	   
	   
//	   for(int row = 0; row<this.getHeight(); row++) {
//		   for(int col = 0; col<this.getWidth(); col++) {
//			   pixels[row][col].setColor(Color.WHITE);
			   
//		   }
//	   }
	   
	  
	   for(int row = 0; row<this.getHeight(); row++) {
		   for(int col = 0; col<this.getWidth(); col++) {
			   if(pixels[row][col].getBlue()%10!=tempVal) {
				   pixels[row][col].setColor(Color.BLACK);
			   }
			   else {
				  pixels[row][col].setColor(Color.WHITE); 
			   }
			   tempVal++;
			   if(tempVal ==7) {
				   tempVal=0;
			   }
			 
			   
		   }
	   }
	   
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
