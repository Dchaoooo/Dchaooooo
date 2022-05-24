package com.csy;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
public abstract class GameObject {
	//�����Ϸ����ı���
//ͼƬ
	private Image img;
//��д��Ϸ����Ĺ��캯��
	public GameObject(String img, int x, int y , GamePanel gamePanel) {
		//��������ֵ(������image������Ϊstring����)
		this.img =Toolkit.getDefaultToolkit().getImage(img);
	}
	//���Ʒ�������ϷԪ����Ҫ�Ĺ�ͬ������
	public abstract void paintSelft(Graphics g);
	//����������εķ���
	public abstract Rectangle gerRec();
	public abstract void painSelf(Graphics g);
	public abstract Rectangle getRec();
}
