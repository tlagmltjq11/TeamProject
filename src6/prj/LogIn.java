package prj;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JPanel {
	private JButton login_bt, join_bt, exit_bt;			// ��ư ��������
	private JLabel id_l, pw_l, back_l, menubar_l;		// �� ��������
	private JTextField id_tx;							// �ؽ�Ʈ�ʵ� ��������
	private JPasswordField pw_pw;						// �н������ʵ� ��������
	private start F;									// start ��������
	private register rg;								// register ��������
	
	// ���ȭ���̹����� ���� �̹��������� ����.
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\background.jpg");
	// �޴��ٿ� ���� �̹��������� ����.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// �⺻ �����ư�� ���� �̹��������� ����.
	private ImageIcon exitbasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitButtonBasic.png");
	// �����ư���� ���콺�� �÷����ÿ� ������ �̹����� ���� �̹��� ������ ����.
	private ImageIcon exitentered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitButtonEntered.png");
	
	// login_bt��ư�� ���� �̹��������� ����.
	private ImageIcon login_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\login.png");
	// login_bt��ư�� ���콺�� �÷����ÿ� �̹����� ���� �̹��������� ����.
	private ImageIcon loginEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\loginEntered.png");
	// join_bt��ư�� ���� �̹��������� ����.
	private ImageIcon join_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\join.png");
	// join_bt��ư�� ���콺�� �÷����ÿ� �̹����� ���� �̹��������� ����.
	private ImageIcon joinEntered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\joinEntered.png");
	// id_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon id_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\id.png");
	// pw_l�� �̹����� ���� �̹��������� ����.
	private ImageIcon pw_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\pw.png");
	
	// ���콺�� x��ǥ y��ǥ�� ������ ����.
	private int mouseX, mouseY;
	
	// �̺�Ʈ ������ Ŭ���� ����.
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// ���õ� ��ư�� login_bt �� ���.
			if (event.getSource() == login_bt) {
				
				// DB�� ����� ȸ�������Ϳ� ���Ͽ� �α��ν�ų�� ���� �Ǻ��ϴ� �κ�
				
				// ȭ�鿡 "�α��� �Ǿ����ϴ�" �� ���.
				JOptionPane.showMessageDialog(null, "�α��� �Ǿ����ϴ�");
				// ī�巹�̾ƿ��� ���� �г��� �̵���Ŵ.
				F.changePanel();
				// �������� ����� ����.
				F.setSize(1280, 720);
			}
			// ���õ� ��ư�� join_bt �� ���.
			else 
			{
				// ȸ������ ��ü�� �����Ѵ�.
				rg = new register();
			}
		}
	}

	public LogIn(start f) {
		
		// �Ѱܹ��� �����Ӱ�ü ����.
		F = f;
		// �����θ� ����ϱ� ���� ����.
		setLayout(null);
		
		// back_img�� �����ϸ鼭 ���� ���� ����.
		back_l = new JLabel(back_img);
		// ����̹����� ��ġ�� ũ�� ����.
		back_l.setBounds(0, 0, 1280, 720);
		
		// �����ư�� exitbasic_img�� �����ϸ� ����.
		exit_bt = new JButton(exitbasic_img);
		// �����ư�� ��ġ�� ����.
		exit_bt.setBounds(1245, 0, 30, 30);
		// �����ư�� �׵θ� ������ ������Ŵ.
		exit_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		exit_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		exit_bt.setFocusPainted(false);
		
		// �����ư�� ���õ� �����ʸ� ����.
		exit_bt.addMouseListener(new MouseAdapter() {
			
			// �����ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �����ư�� �������� exitentered_img���� ����.
				exit_bt.setIcon(exitentered_img);
				// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				exit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				exit_bt.setIcon(exitbasic_img);
				// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				exit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
				// ���α׷��� �����Ŵ.
				System.exit(0);
			}
		});
		
		// login_img�� �����ϸ� ��ư��ü ����.
		login_bt = new JButton(login_img);
		// login_bt�� ��ġ�� ũ�� ����.
		login_bt.setBounds(515, 550, 120, 60);
		// �׵θ� ����.
		login_bt.setBorderPainted(false);
		// ����� ä���� �ʰ� ����.
		login_bt.setContentAreaFilled(false);
		// ��Ŀ�� ȿ���� ����.
		login_bt.setFocusPainted(false);
		// ����� �����ϰ���.
		login_bt.setOpaque(false);
				
		// �α��ι�ư�� ���õ� �����ʸ� ����.
		login_bt.addMouseListener(new MouseAdapter() {
					
			// �α��ι�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �α��ι�ư�� �������� loginEntered_img���� ����.
				login_bt.setIcon(loginEntered_img);
				// �α��ι�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				login_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// �α��ι�ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
			
			// �α��ι�ư���� ���콺�� ���������� ����� ����.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// �α��ι�ư���� ���콺�� ���������� �������� login_img�� ����.
				login_bt.setIcon(login_img);
				// �α��ι�ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				login_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			// �α��ι�ư�� Ŭ���������� ����� ����.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// �α��ι�ư�� Ŭ�������� ������ ȿ���� ����.
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
				
	
		// join_img�� �����ϸ� ��ư��ü ����.
		join_bt = new JButton(join_img);
		// ũ��� ��ġ�� ����.
		join_bt.setBounds(660, 550, 120, 60);
		// �׵θ� ����.
		join_bt.setBorderPainted(false);
		// ����� ä���� �ʰ� ����.
		join_bt.setContentAreaFilled(false);
		// ��Ŀ�� ȿ���� ����.
		join_bt.setFocusPainted(false);
		// ����� �����ϰ���.
		join_bt.setOpaque(false);
				
		// ���Թ�ư�� ���õ� �����ʸ� ����.
		join_bt.addMouseListener(new MouseAdapter() {
			
			// ���Թ�ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// ���Թ�ư�� �������� joinEntered_img���� ����.
				join_bt.setIcon(joinEntered_img);
				// ���Թ�ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				join_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ���Թ�ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
					
			// ���Թ�ư���� ���콺�� ���������� ����� ����.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// ���Թ�ư���� ���콺�� ���������� �������� join_img�� ����.
				join_bt.setIcon(join_img);
				// ���Թ�ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				join_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
					
			// ���Թ�ư�� Ŭ���������� ����� ����.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// ���Թ�ư�� Ŭ�������� ������ ȿ���� ����.
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
				f.setLocation(x - mouseX, y - mouseY);
			}
		});

		// id_img�� �����ϸ� id_l���� ����.
		id_l = new JLabel(id_img);
		// id_l�� ��ġ�� ũ�⸦ ����.
		id_l.setBounds(490, 413, 100,100);
		
		// pw_img�� �����ϸ� pw_l���� ����.
		pw_l = new JLabel(pw_img);
		// pw_l�� ��ġ�� ũ�⸦ ����.
		pw_l.setBounds(490, 463, 100,100);
		
		// �ؽ�Ʈ�ʵ� ��ü ����.
		id_tx = new JTextField(20);
		// �ؽ�Ʈ�ʵ忡 �ԷµǴ� ������ ��Ʈ�� �����ϱ� ���� ��Ʈ��ü�� ����.
		Font font = new Font("arian", Font.BOLD, 20);
		// id_tx �ؽ�Ʈ�ʵ��� ��Ʈ�� font�� ����.
		id_tx.setFont(font);
		// id_tx�� ��ġ�� ũ�⸦ ����.
		id_tx.setBounds(570, 450, 200, 25);
		// �ؽ�Ʈ�ʵ忡 �ԷµǴ� ������ ���� ����.
		id_tx.setForeground(Color.BLACK);
		// �ؽ�Ʈ�ʵ��� �׵θ��� ����.
		id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		id_tx.setHorizontalAlignment(JTextField.CENTER);
		
		// �н������ʵ� ��ü ����.
		pw_pw = new JPasswordField(20);
		// pw_pw�� ��ġ�� ũ�⸦ ����.
		pw_pw.setBounds(570, 500, 200, 25);
		// pw_pw�� ��Ʈ�� font�� ����.
		pw_pw.setFont(font);
		// �ʵ忡 �ԷµǴ� ������ ���� ����.
		pw_pw.setForeground(Color.BLACK);
		// �н������ʵ��� �׵θ��� ����.
		pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw_pw.setHorizontalAlignment(JTextField.CENTER);
		
		// ���� �гο� �������ִ� �κ�
		add(login_bt);
		add(join_bt);
		add(id_l);
		add(pw_l);
		add(id_tx);
		add(pw_pw);
		add(exit_bt);
		add(menubar_l);
		add(back_l);

		// ��ư��ü�� ���� �̺�Ʈ ������ ��ü����
		ButtonListener listen = new ButtonListener();
		// login_bt��ư�� ���� �׼Ǹ����ʿ� listen�� ����.
		login_bt.addActionListener(listen);
		// join_bt��ư�� ���� �׼Ǹ����ʿ� listen�� ����.
		join_bt.addActionListener(listen);
		
		// ȭ���� ���̰��Ѵ�.
		setVisible(true);
		
	}
}
