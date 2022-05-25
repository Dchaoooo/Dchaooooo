package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	//尺寸
	int width = 10;
	int hight = 10;
	//速度
	int speed = 7;
	//方向
   Direction direction;
	public Bullet(String img, int x, int y, GamePanel gamePanel,Direction direction) {
		super(img, x, y, gamePanel);
		this.direction = direction;
		// TODO Auto-generated constructor stub
	}
	public void leftward() {
		x -= speed;
	}
	public void rightward() {
		x += speed;
	}
	public void upward() {
		y -= speed;
	}
	public void downward() {
		y += speed;
	}
	//新写方法go
	public void go() {
	switch(direction) {
	case LEFT:
		leftward();
		break;
	case RIGHT:
		rightward();
		break;
	case UP:
		upward();
		break;
	case DOWN:
		downward();
		break;
	}
	}
	
	@Override
	public void paintSelft(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		this.go();
	}
	@Override
	public Rectangle gerRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,width,height);
	}
	@Override
	public void painSelf(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return null;
	}

}