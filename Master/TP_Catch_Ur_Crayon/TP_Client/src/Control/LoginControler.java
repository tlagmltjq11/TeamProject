package Control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

import Model.Music;
import Starter.Application;
import Thread.LoginRecieveThread;
import Thread.LoginSendThread;
import Thread.RegisterRecieveThread;
import Thread.RegisterSendThread;
import View.LoginView;
import View.RegisterView;
import View.WaitingView;

public class LoginControler {
	private Application app;
	private LoginView view;
	private ButtonListener listen;
	private RegisterView rv;
	private RegisterControler rc;
	private listen mouse;
	private WaitingView wv;
	private WaitingControler wc;
	private Socket server;
	private LoginRecieveThread lrt;
	private LoginSendThread lst;
	private RegisterRecieveThread rrt;
	private RegisterSendThread rst;
	private class listen extends MouseAdapter{
		public void mouseEntered(MouseEvent e){
			if(e.getSource() == view.getExit_bt()) {
				view.getExit_bt().setIcon(view.getExitentered_img());
				view.getExit_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == view.getLogin_bt()) {
				view.getLogin_bt().setIcon(view.getLoginEntered_img());
				view.getLogin_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == view.getJoin_bt()){
				view.getJoin_bt().setIcon(view.getJoinEntered_img());
				view.getJoin_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		}

		
		public void mouseExited(MouseEvent e){
			if(e.getSource() == view.getExit_bt()) {
				view.getExit_bt().setIcon(view.getExitbasic_img());
				view.getExit_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else if(e.getSource() == view.getLogin_bt()) {
				view.getLogin_bt().setIcon(view.getLogin_img());
				view.getLogin_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else if(e.getSource() == view.getJoin_bt()){
				view.getJoin_bt().setIcon(view.getJoin_img());
				view.getJoin_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}

		public void mousePressed(MouseEvent e){
			if(e.getSource() == view.getMenubar_l()) {
				view.setMouseX(e.getX());
				view.setMouseY(e.getY());
			} else if(e.getSource() == view.getExit_bt()){
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				try {
					Thread.sleep(1000);	
				}catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);
			} else {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);	
				}catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		public void mouseDragged(MouseEvent e){
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();

			app.setLocation(x - view.getMouseX(), y - view.getMouseY());
		}




	}


	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == view.getLogin_bt()) {
				lst = new LoginSendThread(server, "Login", view.getID(), view.getPW());
				lrt = new LoginRecieveThread(server,app, view, wc);
				lst.start();   
				lrt.start();
			} else {
				rv = new RegisterView();
				rc = new RegisterControler(rv, server);
				rc.buttonHandler();
			}

		}

	}

	public LoginControler(Application app, LoginView v, Socket s, WaitingControler wc) throws IOException {
		this.wc = wc;
		this.server = s;
		this.app = app;
		view = v;

		eventHandler();
	}


	public void eventHandler() {
		listen = new ButtonListener();
		mouse = new listen();
		view.getLogin_bt().addActionListener(listen);
		view.getJoin_bt().addActionListener(listen);
		view.getExit_bt().addMouseListener(mouse);
		view.getLogin_bt().addMouseListener(mouse);
		view.getJoin_bt().addMouseListener(mouse);
		view.getMenubar_l().addMouseListener(mouse);
		view.getMenubar_l().addMouseMotionListener(mouse);

	}
}
