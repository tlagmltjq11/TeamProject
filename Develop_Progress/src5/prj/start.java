package prj;

import java.awt.CardLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class start extends JFrame {
	private CardLayout cards = new CardLayout();	
	public start() {
		setUndecorated(true);
		setTitle("로그인");
		setSize(1280, 720);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add("One", new LogIn(this));
		getContentPane().add("Two", new waiting(this));
		// ingame 클래스에서 getGraphics를 사용하기 위해 setVisble을 위에서 선언해준다.
		setVisible(true);
		getContentPane().add("Three", new ingame(this));
		
		// 음악재생을 위한 객체를 선언함과 동시에 재생할 곡과 isLoop에 true값을 넣어주면서 무한반복 시킴.
		Music music = new Music("music.mp3", true);
		// 음악 시작.
		music.start();
	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

	public static void main(String[] args) {
		new start();

	}
}
