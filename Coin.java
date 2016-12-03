import java.awt.Color;
import java.awt.Graphics;
public class Coin {
	private int xPos, yPos, size;
	private Man man;
	private Map map;
	private Color color;
	public Coin(int xPos, int yPos, int size, Color color, Map map, Man man){
		this.xPos=xPos;
		this.yPos=yPos;
		this.size=size;
		this.color=color;
		this.map=map;
		this.man=man;
	}
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval((int)xPos, (int)yPos, size, size);
	}
	public void hitTest(){
		if(this.xPos+this.size>=(int)man.getXPos()&&this.xPos+this.size<=(int)(man.getXPos()+man.getSize())&&this.yPos+this.size>=(int)man.getYPos()&&this.yPos+this.size<=(int)(man.getYPos()+man.getSize())){
			this.xPos=-size;
			this.yPos=-size;
		}
	}
}
