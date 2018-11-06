package prj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register extends JFrame {
	private JTextField id_tx;		// �ؽ�Ʈ�ʵ� ��������
	private JPasswordField pw_pw;	// �н������ʵ� ��������
	private JLabel back_l, id_l, pw_l, menubar_l, char1_l, char2_l, char3_l, choose_l;	//�� ��������
	private JButton sign_bt, cancel_bt;	// ��ư ��������
	private JRadioButton character1, character2, character3;	// ������ư ��������
	private ButtonGroup charGroup;	// ��ư�׷� ��������

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
	// ȸ������ ��ư�� ���콺�� �÷��� ��쿡 ������ �̹����� ���� �̹��������� ����.
	private ImageIcon signupEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\signupEntered.png");
	// ȸ������ â���� ��ҹ�ư�� �̹����� ���� �̹��������� ����
	private ImageIcon cancelBasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\cancelBasic.png");
	// ȸ������ â���� ��ҹ�ư���� ���콺�� �÷��� ��쿡 ������ �̹����� ���� �̹��������� ����.
	private ImageIcon cancelEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\cancelEntered.png");
	// ĳ����1�� ���� �̹��������� ����.
	private ImageIcon character1_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character1.png");
	// ĳ����2�� ���� �̹��������� ����.
	private ImageIcon character2_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character2.png");
	// ĳ����3�� ���� �̹��������� ����.
	private ImageIcon character3_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character3.png");
	// �ƹ�Ÿ�� �������ּ���. ��� ������ ���� �̹���
	private ImageIcon choose_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\choose.png");
	
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
		// �����θ� ����ϱ� ���� ����.
		setLayout(null);
		// �������� ����� ����.
		setSize(450, 650);
		// ���� �޴��ٸ� ����.
		setUndecorated(true);
		// ũ�⸦ ������ �� ���Բ� ��.
		setResizable(false);
		// �������� ��ġ�� ������.
		setLocation(400, 80);
		
		// ���󺧿� �̹����� ������ ����
		back_l = new JLabel(back_img);
		// ������ ��ġ�� ����
		back_l.setBounds(0, 0, 450, 650);
		
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
		
		// ���̵�� ��� �ʵ忡 �����  ��Ʈ����
		Font font = new Font("arian", Font.BOLD, 20);
		
		// �ؽ�Ʈ�ʵ� ����.
		id_tx = new  JTextField();
		// �ʵ��� ��Ʈ�� font�� ����.
		id_tx.setFont(font);
		// �ʵ��� �׵θ��� ����
		id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// �ʵ��� ��ġ�� ����.
		id_tx.setBounds(150, 62, 260, 35);
		
		// �н������ʵ� ����.
		pw_pw = new JPasswordField();
		// �ʵ��� ��Ʈ�� font�� ����.
		pw_pw.setFont(font);
		// �ʵ��� �׵θ��� ����.
		pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// �ʵ��� ��ġ�� ����.
		pw_pw.setBounds(150, 112, 260, 35);
		
		// ���̵� ���� ���� ����
		id_l = new JLabel(id_img);
		// ���̵���� ��ġ�� ����.
		id_l.setBounds(50, 30, 100, 100);
		// ����� ���� ���� ����
		pw_l = new JLabel(pw_img);
		// ������� ��ġ�� ����.
		pw_l.setBounds(50, 80, 100, 100);
		
		// ���Թ�ư�� ����.
		sign_bt = new JButton(signupBasic_img);
		// ���Թ�ư�� ��ġ�� ����.
		sign_bt.setBounds(50, 580, 150, 36);
		// ���Թ�ư�� �׵θ� ������ ������Ŵ.
		sign_bt.setBorderPainted(false);
		// ���Թ�ư�� ����� ä���� ����.
		sign_bt.setContentAreaFilled(false);
		// ���Թ�ư�� ��Ŀ�� ǥ�� ����.
		sign_bt.setFocusPainted(false);
		
		// ȸ�����Թ�ư�� ���õ� �����ʸ� ����.
		sign_bt.addMouseListener(new MouseAdapter() {
							
			// ȸ�����Թ�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// ȸ�����Թ�ư�� �������� signupEntered_img)���� ����.
				sign_bt.setIcon(signupEntered_img);
				// ȸ�����Թ�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				sign_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ȸ�����Թ�ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
					
			// ȸ�����Թ�ư���� ���콺�� ���������� ����� ����.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// ȸ�����Թ�ư���� ���콺�� ���������� �������� signupBasic_img�� ����.
				sign_bt.setIcon(signupBasic_img);
				// ȸ�����Թ�ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				sign_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// ȸ�����Թ�ư�� Ŭ���������� ����� ����.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// ȸ�����Թ�ư�� Ŭ�������� ������ ȿ���� ����.
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// ȿ���� ���.
				buttonPressedMusic.start();

				// ���� ó��.
				try {
					Thread.sleep(1000);	// ��ư�� �����ڸ��� ������ ȿ������ �鸮�� �ʱ� ������ 1�� ������ �Ⱓ�� ��.
				}catch(InterruptedException ex)
				{
					// ������ �߻��� �޼ҵ��� ȣ�� ����� �����.
					ex.printStackTrace();
				}
			}
		});
		
		// �����ư�� ����.
		cancel_bt = new JButton(cancelBasic_img);
		// �����ư�� ��ġ�� ����.
		cancel_bt.setBounds(250, 570, 150, 60);
		// �����ư�� �׵θ� ������ ������Ŵ.
		cancel_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		cancel_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		cancel_bt.setFocusPainted(false);
		
		cancel_bt.addMouseListener(new MouseAdapter() {
			
			// �����ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �����ư�� �������� exitentered_img���� ����.
				cancel_bt.setIcon(cancelEntered_img);
				// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				cancel_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// �����ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
			
			/// �����ư���� ���콺�� ���������� ����� ����.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// �����ư���� ���콺�� ���������� �������� exitbasic_img�� ����.
				cancel_bt.setIcon(cancelBasic_img);
				// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				cancel_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			// �����ư�� Ŭ���������� ����� ����.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// �����ư�� Ŭ�������� ������ ȿ���� ����.
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// ȿ���� ���.
				buttonPressedMusic.start();
		
				// ���� ó��.
				try {
					Thread.sleep(1000);	// ��ư�� �����ڸ��� ������ ȿ������ �鸮�� �ʱ� ������ 1�� ������ �Ⱓ�� ��.
				}catch(InterruptedException ex)
				{
					// ������ �߻��� �޼ҵ��� ȣ�� ����� �����.
					ex.printStackTrace();
				}
			}
		});
		
		// ĳ����1�� ��Ÿ�� ������ư ����.
		character1 = new JRadioButton();
		// ������ư�� ��ġ�� ����.
		character1.setBounds(70, 500, 50, 50);
		// ������ư�� �׵θ��� ����.
		character1.setBorderPainted(false);
		// ������ư�� ����� ä�����ʰ� ����.
		character1.setContentAreaFilled(false);
		// ��Ŀ�� ȿ���� ����.
		character1.setFocusPainted(false);
		
		
		// ������ư�� ���� ���콺 �����ʸ� ����.
		character1.addMouseListener(new MouseAdapter() 
		{
			// ĳ���͹�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// ĳ���͹�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				character1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// ĳ���͹�ư�� Ŭ�������� ������ ȿ���� ����.
				Music characterClicked = new Music("characterClicked.mp3", false);
				// ȿ���� ���.
				characterClicked.start();
			}
		});
		
		// ĳ����2�� ��Ÿ�� ������ư ����.
		character2 = new JRadioButton();
		// ������ư�� ��ġ�� ����.
		character2.setBounds(220, 500, 50, 50);
		// ������ư�� �׵θ��� ����.
		character2.setBorderPainted(false);
		// ������ư�� ����� ä�����ʰ� ����.
		character2.setContentAreaFilled(false);
		// ��Ŀ�� ȿ���� ����.
		character2.setFocusPainted(false);
		
		// ������ư�� ���� ���콺 �����ʸ� ����.
		character2.addMouseListener(new MouseAdapter() 
		{
			// ĳ���͹�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// ĳ���͹�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				character2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// ĳ���͹�ư�� Ŭ�������� ������ ȿ���� ����.
				Music characterClicked = new Music("characterClicked.mp3", false);
				// ȿ���� ���.
				characterClicked.start();
			}
		});
		
		// ĳ����3�� ��Ÿ�� ������ư ����.
		character3 = new JRadioButton();
		// ������ư�� ��ġ�� ����.
		character3.setBounds(360, 500, 50, 50);
		// ������ư�� �׵θ��� ����.
		character3.setBorderPainted(false);
		// ������ư�� ����� ä�����ʰ� ����.
		character3.setContentAreaFilled(false);
		// ��Ŀ�� ȿ���� ����.
		character3.setFocusPainted(false);
		
		
		// ������ư�� ���� ���콺 �����ʸ� ����.
		character3.addMouseListener(new MouseAdapter() 
		{
			
			// ĳ���͹�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// ĳ���͹�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				character3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// ĳ���͹�ư�� Ŭ�������� ������ ȿ���� ����.
				Music characterClicked = new Music("characterClicked.mp3", false);
				// ȿ���� ���.
				characterClicked.start();
			}
		});
		
		// ĳ����1�� ���õǾ� �ְ� ��.
		character1.setSelected(true);
		
		// ĳ���Ϳ� ���� ��ư���� �׷�ȭ ��Ű�� ���� ��ư�׷� ����.
		charGroup = new ButtonGroup();
		// ��ư�׷쿡 ĳ����1�� �߰�.
		charGroup.add(character1);
		// ��ư�׷쿡 ĳ����2�� �߰�.
		charGroup.add(character2);
		// ��ư�׷쿡 ĳ����3�� �߰�.
		charGroup.add(character3);
		
		// ĳ����1�� ���� �󺧻���.
		char1_l = new JLabel(character1_img);
		// ���� ��ġ�� ����
		char1_l.setBounds(30, 360, 100, 100);
		// ĳ����2�� ���� �󺧻���.
		char2_l = new JLabel(character2_img);
		// ���� ��ġ�� ����
		char2_l.setBounds(180, 320, 100, 150);
		// ĳ����3�� ���� �󺧻���.
		char3_l = new JLabel(character3_img);
		// ���� ��ġ�� ����
		char3_l.setBounds(320, 330, 100, 150);
		
		// �ƹ�Ÿ�� ������ �ּ���. ��� ������ ���� �� ����.
		choose_l = new JLabel(choose_img);
		// ��ġ�� ����
		choose_l.setBounds(20, 90, 400, 250);
		
		// �����ӿ� �������ִ� �κ�
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
		add(choose_l);
		add(menubar_l);
		add(back_l);
		
		// ȭ���� ���̰��Ѵ�.
		setVisible(true);
		ButtonListener listen = new ButtonListener();
		sign_bt.addActionListener(listen);
		cancel_bt.addActionListener(listen);

	}
}
