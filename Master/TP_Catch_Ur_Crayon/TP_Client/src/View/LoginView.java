package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LoginView extends JPanel{
	private JButton login_bt, join_bt, exit_bt;			
	private JLabel id_l, pw_l, back_l, menubar_l;		
	private JTextField id_tx;							
	private JPasswordField pw_pw;						
	private ImageIcon back_img = new ImageIcon("src/images/background.jpg");
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	private ImageIcon exitbasic_img = new ImageIcon("src/images/exitButtonBasic.png");
	private ImageIcon exitentered_img = new ImageIcon("src/images/exitButtonEntered.png");

	private ImageIcon login_img = new ImageIcon("src/images/login.png");
	private ImageIcon loginEntered_img = new ImageIcon("src/images/loginEntered.png");
	private ImageIcon join_img = new ImageIcon("src/images/join.png");
	private ImageIcon joinEntered_img = new ImageIcon("src/images/joinEntered.png");
	private ImageIcon id_img = new ImageIcon("src/images/id.png");
	private ImageIcon pw_img = new ImageIcon("src/images/pw.png");

	private int mouseX, mouseY;

	public LoginView() {
		setLayout(null);

		back_l = new JLabel(back_img);
		back_l.setBounds(0, 0, 1280, 720);

		exit_bt = new JButton(exitbasic_img);
		exit_bt.setBounds(1245, 0, 30, 30);
		exit_bt.setBorderPainted(false);
		exit_bt.setContentAreaFilled(false);
		exit_bt.setFocusPainted(false);



		login_bt = new JButton(login_img);
		login_bt.setBounds(515, 550, 120, 60);
		login_bt.setBorderPainted(false);
		login_bt.setContentAreaFilled(false);
		login_bt.setFocusPainted(false);
		login_bt.setOpaque(false);




		join_bt = new JButton(join_img);
		join_bt.setBounds(660, 550, 120, 60);
		join_bt.setBorderPainted(false);
		join_bt.setContentAreaFilled(false);
		join_bt.setFocusPainted(false);
		join_bt.setOpaque(false);



		menubar_l = new JLabel(menu_img);
		menubar_l.setBounds(0, 0, 1280, 30);





		id_l = new JLabel(id_img);
		id_l.setBounds(490, 413, 100,100);

		pw_l = new JLabel(pw_img);
		pw_l.setBounds(490, 463, 100,100);

		id_tx = new JTextField(20);
		Font font = new Font("arian", Font.BOLD, 20);
		id_tx.setFont(font);
		id_tx.setBounds(570, 450, 200, 25);
		id_tx.setForeground(Color.BLACK);
		id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		pw_pw = new JPasswordField(20);
		pw_pw.setBounds(570, 500, 200, 25);
		pw_pw.setFont(font);
		pw_pw.setForeground(Color.BLACK);
		pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		add(login_bt);
		add(join_bt);
		add(id_l);
		add(pw_l);
		add(id_tx);
		add(pw_pw);
		add(exit_bt);
		add(menubar_l);
		add(back_l);
	}

	public JButton getLogin_bt() {
		return login_bt;
	}

	public JButton getJoin_bt() {
		return join_bt;
	}

	public JButton getExit_bt() {
		return exit_bt;
	}

	public JLabel getMenubar_l() {
		return menubar_l;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public ImageIcon getExitbasic_img() {
		return exitbasic_img;
	}

	public ImageIcon getExitentered_img() {
		return exitentered_img;
	}

	public ImageIcon getLogin_img() {
		return login_img;
	}

	public ImageIcon getLoginEntered_img() {
		return loginEntered_img;
	}

	public ImageIcon getJoin_img() {
		return join_img;
	}

	public ImageIcon getJoinEntered_img() {
		return joinEntered_img;
	}

	public String getID() {
		return id_tx.getText();
	}
	
	public String getPW() {
		return pw_pw.getText();
	}
	
	public void resetPW() {
		pw_pw.setText("");
	}
	
	public void resetText() {
		id_tx.setText("");
		pw_pw.setText("");
	}
	
}
