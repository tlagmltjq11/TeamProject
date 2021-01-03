package Control;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import Model.Music;
import Model.waiting;
import Starter.Application;
import Thread.WaitingChatRecieveThread;
import Thread.WaitingChatSendThread;
import Thread.MakeRoomRecieveThread;
import Thread.RankingRecieveThread;
import View.MakeRoomView;
import View.RoomLockView;
import View.WaitingView;
public class WaitingControler {
	private Application app;
	private waiting w;	
	private ButtonListener listen;
	private TextListener text;
	private WaitingView view;
	private MakeRoomView mv;
	private MakeRoomControler mc;
	private IngameControler ic;
	private RoomLockView rv;
	private RoomLockControler rc;
	private Mouse mouse;
	private Socket s1, s2, s3;
	private String msg, ID, avatar;
	private RankingRecieveThread rrt,rrt1;
	private WaitingChatSendThread cst;
	private WaitingChatRecieveThread crt;
	private MakeRoomRecieveThread mrrt;
	public Socket s4;
	public Socket s5;

	private class Mouse extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e){
			if(e.getSource() == view.getExit_bt()) {
				view.getExit_bt().setIcon(view.getExitentered_img());
				view.getExit_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == view.getUserexit_bt()){
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		}

		@Override
		public void mouseExited(MouseEvent e){
			if(e.getSource() == view.getExit_bt()) {
				view.getExit_bt().setIcon(view.getExitbasic_img());
				view.getExit_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else {
			}
		}

		@Override
		public void mousePressed(MouseEvent e){
			if(e.getSource() == view.getMenubar_l()) {
				view.setMouseX(e.getX());
				view.setMouseY(e.getY());
			} else {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				try {
					Thread.sleep(1000);	
				}catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);
			}

		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();

			app.setLocation(x - view.getMouseX(), y - view.getMouseY());
		}

	}

	private class TextListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			if(e.getSource() == view.getTextField()){
				String msg = ": " + view.getChatText() + "\n";
				cst = new WaitingChatSendThread(s2, msg, view);
				cst.start();
				view.getTextArea().setCaretPosition(view.getTextArea().getDocument().getLength());
			}
		}
	}



	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == view.getMkr_bt()) {
				if(w.getRoom_num() < 4) {
					mv = new MakeRoomView();
					mc = new MakeRoomControler(app,mv,WaitingControler.this,ic,s3,ID,avatar, w.getRoom_num());
					mc.buttonHandler();
				} else {
					JOptionPane.showMessageDialog(null, "�� �̻� ���� ������ �� �����ϴ�!");
				}
			} else if(event.getSource() == view.getExit_bt()){
				app.offMusic();
				app.dispose();
			} else {
				for(int i = 0 ; i < 4 ; i++) {
					if(event.getSource() == view.getR(i)) {
						w.setSelect(i);
						try {
							ic.setUserInfo(s3,ID, avatar, w.getSelect());
							
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						if(ic.getPW(i).equals("")){
							JOptionPane.showMessageDialog(null, "�濡 �����մϴ�");
							app.changePanel();
							app.setSize(1280,720);
							app.setTitle("������ : " + ic.getTitle(i));
						} else {
							rv = new RoomLockView();
							rc = new RoomLockControler(app,rv,WaitingControler.this, ic);
							rc.buttonHandler();
						}
					}
				}
			}
		}
	}

	

	public void setRanking() {
		rrt1 = new RankingRecieveThread(s1, view, ID);
		rrt1.start();
	}
	
	
	public void setUserInfo(Socket s1, Socket s2, Socket s3, String ID, String avatar) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;

		this.ID = ID;
		this.avatar = avatar;
		rrt = new RankingRecieveThread(s1, view, ID);
		rrt.start();
		view.getTable().updateUI();
		crt = new WaitingChatRecieveThread(s2,view);
		crt.start();
		view.getUserID(ID);
		view.setCharacter_img(avatar);
		mrrt = new MakeRoomRecieveThread(s3, view, ic, w);
		mrrt.start();
	}

	public void Enable_Room(String title) {
		view.getR(w.getRoom_num()).setEnabled(true);
		view.getR(w.getRoom_num()).setText(title);
		w.addRoom_Num();
	}

	// 
	public int getRoom_num() {
		return w.getRoom_num();
	}

	public int getSelect() {
		return w.getSelect();
	}


	public WaitingControler(Application app, WaitingView wv, IngameControler ic) {
		w = new waiting();
		this.app = app;
		this.view = wv;
		this.ic = ic;
	}

	public void buttonHandler() {
		text = new TextListener();
		listen = new ButtonListener();
		mouse = new Mouse();

		view.getTextField().addActionListener(text);


		view.getMkr_bt().addActionListener(listen);
		view.getExit_bt().addActionListener(listen);
		view.getR(0).addActionListener(listen);
		view.getR(1).addActionListener(listen);
		view.getR(2).addActionListener(listen);
		view.getR(3).addActionListener(listen);

		view.getExit_bt().addMouseListener(mouse);
		view.getMenubar_l().addMouseListener(mouse);
		view.getMenubar_l().addMouseMotionListener(mouse);
		view.getUserexit_bt().addMouseListener(mouse);
	}	
}