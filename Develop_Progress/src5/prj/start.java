package prj;

import java.awt.CardLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class start extends JFrame {
	private CardLayout cards = new CardLayout();	
	public start() {
		setUndecorated(true);
		setTitle("�α���");
		setSize(1280, 720);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add("One", new LogIn(this));
		getContentPane().add("Two", new waiting(this));
		// ingame Ŭ�������� getGraphics�� ����ϱ� ���� setVisble�� ������ �������ش�.
		setVisible(true);
		getContentPane().add("Three", new ingame(this));
		
		// ��������� ���� ��ü�� �����԰� ���ÿ� ����� ��� isLoop�� true���� �־��ָ鼭 ���ѹݺ� ��Ŵ.
		Music music = new Music("music.mp3", true);
		// ���� ����.
		music.start();
	}

	public void changePanel() {
		cards.next(this.getContentPane());
	}

	public static void main(String[] args) {
		new start();

	}
}
