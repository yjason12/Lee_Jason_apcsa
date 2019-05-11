import java.awt.Color;
import java.awt.Graphics;

public class Paddle2 extends Block
{
   //instance variables
   private int speed;

   public Paddle2()
   {
	   super(10,10);
	   speed =5;
   }


   //add the other Paddle constructors
   public Paddle2(int x, int y) {
	   super(x, y);
	   speed = 5;
   }
   
   public Paddle2(int x, int y, int widt) {
	   super(x, y, widt);
	   speed = 5;
   }
   
   public Paddle2(int x, int y, int widt, int ht) {
	   super(x, y, widt, ht);
	   speed = 5;
   }
   
   public Paddle2(int x, int y, int widt, int ht, Color col) {
	   super(x, y, widt, ht, col);
	   speed = 5;
   }
   
   public Paddle2(int x, int y, int widt, int ht, Color col, int spd) {
	   super(x, y, widt, ht, col);
	   speed = spd;
   }
   
   public Paddle2(int x, int y, int widt, int ht, int spd) {
	   super(x, y, widt, ht);
	   speed = spd;
   }





   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.GRAY);
	   this.setY(this.getY()-getSpeed());
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.GRAY);
	   this.setY(this.getY()+getSpeed());
	   draw(window);

   }
   
   public void moveLeftAndDraw(Graphics window)
   {
	   draw(window, Color.GRAY);
	   this.setX(this.getX()-getSpeed());
	   draw(window);

   }

   public void moveRightAndDraw(Graphics window)
   {
	   draw(window, Color.GRAY);
	   this.setX(this.getX()+getSpeed());
	   draw(window);

   }

   //add get methods
   
   public int getSpeed() {
	   return speed;
   }
   
   
   //add a toString() method
   public String toString() {
	   String output = "" + super.toString() + " " + getSpeed();
	   return output;
   }
   
}