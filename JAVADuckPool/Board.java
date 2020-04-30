import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.lang.Math;
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
ArrayList <Duck> ducks =new ArrayList<>();
ArrayList <lilies> lilies = new ArrayList<>();
ArrayList <Rock> rocks = new ArrayList<>();

ArrayList <Duck> smallduck = new ArrayList<>();
private void loadBalls() {

		ducks.add(new Duck());


}
private void loadLilies(){
		lilies.add(new lilies());

}
private void loadRocks(){
		rocks.add(new Rock());

	}

private void checkCollision() {
	for(int i = 0; i< ducks.size(); i++) {
		for(int j = i + 1; j< ducks.size(); j++) {
			if(isCollide(ducks.get(i), ducks.get(j))) {
					ducks.get(i).setxSpeed(ducks.get(i).getxSpeed() * -1);
					ducks.get(i).setySpeed(ducks.get(i).getySpeed() * -1);
					ducks.get(j).setxSpeed(ducks.get(j).getxSpeed() * -1);
					ducks.get(j).setySpeed(ducks.get(j).getySpeed() * -1);
			}
		}
	}
}
private void checkCollision2() {    //球和水仙花碰撞
	for(int i = 0; i< ducks.size(); i++) {
		for(int j = 0; j<lilies.size(); j++) {

			if(isCollide2(ducks.get(i), lilies.get(j))) {
				lilies.remove(j);
				ducks.get(i).setLifesecond(ducks.get(i).getLifesecond()+15); //吃水仙花加时

			}
		}
	}
}
private void checkCollision3() {    //球和水仙花碰撞
		for(int i = 0; i< ducks.size(); i++) {
			for(int j = 0; j<rocks.size(); j++) {

				if(isCollide3(ducks.get(i), rocks.get(j))) {
					ducks.get(i).setxSpeed(ducks.get(i).getxSpeed() * -1);
					ducks.get(i).setySpeed(ducks.get(i).getySpeed() * -1);
				}
			}
		}
	}
private void checkheadduck(){  //检查有没有领头鸭
	ArrayList <String> CheckHeadDuckin =new ArrayList<String>();
	for(int i = 0; i< ducks.size(); i++) {              //这个for循环改变图片
		if(ducks.get(i).getLifesecond()>=180){
			ducks.get(i).duckpicture="./png/10xiaodongwu_06.png";
		}
		else {
			ducks.get(i).duckpicture="./png/鸭.png";
		}

	}
	for(int i = 0; i< ducks.size(); i++) {             //这个for提取值到ArrayList
		CheckHeadDuckin.add(ducks.get(i).duckpicture);
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





private boolean isCollide(Duck firstDuck, Duck secondDuck) {
	int xDistance = Math.abs(firstDuck.getX() - secondDuck.getX());
	int yDistance = Math.abs(firstDuck.getY() - secondDuck.getY());
	return xDistance<=max(firstDuck.getLifesecond(), secondDuck.getLifesecond())
			&& yDistance<= firstDuck.getLifesecond() && yDistance<= secondDuck.getLifesecond();
}

private boolean isCollide2(Duck firstDuck, lilies secondLilies) {
	int xDistance = Math.abs(firstDuck.getX() - secondLilies.getX());
	int yDistance = Math.abs(firstDuck.getY() - secondLilies.getY());
	return xDistance<= firstDuck.getLifesecond()
			&& yDistance<= firstDuck.getLifesecond();
}
private boolean isCollide3(Duck firstDuck, Rock secondrock) {
	int xDistance = Math.abs(firstDuck.getX() - secondrock.getX());
	int yDistance = Math.abs(firstDuck.getY() - secondrock.getY());
	return xDistance<= firstDuck.getLifesecond()
			&& yDistance<= firstDuck.getLifesecond();
	}

int ySpeed;
	public Board() {
		new Thread(() -> {
			int sleep = 1000;
			while (true) {
				//此线程用来计时
				for (int i = 0; i < ducks.size() - 1; i++) {
					if(ducks.get(i).getLifesecond()<=80){
						ducks.remove(i);
					}
					else {
						ducks.get(i).setLifesecond(ducks.get(i).getLifesecond() - 2); //减肥
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


				if(ducks.size()<=MAX_BALLS) {
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
					for (int i = 0; i < ducks.size(); i++) {
						if (ducks.get(i).duckpicture == "./png/10xiaodongwu_06.png") {
							HeadDuckX = ducks.get(i).x;
							HeadDuckY = ducks.get(i).y;
							Collections.swap(ducks,0,i);
						}

					}
					for (int i = 1; i < ducks.size(); i++) {

						ducks.get(i).xSpeed = (ducks.get(i-1).x - ducks.get(i).x) / 40;
						ducks.get(i).ySpeed = (ducks.get(i-1).y - ducks.get(i).y )/ 40;
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
	for(Duck duck : ducks) {
		duck.drawBall(g);
		duck.move();
		duck.changeDirection();
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






