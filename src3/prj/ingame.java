package prj;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class ingame extends JPanel {
	private JPanel g_t, g_b, button;
	private JTextArea paint, chat, user, undecided;
	private JButton start, exit;
	private start F;

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exit) {
				JOptionPane.showMessageDialog(null, "���Ƿ� �����ϴ�");
				// ���� ������ ������ ��ư�� ��Ȱ��ȭ �Ǿ�� ��. -> ���� ������ �� �����ϱ�.
				F.changePanel();
				F.changePanel();
			} else {

			}
		}
	}

	public ingame(start f) {
		setLayout(new BorderLayout());
		F = f;

		g_t = new JPanel();
		g_b = new JPanel();
		button = new JPanel();

		g_t.setLayout(new BorderLayout());
		g_b.setLayout(new BorderLayout());
		button.setLayout(new GridLayout(2, 1));

		paint = new JTextArea("�׸���", 18, 50);
		chat = new JTextArea("ä����", 10, 70);
		user = new JTextArea("����� UI", 18, 15);
		undecided = new JTextArea("����", 18, 15);

		start = new JButton("����");
		exit = new JButton("����");

		button.add(start);
		button.add(exit);

		g_t.add(paint, BorderLayout.CENTER);
		g_t.add(user, BorderLayout.EAST);
		g_t.add(undecided, BorderLayout.WEST);
		g_b.add(chat, BorderLayout.CENTER);
		g_b.add(button, BorderLayout.EAST);
		add(g_t, BorderLayout.CENTER);
		add(g_b, BorderLayout.SOUTH);

		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		chat.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		paint.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		user.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		undecided.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		setVisible(true);
		ButtonListener listen = new ButtonListener();
		start.addActionListener(listen);
		exit.addActionListener(listen);

	}
}
