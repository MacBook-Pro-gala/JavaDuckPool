import java.awt.*;
public class lilies implements GameConstants{
    private int x;
    private int y;
    private int w;
    private int h;
    private static RandomGenerator liliesPostion = new RandomGenerator(GWIDTH-100);
    private static RandomGenerator liliesPostiony = new RandomGenerator(GHEIGHT-200);


    public void drawLilies(Graphics g) {

//		g.setColor(this.color);
//		g.fillOval(x, y, w+10, h+10);
        Image image2 = Toolkit.getDefaultToolkit().getImage("./png/haidiyuleipng-013.png");
        g.drawImage(image2,x,y,w,h,null);
    }
    public lilies() {

        this.x = liliesPostion.getRandom();
        this.y = liliesPostiony.getRandom();
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
