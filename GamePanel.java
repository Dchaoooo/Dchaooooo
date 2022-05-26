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
	static AudioClip ac;private static final long serialVersionUID = 1L;

    /** ����˫����ͼƬ */
    private Image offScreenImage = null;
    //��Ϸ״̬ 0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ�� 3 ��Ϸ��ͣ�� 4 ��Ϸʧ�ܣ�5 ��Ϸ�ɹ�
    public int state= 0;
    //��ʱ����
    private int a = 1;
    //�ػ����
    public int count = 0;
    //���ڳ���
    private int width = 1000;
    private int height = 800;
    //��������
    private int enemyCount = 0;
    //�߶�
    private int y = 170;
    //�Ƿ�ʼ
    private boolean start = false;
    //���弯��
    public List<Bullet> bulletList = new ArrayList<>();
    public List<Bot> botList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();
    public List<Wall> wallList = new ArrayList<>();
    public List<Grass> grassList = new ArrayList<>();
    public List<Bullet> removeList = new ArrayList<>();
    public List<Base> baseList = new ArrayList<>();
    public List<BlastObj> blastList = new ArrayList<>();
    //public List<Set> setList = new ArrayList<>();
    public List<Blood> bloodList = new ArrayList<>();
    //����ͼƬ
    public Image background = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
//    private Image select = Toolkit.getDefaultToolkit().getImage("images/tank.png");
    //ָ��ͼƬ
    private Image select = Toolkit.getDefaultToolkit().getImage("images/selecttank.gif");
    //����
    private Base base = new Base("images/star.gif", 455, 744, this);
    //���
    private PlayerOne playerOne = new PlayerOne("images/p1tankU.gif", 125, 510,
            "images/p1tankU.gif","images/p1tankD.gif",
            "images/p1tankL.gif","images/p1tankR.gif", this);
    private PlayerTwo playerTwo = new PlayerTwo("images/p2tankU.gif", 825, 510,
            "images/p2tankU.gif","images/p2tankD.gif",
            "images/p2tankL.gif","images/p2tankR.gif", this);
    //private Set set = new Set("images/tank.png", 500, 500, this);
 

    //���ڵ���������
    public void launch(){
        //����
        setTitle("̹�˴�ս");
        //���ڳ�ʼ��С
        setSize(width, height);
        //�û����ܵ�����С
        setResizable(false);
        //ʹ���ڿɼ�
        setVisible(true);
        //��ȡ��Ļ�ֱ��ʣ�ʹ��������ʱ����
        setLocationRelativeTo(null);
        //��ӹر��¼�
        setDefaultCloseOperation(3);
        //��Ӽ����¼�
        this.addKeyListener(new GamePanel.KeyMonitor());
        //���Χǽ
        for(int i = 0; i< 18; i ++){
            wallList.add(new Wall("images/walls.gif", i*60 ,200, this ));
        }
        for(int i = 0; i< 8; i ++){
            wallList.add(new Wall("images/walls.gif", 445 ,i*60, this ));
        }
        wallList.add(new Wall("images/walls.gif", 385 ,730,this ));
        wallList.add(new Wall("images/walls.gif", 385 ,675,this ));
        wallList.add(new Wall("images/walls.gif", 445 ,675,this ));
        wallList.add(new Wall("images/walls.gif", 505 ,675,this ));
        wallList.add(new Wall("images/walls.gif", 505 ,730,this ));
        wallList.add(new Wall("images/walls.gif", 445 ,300,this ));
        wallList.add(new Wall("images/walls.gif", 525 ,375,this ));
        wallList.add(new Wall("images/walls.gif", 575 ,475,this ));
        wallList.add(new Wall("images/walls.gif", 375 ,375,this ));
        wallList.add(new Wall("images/walls.gif", 325 ,475,this ));
        wallList.add(new Wall("images/walls.gif", 250 ,550,this ));
        wallList.add(new Wall("images/walls.gif", 690 ,550,this ));
//        for(int i = 0; i< 5; i ++){
//        	grassList.add(new Grass("images/grass.jpg", i*60 ,560, this ));
//        }
        grassList.add(new Grass("images/grass.jpg", 385,475,this ));
        grassList.add(new Grass("images/grass.jpg", 445 ,475,this ));
        grassList.add(new Grass("images/grass.jpg", 505 ,475,this ));
        grassList.add(new Grass("images/grass.jpg", 515 ,475,this ));
        grassList.add(new Grass("images/grass2.jpg", 10 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 70 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 130 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 190 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 750 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 810 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 870 ,675,this ));
        grassList.add(new Grass("images/grass2.jpg", 930 ,675,this ));
      
    
        //��ӻ���
        baseList.add(base);
        //setList.add(set);

        while (true){
            if(botList.size() == 0 && enemyCount == 10){
                state = 5;
            }
            if(tankList.size() == 0 && (state == 1 || state == 2)){

                state = 4;
            }
            if(state == 1 || state == 2){
                if (count % 100 == 1 && enemyCount < 10) {
                    Random r = new Random();
                    int rnum =r.nextInt(800);
                    botList.add(new Bot("images/enemy1U.gif", rnum, 110,
                            "images//enemy1U.gif","images/enemy1D.gif",
                            "images/enemy1L.gif","images//enemy1R.gif", this));
                    enemyCount++;
                    //System.out.println("bot: " + botList.size());
                }
            }
            repaint();
            try {
                //�߳�����  1�� = 1000����
                Thread.sleep(25);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println(bulletList.size());
        //System.out.println("tank"+tankList.size());
        //����������һ����С��ImageͼƬ
        if(offScreenImage ==null){
            offScreenImage=this.createImage(width, height);
        }
        //��ø�ͼƬ�Ļ���
        Graphics gImage= offScreenImage.getGraphics();
        //���ñ�����ɫ
        gImage.setColor(Color.black);
        //�����������
        gImage.fillRect(0, 0, width, height);
        //�ı仭�ʵ���ɫ
        gImage.setColor(Color.white);
        //�ı����ִ�С����ʽ
        gImage.setFont(new Font("����",Font.BOLD,50));
        if(state == 0){
            //�������
            gImage.drawString("ѡ����Ϸģʽ",255,100);
            gImage.drawString("������Ϸ",300,200);
            gImage.drawString("˫����Ϸ",300,300);
            gImage.drawString("��1��2ѡ��ģʽ�����س���ʼ��Ϸ",70,400);
            gImage.drawImage(select,160,y,null);
     
        }
        else if(state == 1||state == 2){
            gImage.setColor(Color.white);
            gImage.setFont(new Font("����",Font.BOLD,20));
            gImage.drawString("ʣ����ˣ�" + botList.size(),10,70);
            gImage.drawString("WASD�����ƶ�",50,470);
            gImage.drawString("�ո����",50,500);
            if(state == 2){
                gImage.drawString("����������ƶ�",825,470);
                gImage.drawString("K���",895,500);
            }

            //paint�ػ���ϷԪ��
            for(Tank tank : tankList){
                tank.paintSelf(gImage);
            }
            for(Bullet bullet: bulletList){
                bullet.paintSelf(gImage);
            }
            bulletList.removeAll(removeList);
            for(Bot bot: botList){
                bot.paintSelf(gImage);
            }
            for (Wall wall: wallList){
                wall.paintSelf(gImage);
            }
            for (Grass water: grassList){
                water.paintSelf(gImage);
            }
            for(Base base : baseList){
                base.paintSelf(gImage);
            }
            for(BlastObj blast : blastList){
                blast.paintSelf(gImage);
            }
//            for (Set set: setList){
//                set.paintSelf(gImage);
//            }
            //�ػ����+1
            count++;
        }
        else if(state == 3){
            gImage.drawString("��Ϸ��ͣ",100,300);
        }
        else if(state == 4){
            gImage.drawString("GAME OVER",400,400);
        }
        else if(state == 5){
            gImage.drawString("VICTORY",400,400);
        }
        /** �����������ƺõ�ͼ���������Ƶ������Ļ����� */
        g.drawImage(offScreenImage, 0, 0, null);
    }
    

    private class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                    y = 150;
                    a = 1;
                    break;
                case KeyEvent.VK_2:
                    y = 250;
                    a = 2;
                    break;
                case KeyEvent.VK_ENTER:
                    state = a;
                    //������
                    if(state == 1 && !start){
                        tankList.add(playerOne);
                    }else{
                        tankList.add(playerOne);
                        tankList.add(playerTwo);
                    }
                    start = true;
                    break;
                case KeyEvent.VK_P:
                    if(state != 3){
                        a = state;
                        state = 3;
                    }
                    else{
                        state = a;
                        if(a == 0) {
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
        public void keyReleased(KeyEvent e){
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
