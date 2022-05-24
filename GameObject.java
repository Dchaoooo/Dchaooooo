package com.sxt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {
	//图片
	public Image img;
	//坐标
	public int x;
	public int y;
	//界面
	private GamePanel gamePanel;
	public GameObject(String img,int x,int y,GamePanel gamePanel) {
	this.img = Toolkit.getDefaultToolkit().getImage(img);//把图片换成img类型
	this.x = x;
	this.y = y;
	this.gamePanel = gamePanel;
	}
	//游戏元素需要的共同方法
	//（绘制方法）
   public abstract void paintSelft(Graphics g);
   //为了检测坦克和子弹有没有发生碰撞
   public abstract Rectangle gerRec();
public abstract void painSelf(Graphics g);
public abstract Rectangle getRec();
}