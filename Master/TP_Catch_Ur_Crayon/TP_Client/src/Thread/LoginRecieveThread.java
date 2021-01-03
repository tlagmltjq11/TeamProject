package Thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import Control.WaitingControler;
import Starter.Application;
import View.LoginView;
import View.WaitingView;

public class LoginRecieveThread extends Thread  {
	private String result, ID, avatar;
	private DataInputStream inputstream;
	private Socket s,s1,s2,s3;
	private Application app;
	private WaitingControler wc;
	private LoginView view;

	public LoginRecieveThread(Socket s,Application app, LoginView view, WaitingControler wc) {
		this.app = app;
		this.wc = wc;
		this.s = s;
		this.view = view;
		try {
			inputstream = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public void run() {
		try {
			result = inputstream.readUTF();
			ID = inputstream.readUTF();
			avatar = inputstream.readUTF();
			//avatar_selected = inputstream.readUTF();
			if(result.equals("true")) {
				JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�");
				s1 = new Socket(s.getInetAddress(), s.getPort()+1);
				s2 = new Socket(s.getInetAddress(), s.getPort()+1);
				s3 = new Socket(s.getInetAddress(), s.getPort()+1);
				System.out.println(s.getInetAddress() + "    " + s.getPort() + "    " + ID);
			//	wc.update_rank(s, wv);
				wc.setUserInfo(s1,s2,s3, ID, avatar);
				
				
				// Application�� card Layout���� ���ִٰ� ����?
				// Application ������ �ȿ� ������� �α���, ����, �ΰ����� ����ִµ� changePanel��
				// �ٷ� ���� ���� �гη� ȭ�� ��ȯ�����ִ¾���
				
				
				//wv.setCharacter1_img(avatar_selected);
				//wv.repaint();
				
				
				app.changePanel();
				app.setTitle("����");
			} else if(result.equals("false_PW")){
				JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�");
				view.resetPW();
			}else {
				JOptionPane.showMessageDialog(null, "���� ������ �ùٸ��� �ʽ��ϴ�");
				view.resetText();
			}

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}




