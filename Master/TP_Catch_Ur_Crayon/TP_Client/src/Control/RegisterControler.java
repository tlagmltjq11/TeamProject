package Control;
import Starter.Application;
import Thread.RegisterRecieveThread;
import Thread.RegisterSendThread;
import View.LoginView;
import View.RegisterView;
import Model.Music;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.sql.*;
public class RegisterControler {
	private RegisterView view;
	private ButtonListener listen;
	private MouseAdapter mouse;
	private Socket server;
	private RegisterSendThread rst;
	private RegisterRecieveThread rrt;
	private String msg,avatar;
	
	private class MouseAdapter implements MouseListener, MouseMotionListener{
		public void mouseEntered(MouseEvent e){
			if(e.getSource() == view.getSign_bt()) {
				view.getSign_bt().setIcon(view.getSignupEntered_img());
				view.getSign_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == view.getCancel_bt()) {
				view.getCancel_bt().setIcon(view.getCancelEntered_img());
				view.getCancel_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == view.getCharacter1()){
				view.getCharacter1().setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else if(e.getSource() == view.getCharacter2()){
				view.getCharacter2().setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else if(e.getSource() == view.getCharacter3()){
				view.getCharacter3().setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}
		
		public void mouseExited(MouseEvent e){
			if(e.getSource() == view.getSign_bt()) {
				view.getSign_bt().setIcon(view.getSignupBasic_img());
				view.getSign_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else if(e.getSource() == view.getCancel_bt()) {
				view.getCancel_bt().setIcon(view.getCancelBasic_img());
				view.getCancel_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} 
		}
		
		public void mousePressed(MouseEvent e){
			if(e.getSource() == view.getMenubar_l()) {
				view.setMouseX(e.getX());
				view.setMouseY(e.getY());
			} else if(e.getSource() == view.getCharacter1() || e.getSource() == view.getCharacter2() || e.getSource() == view.getCharacter3()){
				Music characterClicked = new Music("characterClicked.mp3", false);
				characterClicked.start();
			
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

			view.setLocation(x - view.getMouseX(), y - view.getMouseY());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == view.getSign_bt()) {
				if(view.getCharacter1().isSelected()) {
					avatar = "1";
				} else if(view.getCharacter2().isSelected()) {
					avatar = "2";
				} else {
					avatar = "3";
				}
				rst = new RegisterSendThread(server, "Join", view.getID(), view.getPW(), avatar);
				rrt = new RegisterRecieveThread(view, server);
				rst.start();
				rrt.start();
			} else {
				view.dispose();
			}
		}
	}
	
	public RegisterControler(RegisterView v, Socket s){
		server = s;
		view = v;
	}
	
	public void buttonHandler() {
		listen = new ButtonListener();
		mouse = new MouseAdapter();
		view.getSign_bt().addActionListener(listen);
		view.getCancel_bt().addActionListener(listen);
		view.getMenubar_l().addMouseListener(mouse);
		view.getMenubar_l().addMouseMotionListener(mouse);
		view.getSign_bt().addMouseListener(mouse);
		view.getCancel_bt().addMouseListener(mouse);
	}
}
