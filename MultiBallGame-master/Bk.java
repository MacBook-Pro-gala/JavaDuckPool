import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Bk extends JPanel implements GameConstants {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("./png/river6.jpg").getImage(),0,0,GWIDTH,GHEIGHT, null);

    }
}
