import java.awt.*;

public class Ball implements GameConstants {
	
	public int x;
	public int y;
	private int w;
	private int h;
	public int xSpeed;
	public int ySpeed;
	public int line;
	public int lifesecond;
	public String duckpicture="./png/鸭.png";
	private Color color;
	private static RandomGenerator ballPostion = new RandomGenerator(GWIDTH);
	private static RandomGenerator ballPostiony = new RandomGenerator(GHEIGHT-100);
	private static RandomGenerator speedRandom = new RandomGenerator(MAX_SPEED);
	private static RandomGenerator colorRandom = new RandomGenerator(10);
	
	public void drawBall(Graphics g) {
		
//		g.setColor(this.color);
//		g.fillOval(x, y, w+10, h+10);
		Image image1 = Toolkit.getDefaultToolkit().getImage(duckpicture);
		g.drawImage(image1,x,y,lifesecond,lifesecond,null);
	}

	
	public void changeDirection() {
		int randomSpeed= speedRandom.getRandom();
		if(x>=GWIDTH-lifesecond) {
			xSpeed = -randomSpeed;
		}
		else
		if(x<=0) {
			xSpeed = randomSpeed;
		}
		if(y>=GHEIGHT-lifesecond-50) {
			ySpeed = -randomSpeed;
		}
		else
		if(y<=0) {	
			ySpeed =  randomSpeed;
		}
	}
	public void move() {
		
		x+=xSpeed;
		y+=ySpeed;
	}
	public Ball() {

		this.x =   ballPostion.getRandom();
		this.y = ballPostiony.getRandom();
		this.xSpeed = this.ySpeed = speedRandom.getRandomspeed();
		this.w = this.h= 150;
		this.lifesecond=150;
		//pickColor();
	}

//	private void pickColor() {
//		int color = colorRandom.getRandom();
//		switch(color) {
//		case 1:
//			this.color= Color.RED;
//			break;
//		case 2:
//			this.color = Color.GREEN;
//			break;
//		case 3:
//			this.color = Color.YELLOW;
//			break;
//		case 4:
//			this.color = Color.CYAN;
//			break;
//		case 5:
//			this.color = Color.ORANGE;
//			break;
//		case 6:
//			this.color = Color.LIGHT_GRAY;
//			break;
//		case 7:
//			this.color = Color.MAGENTA;
//			break;
//		case 8 :
//			this.color  = Color.PINK;
//			break;
//		case 9:
//			this.color = Color.WHITE;
//			break;
//		default:
//			this.color = Color.BLUE;
//		}
//	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void setLifesecond(int lifesecond) {
		this.lifesecond = lifesecond;
	}

	public int getLifesecond() {
		return lifesecond;
	}
}








