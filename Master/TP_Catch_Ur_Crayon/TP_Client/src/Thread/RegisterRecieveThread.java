package Thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import Starter.Application;
import View.RegisterView;

public class RegisterRecieveThread extends Thread {
	private String result;
	private DataInputStream inputstream;
	private Socket s;
	private RegisterView view;
	
	public RegisterRecieveThread(RegisterView view, Socket s) {
		this.view = view;
		this.s = s;
		try {
			inputstream = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public void run() {
		try {
			result = inputstream.readUTF();
		

			if(result.equals("true")) {

				JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�");
				
				view.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �����մϴ�.");
			}

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
