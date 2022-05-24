package com.csy;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Tank extends GameObject{
	//����̹�˱������ߴ磩
	private int width = 40;
	private int height = 50;
	//̹���ٶ�
	private int speed= 3;
			//̹�˳�ʼ�������ϣ�
	private	Direction direction = Direction.UP;
     //�ĸ�����ͼƬ
	private String upImg;
	private String leftImg;
	private String rightImg;
	private String downImg;
	//̹����Ĺ��캯��
	public Tank(String img, int x, int y, GamePanel gamePanel,
			String upImg,String leftImg, String rightImg,String downImg) {
		super(img,x,y,gamePanel);
		//���ĸ�����ֵ
		this.upImg = upImg;
		this.leftImg = leftImg;
		this.rightImg = rightImg;
		this.downImg = downImg;
	}
	@Override
	//tank��ķ���
	public abstract void painSelf(Graphics g);
	@Override
	//ֱ�Ӽ̳и����࣬Ȼ���ڼ̳и�����
	public abstract Rectangle getRec();
}
