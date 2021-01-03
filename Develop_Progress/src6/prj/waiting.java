package prj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.TextListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class waiting extends JPanel {

	public static JButton r1_bt, r2_bt, r3_bt, r4_bt;
	private JButton mkr_bt, exit_bt, userexit_bt;
	private start F;
	private JTextArea chatarea_ta, rank_ta;
	private JTextField chatfield_tf, id_tf;
	private JLabel back_l, menubar_l, character_l;
	private make_room mr;
	private JPanel user_p, userbottom_p, room_p, roomtop_p, roombot_p;
	private String sendchat_s, receivechat_s;
	private JScrollPane scroll;
	
	// ���ȭ���̹����� ���� �̹��������� ����.
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\waitingback.jpg");
	// �޴��ٿ� ���� �̹��������� ����.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// �⺻ �����ư�� ���� �̹��������� ����.
	private ImageIcon exitbasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitButtonBasic.png");
	// �����ư���� ���콺�� �÷����ÿ� ������ �̹����� ���� �̹��� ������ ����.
	private ImageIcon exitentered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitButtonEntered.png");
	// ĳ����1�� ���� �̹��������� ����.
	private ImageIcon character1_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\character1.png");
	
	private ImageIcon roombasic_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\roomBasic.png");
	private ImageIcon roomentered_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\roomEntered.png");
	private ImageIcon exitbasic2_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitBasic2.png");
	private ImageIcon exitEntered2_img = new ImageIcon("C:\\\\Users\\\\���缷\\\\Desktop\\\\�ڹ�\\\\teampjt\\\\src\\\\images\\\\exitEntered2.png");
	
	// ���콺�� x��ǥ y��ǥ�� ������ ����.
	private int mouseX, mouseY;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == mkr_bt) {
				mr = new make_room(F);

			} else {
				JOptionPane.showMessageDialog(null, "�濡 �����մϴ�");
				F.changePanel();
			}
		}
	}

	public waiting(start f) {
		setLayout(null);
		F = f;
		
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
		
		userexit_bt = new JButton(exitbasic2_img); 
		// �����ư�� �׵θ� ������ ������Ŵ.
		userexit_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		userexit_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		userexit_bt.setFocusPainted(false);
		
		// �����ư�� ���õ� �����ʸ� ����.
		userexit_bt.addMouseListener(new MouseAdapter() {

			// �����ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �����ư�� �������� exitentered_img���� ����.
				userexit_bt.setIcon(exitEntered2_img);
				// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				userexit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				userexit_bt.setIcon(exitbasic2_img);
				// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				userexit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
		
		mkr_bt = new JButton("�游���");
		// �����ư�� �׵θ� ������ ������Ŵ.
		mkr_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		mkr_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		mkr_bt.setFocusPainted(false);
		
		// �游����ư�� ���õ� �����ʸ� ����.
		mkr_bt.addMouseListener(new MouseAdapter() {

			// �����ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �����ư�� �������� exitentered_img���� ����.
				//mkr_bt.setIcon(roomentered_img);
				// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				mkr_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				//mkr_bt.setIcon(roombasic_img);
				// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				mkr_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
		
		chatfield_tf = new JTextField("ID : ");
		chatfield_tf.setBounds(20, 665, 975, 48);
		chatfield_tf.setCaretPosition(chatfield_tf.getText().length());
		chatfield_tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == chatfield_tf)
				{
					sendchat_s = chatfield_tf.getText();
					chatarea_ta.append(sendchat_s + "\n");
					chatarea_ta.setCaretPosition(chatarea_ta.getDocument().getLength());
					chatfield_tf.setText("ID : ");
					chatfield_tf.setCaretPosition(chatfield_tf.getText().length());
				}
				
			}
		});
		
//		chatfield_tf.addKeyListener(new KeyAdapter() {
//			
//			public void KeyReleased(KeyEvent e)
//			{
//				if(e.getSource() == chatfield_tf)
//				{
//					if(e.getKeyCode() == KeyEvent.VK_ENTER)
//					{
//						sendchat_s = chatfield_tf.getText();
//						totalchat_s += sendchat_s;
//						chatarea_ta.setText(totalchat_s);
//						chatfield_tf.setText("ä��: ");
//					}
//				}
//			}
//		});
		
		chatarea_ta = new JTextArea(50, 10);
		chatarea_ta.setEditable(false);
		scroll = new JScrollPane(chatarea_ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(20, 510, 975, 155);
		
		room_p = new JPanel();
		room_p.setLayout(new BorderLayout());
		
		roomtop_p = new JPanel();
		roomtop_p.setLayout(new GridLayout(2, 2, 10, 10));
		
		roombot_p = new JPanel();
		roombot_p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		r1_bt = new JButton("��1");
		r2_bt = new JButton("��2");
		r3_bt = new JButton("��3");
		r4_bt = new JButton("��4");

		roomtop_p.add(r1_bt);
		roomtop_p.add(r2_bt);
		roomtop_p.add(r3_bt);
		roomtop_p.add(r4_bt);
		
		roombot_p.add(mkr_bt);
		
		room_p.add(roomtop_p, BorderLayout.CENTER);
		room_p.add(roombot_p, BorderLayout.SOUTH);
		
		room_p.setBounds(20, 50, 975, 450);
        
		rank_ta = new JTextArea("��ũ", 25, 20);
		rank_ta.setBounds(1010, 50, 250, 450);
		
		back_l = new JLabel(back_img);
		back_l.setBounds(0, 0, 1280, 720);
		
		user_p = new JPanel();
		user_p.setLayout(new GridLayout(2, 1));
		
		userbottom_p = new JPanel();
		userbottom_p.setLayout(new GridLayout(2, 1));
		
		id_tf = new JTextField("User ID");
		character_l = new JLabel(character1_img);
		
		userbottom_p.add(id_tf);
		userbottom_p.add(userexit_bt);
		
		user_p.add(character_l);
		user_p.add(userbottom_p);
		
		user_p.setBounds(1010, 510, 250, 210);
	
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
       
        room_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
        //chatarea_ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		chatfield_tf.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		rank_ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		user_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		
		add(room_p);
		add(scroll);
		add(chatfield_tf);
		add(rank_ta);
		add(user_p);
		add(exit_bt);
		add(menubar_l);
		add(back_l);
		
		setVisible(true);
		ButtonListener listen = new ButtonListener();
		mkr_bt.addActionListener(listen);
		exit_bt.addActionListener(listen);

	}

}
