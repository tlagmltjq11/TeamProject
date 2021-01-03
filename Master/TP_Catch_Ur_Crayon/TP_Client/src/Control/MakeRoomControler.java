package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import Model.waiting;
import Starter.Application;
import Thread.MakeRoomSendThread;
import View.MakeRoomView;

public class MakeRoomControler {
	private MakeRoomView view;
	private ButtonListener listen;
	private Application app;
	private WaitingControler wc;
	private IngameControler ic;
	private Socket s;
	private MakeRoomSendThread mrt;
	private String ID, avatar;
	public Socket s1=null;
	public Socket s2=null;
	public Socket s3=null;
	public Socket s4=null;
	private int num;

	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == view.getOk()) {
				if(Integer.parseInt(view.getRound().getText()) > 10 || Integer.parseInt(view.getRound().getText()) == 0) {
					JOptionPane.showMessageDialog(null, "1 ~ 10 �����߿��� �������ּ���!");
				} else {
					String title = "����: " + view.getTitle() + "   " + view.getTheme().getSelectedItem().toString() + "   ����: " + view.getRound().getText();
					mrt = new MakeRoomSendThread(s, view, title, view.getPW(), view.getRound().getText(), view.getTheme().getSelectedItem().toString());
					mrt.start();
									try {
						ic.setUserInfo(s, ID, avatar, num);
					} catch (IOException e) {
						e.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "�濡 �����մϴ�");
					app.changePanel();
					app.setSize(1280,720);
					app.setTitle("������ : " + ic.getTitle(wc.getRoom_num()));
					view.getN().dispose();
				}
			} else {
				view.getN().dispose();
			}
		}
	}

	public MakeRoomControler(Application app, MakeRoomView mv, WaitingControler wc, IngameControler ic,Socket s, String ID, String avatar, int num) {
		this.app = app;
		view = mv;
		this.wc = wc;
		this.ic = ic;
		this.s = s;
		this.s1 =s;
		this.s2 =s;
		this.s3 =s;
		this.s4 =s;
		this.ID = ID;
		this.avatar = avatar;
		this.num = num;
	}

	public void buttonHandler() {
		listen = new ButtonListener();
		view.getOk().addActionListener(listen);
		view.getCancel().addActionListener(listen);
	}
}
