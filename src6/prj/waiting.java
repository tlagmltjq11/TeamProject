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
	
	// 배경화면이미지에 관한 이미지아이콘 생성.
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\waitingback.jpg");
	// 메뉴바에 관한 이미지아이콘 생성.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// 기본 종료버튼에 관한 이미지아이콘 생성.
	private ImageIcon exitbasic_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonBasic.png");
	// 종료버튼위에 마우스를 올렸을시에 보여줄 이미지에 관한 이미지 아이콘 생성.
	private ImageIcon exitentered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonEntered.png");
	// 캐릭터1에 대한 이미지아이콘 생성.
	private ImageIcon character1_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\character1.png");
	
	private ImageIcon roombasic_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\roomBasic.png");
	private ImageIcon roomentered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\roomEntered.png");
	private ImageIcon exitbasic2_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitBasic2.png");
	private ImageIcon exitEntered2_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitEntered2.png");
	
	// 마우스의 x좌표 y좌표를 저장할 변수.
	private int mouseX, mouseY;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == mkr_bt) {
				mr = new make_room(F);

			} else {
				JOptionPane.showMessageDialog(null, "방에 입장합니다");
				F.changePanel();
			}
		}
	}

	public waiting(start f) {
		setLayout(null);
		F = f;
		
		// 종료버튼에 exitbasic_img를 삽입하며 생성.
		exit_bt = new JButton(exitbasic_img);
		// 종료버튼의 위치를 지정.
		exit_bt.setBounds(1245, 0, 30, 30);
		// 종료버튼의 테두리 설정을 해제시킴.
		exit_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		exit_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		exit_bt.setFocusPainted(false);

		// 종료버튼에 관련된 리스너를 구현.
		exit_bt.addMouseListener(new MouseAdapter() {

			// 종료버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 종료버튼의 아이콘을 exitentered_img으로 설정.
				exit_bt.setIcon(exitentered_img);
				// 종료버튼위에 커서가 있을시 핸드커서로 변경.
				exit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}

			/// 종료버튼에서 마우스를 내렸을때의 사건을 구현.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// 종료버튼에서 마우스를 내렸을때의 아이콘을 exitbasic_img로 설정.
				exit_bt.setIcon(exitbasic_img);
				// 종료버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				exit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 종료버튼을 클릭했을때의 사건을 구현.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 종료버튼을 클릭했을시 나오는 효과음 선언.
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// 효과음 재생.
				buttonPressedMusic.start();

				// 예외 처리.
				try {
					Thread.sleep(1000);	// 버튼을 누르자마자 꺼지면 효과음이 들리지 않기 때문에 1초 정도의 기간을 줌.
				}catch(InterruptedException ex)
				{
					// 에러가 발생한 메소드의 호출 기록을 출력함.
					ex.printStackTrace();
				}
				// 프로그램을 종료시킴.
				System.exit(0);
			}
		});
		
		// 메뉴바 라벨을 menu_img를 삽입하며 생성.
		menubar_l = new JLabel(menu_img);
		// 메뉴바의 위치를 설정.
		menubar_l.setBounds(0, 0, 1280, 30);

		// 마우스에 관한 리스너를 생성.
		menubar_l.addMouseListener(new MouseAdapter() {
			// 마우스로 해당 버튼을 눌렀을때에 관한 이벤트처리.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 이벤트가 발생했을때의 그 좌표를 얻어옴.
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});

		// 마우스에 관한 모션리스너를 생성.
		menubar_l.addMouseMotionListener(new MouseMotionAdapter() 
		{
			// 드래그가 발생했을때의 이벤트처리.
			@Override
			public void mouseDragged(MouseEvent e)
			{
				// 현재 스크린의 좌표를 얻어옴.
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();

				// 프레임의 위치를 드래그한곳으로 이동시킴.
				f.setLocation(x - mouseX, y - mouseY);
			}
		});
		
		userexit_bt = new JButton(exitbasic2_img); 
		// 종료버튼의 테두리 설정을 해제시킴.
		userexit_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		userexit_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		userexit_bt.setFocusPainted(false);
		
		// 종료버튼에 관련된 리스너를 구현.
		userexit_bt.addMouseListener(new MouseAdapter() {

			// 종료버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 종료버튼의 아이콘을 exitentered_img으로 설정.
				userexit_bt.setIcon(exitEntered2_img);
				// 종료버튼위에 커서가 있을시 핸드커서로 변경.
				userexit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}

			/// 종료버튼에서 마우스를 내렸을때의 사건을 구현.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// 종료버튼에서 마우스를 내렸을때의 아이콘을 exitbasic_img로 설정.
				userexit_bt.setIcon(exitbasic2_img);
				// 종료버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				userexit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 종료버튼을 클릭했을때의 사건을 구현.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 종료버튼을 클릭했을시 나오는 효과음 선언.
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// 효과음 재생.
				buttonPressedMusic.start();

				// 예외 처리.
				try {
					Thread.sleep(1000);	// 버튼을 누르자마자 꺼지면 효과음이 들리지 않기 때문에 1초 정도의 기간을 줌.
				}catch(InterruptedException ex)
				{
					// 에러가 발생한 메소드의 호출 기록을 출력함.
					ex.printStackTrace();
				}
				// 프로그램을 종료시킴.
				System.exit(0);
			}
		});
		
		mkr_bt = new JButton("방만들기");
		// 종료버튼의 테두리 설정을 해제시킴.
		mkr_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		mkr_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		mkr_bt.setFocusPainted(false);
		
		// 방만들기버튼에 관련된 리스너를 구현.
		mkr_bt.addMouseListener(new MouseAdapter() {

			// 종료버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 종료버튼의 아이콘을 exitentered_img으로 설정.
				//mkr_bt.setIcon(roomentered_img);
				// 종료버튼위에 커서가 있을시 핸드커서로 변경.
				mkr_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}

			/// 종료버튼에서 마우스를 내렸을때의 사건을 구현.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// 종료버튼에서 마우스를 내렸을때의 아이콘을 exitbasic_img로 설정.
				//mkr_bt.setIcon(roombasic_img);
				// 종료버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				mkr_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 종료버튼을 클릭했을때의 사건을 구현.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 종료버튼을 클릭했을시 나오는 효과음 선언.
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// 효과음 재생.
				buttonPressedMusic.start();

				// 예외 처리.
				try {
					Thread.sleep(1000);	// 버튼을 누르자마자 꺼지면 효과음이 들리지 않기 때문에 1초 정도의 기간을 줌.
				}catch(InterruptedException ex)
				{
					// 에러가 발생한 메소드의 호출 기록을 출력함.
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
//						chatfield_tf.setText("채팅: ");
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
		
		r1_bt = new JButton("방1");
		r2_bt = new JButton("방2");
		r3_bt = new JButton("방3");
		r4_bt = new JButton("방4");

		roomtop_p.add(r1_bt);
		roomtop_p.add(r2_bt);
		roomtop_p.add(r3_bt);
		roomtop_p.add(r4_bt);
		
		roombot_p.add(mkr_bt);
		
		room_p.add(roomtop_p, BorderLayout.CENTER);
		room_p.add(roombot_p, BorderLayout.SOUTH);
		
		room_p.setBounds(20, 50, 975, 450);
        
		rank_ta = new JTextArea("랭크", 25, 20);
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
