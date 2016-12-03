import java.awt.Color;
import java.awt.Graphics;
public class ShootingBaddie extends Man
{
    private Man man;
    public int TILE_SIZE;
    private int[][] data;
    private double distanceFromMan;
    public ShootingBaddie(int xPos, int yPos, int size, Color color, Map map, Man man)
    {
        super(xPos, yPos, size, color, map);
        this.man = man;
        distanceFromMan = Math.sqrt((xPos-man.getXPos())*(xPos-man.getXPos()) + (yPos-man.getYPos())*(yPos-man.getYPos()));
    }
    public void setMan(Man man)
    {
        this.man = man;
    }
    public void draw(Graphics g) {
        int offsetX = (int)(man.getXPos()+(250-man.getSize()/2)*-1);
        int offsetY = (int)(man.getYPos()+(250-man.getSize()/2)*-1);
        float xPos = this.getXPos()-offsetX;
        float yPos = this.getYPos()-offsetY;
        g.setColor(Color.cyan);
		g.fillRect((int)xPos, (int)yPos, getSize(), getSize());
    }
    public int checkDirX(){
        return 0;
    }
    public int checkDirY(){
        return 0;
    }
    public boolean isShootable(int tileSize){
        if(distanceFromMan<= 5*tileSize)
        {
            return true;   
        }
        return false;
    }
}
