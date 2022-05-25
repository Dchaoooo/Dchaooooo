package com.sxt;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Bot  extends Tank{
	int moveTime = 0;
	private Direction direction = randomDirection();

	public Bot(String img, int x, int y, GamePanel gamePanel, String upImg, String leftImg, String rightImg,
			String downImg) {
		super(img, x, y, gamePanel, upImg, leftImg, rightImg, downImg);
		// TODO �Զ����ɵĹ��캯�����
		 
	}
	public Direction randomDirection() {
        Random r = new Random();
        int rnum = r.nextInt(4);
        switch(rnum) {
            case 0:
                return Direction.UP;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.LEFT;
            default:
                return Direction.DOWN;
        }
    }
	
	public void go(){
		attack();
        if(moveTime>=20) {
            direction=randomDirection();
            moveTime=0;
        }else {
            moveTime+=1;
        }
        if(direction == null)
        	return;
        
        switch(direction) {
            case UP:
                upward();
                break;
            case DOWN:
                downward();
                break;
            case RIGHT:
                rightward();
                break;
            case LEFT:
                leftward();
                break;
        }
    }
	
	public void attack() {
		Point P = getHeadPoint();
		Random random = new Random();
		int rnum = random.nextInt(400);
		if(rnum < 4) {
			this.gamePanel.bulletList.add(new EnemyBullet("images/bulletYellow.gif",P.x,P.y,this.gamePanel,direction));
		}
	}
	@Override
	public void painSelf(Graphics g) {
		// TODO �Զ����ɵķ������
		g.drawImage(img,x,y,null);
		go();	
	}

	@Override
	public Rectangle getRec() {
		// TODO �Զ����ɵķ������
		return new Rectangle(x,y,width,height);
		
	}

	@Override
	public void paintSelft(Graphics g) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public Rectangle gerRec() {
		// TODO �Զ����ɵķ������
		return null;
	}
	

}
