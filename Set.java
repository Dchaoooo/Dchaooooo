package Tank;


import java.awt.*;

import javax.swing.ImageIcon;

	public class Set extends GameObject{
		 ImageIcon a= new ImageIcon("images/tank.png");
		 public void paint(Graphics g)
		 {
			 g.drawImage(a.getImage(), 0, 0, null);
		 }
	

    public int width = 90;
    public int height = 90;
    public Set(String img, int x, int y, GamePanel gamePanel){
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