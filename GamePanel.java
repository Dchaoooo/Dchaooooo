package com.csy;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
public class GamePanel extends JFrame {
	
	public static Object gamePanel;
	//����˫����ͼƬ
	Image offScreemImage = null;
	//�����Ϸģʽ 0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ
     int state = 0;
	//��Ϸ�Ƿ�ʼ
	private boolean start = false;
	//��ʱ����
	 int a = 1;
//���ڳߴ�
	 int width = 800;
	 int height = 610;
//ָ��ͼƬ
	 Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
//ָ���ʼ������
     int y=150;
//������������
    public void lanuch() {
	//����
	setTitle("̹�˴�ս");
	//���ڳ�ʼ��С
	setSize(width,height);
	//ʹ��Ļ����
	setLocationRelativeTo(null);
	//��ӹر��¼�
	setDefaultCloseOperation(3);
	//�û����ܵ�����С
	setResizable(false);
	//ʹ���ڿɼ�
	setVisible(true);
	//��������Ӽ��̼�����
	this.addKeyListener(new GamePanel.KeyMonitor());
	//�ػ�
	while(true) {
		repaint();
		try {
			//�߳����� 1�� = 1000����
			Thread.sleep(25);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

//���ȴ���Paint��������
@ Override
public void paint (Graphics g) {
	//����������һ����С��ImageͼƬ
	if(offScreemImage == null) {
		offScreemImage = this.createImage(width, height);
	}
	//��ø�ͼƬ�Ļ���
	Graphics gImage = offScreemImage.getGraphics();
	//���ñ�����ɫ��Ĭ�Ϻ�ɫ��
	gImage.setColor(Color.gray);
	//Ϊ������ӱ���������ʵ�ľ��Σ�Ȼ���������������
	gImage.fillRect(0, 0, width, height);
	//�ı仭����ɫ�������ͱ�����ɫ���ֿ�
	gImage.setColor(Color.blue);
	//�ı����ִ�С����ʽ
	gImage.setFont(new Font ("����",Font.BOLD,50));
	//state = 0,��Ϸδ��ʼ��
	if(state == 0) {
		//�������
		gImage.drawString("ѡ����Ϸģʽ", 220, 100);
		gImage.drawString("����ģʽ", 220, 200);
		gImage.drawString("˫��ģʽ", 220, 300);
		gImage.drawString("��1��2ѡ��ģʽ,���س���ʼ��Ϸ", 0,400);
		//����ָ��
		gImage.drawImage(select, 160, y, null);
	}
	//state ==0/1,��Ϸ��ʼ;
	else if (state == 1 || state == 2) {
		gImage.drawString("��Ϸ��ʼ", 220, 100);
	if (state == 1) {
		gImage.drawString("����ģʽ", 220, 200);
	}
	else {
		gImage.drawString("˫��ģʽ", 220, 200);
		}
	}//�����������ƺõ�ͼ���������Ƶ������Ļ�����
	g.drawImage(offScreemImage, 0, 0, null);
}
//��д���̼�����
private class KeyMonitor extends KeyAdapter{
//���¼���
	@Override
	public void keyPressed(KeyEvent e) {
		//���ؼ�ֵ�����������
		int key = e.getKeyCode();
		//ͨ��switch�������жϰ���1�ļ�ֵ
		switch(key) {
		case KeyEvent.VK_1://����1�ļ�ֵ
		a=1;
		y=150;
		break;
		case KeyEvent.VK_2:
		a=2;
		y=250;
		break;
		case KeyEvent.VK_ENTER:
		state = a;
		break;
		}
		System.out.print(e.getKeyChar());
	}
	}
	//���main����
	public static void main(String[] args) {
		GamePanel gamePanel = new GamePanel();
		gamePanel.lanuch();
	}
  }





