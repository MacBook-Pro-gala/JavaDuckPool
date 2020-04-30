# **duck pond model**
[toc]
## Project display
### Start interface
With translucent interface, more beautiful
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image.png)

### Set interface
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B2%5D.png)

### About the interface
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B3%5D.png)

### The main interface of the model (the leader duck is not generated)
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B4%5D.png)

### The main interface of the model (to generate the leading duck)
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B5%5D.png)



## Project architecture
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B6%5D.png)@w=300
Total items

* 9 class
* An interface
* png
* mp3


## Key technical points
### Customized translucent JPanel
Class definition rewritten
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
### Audio playback

[http://www.javazoom.net/javalayer/javalayer.html](http://www.javazoom.net/javalayer/javalayer.html)
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B7%5D.png)


### Collision realization
```java
private boolean isCollide(Ball firstBall, Ball secondBall) {
	int xDistance = Math.abs(firstBall.getX() - secondBall.getX());
	int yDistance = Math.abs(firstBall.getY() - secondBall.getY());
	return xDistance<=max(firstBall.getLifesecond(),secondBall.getLifesecond())
			&& yDistance<=firstBall.getLifesecond() && yDistance<=secondBall.getLifesecond();
}
```




## Introduction of key functions
### Duck class
Which is the duck class
#### variable
It declares various parameters of the duck, including but not limited to

* x、y（x, y axis position）
* lifesecond（Health value / picture width and height）
* duckpicture（url）

#### method

* drawBall（Draw the function of the duck）
* changeDirection（Change direction after hitting the wall）
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

* move(Duck movement function)
```java
public void move() {
		x+=xSpeed;
		y+=ySpeed;
	}
```
* getter and setter


### Board class
The pond drawing board class is also the most important class of the entire project, where most of the threads are implemented

#### UML
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B8%5D.png)@w=600

#### variable

* playduckmusic（Control music playback）
* MAX_BALLS（Maximum number of ducks）
* MAX_Lilies（Number of water lilies）
* ArrayList <Ball> balls（Loading ducks）
* ArrayList <lilies> lilies（Mount water lily）

#### method
loadballs
```java
private void loadBalls() {

		balls.add(new Ball());

}
```

#### Thread

* Music thread
* Detect collision threads
* Detect lead duck thread
* Load water lily thread
* Load duck thread





### GameFrame
#### UML
![image](https://github.com/liuyuhan1234/JavaDuckPool/blob/master/images/Image%20%5B9%5D.png)@w=600

### main
```java
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitGlobalFont(new Font("宋体", Font.PLAIN, 48));  //统一设置字体

		GameFrame frame = new GameFrame();



		System.out.println(Thread.currentThread());


	}
```

### Setting

#### UML
![036162e9b90c6742f758ce7562a71abb.png](en-resource://database/31261:0)

#### interface
Have buttons and text boxes
```java
 private void windowInit() {
        this.setTitle("设置");
        this.setSize(1500,1500);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField placeTextField = new JTextField(10);
        placeTextField.setBounds(300,300,300,100);
        panel.add(placeTextField);
        JButton addPlaceButton = new JButton("设置最大鸭子个数");
        addPlaceButton.setBounds(650,300,500,100);
        panel.add(addPlaceButton);


        JTextField placeTextField2 = new JTextField(10);
        placeTextField2.setBounds(300,600,300,100);
        panel.add(placeTextField2);
        JButton addPlaceButton2 = new JButton("设置最大水仙花个数");
        addPlaceButton2.setBounds(650,600,500,100);
        panel.add(addPlaceButton2);


        JButton addPlaceButton4 = new JButton("未静音(Not mute)");
        addPlaceButton4.setBounds(450,900,600,100);
        panel.add(addPlaceButton4);

        addPlaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                registerAddPlaceButtonEvent(placeTextField);
                Board.MAX_BALLS = Integer.parseInt(placeTextField.getText());
            }
        });
        addPlaceButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAddPlaceButtonEvent2(placeTextField2);
                Board.MAX_Lilies = Integer.parseInt(placeTextField2.getText());
            }
        });
        addPlaceButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Board.playmusic=Board.playmusic*-1;
                if(Board.playmusic==-1){
                addPlaceButton4.setText("已静音(Mute)");
            }
                else {
                    addPlaceButton4.setText("未静音(Not mute)");
                }
            }
        });
        this.getContentPane().add(panel);
    }
```