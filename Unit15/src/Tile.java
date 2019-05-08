import java.awt.Color;
import java.awt.Graphics;


public class Tile extends Block {
	
	private boolean visible;
	private String name;
	
	public Tile() {
		super();
		setWidth(80);
		setHeight(40);
		setColor(Color.BLUE);
	}
	
	public Tile(int x, int y) {
		super(x, y);
		setColor(Color.BLUE);
	}
	
	public Tile(int x, int y, int widt) {
		super(x, y, widt);
		setColor(Color.BLUE);
	}
	
	public Tile(int x, int y, int widt, int ht) {
		super(x, y, widt, ht);
		setColor(Color.BLUE);
	}
	
	public Tile(int x, int y, int widt, int ht, Color colr) {
		super(x, y, widt, ht, colr);
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVisible(boolean isVis) {
		visible = isVis;
	}
	
	public boolean getVisibile() {
		return visible;
	}
	
}