package prj;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class waiting extends JPanel {

	public static JButton r1, r2, r3, r4;
	private JButton mkr, exit;
	private JPanel w_t, w_b, w_t_l, w_t_l_r, w_mkr, w_rank, w_chat;
	private start F;
	private JTextArea chat, rank;
	private make_room mr;

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exit) {
				JOptionPane.showMessageDialog(null, "������ �����մϴ�");
				F.dispose();
			} else if (event.getSource() == mkr) {
				mr = new make_room(F);

			} else {
				JOptionPane.showMessageDialog(null, "�濡 �����մϴ�");
				F.changePanel();
				F.setTitle("Catch-ur-Crayon");
			}
		}
	}

	public waiting(start f) {
		setLayout(new BorderLayout());
		F = f;

		w_t = new JPanel();
		w_b = new JPanel();
		w_t_l = new JPanel();
		w_t_l_r = new JPanel();
		w_mkr = new JPanel();
		w_rank = new JPanel();
		w_chat = new JPanel();

		w_t.setLayout(new BorderLayout());
		w_b.setLayout(new BorderLayout());
		w_t_l.setLayout(new BorderLayout());
		w_t_l_r.setLayout(new GridLayout(2, 2, 5, 5));
		w_mkr.setLayout(new FlowLayout(FlowLayout.RIGHT));
		w_rank.setLayout(new FlowLayout(FlowLayout.CENTER));
		w_rank.setBackground(Color.white);
		w_chat.setLayout(new FlowLayout(FlowLayout.CENTER));
		w_chat.setBackground(Color.white);

		r1 = new JButton("��1");
		r2 = new JButton("��2");
		r3 = new JButton("��3");
		r4 = new JButton("��4");
		mkr = new JButton("�游���");
		exit = new JButton("����");
		chat = new JTextArea("�̱���(ä��)", 10, 78);
		rank = new JTextArea("�̱���(��ŷ)", 18, 30);
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		chat.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		rank.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		r1.setEnabled(false);
		r2.setEnabled(false);
		r3.setEnabled(false);
		r4.setEnabled(false);

		w_t_l_r.add(r1);
		w_t_l_r.add(r2);
		w_t_l_r.add(r3);
		w_t_l_r.add(r4);

		w_t_l.add(w_t_l_r, BorderLayout.CENTER);
		w_mkr.add(mkr);
		w_t_l.add(w_mkr, BorderLayout.SOUTH);

		w_t.add(w_t_l, BorderLayout.CENTER);
		w_rank.add(rank);
		w_t.add(w_rank, BorderLayout.EAST);

		w_chat.add(chat);
		w_b.add(w_chat, BorderLayout.CENTER);
		w_b.add(exit, BorderLayout.EAST);

		add(w_t, BorderLayout.CENTER);
		add(w_b, BorderLayout.SOUTH);
		setVisible(true);
		ButtonListener listen = new ButtonListener();
		mkr.addActionListener(listen);
		exit.addActionListener(listen);

	}

}
