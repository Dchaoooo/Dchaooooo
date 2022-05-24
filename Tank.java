package com.csy;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Tank extends GameObject{
	//定义坦克变量（尺寸）
	private int width = 40;
	private int height = 50;
	//坦克速度
	private int speed= 3;
			//坦克初始方向（向上）
	private	Direction direction = Direction.UP;
     //四个方向图片
	private String upImg;
	private String leftImg;
	private String rightImg;
	private String downImg;
	//坦克类的构造函数
	public Tank(String img, int x, int y, GamePanel gamePanel,
			String upImg,String leftImg, String rightImg,String downImg) {
		super(img,x,y,gamePanel);
		//给四个方向赋值
		this.upImg = upImg;
		this.leftImg = leftImg;
		this.rightImg = rightImg;
		this.downImg = downImg;
	}
	@Override
	//tank类的方法
	public abstract void painSelf(Graphics g);
	@Override
	//直接继承给父类，然后在继承给子类
	public abstract Rectangle getRec();
}
