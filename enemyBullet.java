package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

public class enemyBullet extends Bullet {

	public enemyBullet(String img, int x, int y, GamePanel gamePanel, Direction direction) {
		super(img, x, y, gamePanel, direction);
		// TODO 自动生成的构造函数存根
	}

	public void paintSelft(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		this.go();
	}

	public Rectangle gerRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}
	
}

