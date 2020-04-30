import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Objects;
import javax.swing.*;
import java.util.Collections;
import static sun.swing.MenuItemLayoutHelper.max;

public class Board extends JPanel implements GameConstants, ActionListener{
private int HeadDuckX;
private int HeadDuckY;
private int x = 5;
private int y = 5;

public static int playmusic=1;
public static int playduckmusic=0;
static int MAX_BALLS = 6;
static 	int MAX_Lilies = 20;
//int speed ;

//private Ball[] balls = new Ball[1];
ArrayList <Ball> balls =new ArrayList<>();
ArrayList <lilies> lilies = new ArrayList<>();
ArrayList <Rock> rocks = new ArrayList<>();

ArrayList <Ball> smallduck = new ArrayList<>();
private void loadBalls() {

		balls.add(new Ball());


}
private void loadLilies(){
		lilies.add(new lilies());

}
private void loadRocks(){
		rocks.add(new Rock());

	}

private void checkCollision() {
	for(int i =0; i<balls.size(); i++) {
		for(int j = i + 1; j<balls.size(); j++) {
			if(isCollide(balls.get(i), balls.get(j))) {
					balls.get(i).setxSpeed(balls.get(i).getxSpeed() * -1);
					balls.get(i).setySpeed(balls.get(i).getySpeed() * -1);
					balls.get(j).setxSpeed(balls.get(j).getxSpeed() * -1);
					balls.get(j).setySpeed(balls.get(j).getySpeed() * -1);
			}
		}
	}
}
private void checkCollision2() {    //球和水仙花碰撞
	for(int i =0; i<balls.size(); i++) {
		for(int j = 0; j<lilies.size(); j++) {

			if(isCollide2(balls.get(i), lilies.get(j))) {
				lilies.remove(j);
				balls.get(i).setLifesecond(balls.get(i).getLifesecond()+15); //吃水仙花加时

			}
		}
	}
}
private void checkCollision3() {    //球和水仙花碰撞
		for(int i =0; i<balls.size(); i++) {
			for(int j = 0; j<rocks.size(); j++) {

				if(isCollide3(balls.get(i), rocks.get(j))) {
					balls.get(i).setxSpeed(balls.get(i).getxSpeed() * -1);
					balls.get(i).setySpeed(balls.get(i).getySpeed() * -1);
				}
			}
		}
	}
private void checkheadduck(){  //检查有没有领头鸭
	ArrayList <String> CheckHeadDuckin =new ArrayList<String>();
	for(int i =0; i<balls.size(); i++) {              //这个for循环改变图片
		if(balls.get(i).getLifesecond()>=180){
			balls.get(i).duckpicture="./png/10xiaodongwu_06.png";
		}
		else {
			balls.get(i).duckpicture="./png/鸭.png";
		}

	}
	for(int i =0; i<balls.size(); i++) {             //这个for提取值到ArrayList
		CheckHeadDuckin.add(balls.get(i).duckpicture);
	}

	if(CheckHeadDuckin.contains("./png/10xiaodongwu_06.png")){
		System.out.println(CheckHeadDuckin);
		System.out.println("playduckmusic赋值为1");
		playduckmusic=1;
	}
	else {
		playduckmusic=0;
	}

}





private boolean isCollide(Ball firstBall, Ball secondBall) {
	int xDistance = Math.abs(firstBall.getX() - secondBall.getX());
	int yDistance = Math.abs(firstBall.getY() - secondBall.getY());
	return xDistance<=max(firstBall.getLifesecond(),secondBall.getLifesecond())
			&& yDistance<=firstBall.getLifesecond() && yDistance<=secondBall.getLifesecond();
}

private boolean isCollide2(Ball firstBall, lilies secondLilies) {
	int xDistance = Math.abs(firstBall.getX() - secondLilies.getX());
	int yDistance = Math.abs(firstBall.getY() - secondLilies.getY());
	return xDistance<=firstBall.getLifesecond()
			&& yDistance<=firstBall.getLifesecond();
}
private boolean isCollide3(Ball firstBall, Rock secondrock) {
	int xDistance = Math.abs(firstBall.getX() - secondrock.getX());
	int yDistance = Math.abs(firstBall.getY() - secondrock.getY());
	return xDistance<=firstBall.getLifesecond()
			&& yDistance<=firstBall.getLifesecond();
	}

int ySpeed;
	public Board() {
		new Thread(() -> {
			int sleep = 1000;
			while (true) {
				//此线程用来计时
				for (int i = 0; i < balls.size() - 1; i++) {
					if(balls.get(i).getLifesecond()<=80){
						balls.remove(i);
					}
					else {
						balls.get(i).setLifesecond(balls.get(i).getLifesecond() - 2); //减肥
					}
				}
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).start();

		new Thread(() -> {
			int sleep = 2000;
			while (true) {  //最多生成的鸭子个数

				//***************————测试————****************//
//				System.out.println("生成鸭子的x;y速度分别为");
//				for(int i=0;i<balls.size();i++) {
//					System.out.print(balls.get(i).xSpeed);
//					System.out.print(" ; ");
//					System.out.println(balls.get(i).ySpeed);
//				}
//				System.out.print("图中共有鸭子数量：");
//				System.out.println(balls.size());
//				System.out.println("----------------");
//				System.out.print("图中共有水仙花数量：");
//				System.out.println(lilies.size());
//				System.out.println("----------------");
				//***************————测试————****************//


				if(balls.size()<=MAX_BALLS) {
					loadBalls();
				}
				try {

					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			int sleep2 = 3000;
			while (true) {  //最多生成的水仙花个数
				if(lilies.size()<=MAX_Lilies) {
					loadLilies();
					loadLilies();
				}
				if(rocks.size()<=4){
					loadRocks();
				}
				try {

					Thread.sleep(sleep2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			int sleep4 = 400;
			while (true) {  //检测碰撞线程
				if(playduckmusic!=1) {
					checkCollision();
				}
				checkCollision2();
				checkCollision3();
				checkheadduck();
				try {

					Thread.sleep(sleep4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			int sleep4 = 1;
			while (true) {  //绘图线程
				repaint();
				try {

					Thread.sleep(sleep4);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();


		new Thread(() -> {
			int sleep5 = 0;
			while (playmusic==1) {  //音乐线程
				new MusicPlayer(new File("./music/bg3.mp3")).run();
				try {

					Thread.sleep(sleep5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			int sleep5 = 10;
			while (playmusic==1) {  //音乐线程2

				if(playduckmusic==1) {

					//************************————测试————*********************************//
					System.out.print("播放鸭子叫");
					System.out.println(playduckmusic);
					//************************————测试————*********************************//

					new MusicPlayer(new File("./music/duckmusic.mp3")).run();
				}
				else {
					//************************————测试————*********************************//
					System.out.print("不不不播放鸭子叫");
					System.out.println(playduckmusic);
					//************************————测试————*********************************//
				}
				try {

					Thread.sleep(sleep5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			int sleep6= 10;
			while (true) {  //鸭子串线程
				if(playduckmusic==1) {
					System.out.println("鸭子串线程开始");
					for (int i = 0; i < balls.size(); i++) {
						if (balls.get(i).duckpicture == "./png/10xiaodongwu_06.png") {
							HeadDuckX = balls.get(i).x;
							HeadDuckY = balls.get(i).y;
							Collections.swap(balls,0,i);
						}

					}
					for (int i = 1; i < balls.size(); i++) {

						balls.get(i).xSpeed = (balls.get(i-1).x - balls.get(i).x) / 40;
						balls.get(i).ySpeed = (balls.get(i-1).y - balls.get(i).y )/ 40;
//							smallduck.add(balls.get(i));

					}
//					for (int i = 0; i < smallduck.size(); i++) {
//						if(i==0){
//							smallduck.get(0).xSpeed=(HeadDuckX - balls.get(i).x) / 100;
//
//						}
//						smallduck.get(i).xSpeed =
//					}
				}


				try {
					Thread.sleep(sleep6);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		//System.out.println(balls.length);
//		for(Ball ball : balls) {
//			System.out.println(ball.getX()+ " "+ball.getY()+" "+ball.getxSpeed()+" "+ball.getySpeed());
//		}
	setSize(GWIDTH,GHEIGHT);
	setBackground(Color.BLACK);
	//ySpeed = speed = 5;
	gameLoop();
	
}
private Timer timer ;
//private Ball ball = new Ball();
@Override
public void actionPerformed(ActionEvent e) {
	//repaint();
//	checkCollision();
//	checkCollision2();
	Toolkit.getDefaultToolkit().sync();

	//ball.move();
	//ball.changeDirection();
	//move();
	//changeDirection();
}

public void gameLoop() {
	timer = new Timer(DELAY,this);
	timer.start();
}

private void drawBalls(Graphics g) {
	for(Ball ball : balls) {
		ball.drawBall(g);
		ball.move();
		ball.changeDirection();
	}
}
private void drawLilies (Graphics g){
	if(lilies.size()!=0) {
		for (lilies lilies : lilies) {
			lilies.drawLilies(g);
		}
	}
}
private void drawRocks (Graphics g){
	if(rocks.size()!=0) {
		for (Rock rocks : rocks) {
			rocks.drawRock(g);
		}
	}
}
@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(new ImageIcon("./png/river6.jpg").getImage(),0,0,GWIDTH,GHEIGHT, null);
	drawBalls(g);
	drawLilies(g);
	drawRocks(g);
	//ball.drawBall(g);
//	g.setColor(Color.YELLOW);
//	g.fillOval(x, y, 50, 50);
	
}

}






