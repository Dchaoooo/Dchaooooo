package com.sxt;

import java.awt.Graphics;
import java.awt.Rectangle;

//�̳�̹��
public class Playerone extends Tank{

	public Playerone(String img, int x, int y, GamePanel gamePanel, String upImg, String leftImg, String rightImg,
			String downImg) {
		super(img, x, y, gamePanel, upImg, leftImg, rightImg, downImg);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void painSelf(Graphics g) {
		// TODO �Զ����ɵķ������
		g.drawImage(img, x, y, null);
	}

	@Override
	public Rectangle getRec() {
		// TODO �Զ����ɵķ������
		return new Rectangle(x, y, width, height);
	}

	@Override
	public void paintSelft(Graphics g) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public Rectangle gerRec() {
		// TODO �Զ����ɵķ������
		return null;
	}

	public static void paintSelf(Graphics gImage) {
		// TODO �Զ����ɵķ������
		
	}

	
	
}

	
