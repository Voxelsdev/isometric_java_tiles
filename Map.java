import java.awt.Color;
import java.awt.Graphics;
public class Map {
    /** The value indicating a clear cell */
    private static final int CLEAR = 0;
    /** The value indicating a blocked cell */
    private static final int BLOCKED = 1;
    /** The rendered size of the tile (in pixels) */
    private Man man;
    public int TILE_SIZE;
    private int[][] data;
    private int tileXSize;
    private int tileYSize;
    public Map(int[][]data, int size) {
        this.data = data;
        this.TILE_SIZE = size;
        this.tileXSize = size*(3/2);
        this.tileYSize = size/2;
    }
    public void setMan(Man man){
        this.man = man;
    }
    public void setMap(int[][]data){
        this.data = data;
    }
    public void draw(Graphics g) {
        int offsetX = (int)(man.getXPos()-(man.getYPos()*2)+((data.length*tileXSize)-(739+man.getSize()))*-1);
        int offsetY = (int)(man.getYPos()+(man.getXPos()/2)+((data.length*tileYSize)+(93+man.getSize()))*-1);
        for (int y1=0;y1<data.length;y1++) {
            for (int x1=0;x1<data[0].length;x1++) {
                g.setColor(Color.darkGray);
                if (data[y1][x1] == BLOCKED)
                    g.setColor(Color.gray);
                int x = x1 - y1;
                int y = (x1 + y1) / 2;
                int yShift = 0;
                int xShift = 0;
                if((x1+y1)%2==1)
                     yShift = TILE_SIZE/2;
                int[] xPoints={x*TILE_SIZE-offsetX-TILE_SIZE/2+xShift, x*TILE_SIZE-offsetX+TILE_SIZE/2+xShift, (x*TILE_SIZE-offsetX)+TILE_SIZE+TILE_SIZE/2+xShift,(x*TILE_SIZE-offsetX)+TILE_SIZE/2+xShift};
                int[] yPoints={y*TILE_SIZE-offsetY+TILE_SIZE/2+yShift, y*TILE_SIZE-offsetY+TILE_SIZE+yShift, y*TILE_SIZE-offsetY+TILE_SIZE/2+yShift, y*TILE_SIZE-offsetY+yShift};
                g.fillPolygon(xPoints, yPoints, 4);
                g.setColor(g.getColor().darker());
                g.drawPolygon(xPoints, yPoints, 4);
            }
        }
    }
    public boolean blocked(float x, float y) {
        return data[(int) x/TILE_SIZE][(int) y/TILE_SIZE] == BLOCKED;
    }
    public int getTileSize(){
        return this.TILE_SIZE;
    }
}