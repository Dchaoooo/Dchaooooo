package com.sxt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GamePanel extends JFrame{
	//����˫����ͼƬ
	Image offScreemImage = null;
  //���ڳ���
	int width = 800;
	int height = 610;
	//ָ��ͼƬ
	Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
	//ָ���ʼ������
	int y = 150;
	//��Ϸ״̬ 0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ
	int state = 0;
	//��Ϸ�Ƿ�ʼ
	private boolean start = false;
	//��ʱ����
	private int a = 1;
	//playerOne
	Playerone playerOne = new Playerone("images/player1/p1tankU.gif",125,510,this,
			"images/player1/p1tankU.gif","images/player1/p1tankL.gif",
			"images/player1/p1tankR.gif","images/player1/p1tankD.gif");
 //���ڵ����÷���
	public void launch() {
	//����
		setTitle("��Ů����̹�˴�ս");
   //���ڳ�ʼ��С
		setSize(width,height);
   //ʹ��Ļ����
		setLocationRelativeTo(null);
   //��ӹر�ʱ��
		setDefaultCloseOperation(3);
   //�û����ܵ��ڴ�С
		setResizable(false);
  //ʹ���ڿɼ�
		setVisible(true);
		//��Ӽ��̼�����
		this.addKeyListener(new GamePanel.KeyMonitor());
		//�ػ�
		while(true) {
			repaint();
			try {
				Thread.sleep(25);
			}catch(Exception e) {
				e.printStackTrace();
			}
		  }
		}
	//paint����
	@Override
	public void paint(Graphics g) {
		//����������һ����ImageͼƬ
		if(offScreemImage == null) {
			offScreemImage = this.createImage(width,height);
		}
		//��ø�ͼƬ�Ļ���
		Graphics gImage = offScreemImage.getGraphics();
		//���ñ�����ɫ
		gImage.setColor(Color.gray);
		//����ʵ�ľ���	�����������
		gImage.fillRect(0, 0, width, height);
		//�ı仭����ɫ
		gImage.setColor(Color.blue);
		//�ı����ִ�С����ʽ
		gImage.setFont(new Font("����",Font.BOLD,50));
		
		//state == 0,��Ϸδ��ʼ
		if(state ==0) {
			//�������
			gImage.drawString("ѡ����Ϸģʽ", 220, 100);
			gImage.drawString("����ģʽ", 220, 200);
			gImage.drawString("˫��ģʽ", 220,300);
			gImage.drawString("��1��2ѡ��ģʽ�����س���ʼ��Ϸ", 0,400);
			//����ָ��
			gImage.drawImage(select, 160, y, null);
		}
		//state == 0/1,��Ϸ��ʼ
		else if(state == 1 || state == 2) {
			gImage.drawString("��Ϸ��ʼ",220,100);
			if(state == 1) {
				gImage.drawString("����ģʽ",220,200);
				}
			else {
				gImage.drawString("˫��ģʽ",220,200);
			}
			//���Ԫ��
		Playerone.paintSelf(gImage);
		}
		/**�����������ƺõ�ͼ���������Ƶ������Ļ�����*/
		g.drawImage(offScreemImage,0,0,null);
	}
	//���̼�����
	private class KeyMonitor extends KeyAdapter{
		//���¼���
		@Override
		public void keyPressed(KeyEvent e ) {
			//���ؼ�ֵ
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_1:
				a = 1;
				y = 150;
				break;
			case KeyEvent.VK_2:
				a = 2;
				y = 250;
				break;
			case KeyEvent.VK_ENTER:
				state = a; 
				break;
			}
			System.out.println(e.getKeyChar());
		}
		
	}
	
//main
	public static void main(String[] args) {
		GamePanel gp = new GamePanel();
		gp.launch();
	}
	
}
