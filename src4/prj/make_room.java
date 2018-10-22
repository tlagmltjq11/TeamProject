package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class make_room extends JPanel {
	private JPanel p_t, p_b, l1, l2;
	private JTextField title, pw;
	private JLabel l_title, l_pw;
	private JButton ok, cancel;
	private JFrame n;
	private start F;
	private int room_num;

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == ok) {
				// 방제목과 비밀번호가 제대로 입력되었는지 확인 후 ! 방생성 -> 서버에 연동하기.
				JOptionPane.showMessageDialog(null, "방에 입장합니다");
				room_num++;
				open_room();
				n.dispose();
				F.changePanel();
				F.setTitle("Catch-ur-Crayon");
			} else {
				n.dispose();
			}
		}
	}

	public void open_room() {
		if (room_num == 1) {
			waiting.r1.setEnabled(true);
		} else if (room_num == 2) {
			waiting.r2.setEnabled(true);
		} else if (room_num == 3) {
			waiting.r3.setEnabled(true);
		} else {
			waiting.r4.setEnabled(true);
		}
	}

	public make_room(start f) {
		n = new JFrame("방 만들기");
		n.setSize(300, 150);
		F = f;
		n.add(this);

		n.setLocation(450, 300);

		setLayout(new GridLayout(2, 1));

		l1 = new JPanel();
		l2 = new JPanel();
		l1.setLayout(new FlowLayout(FlowLayout.CENTER));
		l2.setLayout(new FlowLayout(FlowLayout.CENTER));

		p_t = new JPanel();
		p_b = new JPanel();
		l_title = new JLabel("방 제목");
		l_pw = new JLabel("비밀번호");
		title = new JTextField(20);
		pw = new JTextField(20);
		ok = new JButton("확인");
		cancel = new JButton("취소");
		p_b.setLayout(new GridLayout(1, 2));
		p_t.setLayout(new GridLayout(2, 2));
		l1.add(l_title);
		p_t.add(l1);
		p_t.add(title);
		l2.add(l_pw);
		p_t.add(l2);
		p_t.add(pw);
		p_b.add(ok);
		p_b.add(cancel);
		add(p_t);
		add(p_b);
		n.setVisible(true);
		ButtonListener listen = new ButtonListener();
		ok.addActionListener(listen);
		cancel.addActionListener(listen);
	}
}
