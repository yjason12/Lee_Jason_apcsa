import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int count =0;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	
	Random rand = new Random();

	public Breakout()
	{
		
		ball = new Ball(600,200,10,10,Color.BLUE,3,2);
		paddle = new Paddle(400, 400, 40, 40,Color.BLUE,3);

		keys = new boolean[4];
		
		
		//left
		for (int x = 5; x < 85; x += 40)
		{
			for (int y = 5 ; y < 550 ; y += 80)
			{
				blocks.add(new Block(x, y, 35, 75, Color.RED));
			}
		}
		
		//right
		for (int x = 685; x < 750 ; x += 80)
		{
			for (int y = 5 ; y < 550 ; y += 80)
			{
				blocks.add(new Block(x, y, 35, 75, Color.RED));
			}
		}

		for (int x = 645; x < 720 ; x += 80)
		{
			for (int y = 5 ; y < 550 ; y += 80)
			{
				blocks.add(new Block(x, y, 35, 75, Color.RED));
			}
		}
		
		//top
		for (int x = 85; x < 600 ; x += 80)
		{
			for (int y = 5 ; y < 85 ; y += 40)
			{
				blocks.add(new Block(x, y, 75, 35, Color.RED));
			}
		}
		
		//bottom
		for (int x = 85; x < 600 ; x += 80)
		{
			for (int y = 525 ; y > 445 ; y -= 40)
			{
				blocks.add(new Block(x, y, 75, 35, Color.RED));
			}
		}
		
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		Graphics2D twoDGraph = (Graphics2D)window;


		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		
		for (Block b : blocks)
			b.draw(graphToBack);
		
		graphToBack.setColor(Color.BLUE);
		//graphToBack.drawString("SCOREBOARD",350,80);

		if (ball.getX() < 0)
		{
			ball.setXSpeed(Math.abs(ball.getXSpeed()));
		}
		else if (ball.getX() > getWidth())
		{
			ball.setXSpeed(-1 * Math.abs(ball.getXSpeed()));
		}
		if (ball.getY() < 0)
		{
			ball.setYSpeed(Math.abs(ball.getYSpeed()));
		}
		
		else if (ball.getY() > getHeight())
		{
			ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
		}

		if (ball.didCollideLeft(paddle))
		{
			ball.setXSpeed(Math.abs(ball.getXSpeed()));
		}
		if (ball.didCollideRight(paddle))
		{
			ball.setXSpeed(-1 * Math.abs(ball.getXSpeed()));
		}
		if (ball.didCollideBottom(paddle))
		{
			ball.setYSpeed(Math.abs(ball.getYSpeed()));
		}
		if (ball.didCollideTop(paddle))
		{
			ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
		}
		
		for (Block b : blocks)
		{
			if (ball.didCollideLeft(b) || ball.didCollideRight(b))
			{
				b.setColor(Color.WHITE);
				b.draw(graphToBack);
				blocks.remove(b);
				ball.setXSpeed(-1 * ball.getXSpeed());
				count++;
				checkRestart();
			}
			
			else if (ball.didCollideTop(b) || ball.didCollideBottom(b))
			{
				b.setColor(Color.WHITE);
				b.draw(graphToBack);
				blocks.remove(b);
				ball.setYSpeed(-1 * ball.getYSpeed());
				count++;
				checkRestart();
			}
		}
		

		if(keys[0] == true && paddle.getY() > 85)
		{
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true && paddle.getY() < 440)
		{
			paddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true && paddle.getX() > 85)
		{
			paddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[3] == true && paddle.getX() < 600)
		{
			paddle.moveRightAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'A' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'A' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
	
	public void checkRestart()
	{
		if (count == 56)
		{
			for (int x = 5; x < 85; x += 40)
			{
				for (int y = 5 ; y < 550 ; y += 80)
				{
					blocks.add(new Block(x, y, 35, 75, Color.RED));
				}
			}
			
			//right
			for (int x = 685; x < 750 ; x += 80)
			{
				for (int y = 5 ; y < 550 ; y += 80)
				{
					blocks.add(new Block(x, y, 35, 75, Color.RED));
				}
			}

			for (int x = 645; x < 720 ; x += 80)
			{
				for (int y = 5 ; y < 550 ; y += 80)
				{
					blocks.add(new Block(x, y, 35, 75, Color.RED));
				}
			}
			
			//top
			for (int x = 85; x < 600 ; x += 80)
			{
				for (int y = 5 ; y < 85 ; y += 40)
				{
					blocks.add(new Block(x, y, 75, 35, Color.RED));
				}
			}
			
			//bottom
			for (int x = 85; x < 600 ; x += 80)
			{
				for (int y = 525 ; y > 445 ; y -= 40)
				{
					blocks.add(new Block(x, y, 75, 35, Color.RED));
				}
			}
		}
	}
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
}