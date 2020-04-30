import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//import Logic.CastImage;

public class maobolibk extends JPanel {

    private BufferedImage background;

    private float transparency;


    public maobolibk(){
        this.transparency= (float) 0.4; //阿尔法透明度
        try {
            background = ImageIO.read(ImageIO.createImageInputStream(new File("./png/river6.jpg")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**这个方法用来设置JPanel的透明度
     *
     * @param transparency:透明度
     *
     * @return void
     */
    public void setTransparent(float transparency) {
        this.transparency = transparency;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g.create();

        graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));

        graphics2d.setColor(Color.white);

        graphics2d.drawImage(background, 0, 0, this);//这里如果使用Image的对象，而不是BufferedImage的对象，是绘制不出来的，不知道为何。

        graphics2d.dispose();
    }

}