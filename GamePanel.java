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
	//定义双缓存图片
	Image offSImage =null;
	//游戏模式选择0 游戏未开始，1 单人模式，2 双人模式 
	 public int state = 0;
	 //游戏是否开始
	 private boolean start =false;
	 //临时变量
	 private int a = 1;
		//窗口长宽
		int width = 800;
		int height = 610;
		//指针图片
		Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
		//指针初始纵坐标
		int y = 150;
		private Object offSceeemImage;
		private Image offScreemImage;
	//窗口的启动方法
	public void launch() {
	//标题
	setTitle("靓女大战靓仔");
	//窗口的创始大小
	setSize(width,height);
	//使屏幕居中
	setLocationRelativeTo(null);
	//添加关闭事件
	setDefaultCloseOperation(3);
	//用户不能调整大小
	setResizable(false);
	//使窗口可见
	setVisible(true);
	//添加键盘监视器
	this.addKeyListener(new GamePanel.KeyMonitor());
	//重绘
	 while(true) {
		 repaint();
		 try {
			 Thread.sleep(25);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	}
	
	
	
	
	//paint()方法
	@Override
	public void paint (Graphics g) {       //可以向窗口里面添加文字图片 并修改字体颜色大小
		//创建和容器大小一样的Image图片
		if(offSceeemImage == null) {
			offScreemImage = this.createImage(width, height);
		}
		//获得该图片的画笔
		Graphics gImage = offScreemImage.getGraphics();
		
	//设置画笔大小
		gImage.setColor(Color.gray);
	//绘制实心矩形
		gImage.fillRect(0,0,width,height);
		//改变画笔颜色
		gImage.setColor(Color.blue);
		//改变文字大小和样式
		gImage.setFont(new Font( "仿宋",Font.BOLD,50));
		
		//state == 0,游戏未开始
		if(state == 0) {
			//添加文字
			gImage.drawString("选择游戏模式",220,100);
			gImage.drawString("单人模式",220,200);
			gImage.drawString("双人模式",220,300);
			//绘制指针
			gImage.drawImage(select, 160, y, null);
		}
		//state ==0/1,游戏开始
		else if(state == 1||state == 2) {
			g.drawString("游戏开始",220,100);
			if(state == 1) {
				gImage.drawString("单人模式",220,200);
			}
			else {
				gImage.drawString("双人模式",220,300);
			}
		}
		
		//将缓冲区绘制好的图形整个绘制到容器的画布中
		g.drawImage(offScreemImage, 0, 0, null);
	}
	
	
	
	//键盘监视器
	class KeyMonitor extends KeyAdapter{
		//按下键盘
		@Override
		public void keyPressed(KeyEvent e) {
			//返回键值
			
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
