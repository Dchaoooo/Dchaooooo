# Dchaooooo
这是仅供凯里学院大数据工程学院20计科本1班的代常豪、崔松原、付婷丽三位同学上传代码滴repository
package com.tank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public abstract class GameObject {
	//图片
	private Image img;
	//坐标
	private int x;
	private int y;
	//界面
	private GamePanel gamePanel;
	public GameObject(String img,int x,int y,GamePanel gamePanel) {
		this.img = Toolkit.getDefaultToolkit().getImage(img);
		this.x = x;
		this.y = y;
		this.gamePanel = gamePanel;
	}
	public abstract void painSelft(Graphics g);
	
	public abstract Rectangle gerRec();
}
//
