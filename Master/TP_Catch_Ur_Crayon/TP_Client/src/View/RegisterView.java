package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterView extends JFrame{
	private JTextField id_tx;		
	private JPasswordField pw_pw;	
	private JLabel back_l, id_l, pw_l, menubar_l, char1_l, char2_l, char3_l, choose_l;	
	private JButton sign_bt, cancel_bt;	
	private JRadioButton character1, character2, character3;	
	private ButtonGroup charGroup;	

	private int mouseX, mouseY;
	
	private ImageIcon back_img = new ImageIcon("src/images/registerback.jpg");
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	private ImageIcon id_img = new ImageIcon("src/images/idImg.png");
	private ImageIcon pw_img = new ImageIcon("src/images/passwordImg.png");
	private ImageIcon signupBasic_img = new ImageIcon("src/images/signupBasic.png");
	private ImageIcon signupEntered_img = new ImageIcon("src/images/signupEntered.png");
	private ImageIcon cancelBasic_img = new ImageIcon("src/images/cancelBasic.png");
	private ImageIcon cancelEntered_img = new ImageIcon("src/images/cancelEntered.png");
	private ImageIcon character1_img = new ImageIcon("src/images/character1.png");
	private ImageIcon character2_img = new ImageIcon("src/images/character2.png");
	private ImageIcon character3_img = new ImageIcon("src/images/character3.png");
	private ImageIcon choose_img = new ImageIcon("src/images/choose.png");
	
	
	public RegisterView() {
				setLayout(null);
				setSize(450, 650);
				setUndecorated(true);
				setResizable(false);
				setLocation(400, 80);
				
				back_l = new JLabel(back_img);
				back_l.setBounds(0, 0, 450, 650);
				
				menubar_l = new JLabel(menu_img);
				menubar_l.setBounds(0, 0, 1280, 30);

				
				
				Font font = new Font("arian", Font.BOLD, 20);
				
				id_tx = new  JTextField();
				id_tx.setFont(font);
				id_tx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				id_tx.setBounds(150, 62, 260, 35);
				
				pw_pw = new JPasswordField();
				pw_pw.setFont(font);
				pw_pw.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				pw_pw.setBounds(150, 112, 260, 35);
				
				id_l = new JLabel(id_img);
				id_l.setBounds(50, 30, 100, 100);
				pw_l = new JLabel(pw_img);
				pw_l.setBounds(50, 80, 100, 100);
				
				sign_bt = new JButton(signupBasic_img);
				sign_bt.setBounds(50, 580, 150, 36);
				sign_bt.setBorderPainted(false);
				sign_bt.setContentAreaFilled(false);
				sign_bt.setFocusPainted(false);
	

				cancel_bt = new JButton(cancelBasic_img);
				cancel_bt.setBounds(250, 570, 150, 60);
				cancel_bt.setBorderPainted(false);
				cancel_bt.setContentAreaFilled(false);
				cancel_bt.setFocusPainted(false);
				
				
				character1 = new JRadioButton();
				character1.setBounds(70, 500, 50, 50);
				character1.setBorderPainted(false);
				character1.setContentAreaFilled(false);
				character1.setFocusPainted(false);
				
				
				
				character2 = new JRadioButton();
				character2.setBounds(220, 500, 50, 50);
				character2.setBorderPainted(false);
				character2.setContentAreaFilled(false);
				character2.setFocusPainted(false);
				
				
				character3 = new JRadioButton();
				character3.setBounds(360, 500, 50, 50);
				character3.setBorderPainted(false);
				character3.setContentAreaFilled(false);
				character3.setFocusPainted(false);
				
				
				character1.setSelected(true);
				charGroup = new ButtonGroup();
				charGroup.add(character1);
				charGroup.add(character2);
				charGroup.add(character3);
				
				char1_l = new JLabel(character1_img);
				char1_l.setBounds(30, 360, 100, 100);
				char2_l = new JLabel(character2_img);
				char2_l.setBounds(180, 320, 100, 150);
				char3_l = new JLabel(character3_img);
				char3_l.setBounds(320, 330, 100, 150);
				
				choose_l = new JLabel(choose_img);
				choose_l.setBounds(20, 90, 400, 250);
				
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
				
				setVisible(true);
	}
	
	public ImageIcon getSignupBasic_img() {
		return signupBasic_img;
	}



	public ImageIcon getSignupEntered_img() {
		return signupEntered_img;
	}



	public ImageIcon getCancelBasic_img() {
		return cancelBasic_img;
	}



	public ImageIcon getCancelEntered_img() {
		return cancelEntered_img;
	}



	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}



	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}



	public JLabel getMenubar_l() {
		return menubar_l;
	}



	public JButton getSign_bt() {
		return sign_bt;
	}



	public JButton getCancel_bt() {
		return cancel_bt;
	}



	public JRadioButton getCharacter1() {
		return character1;
	}



	public JRadioButton getCharacter2() {
		return character2;
	}



	public JRadioButton getCharacter3() {
		return character3;
	}



	public int getMouseX() {
		return mouseX;
	}



	public int getMouseY() {
		return mouseY;
	}



	
	
	public String getID() {
		return id_tx.getText();
	}
	
	public String getPW() {
		return pw_pw.getText();
	}
	
	public void resetText() {
		id_tx.setText("");
		pw_pw.setText("");
	}
	
}
