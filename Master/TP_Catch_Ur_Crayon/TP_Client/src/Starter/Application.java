package Starter;
import Control.*;
import View.*;
import Model.Music;
//import Model.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.awt.Graphics;

public class Application extends JFrame{
	public CardLayout cards = new CardLayout();
	public static Application app = null;
	private LoginView lv;
	private LoginControler lc;
	private RegisterView rv;
	private RegisterControler rc;
	private WaitingView wv;
	private WaitingControler wc;
	private IngameView iv;
	private IngameControler ic;
	private Music music;

	public Application(Socket s) throws IOException {

		setUndecorated(true);
		setTitle("�α���");
		setSize(1280, 720);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		lv = new LoginView();
		wv = new WaitingView();
		setVisible(true);
		iv = new IngameView(this);
		ic = new IngameControler(this,iv,wv);

		wc = new WaitingControler(this, wv, ic);
		ic.setWaitingControler(wc);
		lc = new LoginControler(this,lv,s,wc);
		getContentPane().add("One", lv);
		getContentPane().add("Two", wv);
		getContentPane().add("Three", iv);
		
		
		
		wc.buttonHandler();
		ic.buttonHandler();

		music = new Music("music.mp3", true);

		music.start();

	}

	public void offMusic() {
		music.close();
	}


	public void changePanel() {
		cards.next(this.getContentPane());
	}

	public static void main(String[] args) {

		Socket server = null;		
		try {
			server = new Socket("192.168.0.54", 8046);	 
				


			if(server != null) {
				System.out.println("���� ����");
				app = new Application(server); 
			}
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
