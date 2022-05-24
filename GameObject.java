package com.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {
	//Í¼Æ¬
	private Image img;
	//×ø±ê
	private int x;
	private int y;
	//½çÃæ
	private GamePanel gamePanel;
	public GameObject(String img,int x,int y,GamePanel gamePanel) {
		this.img = Toolkit.getDefaultToolkit().getImage(img);
		this.x = x;
		this.y = y;
		this.gamePanel = gamePanel;
	}
	public abstract void painSelft(Graphics g);
	
	public abstract Rectangle gerRec();
}
//