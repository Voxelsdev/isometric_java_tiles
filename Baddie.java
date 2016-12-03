import java.awt.Color;
import java.awt.Graphics;
/**
 * Baddies are there to fight the man
 * they do not have dangerous methods yet
 * @author Wind Lothamer
 *
 */
public class Baddie extends Man {
    //new field--the man that he must attack
    private Man man;
    public int TILE_SIZE;
    private int[][] data;
   
     /* Extend the man's constructor but add the man
     * @param xPos
     * @param yPos
     * @param size
     * @param color
     * @param map
     * @param man
     */
    public Baddie(int xPos, int yPos, int size, Color color, Map map, Man man){
        super(xPos, yPos, size, color, map);
        this.man = man;
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
        g.setColor(Color.blue);
		g.fillRect((int)xPos, (int)yPos, getSize(), getSize());
    }
    /**
     * find out which direction to move
     * to eat the man
     * @return -1, 0, 1 for dirX
     */
    public int checkDirX(){
        if(this.getXPos()>man.getXPos())
            return -1;
        else if(this.getXPos()<man.getXPos())
            return 1;
        return 0;
    }
    /**
     * find out which direction to move
     * to eat the man
     * @return -1, 0, 1 for dirY
     */
    public int checkDirY(){
        if(this.getYPos()>man.getYPos())
            return -1;
        else if(this.getYPos()<man.getYPos())
            return 1;
        return 0;
    }
}
