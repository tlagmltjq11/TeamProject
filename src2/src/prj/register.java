package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register extends JPanel {
	private JPanel p_t, p_b, l1, l2;
	private JTextField id, pw;
	private JLabel l_id, l_pw;
	private JButton reg, cancel;
	private JFrame n;

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == reg) {
				// id�� pw�� ����� �ԷµǾ����� Ȯ�� ��! DB�� ������ �����ִ� �κ�
				JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�");
				n.dispose();
			} else {
				n.dispose();
			}
		}
	}

	public register() {
		n = new JFrame("ȸ�� ����");
		n.setSize(330, 150);

		n.add(this);

		n.setLocation(300, 200);

		setLayout(new GridLayout(2, 1));

		l1 = new JPanel();
		l2 = new JPanel();
		l1.setLayout(new FlowLayout(FlowLayout.CENTER));
		l2.setLayout(new FlowLayout(FlowLayout.CENTER));

		p_t = new JPanel();
		p_b = new JPanel();
		l_id = new JLabel("ID");
		l_pw = new JLabel("PW");
		id = new JTextField(20);
		pw = new JTextField(20);
		reg = new JButton("����");
		cancel = new JButton("���");
		p_b.setLayout(new GridLayout(1, 2));
		p_t.setLayout(new GridLayout(2, 2));
		l1.add(l_id);
		p_t.add(l1);
		p_t.add(id);
		l2.add(l_pw);
		p_t.add(l2);
		p_t.add(pw);
		p_b.add(reg);
		p_b.add(cancel);
		add(p_t);
		add(p_b);
		n.setVisible(true);
		ButtonListener listen = new ButtonListener();
		reg.addActionListener(listen);
		cancel.addActionListener(listen);

	}
}
