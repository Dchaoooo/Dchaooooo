package com.sxt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {
	//ͼƬ
	public Image img;
	//����
	public int x;
	public int y;
	//����
	private GamePanel gamePanel;
	public GameObject(String img,int x,int y,GamePanel gamePanel) {
	this.img = Toolkit.getDefaultToolkit().getImage(img);//��ͼƬ����img����
	this.x = x;
	this.y = y;
	this.gamePanel = gamePanel;
	}
	//��ϷԪ����Ҫ�Ĺ�ͬ����
	//�����Ʒ�����
   public abstract void paintSelft(Graphics g);
   //Ϊ�˼��̹�˺��ӵ���û�з�����ײ
   public abstract Rectangle gerRec();
public abstract void painSelf(Graphics g);
public abstract Rectangle getRec();
}