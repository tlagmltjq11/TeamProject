package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start extends JFrame {
	private CardLayout cards = new CardLayout();
	
	public start() {
		
		setTitle("로그인");
		setSize(1280, 720);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		getContentPane().add("One", new LogIn(this));
		getContentPane().add("Two", new waiting(this));
		getContentPane().add("Three", new ingame(this));
		
		// 음악재생을 위한 객체를 선언함과 동시에 재생할 곡과 isLoop에 true값을 넣어주면서 무한반복 시킴.
		Music music = new Music("music.mp3", true);
		// 음악 시작.
		music.start();
		
		setVisible(true);
	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

	public static void main(String[] args) {
		new start();

	}
}
