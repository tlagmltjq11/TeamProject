package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register extends JFrame {
	private JTextField id_tx;
	private JPasswordField pw_pw;
	private JLabel back_l, id_l, pw_l, menubar_l, char1_l, char2_l, char3_l;
	private JButton sign_bt, cancel_bt;
	private JRadioButton character1, character2, character3;
	private ButtonGroup charGroup;

	// ���콺�� x��ǥ y��ǥ�� ������ ����.
	private int mouseX, mouseY;
	
	// back_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\registerback.jpg");
	// �޴��ٿ� ���� �̹��������� ����.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// id_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon id_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\idImg.png");
	// pw_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon pw_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\passwordImg.png");
	// sign_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon signupBasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\signupBasic.png");
	private ImageIcon signupEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\signupEntered.png");
	private ImageIcon cancelBasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\cancelBasic.png");
	private ImageIcon cancelEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\cancelEntered.png");
	
	private ImageIcon character1_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character1.png");
	private ImageIcon character2_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character2.png");
	private ImageIcon character3_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character3.png");

	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == sign_bt) {
				// id�� pw�� ����� �ԷµǾ����� Ȯ�� ��! DB�� ������ �����ִ� �κ�
				JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�");
				dispose();
			} else {
				dispose();
			}
		}
	}

	public register() {
		setTitle("sign up");
		setLayout(null);
		setSize(800, 480);
		setUndecorated(true);
		setResizable(false);
		setLocation(400, 200);
		
		back_l = new JLabel(back_img);
		back_l.setBounds(0, 0, 800, 480);
		
		// �޴��� ���� menu_img�� �����ϸ� ����.
		menubar_l = new JLabel(menu_img);
		// �޴����� ��ġ�� ����.
		menubar_l.setBounds(0, 0, 1280, 30);

		// ���콺�� ���� �����ʸ� ����.
		menubar_l.addMouseListener(new MouseAdapter() {
			// ���콺�� �ش� ��ư�� ���������� ���� �̺�Ʈó��.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// �̺�Ʈ�� �߻��������� �� ��ǥ�� ����.
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		// ���콺�� ���� ��Ǹ����ʸ� ����.
		menubar_l.addMouseMotionListener(new MouseMotionAdapter() 
		{
			// �巡�װ� �߻��������� �̺�Ʈó��.
			@Override
			public void mouseDragged(MouseEvent e)
			{
				// ���� ��ũ���� ��ǥ�� ����.
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				// �������� ��ġ�� �巡���Ѱ����� �̵���Ŵ.
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		Font font = new Font("arian", Font.BOLD, 20);
		
		id_tx = new  JTextField();
		id_tx.setFont(font);
		id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		id_tx.setBounds(150, 92, 150, 35);
		
		pw_pw = new JPasswordField();
		pw_pw.setFont(font);
		pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw_pw.setBounds(150, 142, 150, 35);
		
		id_l = new JLabel(id_img);
		id_l.setBounds(50, 60, 100, 100);
		pw_l = new JLabel(pw_img);
		pw_l.setBounds(50, 110, 100, 100);
		
		sign_bt = new JButton(signupBasic_img);
		// ���Թ�ư�� ��ġ�� ����.
		sign_bt.setBounds(200, 400, 150, 36);
		// ���Թ�ư�� �׵θ� ������ ������Ŵ.
		sign_bt.setBorderPainted(false);
		// ���Թ�ư�� ����� ä���� ����.
		sign_bt.setContentAreaFilled(false);
		// ���Թ�ư�� ��Ŀ�� ǥ�� ����.
		sign_bt.setFocusPainted(false);
		
		cancel_bt = new JButton(cancelBasic_img);
		// �����ư�� ��ġ�� ����.
		cancel_bt.setBounds(450, 385, 150, 60);
		// �����ư�� �׵θ� ������ ������Ŵ.
		cancel_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		cancel_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		cancel_bt.setFocusPainted(false);
		
		character1 = new JRadioButton();
		character1.setBounds(500, 100, 50, 50);
		character1.setBorderPainted(false);
		character1.setContentAreaFilled(false);
		character1.setFocusPainted(false);
		
		character2 = new JRadioButton();
		character2.setBounds(500, 200, 50, 50);
		character2.setBorderPainted(false);
		character2.setContentAreaFilled(false);
		character2.setFocusPainted(false);
		
		character3 = new JRadioButton();
		character3.setBounds(500, 300, 50, 50);
		character3.setBorderPainted(false);
		character3.setContentAreaFilled(false);
		character3.setFocusPainted(false);
		
		character1.setSelected(true);
		
		charGroup = new ButtonGroup();
		charGroup.add(character1);
		charGroup.add(character2);
		charGroup.add(character3);
		
		char1_l = new JLabel(character1_img);
		char1_l.setBounds(600, 40, 100, 100);
		char2_l = new JLabel(character2_img);
		char2_l.setBounds(600, 135, 100, 150);
		char3_l = new JLabel(character3_img);
		char3_l.setBounds(600, 275, 100, 150);
		
		add(id_l);
		add(pw_l);
		add(id_tx);
		add(pw_pw);
		add(sign_bt);
		add(cancel_bt);
		add(character1);
		add(character2);
		add(character3);
		add(char1_l);
		add(char2_l);
		add(char3_l);
		add(menubar_l);
		add(back_l);
		
		setVisible(true);
		ButtonListener listen = new ButtonListener();
		sign_bt.addActionListener(listen);
		cancel_bt.addActionListener(listen);

	}
}
