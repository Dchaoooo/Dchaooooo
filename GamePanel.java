package com.tank;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class GamePanel extends JFrame {
	//����˫����ͼƬ
	Image offSImage =null;
	//��Ϸģʽѡ��0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ 
	 public int state = 0;
	 //��Ϸ�Ƿ�ʼ
	 private boolean start =false;
	 //��ʱ����
	 private int a = 1;
		//���ڳ���
		int width = 800;
		int height = 610;
		//ָ��ͼƬ
		Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
		//ָ���ʼ������
		int y = 150;
		private Object offSceeemImage;
		private Image offScreemImage;
	//���ڵ���������
	public void launch() {
	//����
	setTitle("��Ů��ս����");
	//���ڵĴ�ʼ��С
	setSize(width,height);
	//ʹ��Ļ����
	setLocationRelativeTo(null);
	//��ӹر��¼�
	setDefaultCloseOperation(3);
	//�û����ܵ�����С
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
	
	
	
	
	//paint()����
	@Override
	public void paint (Graphics g) {       //�����򴰿������������ͼƬ ���޸�������ɫ��С
		//������������Сһ����ImageͼƬ
		if(offSceeemImage == null) {
			offScreemImage = this.createImage(width, height);
		}
		//��ø�ͼƬ�Ļ���
		Graphics gImage = offScreemImage.getGraphics();
		
	//���û��ʴ�С
		gImage.setColor(Color.gray);
	//����ʵ�ľ���
		gImage.fillRect(0,0,width,height);
		//�ı仭����ɫ
		gImage.setColor(Color.blue);
		//�ı����ִ�С����ʽ
		gImage.setFont(new Font( "����",Font.BOLD,50));
		
		//state == 0,��Ϸδ��ʼ
		if(state == 0) {
			//�������
			gImage.drawString("ѡ����Ϸģʽ",220,100);
			gImage.drawString("����ģʽ",220,200);
			gImage.drawString("˫��ģʽ",220,300);
			//����ָ��
			gImage.drawImage(select, 160, y, null);
		}
		//state ==0/1,��Ϸ��ʼ
		else if(state == 1||state == 2) {
			g.drawString("��Ϸ��ʼ",220,100);
			if(state == 1) {
				gImage.drawString("����ģʽ",220,200);
			}
			else {
				gImage.drawString("˫��ģʽ",220,300);
			}
		}
		
		//�����������ƺõ�ͼ���������Ƶ������Ļ�����
		g.drawImage(offScreemImage, 0, 0, null);
	}
	
	
	
	//���̼�����
	class KeyMonitor extends KeyAdapter{
		//���¼���
		@Override
		public void keyPressed(KeyEvent e) {
			//���ؼ�ֵ
			
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_1:
				a = 1;
				y = 150;
				break;

			case KeyEvent.VK_2:
				a=2;
				y=250;
				break;

			case KeyEvent.VK_ENTER:
				state = a;
				break;
			}
		}

	}
	
	
	
	//main
	public static void main(String[] args) {
		GamePanel gp = new GamePanel();
		gp.launch();
	}
}
