package prj;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class ingame extends JPanel {
	private JPanel paint_p, paintgui_p, paintdraw_p, gui_p, userinfo1_p, userinfo2_p, userinfo3_p, userinfo4_p;	// �׸��� ��ü�г�, �׸����� ui�г�, �׸����� �׸��г�
	private JTextArea chat_txa;	 // ä����
	private JButton ready_bt, exit_bt, pencil_bt, eraser_bt, eraseall_bt, colorselect_bt, menuexit_bt;	// ��ŸƮ��ư, �����ư, ���ʹ�ư, ���찳��ư, �������ư
	private JLabel background_l, linethickness_l, menubar_l, user1ID_l, user2ID_l, user3ID_l, user4ID_l, user1ch_l, user2ch_l, user3ch_l, user4ch_l, timer_l, theme_l, round_l;	// �޹��� ��, �����⸦ ��Ÿ���� ��
	private JTextField setlinethickness_tx, chat_tx, user1score_tx, user2score_tx, user3score_tx, user4score_tx, question_tx;		// �� ���⸦ �Է½�Ű�� �ؽ�Ʈ�ʵ�
	private Color selectedColor;		// ���õ� �÷��� ��Ÿ��.
	private Graphics graphics;		// �׷��Ƚ� ����
	private Graphics2D graphics2;	// �����⸦ ���� �׷��Ƚ�2D ���
	private JScrollPane scroll;
	private String sendchat_s;
	private int thickness = 10;		// �����⸦ �Է¹��� ����
	private int startX;			// ���� x��ǥ
	private int startY;			// ���� y��ǥ
	private int endX;			// �� x��ǥ
	private int endY;			// �� y��ǥ
	private int mouseX, mouseY; // �޴��ٿ������ ��ǥ��.
	private start F;			// start�� ���� ��������
	private boolean tf = false;		// ???????
	
	// �޹��󺧿� ����� �̹��������� ����
	private ImageIcon ingameback_img = new ImageIcon("src/images/ingameback.jpg");
	// �޴��ٿ� ���� �̹��������� ����.
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	// �⺻ �����ư�� ���� �̹��������� ����.
	private ImageIcon exitbasic_img = new ImageIcon("src/images/exitButtonBasic.png");
	// �����ư���� ���콺�� �÷����ÿ� ������ �̹����� ���� �̹��� ������ ����.
	private ImageIcon exitentered_img = new ImageIcon("src/images/exitButtonEntered.png");
	
	private ImageIcon pencil_img = new ImageIcon("src/images/pencil.png"); 
	private ImageIcon eraser_img = new ImageIcon("src/images/eraser.png"); 
	private ImageIcon clear_img = new ImageIcon("src/images/clear.png"); 
	private ImageIcon colorchooser_img = new ImageIcon("src/images/colorchooser.png"); 
	private ImageIcon exitBasic2_img = new ImageIcon("src/images/exitBasic2.png"); 
	private ImageIcon exitEntered2_img = new ImageIcon("src/images/exitEntered2.png"); 
	private ImageIcon readyBasic_img = new ImageIcon("src/images/readyBasic.png"); 
	private ImageIcon readyEntered_img = new ImageIcon("src/images/readyEntered.png"); 
	
	// ������ �޼ҵ�
	public ingame(start f) {
		// �����θ� ����ϱ� ���� ����.
		setLayout(null);
		// �Ѱܹ��� �����Ӱ�ü ����.
		F = f;
		
		// ingameback_img�� �����ϸ鼭 ���� �󺧻���
		background_l = new JLabel(ingameback_img);
		// ������ ��ġ�� ũ�� ����
		background_l.setBounds(0, 0, 1280, 720);

		//-----------------------------------------------------�޴��� �ڵ�-------------------------------------------------------
		
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
		
		// �����ư�� exitbasic_img�� �����ϸ� ����.
		menuexit_bt = new JButton(exitbasic_img);
		// �����ư�� ��ġ�� ����.
		menuexit_bt.setBounds(1245, 0, 30, 30);
		// �����ư�� �׵θ� ������ ������Ŵ.
		menuexit_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		menuexit_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		menuexit_bt.setFocusPainted(false);
		
		// �����ư�� ���õ� �����ʸ� ����.
		menuexit_bt.addMouseListener(new MouseAdapter() {

			// �����ư���� ���콺�� �÷������� ����� ����.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// �����ư�� �������� exitentered_img���� ����.
				menuexit_bt.setIcon(exitentered_img);
				// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
				menuexit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				menuexit_bt.setIcon(exitbasic_img);
				// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
				menuexit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

		//-----------------------------------------------------�޴��� �ڵ� ��-------------------------------------------------------
		
		//---------------------------------------�׸��� �ڵ�-------------------------------------------
		
		// �׸��� �г� ����
		paint_p = new JPanel();
		// �����θ� ����ϱ� ���� ����.
		paint_p.setLayout(null);
		
		// �׸��� �� ui�г� ����
		paintgui_p = new JPanel();
		// ����� ȸ������ ����.
		paintgui_p.setBackground(Color.gray);
		// �����θ� ����ϱ� ���� ����.
		paintgui_p.setLayout(null);
		
		// ���ʹ�ư�� ����
		pencil_bt = new JButton(pencil_img);
		// �����ư�� �׵θ� ������ ������Ŵ.
		pencil_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		pencil_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		pencil_bt.setFocusPainted(false);
		// ���ʹ�ư�� ��ġ�� ũ�⸦ ����.
		pencil_bt.setBounds(10,10,50,50);
		
		// ���찳 ��ư�� ����
		eraser_bt = new JButton(eraser_img);
		// �����ư�� �׵θ� ������ ������Ŵ.
		eraser_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		eraser_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		eraser_bt.setFocusPainted(false);
		// ���찳 ��ư�� ��ġ�� ũ�⸦ ����.
		eraser_bt.setBounds(65,10,50,50);
		
		eraseall_bt = new JButton(clear_img);
		// �����ư�� �׵θ� ������ ������Ŵ.
		eraseall_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		eraseall_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		eraseall_bt.setFocusPainted(false);
		eraseall_bt.setBounds(120, 10, 50, 50);
		
		// ������ ��ư ����
		colorselect_bt = new  JButton(colorchooser_img);
		// �����ư�� �׵θ� ������ ������Ŵ.
		colorselect_bt.setBorderPainted(false);
		// �����ư�� ����� ä���� ����.
		colorselect_bt.setContentAreaFilled(false);
		// �����ư�� ��Ŀ�� ǥ�� ����.
		colorselect_bt.setFocusPainted(false);
		// ������ ��ư�� ��ġ�� ũ�⸦ ����.
		colorselect_bt.setBounds(175,10,50,50);
		
		// font ����
		Font font = new Font("���ʷյ���", Font.BOLD, 25);
		// "���⺯��" �� ��Ÿ�� �󺧻���
		linethickness_l = new JLabel("Size");
		// ���⺯�� ���� ��Ʈ�� font�� ����.
		linethickness_l.setFont(font);
		// ���⺯�� ���� ��ġ�� ũ�� ����.
		linethickness_l.setBounds(230,20,60,45);
		
		// ���⸦ �Է��� �ؽ�Ʈ�ʵ� ���� �⺻�� 10�� ��
		setlinethickness_tx = new JTextField("10", 5);
		// ��Ʈ��  font�� ����
		setlinethickness_tx.setFont(font);
		// ��� ���ķ� ����.
		setlinethickness_tx.setHorizontalAlignment(JTextField.CENTER);
		// ��ġ�� ũ�⸦ ����.
		setlinethickness_tx.setBounds(285, 20, 50, 35);
		
		question_tx = new JTextField("���þ�");
		question_tx.setBounds(400, 15, 150, 40);
		
		theme_l = new JLabel("�׸�");
		theme_l.setBounds(350, 15, 50, 45);
		
		timer_l = new JLabel("Ÿ�̸�");
		timer_l.setBounds(700, 15, 50, 50);
		
		round_l = new JLabel("����");
		round_l.setBounds(800, 15, 50, 50);
		
		// ui�гο� �����ϴ� �κ�.
		paintgui_p.add(pencil_bt);
		paintgui_p.add(eraser_bt);
		paintgui_p.add(eraseall_bt);
		paintgui_p.add(colorselect_bt);
		paintgui_p.add(linethickness_l);
		paintgui_p.add(question_tx);
		paintgui_p.add(setlinethickness_tx);
		paintgui_p.add(theme_l);
		paintgui_p.add(timer_l);
		paintgui_p.add(round_l);
		
		// �׸��� �׸� �гλ���.
		paintdraw_p = new JPanel();
		// ����� �Ͼ������ ����.
		paintdraw_p.setBackground(Color.WHITE);
		
		// ui�г��� ��ġ�� ũ�� ����.
		paintgui_p.setBounds(0,0,900,60);
		// �׸��г��� ��ġ�� ũ�� ����.
		paintdraw_p.setBounds(0, 50, 900, 800);
		// �׸��� �гο� ui�� �׸��г��� ����
		paint_p.add(paintgui_p);
		paint_p.add(paintdraw_p);
		// �׸��� �г��� ��ġ�� ũ�⸦ ����.
		paint_p.setBounds(80, 40, 900, 520);
		
	
		// �׷��Ⱥ��� �ʱ�ȭ
		graphics = f.getGraphics();
		// graphics2�� graphic������ Graphics2Dȭ ���� ������. -> �����⺯�� ����� ����ϱ� ����
		graphics2 = (Graphics2D)graphics;
		graphics2.setColor(selectedColor);
		
		paintdraw_p.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		paintdraw_p.addMouseMotionListener(new PaintDraw());
		
		pencil_bt.addActionListener(new ToolActionListener());
		eraser_bt.addActionListener(new ToolActionListener());
		eraseall_bt.addActionListener(new ToolActionListener());
		colorselect_bt.addActionListener(new ToolActionListener());
		
		//-------------------------------------------------�׸��� �ڵ� ��-------------------------------------------
		
		//-------------------------------------------------�׸��� �� UI �ڵ�----------------------------------------
		
		// font ����
		Font font2 = new Font("���ʷյ���", Font.BOLD, 15);
		chat_tx = new JTextField("ID : ");
		chat_tx.setBounds(80, 660, 900, 48);
		chat_tx.setCaretPosition(chat_tx.getText().length());
		chat_tx.setFont(font2);
		chat_tx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == chat_tx)
				{
					sendchat_s = chat_tx.getText();
					chat_txa.append(sendchat_s + "\n");
					chat_txa.setCaretPosition(chat_txa.getDocument().getLength());
					chat_tx.setText("ID : ");
					chat_tx.setCaretPosition(chat_tx.getText().length());
				}

			}
		});		
		
		chat_txa = new JTextArea();
		chat_txa.setEditable(false);
		chat_txa.setFont(font2);
		scroll = new JScrollPane(chat_txa, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(80, 560, 900, 100);
		
		gui_p = new JPanel();
		gui_p.setLayout(null);
		gui_p.setBounds(980, 40, 250, 668);
		
		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
        Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
        
        gui_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
        chat_tx.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
        
        ready_bt = new JButton(readyBasic_img);
        ready_bt.setBounds(-2, 495, 250, 120);
        // �����ư�� �׵θ� ������ ������Ŵ.
        ready_bt.setBorderPainted(false);
        // �����ư�� ����� ä���� ����.
        ready_bt.setContentAreaFilled(false);
        // �����ư�� ��Ŀ�� ǥ�� ����.
        ready_bt.setFocusPainted(false);
        
        // �����ư�� ���õ� �����ʸ� ����.
        ready_bt.addMouseListener(new MouseAdapter() {

        	// �����ư���� ���콺�� �÷������� ����� ����.
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		// �����ư�� �������� exitentered_img���� ����.
        		ready_bt.setIcon(readyEntered_img);
        		// �����ư���� Ŀ���� ������ �ڵ�Ŀ���� ����.
        		ready_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        		ready_bt.setIcon(readyBasic_img);
        		// �����ư���� ���콺�� �������� Ŀ���� �⺻Ŀ���� ����.
        		ready_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        
        exit_bt = new JButton(exitBasic2_img);
        exit_bt.setBounds(-2, 565, 250, 120);
        //exit_bt.setRolloverIcon(exitEntered2_img);
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
        		exit_bt.setIcon(exitEntered2_img);
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
        		exit_bt.setIcon(exitBasic2_img);
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
        	}
        });
        
        userinfo1_p = new JPanel();
        userinfo1_p.setLayout(null);
        userinfo1_p.setBounds(5, 10, 240, 120);
      
        user1ch_l = new JLabel("ĳ����");
        user1ch_l.setBounds(20, 10, 100, 100);

        user1ID_l = new JLabel("������");
        user1ID_l.setBounds(100, 0, 100, 125);

        user1score_tx = new JTextField("1000��");
        user1score_tx.setBounds(100, 125, 100, 125);

        userinfo1_p.add(user1ch_l);
        userinfo1_p.add(user1ID_l);
        userinfo1_p.add(user1score_tx);

        //----------------user1
        
        userinfo2_p = new JPanel();
        userinfo2_p.setLayout(null);
        userinfo2_p.setBounds(5, 135, 240, 120);
        
        user2ch_l = new JLabel("ĳ����");
        user2ch_l.setBounds(0, 0, 100, 100);

        user2ID_l = new JLabel("������");
        user2ID_l.setBounds(100, 0, 100, 125);

        user2score_tx = new JTextField("1000��");
        user2score_tx.setBounds(100, 125, 100, 125);

        userinfo2_p.add(user2ch_l);
        userinfo2_p.add(user2ID_l);
        userinfo2_p.add(user2score_tx);

        //----------------user2
        
        userinfo3_p = new JPanel();
        userinfo3_p.setLayout(null);
        userinfo3_p.setBounds(5, 260, 240, 120);
        
        user3ch_l = new JLabel("ĳ����");
        user3ch_l.setBounds(0, 0, 100, 100);

        user3ID_l = new JLabel("�̽�ȣ");
        user3ID_l.setBounds(100, 0, 100, 125);

        user3score_tx = new JTextField("1000��");
        user3score_tx.setBounds(100, 125, 100, 125);

        userinfo3_p.add(user3ch_l);
        userinfo3_p.add(user3ID_l);
        userinfo3_p.add(user3score_tx);
        
        //----------------user3
        
        userinfo4_p = new JPanel();
        userinfo4_p.setLayout(null);
        userinfo4_p.setBounds(5, 385, 240, 120);
        
        user4ch_l = new JLabel("ĳ����");
        user4ch_l.setBounds(0, 0, 100, 100);

        user4ID_l = new JLabel("����");
        user4ID_l.setBounds(100, 0, 100, 125);

        user4score_tx = new JTextField("1000��");
        user4score_tx.setBounds(100, 125, 100, 125);

        userinfo4_p.add(user4ch_l);
        userinfo4_p.add(user4ID_l);
        userinfo4_p.add(user4score_tx);
        
        //----------------user4
        
        List<JLabel> charlist = new ArrayList<>();
        charlist.add(user1ch_l);
        charlist.add(user2ch_l);
        charlist.add(user3ch_l);
        charlist.add(user4ch_l);
        
        List<JLabel> idlist = new ArrayList<>();
        idlist.add(user1ID_l);
        idlist.add(user2ID_l);
        idlist.add(user3ID_l);
        idlist.add(user4ID_l);
        
        List<JTextField> sclist = new ArrayList<>();
        sclist.add(user1score_tx);
        sclist.add(user2score_tx);
        sclist.add(user3score_tx);
        sclist.add(user4score_tx);
        
        
        //idlist.get(0).setText("��Ű��");
        
        gui_p.setBackground(Color.WHITE);
        gui_p.add(userinfo1_p);
        gui_p.add(userinfo2_p);
        gui_p.add(userinfo3_p);
        gui_p.add(userinfo4_p);
        gui_p.add(ready_bt);
        gui_p.add(exit_bt);
        
       //-------------------------------------------------�׸��� �� UI �ڵ� ��----------------------------------------
        
		add(paint_p);
		add(gui_p);
		add(scroll);
		add(chat_tx);
		add(menuexit_bt);
		add(menubar_l);
		add(background_l);
		
		setVisible(true);
	
		ButtonListener listen = new ButtonListener();
		ready_bt.addActionListener(listen);
		exit_bt.addActionListener(listen);

	}
	
	
	// ���۹�ư, �����ư�� ���� �׼Ǹ�����
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exit_bt) {
				JOptionPane.showMessageDialog(null, "���Ƿ� �����ϴ�");
				// ���� ������ ������ ��ư�� ��Ȱ��ȭ �Ǿ�� ��. -> ���� ������ �� �����ϱ�.
				F.cards.show(F.getContentPane(), "Two");
			} else {

			}
		}
	}

	// �׸��� �׸� �гο� ���� ���콺 ��Ǹ����� ����
	public class PaintDraw implements MouseMotionListener
	{

		// ���콺 �巡�� �޼ҵ�
		@Override
		public void mouseDragged(MouseEvent e) {
			// thickness�� setlinethickness_tx�� ����� ���ڿ����� ����ȭ���� ������.
			thickness = Integer.parseInt(setlinethickness_tx.getText());

			// ���� x��ǥ�� ���� ����.
			endX = e.getX();

			// ���� y��ǥ�� ���� ����.
			endY = e.getY();
			
			if(endX < 0 || endY < 0 || endX > 895 || endY > 455)
			{
				return;
			}

			graphics2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, 0));
			graphics2.drawLine(startX+82, startY+100, endX+82, endY+100);

			startX = endX;

			startY = endY;

		}

		// ������� ������ implements �߱⿡ ���ܵ־���.
		@Override
		public void mouseMoved(MouseEvent e) 
		{

		}
	}

	// ����, ���찳, clear, �����濡 ���� �׼Ǹ�����
	public class ToolActionListener implements ActionListener {
		
		// �������̵��� actionPerformed�޼ҵ� ����
		public void actionPerformed(ActionEvent e )
		{
			// ���ʹ�ư�� �������� �� if���� ��Ϲ����� ���� ����
			if(e.getSource() == pencil_bt) 
			{ 
				if(tf == false) 
					{
					 	// �׷����� ������ ������ ����
						graphics2.setColor(Color.BLACK);
					}
				else 
					{
						// �׷����� ������ selectedColor������ ������ ����
						graphics2.setColor(selectedColor);
					}
				// �����ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
			// ���찳��ư�� �������� �� if���� ��Ϲ����� ���� ����
			else if(e.getSource() == eraser_bt) 
			{
				// �׷����� ������ ������� ����� ������ ������� ���� �׷��� �������� ��ó�� ���̰� �Ѵ�.
				graphics2.setColor(Color.WHITE);
				// �����ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
			}
			else if(e.getSource() == colorselect_bt)
			{
				// �����ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
				// ���� ��������� �˷���.
				tf = true;
				// JColorChooser ����
				JColorChooser chooser = new JColorChooser();
				// ���õ� �÷����� selectedColor�� ����
				selectedColor = chooser.showDialog(null, "Color", Color.orange);
				// ���� ���� ����.
				graphics2.setColor(selectedColor);
			}
			else
			{
				// �����ư���� Ŀ���� �÷��� �� ������ ȿ���� ����.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// ȿ���� ���.
				buttonEnteredMusic.start();
				// �г��� �ʱ�ȭ�Ͽ� �ٽ� �׷��ش�.
				repaint();
			}
		}
	}
}
