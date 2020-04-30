import java.awt.*;
public class Rock implements GameConstants{
    private int x;
    private int y;
    private int w;
    private int h;
    private static RandomGenerator RockPostion = new RandomGenerator(GWIDTH-300);
    private static RandomGenerator RockPostiony = new RandomGenerator(GHEIGHT-200);


    public void drawRock(Graphics g) {

//		g.setColor(this.color);
//		g.fillOval(x, y, w+10, h+10);
        Image image3 = Toolkit.getDefaultToolkit().getImage("./png/rock.png");
        g.drawImage(image3,x,y,w,h,null);
    }
    public Rock() {

        this.x = RockPostion.getRandom();
        this.y = RockPostiony.getRandom();
        this.w = this.h= 150;
    }




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
