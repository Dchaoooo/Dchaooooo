package Tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Blast extends GameObject{
//±¬Õ¨ˆD¼¯
	static Image[] imgs =new Image[10];
	int explodeCount = 0;
	static {
		for (int i=0; i<10; i++) {
			imgs[i] =Toolkit.getDefaultToolkit().getImage("images/blast/blast" +(i+1) + ".gif");
		}
	}
	public Blast(String img, int x, int y, GamePanel gamePanel){
      super(img, x, y, gamePanel);
  }
	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		if(explodeCount < 10) {
			g.drawImage(imgs[explodeCount], x, y, null);
			explodeCount++;
		}
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return null;
	}

}
