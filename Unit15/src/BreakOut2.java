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


public class BreakOut2 extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	//privateSpeedUpBall ball;
	//private BlinkyBall ball;
	
	private Paddle paddle;
	private boolean[] keys;
	private BufferedImage back;
	private Wall wallLeft;
	private Wall wallRight;
	private Wall wallTop;
	private Wall wallBottom;
	private Block[][] blocklist;
	private int points;
	

	public BreakOut2()
	{
		System.out.println("");
		//set up all variables related to the game
		ball = new Ball(300, 20, 10, 10, Color.BLACK, 3, 3);		
		paddle = new Paddle(700,300,30,100, Color.RED,5);
		
		blocklist=new Block[4][5];
		int i=0;
		while (i<4){
			int j=0;
			while (j<5){
				blocklist[i][j]=new Block(50*i+10, 120*j+10, 30,100, Color.GREEN);
				j++;
			}
			i++;
		}
		
		
		

		// set up walls
		wallLeft = new Wall(0,0,10,600);
		wallRight = new Wall(760,0,10,600);
		wallBottom = new Wall(20,530,800,20);
		wallTop = new Wall(20,0,800,20);
	
		
		keys = new boolean[4];

    
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
	
		paddle.draw(graphToBack);
		wallLeft.draw(graphToBack);
		wallRight.draw(graphToBack);
		wallTop.draw(graphToBack);
		wallBottom.draw(graphToBack);
		
		for (Block[] b: blocklist){
			for (Block block: b){
				block.draw(graphToBack);
			}
			
		}
		
		if (ball.didCollideLeft(wallLeft)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		
		if (ball.didCollideBottom(wallBottom) || ball.didCollideTop(wallTop))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideRight(wallRight)) {
			ball.setXSpeed(0);
			ball.setYSpeed(0);
	
			ball.draw(graphToBack, Color.WHITE);
	
			ball.setX(200);
			ball.setY(400);
			ball.setXSpeed(3);
			ball.setYSpeed(2);
			graphToBack.setColor(Color.WHITE);
			graphToBack.drawString("Points: "+points, 300, 500);
			graphToBack.setColor(Color.BLACK);
			points=0;
			graphToBack.drawString("Points: "+points, 300, 500);
			ball.draw(graphToBack, Color.BLACK);
			
		}
		if (ball.didCollideRight(paddle)){
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.didCollideTop(paddle) || ball.didCollideBottom(paddle)){
			ball.setYSpeed(-ball.getYSpeed());
		}
		graphToBack.drawString("Points: "+points, 300, 500);
		for (Block[] b: blocklist){
			for (Block block: b){
				if (ball.didCollideBottom(block)||ball.didCollideTop(block)||ball.didCollideLeft(block)){
					block.draw(graphToBack,Color.WHITE);
					block.setWidth(0);
					block.setHeight(0);
					
					ball.setXSpeed(-ball.getXSpeed());
					
					
					graphToBack.setColor(Color.WHITE);
					graphToBack.drawString("Points: "+points, 300, 500);
					graphToBack.setColor(Color.BLACK);
					points++;
					graphToBack.drawString("Points: "+points, 300, 500);
				}
			}
			
		}
		
		
		//see if the paddles need to be moved

		if (keys[0] == true)
		{
			//move left paddle up and draw it on the window
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			paddle.moveDownAndDraw(graphToBack);

		}

		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;

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
}
