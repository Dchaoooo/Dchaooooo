package com.csy;

import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullet extends Bullet{

	public EnemyBullet(String img, int x, int y, GamePanel gamePanel, Direction direction) {
		super(img, x, y, gamePanel, direction);
	}
	/*public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
		this.go();
	}
public Rectangle getRec() {
	return new Rectangle(x,y,width,height);*/
	 public void hitPlayer(){
	        Rectangle next= this.getRec();
	        java.util.List<Tank> tanks = this.gamePanel.tankList;
	        //×Óµ¯ºÍTank
	        for(Tank tank: tanks){
	            if(tank.getRec().intersects(next)){
	                System.out.println("hit tank");
	                tank.alive = false;
	                this.gamePanel.tankList.remove(tank);
	                this.gamePanel.removeList.add(this);
	                break;
	            }
}
}
	 public void paintSelf(Graphics g){
	        g.drawImage(img, x, y, null);
	        go();
	        hitPlayer();
	    }
	}
