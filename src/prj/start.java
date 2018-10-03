package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class start extends JFrame {
	private CardLayout cards = new CardLayout();
	
	public start() {
		
		setTitle("�α���");
		setSize(1280, 720);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		getContentPane().add("One", new LogIn(this));
		getContentPane().add("Two", new waiting(this));
		getContentPane().add("Three", new ingame(this));
		
		// ��������� ���� ��ü�� �����԰� ���ÿ� ����� ��� isLoop�� true���� �־��ָ鼭 ���ѹݺ� ��Ŵ.
		Music music = new Music("music.mp3", true);
		// ���� ����.
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
