package View;
import javax.swing.*;
import java.awt.*;

public class RoomLockView extends JPanel{
	private JPanel p_t, p_b;
	private JTextField pw;
	private JLabel l_pw;
	private JButton ok, cancel;
	private Frame n;
	
	public RoomLockView() {
		n = new Frame("��й�ȣ �Է�");
		n.setSize(330,150);
		n.add(this);		
		n.setLocation(400, 100);
		setLayout(new GridLayout(2,1));
		
		p_t = new JPanel();
		p_b = new JPanel();
		p_t.setLayout(new GridLayout(1,2));
		p_b.setLayout(new GridLayout(1,2));
		pw = new JTextField(20);
		l_pw = new JLabel("PW");
		ok = new JButton("Ȯ��");
		cancel = new JButton("���");
		
		p_t.add(l_pw);
		p_t.add(pw);
		p_b.add(ok);
		p_b.add(cancel);
		
		add(p_t);
		add(p_b);
		n.setVisible(true);
	}
	
	public String getPW() {
		return pw.getText();
	}
	
	public void resetPW() {
		pw.setText("");
	}
	
	public Frame getN() {
		return n;
	}

	public JButton getOk() {
		return ok;
	}

	public JButton getCancel() {
		return cancel;
	}
	
	

}
