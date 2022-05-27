package com.csy;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class GamePanel extends JFrame {
	static URL url;
	static AudioClip ac;
	private static final long serialVersionUID = 1L;
	private Image offScreenImage = null;
	// 游戏状态 0 游戏未开始，1 单人模式，2 双人模式， 3 游戏暂停， 4 游戏失败，5 游戏成功
	public int state = 0;
	// 临时变量
	private int a = 1;
	// 重绘次数
	public int count = 0;
	// 窗口长宽
	private int width = 1000;
	private int height = 800;
	// 敌人数量
	private int enemyCount = 0;
	// 高度
	private int y = 259;
	// 是否开始
	private boolean start = false;
	// 物体集合
	public List<Bullet> bulletList = new ArrayList<>();
	public List<Bot> botList = new ArrayList<>();
	public List<Tank> tankList = new ArrayList<>();
	public List<Wall> wallList = new ArrayList<>();
	public List<Grass> grassList = new ArrayList<>();
	public List<River> riverList = new ArrayList<>();
	public List<Bullet> removeList = new ArrayList<>();
	public List<Base> baseList = new ArrayList<>();
	public List<BlastObj> blastList = new ArrayList<>();
	// public List<Set> setList = new ArrayList<>();
	// 背景图片
	public Image background = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
//    private Image select = Toolkit.getDefaultToolkit().getImage("images/tank.png");
	// 指针图片
	private Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
	// 基地
	private Base base = new Base("images/star.gif", 455, 744, this);
	// 玩家
	private PlayerOne playerOne = new PlayerOne("images/p1tankU.gif", 125, 510, "images/p1tankU.gif",
			"images/p1tankD.gif", "images/p1tankL.gif", "images/p1tankR.gif", this);
	private PlayerTwo playerTwo = new PlayerTwo("images/p2tankU.gif", 825, 510, "images/p2tankU.gif",
			"images/p2tankD.gif", "images/p2tankL.gif", "images/p2tankR.gif", this);
//    private River river = new river("images/water.jpg", 500, 500, this);

	// 窗口的启动方法
	public void launch() {
		// 标题
		setTitle("坦克大战");
		// 窗口初始大小
		setSize(width, height);
		// 用户不能调整大小
		setResizable(false);
		// 使窗口可见
		setVisible(true);
		// 获取屏幕分辨率，使窗口生成时居中
		setLocationRelativeTo(null);
		// 添加关闭事件
		setDefaultCloseOperation(3);
		// 添加键盘事件
		this.addKeyListener(new GamePanel.KeyMonitor());
		// 添加围墙
		for (int i = 0; i < 18; i++) {
			wallList.add(new Wall("images/walls.gif", i * 60, 200, this));
		}
		// 竖墙
		for (int i = 0; i < 8; i++) {
			wallList.add(new Wall("images/walls.gif", 445, i * 60, this));
		}
		wallList.add(new Wall("images/walls.gif", 385, 730, this));
		wallList.add(new Wall("images/walls.gif", 385, 675, this));
		wallList.add(new Wall("images/walls.gif", 445, 675, this));
		wallList.add(new Wall("images/walls.gif", 505, 675, this));
		wallList.add(new Wall("images/walls.gif", 505, 730, this));
		wallList.add(new Wall("images/walls.gif", 445, 300, this));
		wallList.add(new Wall("images/walls.gif", 525, 375, this));
		wallList.add(new Wall("images/walls.gif", 575, 475, this));
		wallList.add(new Wall("images/walls.gif", 375, 375, this));
		wallList.add(new Wall("images/walls.gif", 325, 475, this));
		wallList.add(new Wall("images/walls.gif", 250, 550, this));
		wallList.add(new Wall("images/walls.gif", 690, 550, this));
//        for(int i = 0; i< 5; i ++){
//        	grassList.add(new Grass("images/grass.jpg", i*60 ,560, this ));
//        }
		grassList.add(new Grass("images/grass.jpg", 385, 475, this));
		grassList.add(new Grass("images/grass.jpg", 445, 475, this));
		grassList.add(new Grass("images/grass.jpg", 505, 475, this));
		grassList.add(new Grass("images/grass.jpg", 515, 475, this));
		grassList.add(new Grass("images/grass2.jpg", 10, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 70, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 130, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 190, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 750, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 810, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 870, 675, this));
		grassList.add(new Grass("images/grass2.jpg", 930, 675, this));
		for (int i = 0; i < 5; i++) {
			riverList.add(new River("images/water.jpg", i * 60, 300, this));
		}
		riverList.add(new River("images/water.jpg", 700, 300, this));
		riverList.add(new River("images/water.jpg", 760, 300, this));
		riverList.add(new River("images/water.jpg", 820, 300, this));
		riverList.add(new River("images/water.jpg", 880, 300, this));
		riverList.add(new River("images/water.jpg", 940, 300, this));
//       riverList.add(new River("images/water.jpg", 1000 ,300,this ));
//       riverList.add(new River("images/water.jpg", 525 ,300,this ));

		// 添加基地
		baseList.add(base);

		while (true) {
			if (botList.size() == 0 && enemyCount == 10) {
				state = 5;
			}
			if (tankList.size() == 0 && (state == 1 || state == 2)) {

				state = 4;
			}
			if (state == 1 || state == 2) {
				if (count % 100 == 1 && enemyCount < 10) {
					Random r = new Random();
					int rnum = r.nextInt(800);
					botList.add(new Bot("images/enemy1U.gif", rnum, 110, "images//enemy1U.gif", "images/enemy1D.gif",
							"images/enemy1L.gif", "images//enemy1R.gif", this));
					enemyCount++;
					// System.out.println("bot: " + botList.size());
				}
			}
			repaint();
			try {
				// 线程休眠 1秒 = 1000毫秒
				Thread.sleep(25);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		// System.out.println(bulletList.size());
		// System.out.println("tank"+tankList.size());
		// 创建和容器一样大小的Image图片
		if (offScreenImage == null) {
			offScreenImage = this.createImage(width, height);
		}
		// 获得该图片的画布
		Graphics gImage = offScreenImage.getGraphics();
		// 设置背景颜色
		gImage.setColor(Color.black);

		gImage.drawImage(GameUtils.bgImg, 0, 0, null);
		// 填充整个画布
//        gImage.fillRect(0, 0, width, height);
		// 改变画笔的颜色
		gImage.setFont(new Font("Brush Script MT", Font.BOLD, 80));
		gImage.setColor(Color.pink);

		if (state == 0) {
			// 添加文字
			gImage.drawString("TANK WAR", 285, 100);
			// 改变文字大小和样式
			gImage.setFont(new Font("方正舒体", Font.BOLD, 50));
			gImage.setColor(Color.white);
//        	gImage.drawString("TANK WAR",355,100);
			gImage.drawString("选择游戏模式", 300, 200);
			gImage.drawString("单人游戏", 355, 300);
			gImage.drawString("双人游戏", 355, 400);
			gImage.drawString("按1，2选择模式，按回车开始游戏", 70, 500);
			gImage.drawImage(select, 160, y, null);

		}

		else if (state == 1 || state == 2) {
			gImage.setColor(Color.white);
			gImage.setFont(new Font("仿宋", Font.BOLD, 20));
			gImage.drawString("剩余敌人：" + botList.size(), 10, 70);
			gImage.drawString("WASD控制移动", 50, 470);
			gImage.drawString("空格射击", 50, 500);
			if (state == 2) {
				gImage.drawString("方向键控制移动", 825, 470);
				gImage.drawString("K射击", 895, 500);
			}

			// paint重绘游戏元素
			for (Tank tank : tankList) {
				tank.paintSelf(gImage);
			}
			for (Bullet bullet : bulletList) {
				bullet.paintSelf(gImage);
			}
			bulletList.removeAll(removeList);
			for (Bot bot : botList) {
				bot.paintSelf(gImage);
			}
			for (Wall wall : wallList) {
				wall.paintSelf(gImage);
			}
			for (Grass grass : grassList) {
				grass.paintSelf(gImage);
			}
			for (Base base : baseList) {
				base.paintSelf(gImage);
			}
			for (BlastObj blast : blastList) {
				blast.paintSelf(gImage);
			}
			for (River river : riverList) {
				river.paintSelf(gImage);
			}
			// 重绘次数+1
			count++;
		} else if (state == 3) {
			gImage.drawString("THE GAME PAUSES", 300, 400);
		} else if (state == 4) {
			gImage.drawString("GAME OVER", 300, 400);
		} else if (state == 5) {
			gImage.drawString("VICTORY", 400, 400);
		}
		/** 将缓冲区绘制好的图形整个绘制到容器的画布中 */
		g.drawImage(offScreenImage, 0, 0, null);
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// super.keyPressed(e);
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_1:
				y = 260;
				a = 1;
				break;
			case KeyEvent.VK_2:
				y = 360;
				a = 2;
				break;
			case KeyEvent.VK_ENTER:
				state = a;
				// 添加玩家
				if (state == 1 && !start) {
					tankList.add(playerOne);
				} else {
					tankList.add(playerOne);
					tankList.add(playerTwo);
				}
				start = true;
				break;
			case KeyEvent.VK_P:
				if (state != 3) {
					a = state;
					state = 3;
				} else {
					state = a;
					if (a == 0) {
						a = 1;
					}
				}
				break;
			default:
				playerOne.keyPressed(e);
				playerTwo.keyPressed(e);
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			playerOne.keyReleased(e);
			playerTwo.keyReleased(e);
		}
	}

	public static void main(String[] args) throws MalformedURLException {
		File f1 = new File("audio\\ex.wav");
		url = f1.toURL();
		ac = Applet.newAudioClip(url);
		ac.loop();
		GamePanel gamePanel = new GamePanel();
		gamePanel.launch();
	}
}
