import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class GameFrame extends JFrame implements GameConstants {
	Font newFont = new Font("宋体",Font.PLAIN,46); //定义新字体
	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		//啊啊
		}
	}
	JProgressBar pb = new JProgressBar();
	public GameFrame() {



//		JLabel labelScore = new JLabel("所得分数为:", JLabel.CENTER);
//		//labelScore.setFont(newFont); //设置新字体
//		this.add(labelScore, BorderLayout.NORTH);


//		JPanel dashboard2 =new JPanel();
//		dashboard2.setBackground(Color.GRAY);
//
//		pb.setMaximum(100);
//		pb.setValue(50);
//		pb.setStringPainted(true);
//		pb.setSize(400,100);
//		dashboard2.add(pb,BorderLayout.CENTER);
//		this.add(dashboard2,BorderLayout.WEST);
//		new Thread(() -> {
//			int sleep = 1000;
//			while (pb.getValue()!=0) {
//				pb.setValue(pb.getValue()-1);
//				try {
//
//					Thread.sleep(sleep);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();

//		JPanel panelButtom = new JPanel(); //新建面板；面板上放置组件
//		panelButtom.setLayout(new BorderLayout());
//		JLabel labelHelp;// 帮助信息
//		labelHelp = new JLabel("按 PageUP 或 PageDown 键改变速度",JLabel.CENTER);
//		//labelHelp.setFont(newFont); //设置新字体
//		panelButtom.add(labelHelp, BorderLayout.NORTH);
//
//		labelHelp = new JLabel("按 Enter 或 S 键重新开始游戏", JLabel.CENTER);
//		//labelHelp.setFont(newFont); //设置新字体
//		panelButtom.add(labelHelp, BorderLayout.CENTER);
//
//		labelHelp = new JLabel("按 SPACE 键或 P 键暂停游戏", JLabel.CENTER);
//		// labelHelp.setFont(newFont); //设置新字体
//		panelButtom.add(labelHelp, BorderLayout.SOUTH);
//		this.add(panelButtom, BorderLayout.SOUTH);







		JPanel startmenu =new maobolibk();
		JButton a = new JButton("开始运行(run)");
		JButton b = new JButton("设置(Setting)");
		JButton c = new JButton("关于(About)");
		startmenu.setLayout(null);

		a.setBounds(200,800/2-200,400,100);
		startmenu.add(a);
		b.setBounds(200,800/2,400,100);
		startmenu.add(b);
		c.setBounds(200,800/2+200,400,100);
		startmenu.add(c);


		startmenu.setBounds(GWIDTH/2-400,GHEIGHT/2-500,800,1000);

		JPanel bk =new Bk();
		bk.setLayout(null);
		//Image imagebk = Toolkit.getDefaultToolkit().getImage("./png/river4.png");
		//g.drawImage(new ImageIcon("./png/river4.jpg").getImage(),0,0,GWIDTH,GHEIGHT, this);
		bk.setBounds(0,0,GWIDTH,GHEIGHT);
		this.add(bk);
		bk.add(startmenu);

		// 给按钮 增加 监听
		a.addActionListener(new ActionListener() {

			// 当按钮被点击时，就会触发 ActionEvent事件
			// actionPerformed 方法就会被执行
			public void actionPerformed(ActionEvent e) {
				startmenu.setVisible(false);
				Board board = new Board();
				add(board);
			}
		});

		b.addActionListener(new ActionListener() {

			// 当按钮被点击时，就会触发 ActionEvent事件
			// actionPerformed 方法就会被执行
			public void actionPerformed(ActionEvent e) {
				JFrame addPlaceFrame = new Setting();
				addPlaceFrame.setAlwaysOnTop(true);
				addPlaceFrame.setVisible(true);
				addPlaceFrame.setLocationRelativeTo(null);//在屏幕中居中显示

			}
		});
		c.addActionListener(new ActionListener() {

			// 当按钮被点击时，就会触发 ActionEvent事件
			// actionPerformed 方法就会被执行
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Author：刘宇涵(288141) 有效代码行数: 929行", "关于", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		setLocationRelativeTo(null);
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // 设置窗口大小不能变化
		setTitle(TITLE);
		setSize(GWIDTH,GHEIGHT);
		this.setLayout(null);
		this.setLocationRelativeTo(null);//在屏幕中居中显示
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitGlobalFont(new Font("宋体", Font.PLAIN, 48));  //统一设置字体

		GameFrame frame = new GameFrame();



		System.out.println(Thread.currentThread());


	}


}
