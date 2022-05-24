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
	//定义双缓存图片
	Image offScreemImage = null;
	//添加游戏模式 0 游戏未开始，1 单人模式，2 双人模式
     int state = 0;
	//游戏是否开始
	private boolean start = false;
	//临时变量
	 int a = 1;
//窗口尺寸
	 int width = 800;
	 int height = 610;
//指针图片
	 Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
//指针初始纵坐标
     int y=150;
//窗口启动方法
    public void lanuch() {
	//标题
	setTitle("坦克大战");
	//窗口初始大小
	setSize(width,height);
	//使屏幕居中
	setLocationRelativeTo(null);
	//添加关闭事件
	setDefaultCloseOperation(3);
	//用户不能调整大小
	setResizable(false);
	//使窗口可见
	setVisible(true);
	//给窗口添加键盘监视器
	this.addKeyListener(new GamePanel.KeyMonitor());
	//重绘
	while(true) {
		repaint();
		try {
			//线程休眠 1秒 = 1000毫秒
			Thread.sleep(25);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

//首先创建Paint（）方法
@ Override
public void paint (Graphics g) {
	//创建和容器一样大小的Image图片
	if(offScreemImage == null) {
		offScreemImage = this.createImage(width, height);
	}
	//获得该图片的画布
	Graphics gImage = offScreemImage.getGraphics();
	//设置背景颜色（默认黑色）
	gImage.setColor(Color.gray);
	//为窗口添加背景（绘制实心矩形，然后填充整个画布）
	gImage.fillRect(0, 0, width, height);
	//改变画笔颜色，让它和背景颜色区分开
	gImage.setColor(Color.blue);
	//改变文字大小和样式
	gImage.setFont(new Font ("仿宋",Font.BOLD,50));
	//state = 0,游戏未开始；
	if(state == 0) {
		//添加文字
		gImage.drawString("选择游戏模式", 220, 100);
		gImage.drawString("单人模式", 220, 200);
		gImage.drawString("双人模式", 220, 300);
		gImage.drawString("按1，2选择模式,按回车开始游戏", 0,400);
		//绘制指针
		gImage.drawImage(select, 160, y, null);
	}
	//state ==0/1,游戏开始;
	else if (state == 1 || state == 2) {
		gImage.drawString("游戏开始", 220, 100);
	if (state == 1) {
		gImage.drawString("单人模式", 220, 200);
	}
	else {
		gImage.drawString("双人模式", 220, 200);
		}
	}//将缓存区绘制好的图形整个绘制到容器的画布中
	g.drawImage(offScreemImage, 0, 0, null);
}
//编写键盘监视器
private class KeyMonitor extends KeyAdapter{
//按下键盘
	@Override
	public void keyPressed(KeyEvent e) {
		//返回键值（输出按键）
		int key = e.getKeyCode();
		//通过switch方法来判断按键1的键值
		switch(key) {
		case KeyEvent.VK_1://按键1的键值
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
	//添加main方法
	public static void main(String[] args) {
		GamePanel gamePanel = new GamePanel();
		gamePanel.lanuch();
	}
  }





