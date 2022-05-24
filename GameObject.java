package com.csy;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
public abstract class GameObject {
	//添加游戏父类的变量
//图片
	private Image img;
//编写游戏父类的构造函数
	public GameObject(String img, int x, int y , GamePanel gamePanel) {
		//给变量赋值(类型是image，参数为string类型)
		this.img =Toolkit.getDefaultToolkit().getImage(img);
	}
	//绘制方法（游戏元素需要的共同方法）
	public abstract void paintSelft(Graphics g);
	//返回自身矩形的方法
	public abstract Rectangle gerRec();
	public abstract void painSelf(Graphics g);
	public abstract Rectangle getRec();
}
