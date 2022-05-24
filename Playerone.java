package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

//继承坦克
public class Playerone extends Tank{

	public Playerone(String img, int x, int y, GamePanel gamePanel, String upImg, String leftImg, String rightImg,
			String downImg) {
		super(img, x, y, gamePanel, upImg, leftImg, rightImg, downImg);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void painSelf(Graphics g) {
		// TODO 自动生成的方法存根
		g.drawImage(img, x, y, null);
	}

	@Override
	public Rectangle getRec() {
		// TODO 自动生成的方法存根
		return new Rectangle(x, y, width, height);
	}

	@Override
	public void paintSelft(Graphics g) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Rectangle gerRec() {
		// TODO 自动生成的方法存根
		return null;
	}

	public static void paintSelf(Graphics gImage) {
		// TODO 自动生成的方法存根
		
	}

	
	
}

	
