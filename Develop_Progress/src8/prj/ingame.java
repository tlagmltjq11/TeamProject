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
	private JPanel paint_p, paintgui_p, paintdraw_p, gui_p, userinfo1_p, userinfo2_p, userinfo3_p, userinfo4_p;	// 그림판 전체패널, 그림판중 ui패널, 그림판중 그림패널
	private JTextArea chat_txa;	 // 채팅판
	private JButton ready_bt, exit_bt, pencil_bt, eraser_bt, eraseall_bt, colorselect_bt, menuexit_bt;	// 스타트버튼, 종료버튼, 연필버튼, 지우개버튼, 색변경버튼
	private JLabel background_l, linethickness_l, menubar_l, user1ID_l, user2ID_l, user3ID_l, user4ID_l, user1ch_l, user2ch_l, user3ch_l, user4ch_l, timer_l, theme_l, round_l;	// 뒷배경용 라벨, 선굵기를 나타내는 라벨
	private JTextField setlinethickness_tx, chat_tx, user1score_tx, user2score_tx, user3score_tx, user4score_tx, question_tx;		// 선 굵기를 입력시키는 텍스트필드
	private Color selectedColor;		// 선택된 컬러를 나타냄.
	private Graphics graphics;		// 그래픽스 변수
	private Graphics2D graphics2;	// 선굵기를 위해 그래픽스2D 사용
	private JScrollPane scroll;
	private String sendchat_s;
	private int thickness = 10;		// 선굵기를 입력받을 변수
	private int startX;			// 시작 x좌표
	private int startY;			// 시작 y좌표
	private int endX;			// 끝 x좌표
	private int endY;			// 끝 y좌표
	private int mouseX, mouseY; // 메뉴바에사용할 좌표값.
	private start F;			// start에 대한 참조변수
	private boolean tf = false;		// ???????
	
	// 뒷배경라벨에 사용할 이미지아이콘 생성
	private ImageIcon ingameback_img = new ImageIcon("src/images/ingameback.jpg");
	// 메뉴바에 관한 이미지아이콘 생성.
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	// 기본 종료버튼에 관한 이미지아이콘 생성.
	private ImageIcon exitbasic_img = new ImageIcon("src/images/exitButtonBasic.png");
	// 종료버튼위에 마우스를 올렸을시에 보여줄 이미지에 관한 이미지 아이콘 생성.
	private ImageIcon exitentered_img = new ImageIcon("src/images/exitButtonEntered.png");
	
	private ImageIcon pencil_img = new ImageIcon("src/images/pencil.png"); 
	private ImageIcon eraser_img = new ImageIcon("src/images/eraser.png"); 
	private ImageIcon clear_img = new ImageIcon("src/images/clear.png"); 
	private ImageIcon colorchooser_img = new ImageIcon("src/images/colorchooser.png"); 
	private ImageIcon exitBasic2_img = new ImageIcon("src/images/exitBasic2.png"); 
	private ImageIcon exitEntered2_img = new ImageIcon("src/images/exitEntered2.png"); 
	private ImageIcon readyBasic_img = new ImageIcon("src/images/readyBasic.png"); 
	private ImageIcon readyEntered_img = new ImageIcon("src/images/readyEntered.png"); 
	
	// 생성자 메소드
	public ingame(start f) {
		// 절대경로를 사용하기 위한 설정.
		setLayout(null);
		// 넘겨받은 프레임객체 지정.
		F = f;
		
		// ingameback_img를 삽입하면서 배경용 라벨생성
		background_l = new JLabel(ingameback_img);
		// 배경라벨의 위치와 크기 지정
		background_l.setBounds(0, 0, 1280, 720);

		//-----------------------------------------------------메뉴바 코드-------------------------------------------------------
		
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
		
		// 종료버튼에 exitbasic_img를 삽입하며 생성.
		menuexit_bt = new JButton(exitbasic_img);
		// 종료버튼의 위치를 지정.
		menuexit_bt.setBounds(1245, 0, 30, 30);
		// 종료버튼의 테두리 설정을 해제시킴.
		menuexit_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		menuexit_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		menuexit_bt.setFocusPainted(false);
		
		// 종료버튼에 관련된 리스너를 구현.
		menuexit_bt.addMouseListener(new MouseAdapter() {

			// 종료버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 종료버튼의 아이콘을 exitentered_img으로 설정.
				menuexit_bt.setIcon(exitentered_img);
				// 종료버튼위에 커서가 있을시 핸드커서로 변경.
				menuexit_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
				menuexit_bt.setIcon(exitbasic_img);
				// 종료버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				menuexit_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

		//-----------------------------------------------------메뉴바 코드 끝-------------------------------------------------------
		
		//---------------------------------------그림판 코드-------------------------------------------
		
		// 그림판 패널 생성
		paint_p = new JPanel();
		// 절대경로를 사용하기 위한 설정.
		paint_p.setLayout(null);
		
		// 그림판 중 ui패널 생성
		paintgui_p = new JPanel();
		// 배경을 회색으로 지정.
		paintgui_p.setBackground(Color.gray);
		// 절대경로를 사용하기 위한 설정.
		paintgui_p.setLayout(null);
		
		// 연필버튼을 생성
		pencil_bt = new JButton(pencil_img);
		// 종료버튼의 테두리 설정을 해제시킴.
		pencil_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		pencil_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		pencil_bt.setFocusPainted(false);
		// 연필버튼의 위치와 크기를 지정.
		pencil_bt.setBounds(10,10,50,50);
		
		// 지우개 버튼을 생성
		eraser_bt = new JButton(eraser_img);
		// 종료버튼의 테두리 설정을 해제시킴.
		eraser_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		eraser_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		eraser_bt.setFocusPainted(false);
		// 지우개 버튼의 위치와 크기를 지정.
		eraser_bt.setBounds(65,10,50,50);
		
		eraseall_bt = new JButton(clear_img);
		// 종료버튼의 테두리 설정을 해제시킴.
		eraseall_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		eraseall_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		eraseall_bt.setFocusPainted(false);
		eraseall_bt.setBounds(120, 10, 50, 50);
		
		// 색변경 버튼 생성
		colorselect_bt = new  JButton(colorchooser_img);
		// 종료버튼의 테두리 설정을 해제시킴.
		colorselect_bt.setBorderPainted(false);
		// 종료버튼의 배경을 채우지 않음.
		colorselect_bt.setContentAreaFilled(false);
		// 종료버튼의 포커스 표시 설정.
		colorselect_bt.setFocusPainted(false);
		// 색변경 버튼의 위치와 크기를 지정.
		colorselect_bt.setBounds(175,10,50,50);
		
		// font 생성
		Font font = new Font("함초롱돋움", Font.BOLD, 25);
		// "굵기변경" 을 나타낼 라벨생성
		linethickness_l = new JLabel("Size");
		// 굵기변경 라벨의 폰트를 font로 설정.
		linethickness_l.setFont(font);
		// 굵기변경 라벨의 위치와 크기 설정.
		linethickness_l.setBounds(230,20,60,45);
		
		// 굵기를 입력할 텍스트필드 생성 기본값 10을 줌
		setlinethickness_tx = new JTextField("10", 5);
		// 폰트를  font로 설정
		setlinethickness_tx.setFont(font);
		// 가운데 정렬로 설정.
		setlinethickness_tx.setHorizontalAlignment(JTextField.CENTER);
		// 위치와 크기를 지정.
		setlinethickness_tx.setBounds(285, 20, 50, 35);
		
		question_tx = new JTextField("제시어");
		question_tx.setBounds(400, 15, 150, 40);
		
		theme_l = new JLabel("테마");
		theme_l.setBounds(350, 15, 50, 45);
		
		timer_l = new JLabel("타이머");
		timer_l.setBounds(700, 15, 50, 50);
		
		round_l = new JLabel("라운드");
		round_l.setBounds(800, 15, 50, 50);
		
		// ui패널에 삽입하는 부분.
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
		
		// 그림을 그릴 패널생성.
		paintdraw_p = new JPanel();
		// 배경을 하얀색으로 설정.
		paintdraw_p.setBackground(Color.WHITE);
		
		// ui패널의 위치와 크기 지정.
		paintgui_p.setBounds(0,0,900,60);
		// 그림패널의 위치와 크기 지정.
		paintdraw_p.setBounds(0, 50, 900, 800);
		// 그림판 패널에 ui와 그림패널을 삽입
		paint_p.add(paintgui_p);
		paint_p.add(paintdraw_p);
		// 그림판 패널의 위치와 크기를 지정.
		paint_p.setBounds(80, 40, 900, 520);
		
	
		// 그래픽변수 초기화
		graphics = f.getGraphics();
		// graphics2에 graphic변수를 Graphics2D화 시켜 저장함. -> 선굵기변경 기능을 사용하기 위함
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
		
		//-------------------------------------------------그림판 코드 끝-------------------------------------------
		
		//-------------------------------------------------그림판 외 UI 코드----------------------------------------
		
		// font 생성
		Font font2 = new Font("함초롱돋움", Font.BOLD, 15);
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
        // 종료버튼의 테두리 설정을 해제시킴.
        ready_bt.setBorderPainted(false);
        // 종료버튼의 배경을 채우지 않음.
        ready_bt.setContentAreaFilled(false);
        // 종료버튼의 포커스 표시 설정.
        ready_bt.setFocusPainted(false);
        
        // 종료버튼에 관련된 리스너를 구현.
        ready_bt.addMouseListener(new MouseAdapter() {

        	// 종료버튼위에 마우스를 올렸을때의 사건을 구현.
        	@Override
        	public void mouseEntered(MouseEvent e)
        	{
        		// 종료버튼의 아이콘을 exitentered_img으로 설정.
        		ready_bt.setIcon(readyEntered_img);
        		// 종료버튼위에 커서가 있을시 핸드커서로 변경.
        		ready_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        		ready_bt.setIcon(readyBasic_img);
        		// 종료버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
        		ready_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        
        exit_bt = new JButton(exitBasic2_img);
        exit_bt.setBounds(-2, 565, 250, 120);
        //exit_bt.setRolloverIcon(exitEntered2_img);
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
        		exit_bt.setIcon(exitEntered2_img);
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
        		exit_bt.setIcon(exitBasic2_img);
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
        	}
        });
        
        userinfo1_p = new JPanel();
        userinfo1_p.setLayout(null);
        userinfo1_p.setBounds(5, 10, 240, 120);
      
        user1ch_l = new JLabel("캐릭터");
        user1ch_l.setBounds(20, 10, 100, 100);

        user1ID_l = new JLabel("김준형");
        user1ID_l.setBounds(100, 0, 100, 125);

        user1score_tx = new JTextField("1000점");
        user1score_tx.setBounds(100, 125, 100, 125);

        userinfo1_p.add(user1ch_l);
        userinfo1_p.add(user1ID_l);
        userinfo1_p.add(user1score_tx);

        //----------------user1
        
        userinfo2_p = new JPanel();
        userinfo2_p.setLayout(null);
        userinfo2_p.setBounds(5, 135, 240, 120);
        
        user2ch_l = new JLabel("캐릭터");
        user2ch_l.setBounds(0, 0, 100, 100);

        user2ID_l = new JLabel("손진영");
        user2ID_l.setBounds(100, 0, 100, 125);

        user2score_tx = new JTextField("1000점");
        user2score_tx.setBounds(100, 125, 100, 125);

        userinfo2_p.add(user2ch_l);
        userinfo2_p.add(user2ID_l);
        userinfo2_p.add(user2score_tx);

        //----------------user2
        
        userinfo3_p = new JPanel();
        userinfo3_p.setLayout(null);
        userinfo3_p.setBounds(5, 260, 240, 120);
        
        user3ch_l = new JLabel("캐릭터");
        user3ch_l.setBounds(0, 0, 100, 100);

        user3ID_l = new JLabel("이승호");
        user3ID_l.setBounds(100, 0, 100, 125);

        user3score_tx = new JTextField("1000점");
        user3score_tx.setBounds(100, 125, 100, 125);

        userinfo3_p.add(user3ch_l);
        userinfo3_p.add(user3ID_l);
        userinfo3_p.add(user3score_tx);
        
        //----------------user3
        
        userinfo4_p = new JPanel();
        userinfo4_p.setLayout(null);
        userinfo4_p.setBounds(5, 385, 240, 120);
        
        user4ch_l = new JLabel("캐릭터");
        user4ch_l.setBounds(0, 0, 100, 100);

        user4ID_l = new JLabel("심희섭");
        user4ID_l.setBounds(100, 0, 100, 125);

        user4score_tx = new JTextField("1000점");
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
        
        
        //idlist.get(0).setText("쌉키모");
        
        gui_p.setBackground(Color.WHITE);
        gui_p.add(userinfo1_p);
        gui_p.add(userinfo2_p);
        gui_p.add(userinfo3_p);
        gui_p.add(userinfo4_p);
        gui_p.add(ready_bt);
        gui_p.add(exit_bt);
        
       //-------------------------------------------------그림판 외 UI 코드 끝----------------------------------------
        
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
	
	
	// 시작버튼, 종료버튼에 대한 액션리스너
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exit_bt) {
				JOptionPane.showMessageDialog(null, "대기실로 나갑니다");
				// 방을 나갈시 방입장 버튼이 비활성화 되어야 함. -> 서버 구현된 후 구현하기.
				F.cards.show(F.getContentPane(), "Two");
			} else {

			}
		}
	}

	// 그림을 그릴 패널에 대한 마우스 모션리스너 생성
	public class PaintDraw implements MouseMotionListener
	{

		// 마우스 드래그 메소드
		@Override
		public void mouseDragged(MouseEvent e) {
			// thickness에 setlinethickness_tx에 저장된 문자열값을 정수화시켜 저장함.
			thickness = Integer.parseInt(setlinethickness_tx.getText());

			// 끝점 x좌표를 구해 저장.
			endX = e.getX();

			// 끝점 y좌표를 구해 저장.
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

		// 사용하지 않지만 implements 했기에 남겨둬야함.
		@Override
		public void mouseMoved(MouseEvent e) 
		{

		}
	}

	// 연필, 지우개, clear, 색변경에 대한 액션리스너
	public class ToolActionListener implements ActionListener {
		
		// 오버라이딩된 actionPerformed메소드 실행
		public void actionPerformed(ActionEvent e )
		{
			// 연필버튼이 눌렸을떄 밑 if문장 블록범위내 문장 실행
			if(e.getSource() == pencil_bt) 
			{ 
				if(tf == false) 
					{
					 	// 그려지는 색상을 검은색 지정
						graphics2.setColor(Color.BLACK);
					}
				else 
					{
						// 그려지는 색상을 selectedColor변수의 값으로 지정
						graphics2.setColor(selectedColor);
					}
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}
			// 지우개버튼이 눌렸을떄 밑 if문장 블록범위내 문장 실행
			else if(e.getSource() == eraser_bt) 
			{
				// 그려지는 색상을 흰색으로 해줬기 때문에 흰색으로 펜이 그려져 지워지는 것처럼 보이게 한다.
				graphics2.setColor(Color.WHITE);
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}
			else if(e.getSource() == colorselect_bt)
			{
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
				// 색이 변경됐음을 알려줌.
				tf = true;
				// JColorChooser 생성
				JColorChooser chooser = new JColorChooser();
				// 선택된 컬러값을 selectedColor에 저장
				selectedColor = chooser.showDialog(null, "Color", Color.orange);
				// 선의 색을 지정.
				graphics2.setColor(selectedColor);
			}
			else
			{
				// 종료버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
				// 패널을 초기화하여 다시 그려준다.
				repaint();
			}
		}
	}
}
