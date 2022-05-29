package Tank;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Grass extends GameObject {

    public int width = 70;
    public int height = 70;
    public Grass(String img, int x, int y, GamePanel gamePanel){
        super(img, x, y, gamePanel);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
