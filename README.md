# 目录
[toc]
## 项目展示
### 开始界面
拥有半透明界面，更加美观
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image.png)

### 设置界面
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B2%5D.png1)

### 关于界面
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B3%5D.png)

### 模型主界面（未生成领头鸭）
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B4%5D.png)

### 模型主界面（生成领头鸭）
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B5%5D.png)



## 项目架构
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B6%5D.png)@w=300
项目共有

* 9个类
* 一个接口
* png若干
* mp3若干


## 关键技术点
### 定制半透明的JPanel
重写了类来定义
```java
@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
			Graphics2D graphics2d = (Graphics2D) g.create();
			
			graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));
			
			
			graphics2d.setColor(getBackground());
			graphics2d.fillRect(0, 0, getWidth(), getHeight());
			
//			graphics2d.drawImage(background, 0, 0, getWidth(), getHeight(), 46, 114, 315, 521, this);
			
			graphics2d.dispose();
	}

```
### 音频播放实现

[http://www.javazoom.net/javalayer/javalayer.html](http://www.javazoom.net/javalayer/javalayer.html)
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B7%5D.png)


### 碰撞实现
```java
private boolean isCollide(Ball firstBall, Ball secondBall) {
	int xDistance = Math.abs(firstBall.getX() - secondBall.getX());
	int yDistance = Math.abs(firstBall.getY() - secondBall.getY());
	return xDistance<=max(firstBall.getLifesecond(),secondBall.getLifesecond())
			&& yDistance<=firstBall.getLifesecond() && yDistance<=secondBall.getLifesecond();
}
```




## 重点类功能介绍
### Ball类
也就是鸭子的类
#### 变量
其中声明了鸭子的各种参数，包括但不局限于

* x、y（x、y轴位置）
* lifesecond（生命值/图片宽高）
* duckpicture（图片的url）

#### 方法

* drawBall（画出鸭子的函数）
* changeDirection（撞到墙壁后改变方向）
```java
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
```

* move(鸭子移动函数)
```java
public void move() {
		x+=xSpeed;
		y+=ySpeed;
	}
```
* getter and setter


### Board类
池塘画板类，也是整个项目最重要的类，大部分线程在其中实现

#### UML
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B8%5D.png)@w=600

#### 变量

* playduckmusic（控制音乐播放）
* MAX_BALLS（最大鸭子数量）
* MAX_Lilies（最大水百合数量）
* ArrayList <Ball> balls（装载鸭子）
* ArrayList <lilies> lilies（装载水百合）

#### 方法
loadballs
```java
private void loadBalls() {

		balls.add(new Ball());

}
```

#### 线程

* 音乐线程
* 检测碰撞线程
* 检测领头鸭线程
* 载入水百合线程
* 载入鸭子线程





### GameFrame
#### UML
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B9%5D.png)@w=600
