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
	private JButton login_bt, join_bt, exit_bt;			// 버튼 참조변수
	private JLabel id_l, pw_l, back_l, menubar_l;		// 라벨 참조변수
	private JTextField id_tx;							// 텍스트필드 참조변수
	private JPasswordField pw_pw;						// 패스워드필드 참조변수
	private start F;									// start 참조변수
	private register rg;								// register 참조변수
	
	// 배경화면이미지에 관한 이미지아이콘 생성.
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\background.jpg");
	// 메뉴바에 관한 이미지아이콘 생성.
	private ImageIcon menu_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\menubar.png");
	// 기본 종료버튼에 관한 이미지아이콘 생성.
	private ImageIcon exitbasic_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonBasic.png");
	// 종료버튼위에 마우스를 올렸을시에 보여줄 이미지에 관한 이미지 아이콘 생성.
	private ImageIcon exitentered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\exitButtonEntered.png");
	
	// login_bt버튼에 관한 이미지아이콘 생성.
	private ImageIcon login_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\login.png");
	// login_bt버튼에 마우스를 올렸을시에 이미지에 관한 이미지아이콘 생성.
	private ImageIcon loginEntered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\loginEntered.png");
	// join_bt버튼에 관한 이미지아이콘 생성.
	private ImageIcon join_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\join.png");
	// join_bt버튼에 마우스를 올렸을시에 이미지에 관한 이미지아이콘 생성.
	private ImageIcon joinEntered_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\joinEntered.png");
	// id_l라벨 이미지에 관한 이미지아이콘 생성.
	private ImageIcon id_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\id.png");
	// pw_l라벨 이미지에 관한 이미지아이콘 생성.
	private ImageIcon pw_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\pw.png");
	
	// 마우스의 x좌표 y좌표를 저장할 변수.
	private int mouseX, mouseY;
	
	// 이벤트 리스너 클래스 정의.
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// 선택된 버튼이 login_bt 일 경우.
			if (event.getSource() == login_bt) {
				
				// DB에 저장된 회원데이터와 비교하여 로그인시킬지 말지 판별하는 부분
				
				// 화면에 "로그인 되었습니다" 를 출력.
				JOptionPane.showMessageDialog(null, "로그인 되었습니다");
				// 카드레이아웃을 통해 패널을 이동시킴.
				F.changePanel();
				// 프레임의 사이즈를 정함.
				F.setSize(1280, 720);
			}
			// 선택된 버튼이 join_bt 일 경우.
			else 
			{
				// 회원가입 객체를 생성한다.
				rg = new register();
			}
		}
	}

	public LogIn(start f) {
		
		// 넘겨받은 프레임객체 지정.
		F = f;
		// 절대경로를 사용하기 위한 설정.
		setLayout(null);
		
		// back_img를 삽입하면서 배경용 라벨을 생성.
		back_l = new JLabel(back_img);
		// 배경이미지의 위치와 크기 지정.
		back_l.setBounds(0, 0, 1280, 720);
		
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
		
		// login_img를 삽입하며 버튼객체 생성.
		login_bt = new JButton(login_img);
		// login_bt의 위치와 크기 설정.
		login_bt.setBounds(515, 550, 120, 60);
		// 테두리 지움.
		login_bt.setBorderPainted(false);
		// 배경을 채우지 않게 설정.
		login_bt.setContentAreaFilled(false);
		// 포커스 효과를 없앰.
		login_bt.setFocusPainted(false);
		// 배경을 투명하게함.
		login_bt.setOpaque(false);
				
		// 로그인버튼에 관련된 리스너를 구현.
		login_bt.addMouseListener(new MouseAdapter() {
					
			// 로그인버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 로그인버튼의 아이콘을 loginEntered_img으로 설정.
				login_bt.setIcon(loginEntered_img);
				// 로그인버튼위에 커서가 있을시 핸드커서로 변경.
				login_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 로그인버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}
			
			// 로그인버튼에서 마우스를 내렸을때의 사건을 구현.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// 로그인버튼에서 마우스를 내렸을때의 아이콘을 login_img로 설정.
				login_bt.setIcon(login_img);
				// 로그인버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				login_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			// 로그인버튼을 클릭했을때의 사건을 구현.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 로그인버튼을 클릭했을시 나오는 효과음 선언.
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
				
	
		// join_img를 삽입하며 버튼객체 생성.
		join_bt = new JButton(join_img);
		// 크기와 위치를 지정.
		join_bt.setBounds(660, 550, 120, 60);
		// 테두리 지움.
		join_bt.setBorderPainted(false);
		// 배경을 채우지 않게 설정.
		join_bt.setContentAreaFilled(false);
		// 포커스 효과를 없앰.
		join_bt.setFocusPainted(false);
		// 배경을 투명하게함.
		join_bt.setOpaque(false);
				
		// 가입버튼에 관련된 리스너를 구현.
		join_bt.addMouseListener(new MouseAdapter() {
			
			// 가입버튼위에 마우스를 올렸을때의 사건을 구현.
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// 가입버튼의 아이콘을 joinEntered_img으로 설정.
				join_bt.setIcon(joinEntered_img);
				// 가입버튼위에 커서가 있을시 핸드커서로 변경.
				join_bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 가입버튼위에 커서를 올렸을 시 나오는 효과음 선언.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// 효과음 재생.
				buttonEnteredMusic.start();
			}
					
			// 가입버튼에서 마우스를 내렸을때의 사건을 구현.
			@Override
			public void mouseExited(MouseEvent e)
			{
				// 가입버튼에서 마우스를 내렸을때의 아이콘을 join_img로 설정.
				join_bt.setIcon(join_img);
				// 가입버튼에서 마우스를 내렸을때 커서를 기본커서로 설정.
				join_bt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
					
			// 가입버튼을 클릭했을때의 사건을 구현.
			@Override
			public void mousePressed(MouseEvent e)
			{
				// 가입버튼을 클릭했을시 나오는 효과음 선언.
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

		// id_img를 삽입하며 id_l라벨을 생성.
		id_l = new JLabel(id_img);
		// id_l의 위치와 크기를 지정.
		id_l.setBounds(490, 413, 100,100);
		
		// pw_img를 삽입하며 pw_l라벨을 생성.
		pw_l = new JLabel(pw_img);
		// pw_l의 위치와 크기를 지정.
		pw_l.setBounds(490, 463, 100,100);
		
		// 텍스트필드 객체 생성.
		id_tx = new JTextField(20);
		// 텍스트필드에 입력되는 글자의 폰트를 변경하기 위해 폰트객체를 생성.
		Font font = new Font("arian", Font.BOLD, 20);
		// id_tx 텍스트필드의 폰트를 font로 설정.
		id_tx.setFont(font);
		// id_tx의 위치와 크기를 지정.
		id_tx.setBounds(570, 450, 200, 25);
		// 텍스트필드에 입력되는 글자의 색을 지정.
		id_tx.setForeground(Color.BLACK);
		// 텍스트필드의 테두리를 지움.
		id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		id_tx.setHorizontalAlignment(JTextField.CENTER);
		
		// 패스워드필드 객체 생성.
		pw_pw = new JPasswordField(20);
		// pw_pw의 위치와 크기를 지정.
		pw_pw.setBounds(570, 500, 200, 25);
		// pw_pw의 폰트를 font로 설정.
		pw_pw.setFont(font);
		// 필드에 입력되는 글자의 색을 지정.
		pw_pw.setForeground(Color.BLACK);
		// 패스워드필드의 테두리를 지움.
		pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pw_pw.setHorizontalAlignment(JTextField.CENTER);
		
		// 현재 패널에 삽입해주는 부분
		add(login_bt);
		add(join_bt);
		add(id_l);
		add(pw_l);
		add(id_tx);
		add(pw_pw);
		add(exit_bt);
		add(menubar_l);
		add(back_l);

		// 버튼객체에 대한 이벤트 리스너 객체생성
		ButtonListener listen = new ButtonListener();
		// login_bt버튼에 대한 액션리스너에 listen을 삽입.
		login_bt.addActionListener(listen);
		// join_bt버튼에 대한 액션리스너에 listen을 삽입.
		join_bt.addActionListener(listen);
		
		// 화면을 보이게한다.
		setVisible(true);
		
	}
}
