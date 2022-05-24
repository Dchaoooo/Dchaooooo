package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Tank extends GameObject {
//坦克尺寸
	public int width = 40;
	public int height = 50;
	//坦克速度
	private int speed = 3;
	//坦克方向
	private Direction direction = Direction.UP;
	//坦克四个方向的图片
	private String upimg;
	private String leftimg;
	private String rightimg;
	private String downimg;
	//坦克类构造函数
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
