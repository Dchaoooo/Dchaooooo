package com.tank;

public class Tank extends GameObject {
	//�ߴ�
	private int width = 40;
	private int height = 50;
	//�ٶ�
	private int speed = 3;
	//����
	private Direction direction = Direction.UP;
	//�ĸ������ͼƬ
	private String upImg;
	private String leftImg;
	private String rightImg;
	private String downImg;
	
	1
	public Tank(String img,int x,int y,GamePanel gamePanel,String upImg,String leftImg,
			String rightImg,String downImg,) {
		super(img, x, y, gamePanel);
		this.upImg = upImg;
		this.leftImg = leftImg;
		this.rightImg = rightImg;
		this.downImg = downImg;
	}
}
