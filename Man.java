import java.awt.Color;
import java.awt.Graphics;
public class Man {
	private float xPos, yPos;
	private Color color;
	private int size;
	private Map map;
	public Man(int xPos, int yPos, int size, Color color, Map map){
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.color = color;
		this.map=map;
	}
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(500-this.size/2, 500-this.size/2, size, size);
	}
	public int getSize(){
		return this.size;
	}
	public float getXPos(){
		return this.xPos;
	}
	public float getYPos(){
		return this.yPos;
	}
	public void setXPos(int x){
		this.xPos = x;
	}
	public void setYPos(int y){
		this.yPos = y;
	}
	public Color getColor(){
	   return this.color; 
	}
	public boolean move(float dx, float dy) {
		// work out what the new position of this entity will be
		float newX = xPos + dx;
		float newY = yPos + dy;
		if (validLocation(newX, newY)) {
			// if it doesn't then change our position to the new position
			xPos =  newX;
			yPos =  newY;
			return true;
		}
		return false;
	}
	public boolean validLocation(float newX, float newY) {
		if (map.blocked(newY - 1, newX - 1)) {
			return false;
		}
		if (map.blocked(newY + size-1, newX - 1)) {
			return false;
		}
		if (map.blocked(newY - 1, newX + size-1)) {
			return false;
		}
		if (map.blocked(newY + size-1, newX + size-1)) {
			return false;
		}
		// if all the points checked are unblocked then we're in an ok
		// location
		return true;
	}
}
