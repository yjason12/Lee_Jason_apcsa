
import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.*;

public class Pong2 extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle2 leftPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private ArrayList<Tile> tiles;
	private int level;


	public Pong2()
	{
		//set up all variables related to the game
		ball = new Ball(350, 250, 10, 10, Color.BLACK, 3, 3);
		leftPaddle = new Paddle2(400, 400, 40, 40, Color.RED, 2);
		keys = new boolean[4];
		tiles = new ArrayList<Tile>();
		level = 1;
		
		//top tiles
		for (int i = 5; i < 750; i+=85) {
			for (int j = 5; j < 90; j+=45) {
				tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
			}
		}
		
		//bottom tiles
		for (int i = 5; i < 750; i+=85) {
			for (int j = 680; j < 750; j+=45) {
				tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
			}
		}
		
		//left tiles
		for (int j = 95; j < 660; j+=45) {
			for (int i = 5; i < 175; i+=85) {
				tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
			}
		}
				
		//right tiles
		for (int j = 95; j < 660; j+=45) {
			for (int i = 600; i < 750; i+=85) {
				tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
			}
		}
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		for (Tile tile : tiles) {
			tile.draw(graphToBack);
		}
		
		graphToBack.setColor(Color.LIGHT_GRAY);
		graphToBack.setFont(new Font("Helvetica", Font.PLAIN, 50));
		graphToBack.drawString(Integer.toString(level), 400, 360);
		
		
		//Change Level
		if (tiles.size() == 0) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			level++;
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(400, 290, 75, 75);
			graphToBack.drawString(Integer.toString(level), 400, 360);
			graphToBack.setColor(Color.WHITE);
			
			//top tiles
			for (int i = 5; i < 750; i += 85) {
				for (int j = 5; j < 90; j += 45) {
					tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
				}
			}
			
			//bottom tiles
			for (int i = 5; i < 750; i += 85) {
				for (int j = 680; j < 750; j += 45) {
					tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
				}
			}
			
			//left tiles
			for (int j = 95; j < 660; j += 45) {
				for (int i = 5; i < 175; i += 85) {
					tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
				}
			}
			
			//right tiles
			for (int j = 95; j < 660; j += 45) {
				for (int i = 600; i < 750; i += 85) {
					tiles.add(new Tile(i, j, 80, 40, Color.BLACK));
				}
			}
			
			for (Tile tile : tiles) {
				tile.draw(graphToBack);
			}
			
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(ball.getX(), ball.getY(), 10, 10);
			ball = null;
			ball = new Ball(350, 250, 10, 10, Color.GREEN, 3, 3);
		}
		
		
		
		
		//TOP OR BOTTOM WALL
		
		if (didCollideTop() || didCollideBottom()) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		
		//LEFT OR RIGHT WALL
		
		if (didCollideRight() || didCollideLeft()) {
			ball.setXSpeed(-ball.getXSpeed());
		}

		//LEFT PADDLE COLLISION
		
		if (lCollide(leftPaddle)) {
			ball.setYSpeed(ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		//RIGHT PADDLE COLLISION
		
		if (rCollide(leftPaddle)) {
			ball.setYSpeed(ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
		} 
		
		//TOP PADDLE COLLISION
		
		if (tCollide(leftPaddle)) {
			ball.setYSpeed(-ball.getYSpeed());
			ball.setXSpeed(ball.getXSpeed());
		} 
		
		//BOTTOM PADDLE COLLISION
		
		if (bCollide(leftPaddle)) {
			ball.setYSpeed(-ball.getYSpeed());
			ball.setXSpeed(ball.getXSpeed());
		}		
	
		for (Tile tile : tiles) {
			if (lCollide(tile) || rCollide(tile)) {
				tile.draw(graphToBack, Color.WHITE);
				tiles.remove(tile);
				ball.setXSpeed(-ball.getXSpeed());
			}
		}
		
		for (Tile tile : tiles) {
			if (tCollide(tile) || bCollide(tile)) {
				tile.draw(graphToBack, Color.WHITE);
				tiles.remove(tile);
				ball.setYSpeed(-ball.getYSpeed());
			}
		}

		//see if the paddles need to be moved
		
		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[2] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		
		
		
		if(keys[1] == true)
		{
			//move left paddle left and draw it on the window
			leftPaddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			//move left paddle right and draw it on the window
			leftPaddle.moveRightAndDraw(graphToBack);

		}
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'A' : keys[1]=true; break;
			case 'S' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'A' : keys[1]=false; break;
			case 'S' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
   
   //Collision Detection
   public boolean didCollideLeft() {
	   if (ball.getX() < 1) {
		   return true;
	   }
	   return false;
   }
   
   public boolean didCollideRight() {
	   if (ball.getX() > 780) {
		   return true;
	   }
	   return false;
   }
   
   public boolean didCollideTop() {
	   if (ball.getY() < 1) {
		   return true;
	   }
	   return false;
   }
   
   public boolean didCollideBottom() {
	   if (ball.getY() > 780) {
		   return true;
	   }
	   return false;
   }
   
   
   
   //X AND Y ARE IN TOP LEFT AND DRAWS RIGHT AND DOWN!!!
   public boolean lCollide(Block n){
	   if(ball.getX() + 2*ball.getXSpeed() >= n.getX() && ball.getX() < n.getX() + n.getWidth() /2 && ball.getY() >= n.getY() && ball.getY() <=  n.getY() + n.getHeight())
			return true;
	   else
		   return false;
   }
   
   public boolean rCollide (Block n){
	   if(ball.getX() + 2*ball.getXSpeed() <= n.getX() + n.getWidth() && ball.getX() >= n.getX() + n.getWidth()/2 && ball.getY() >= n.getY() && ball.getY() <=  n.getY() + n.getHeight())
			return true;
	   else
		   return false;
   }
   
   public boolean tCollide(Block n){
	   if(ball.getY() + 2*ball.getYSpeed() >= n.getY() && ball.getY() <= n.getY() + n.getHeight()/2 && ball.getX() >= n.getX() && ball.getX() <=  n.getX() + n.getWidth())
			return true;
	   else
		   return false;
   }
   
   public boolean bCollide(Block n){
	   if(ball.getY() + 2*ball.getYSpeed() <= n.getY() + n.getHeight() && ball.getY() >= n.getY() + n.getHeight()/2 && ball.getX() >= n.getX() && ball.getX() <=  n.getX() + n.getWidth())
			return true;
	   else
		   return false;
   }
   
   public int rand() {
	   int output = (int)(Math.floor((Math.random()*7) - 3));
	   if (output >= -1 && output <=1) {
		   return 2;
	   } else {
		   return output;
	   }
   }
   
}