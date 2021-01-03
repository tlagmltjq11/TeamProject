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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ingame extends JPanel {
	private JPanel paint_p, paintgui_p, paintdraw_p, gui_p;	// 그림판 전체패널, 그림판중 ui패널, 그림판중 그림패널
	private JTextArea chat_txa;	 // 채팅판
	private JButton start_bt, exit_bt, pencil_bt, eraser_bt, eraseall_bt, colorselect_bt, menuexit_bt;	// 스타트버튼, 종료버튼, 연필버튼, 지우개버튼, 색변경버튼
	private JLabel background_l, linethickness_l, menubar_l;	// 뒷배경용 라벨, 선굵기를 나타내는 라벨
	private JTextField setlinethickness_tx, chat_tx;		// 선 굵기를 입력시키는 텍스트필드
	private Color selectedColor;		// 선택된 컬러를 나타냄.
	private Graphics graphics;		// 그래픽스 변수
	private Graphics2D graphics2;	// 선굵기를 위해 그래픽스2D 사용
	private int thickness = 10;		// 선굵기를 입력받을 변수
	private int startX;			// 시작 x좌표
	private int startY;			// 시작 y좌표
	private int endX;			// 끝 x좌표
	private int endY;			// 끝 y좌표
	private int mouseX, mouseY; // 메뉴바에사용할 좌표값.
	private start F;			// start에 대한 참조변수
	private boolean tf = false;		// ???????

	// 뒷배경라벨에 사용할 이미지아이콘 생성
	private ImageIcon ingameback_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\ingameback.jpg");
	// 메뉴바에 관한 이미지아이콘 생성.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// 기본 종료버튼에 관한 이미지아이콘 생성.
	private ImageIcon exitbasic_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonBasic.png");
	// 종료버튼위에 마우스를 올렸을시에 보여줄 이미지에 관한 이미지 아이콘 생성.
	private ImageIcon exitentered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonEntered.png");
	
	
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
		
		// font 생성
		Font font = new Font("함초롱돋움", Font.BOLD, 25);
		// 연필버튼을 생성
		pencil_bt = new JButton("연필");
		// 연필버튼의 폰트를 font로 설정
		pencil_bt.setFont(font);
		// 연필버튼의 위치와 크기를 지정.
		pencil_bt.setBounds(10,10,90,45);
		
		// 지우개 버튼을 생성
		eraser_bt = new JButton("지우개");
		// 지우개 버튼의 폰트를 font로 설정.
		eraser_bt.setFont(font);
		// 지우개 버튼의 위치와 크기를 지정.
		eraser_bt.setBounds(105,10,109,45);
		
		eraseall_bt = new JButton("clear");
		eraseall_bt.setFont(font);
		eraseall_bt.setBounds(245, 10, 110, 45);
		
		// 색변경 버튼 생성
		colorselect_bt = new  JButton("색변경");
		// 색변경 버튼의 폰트를 font로 설정.
		colorselect_bt.setFont(font);
		// 색변경 버튼의 위치와 크기를 지정.
		colorselect_bt.setBounds(370,10,110,45);
		
		// "굵기변경" 을 나타낼 라벨생성
		linethickness_l = new JLabel("굵기변경");
		// 굵기변경 라벨의 폰트를 font로 설정.
		linethickness_l.setFont(font);
		// 굵기변경 라벨의 위치와 크기 설정.
		linethickness_l.setBounds(680,10,100,45);
		
		// 굵기를 입력할 텍스트필드 생성 기본값 10을 줌
		setlinethickness_tx = new JTextField("10", 5);
		// 폰트를  font로 설정
		setlinethickness_tx.setFont(font);
		// 가운데 정렬로 설정.
		setlinethickness_tx.setHorizontalAlignment(JTextField.CENTER);
		// 위치와 크기를 지정.
		setlinethickness_tx.setBounds(780, 15, 50, 35);
		
		// ui패널에 삽입하는 부분.
		paintgui_p.add(pencil_bt);
		paintgui_p.add(eraser_bt);
		paintgui_p.add(eraseall_bt);
		paintgui_p.add(colorselect_bt);
		paintgui_p.add(linethickness_l);
		paintgui_p.add(setlinethickness_tx);
		
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
		paint_p.setBounds(80, 50, 900, 520);
		
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

		chat_txa = new JTextArea(20, 5);
		chat_txa.setBackground(Color.LIGHT_GRAY);
		chat_txa.setBounds(80, 570, 900, 100);
		
		chat_tx = new JTextField(20);
		chat_tx.setBounds(80,665,900,30);		
		
		gui_p = new JPanel();
		gui_p.setLayout(null);
		gui_p.setBounds(980, 50, 250, 644);
		
		add(paint_p);
		add(gui_p);
		add(chat_txa);
		add(chat_tx);
		add(menuexit_bt);
		add(menubar_l);
		add(background_l);
		
		setVisible(true);
	
		ButtonListener listen = new ButtonListener();
		//start_bt.addActionListener(listen);
		//exit_bt.addActionListener(listen);

	}
	
	
	// 시작버튼, 종료버튼에 대한 액션리스너
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == exit_bt) {
				JOptionPane.showMessageDialog(null, "대기실로 나갑니다");
				// 방을 나갈시 방입장 버튼이 비활성화 되어야 함. -> 서버 구현된 후 구현하기.
				F.changePanel();
				F.changePanel();
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
			}
			// 지우개버튼이 눌렸을떄 밑 if문장 블록범위내 문장 실행
			else if(e.getSource() == eraser_bt) 
			{
				// 그려지는 색상을 흰색으로 해줬기 때문에 흰색으로 펜이 그려져 지워지는 것처럼 보이게 한다.
				graphics2.setColor(Color.WHITE);
			}
			else if(e.getSource() == colorselect_bt)
			{
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
				// 패널을 초기화하여 다시 그려준다.
				repaint();
			}
		}
	}
}
