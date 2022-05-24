package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Tank extends GameObject {
//̹�˳ߴ�
	public int width = 40;
	public int height = 50;
	//̹���ٶ�
	private int speed = 3;
	//̹�˷���
	private Direction direction = Direction.UP;
	//̹���ĸ������ͼƬ
	private String upimg;
	private String leftimg;
	private String rightimg;
	private String downimg;
	//̹���๹�캯��
	public Tank(String img,int x,int y,GamePanel gamePanel,String upImg,String leftImg,String rightImg,String downImg) {
		super(img,x,y,gamePanel);
		this.upimg = upImg;
		this.rightimg = rightImg;
		this.downimg = downImg;
	}
	@Override
	public abstract void painSelf(Graphics g);
	@Override
	public abstract Rectangle getRec();
}
