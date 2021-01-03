package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import Starter.Application;


public class IngameView extends JPanel{

	
	private JPanel paint_p, paintgui_p, paintdraw_p, gui_p, userinfo1_p, userinfo2_p, userinfo3_p, userinfo4_p;	
	private JTextArea chat_txa;	 
	private JButton ready_bt, exit_bt, pencil_bt, eraser_bt, eraseall_bt, colorselect_bt, menuexit_bt;	
	private JLabel character_l, background_l, linethickness_l, menubar_l, user1ID_l, user2ID_l, user3ID_l, user4ID_l, user1ch_l, user2ch_l, user3ch_l, user4ch_l, timer_l, theme_l, round_l;
	private JTextField setlinethickness_tx, chat_tx, user1score_tx, user2score_tx, user3score_tx, user4score_tx, question_tx;		
	private Color selectedColor;		
	private Graphics graphics;		
	private Graphics2D graphics2;	
	private JScrollPane scroll;
	private String sendchat_s, avatar;
	private int thickness = 10;		
	private int startX;			
	private int startY;			
	private int endX;			
	private int endY;			
	private int mouseX, mouseY; 
	private boolean tf = false;		
	private List<JLabel> charlist;
	private List<JLabel> idlist;
    private List<JTextField> sclist;
    public int num = 0;
	
	private ImageIcon ingameback_img = new ImageIcon("src/images/ingameback.jpg");
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	private ImageIcon exitbasic_img = new ImageIcon("src/images/exitButtonBasic.png");
	private ImageIcon exitentered_img = new ImageIcon("src/images/exitButtonEntered.png");
	private ImageIcon pencil_img = new ImageIcon("src/images/pencil.png"); 
	private ImageIcon eraser_img = new ImageIcon("src/images/eraser.png"); 
	private ImageIcon clear_img = new ImageIcon("src/images/clear.png"); 
	private ImageIcon colorchooser_img = new ImageIcon("src/images/colorchooser.png"); 
	private ImageIcon exitBasic2_img = new ImageIcon("src/images/exitBasic2.png"); 
	private ImageIcon exitEntered2_img = new ImageIcon("src/images/exitEntered2.png"); 
	private ImageIcon readyBasic_img = new ImageIcon("src/images/readyBasic.png"); 
	private ImageIcon readyEntered_img = new ImageIcon("src/images/readyEntered.png"); 

	private ImageIcon character_img = new ImageIcon("src/images/character1.png");
	private ImageIcon chosen_character;
	
	public IngameView(Application app) {
				setLayout(null);
				
				
				background_l = new JLabel(ingameback_img);
				background_l.setBounds(0, 0, 1280, 720);

				menubar_l = new JLabel(menu_img);
				menubar_l.setBounds(0, 0, 1280, 30);

				

				menuexit_bt = new JButton(exitbasic_img);
				menuexit_bt.setBounds(1245, 0, 30, 30);
				menuexit_bt.setBorderPainted(false);
				menuexit_bt.setContentAreaFilled(false);
				menuexit_bt.setFocusPainted(false);
				
				

				paint_p = new JPanel();
				paint_p.setLayout(null);
				
				paintgui_p = new JPanel();
				paintgui_p.setBackground(Color.gray);
				paintgui_p.setLayout(null);
				
				pencil_bt = new JButton(pencil_img);
				pencil_bt.setBorderPainted(false);
				pencil_bt.setContentAreaFilled(false);
				pencil_bt.setFocusPainted(false);
				pencil_bt.setBounds(10,10,50,50);
				
				eraser_bt = new JButton(eraser_img);
				eraser_bt.setBorderPainted(false);
				eraser_bt.setContentAreaFilled(false);
				eraser_bt.setFocusPainted(false);
				eraser_bt.setBounds(65,10,50,50);
				
				eraseall_bt = new JButton(clear_img);
				eraseall_bt.setBorderPainted(false);
				eraseall_bt.setContentAreaFilled(false);
				eraseall_bt.setFocusPainted(false);
				eraseall_bt.setBounds(120, 10, 50, 50);
				
				colorselect_bt = new  JButton(colorchooser_img);
				colorselect_bt.setBorderPainted(false);
				colorselect_bt.setContentAreaFilled(false);
				colorselect_bt.setFocusPainted(false);
				colorselect_bt.setBounds(175,10,50,50);
				
				Font font = new Font("���ʷյ���", Font.BOLD, 25);
				linethickness_l = new JLabel("Size");
				linethickness_l.setFont(font);
				linethickness_l.setBounds(230,20,60,45);
				
				setlinethickness_tx = new JTextField("10", 5);
				setlinethickness_tx.setFont(font);
				setlinethickness_tx.setHorizontalAlignment(JTextField.CENTER);
				setlinethickness_tx.setBounds(285, 20, 50, 35);
				
				question_tx = new JTextField("���þ�");
				question_tx.setBounds(400, 15, 150, 40);
				question_tx.setFont(font);
				
				timer_l = new JLabel("03:00");
				timer_l.setFont(font);
				timer_l.setBounds(640, 15, 100, 50);
				
				round_l = new JLabel("����");
				round_l.setBounds(800, 15, 100, 50);
				round_l.setFont(font);
				
				paintgui_p.add(pencil_bt);
				paintgui_p.add(eraser_bt);
				paintgui_p.add(eraseall_bt);
				paintgui_p.add(colorselect_bt);
				paintgui_p.add(linethickness_l);
				paintgui_p.add(setlinethickness_tx);
				paintgui_p.add(question_tx);
				paintgui_p.add(timer_l);
				paintgui_p.add(round_l);
				
				paintdraw_p = new JPanel();
				paintdraw_p.setBackground(Color.WHITE);
				
				paintgui_p.setBounds(0,0,900,60);
				paintdraw_p.setBounds(0, 50, 900, 800);
				paint_p.add(paintgui_p);
				paint_p.add(paintdraw_p);
				paint_p.setBounds(80, 40, 900, 520);
				
				
				graphics = app.getGraphics();
				graphics2 = (Graphics2D)graphics;
				graphics2.setColor(selectedColor);
				
				
				Font font2 = new Font("���ʷյ���", Font.BOLD, 15);
				chat_tx = new JTextField("");
				chat_tx.setBounds(80, 660, 900, 48);
				chat_tx.setFont(font2);
				

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
		        ready_bt.setBorderPainted(false);
		        ready_bt.setContentAreaFilled(false);
		        ready_bt.setFocusPainted(false);
		        
		        exit_bt = new JButton(exitBasic2_img);
		        exit_bt.setBounds(-2, 565, 250, 120);
		        exit_bt.setBorderPainted(false);
		        exit_bt.setContentAreaFilled(false);
		        exit_bt.setFocusPainted(false);
		        
		        userinfo1_p = new JPanel();
		        userinfo1_p.setLayout(null);
		        userinfo1_p.setBounds(5, 10, 240, 120);
		      
		        user1ch_l = new JLabel("");
		        user1ch_l.setBounds(5, 10, 100, 100);

		        user1ID_l = new JLabel("");
		        user1ID_l.setBounds(150, 20, 70, 30);

		        user1score_tx = new JTextField("0");
		        user1score_tx.setBounds(150, 60, 55, 30);

		        userinfo1_p.add(user1ch_l);
		        userinfo1_p.add(user1ID_l);
		        userinfo1_p.add(user1score_tx);
		        
		        
		        //----------------user1
		        
		        userinfo2_p = new JPanel();
		        userinfo2_p.setLayout(null);
		        userinfo2_p.setBounds(5, 135, 240, 120);
		        
		        user2ch_l = new JLabel("");
		        user2ch_l.setBounds(5, 10, 100, 100);

		        user2ID_l = new JLabel("");
		        user2ID_l.setBounds(150, 20, 70, 30);

		        user2score_tx = new JTextField("0");
		        user2score_tx.setBounds(150, 60, 55, 30);

		        userinfo2_p.add(user2ch_l);
		        userinfo2_p.add(user2ID_l);
		        userinfo2_p.add(user2score_tx);

		        //----------------user2
		        
		        userinfo3_p = new JPanel();
		        userinfo3_p.setLayout(null);
		        userinfo3_p.setBounds(5, 260, 240, 120);
		       
		        user3ch_l = new JLabel("");
		        user3ch_l.setBounds(5, 10, 100, 100);

		        user3ID_l = new JLabel("");
		        user3ID_l.setBounds(150, 20, 70, 30);

		        user3score_tx = new JTextField("0");
		        user3score_tx.setBounds(150, 60, 55, 30);

		        userinfo3_p.add(user3ch_l);
		        userinfo3_p.add(user3ID_l);
		        userinfo3_p.add(user3score_tx);		        
		        //----------------user3
		        
		        userinfo4_p = new JPanel();
		        userinfo4_p.setLayout(null);
		        userinfo4_p.setBounds(5, 385, 240, 120);
		        
		        
		        user4ch_l = new JLabel("");
		        user4ch_l.setBounds(5, 10, 100, 100);

		        user4ID_l = new JLabel("");
		        user4ID_l.setBounds(150, 20, 70, 30);

		        user4score_tx = new JTextField("0");
		        user4score_tx.setBounds(150, 60, 55, 30);

		        userinfo4_p.add(user4ch_l);
		        userinfo4_p.add(user4ID_l);
		        userinfo4_p.add(user4score_tx);
		        
		       
		        charlist = new ArrayList<>();
		        charlist.add(user1ch_l);
		        charlist.add(user2ch_l);
		        charlist.add(user3ch_l);
		        charlist.add(user4ch_l);
		        
		        idlist = new ArrayList<>();
		        idlist.add(user1ID_l);
		        idlist.add(user2ID_l);
		        idlist.add(user3ID_l);
		        idlist.add(user4ID_l);
		        
		        sclist = new ArrayList<>();
		        sclist.add(user1score_tx);
		        sclist.add(user2score_tx);
		        sclist.add(user3score_tx);
		        sclist.add(user4score_tx);
	
		        
		        gui_p.setBackground(Color.WHITE);
		        gui_p.add(userinfo1_p);
		        gui_p.add(userinfo2_p);
		        gui_p.add(userinfo3_p);
		        gui_p.add(userinfo4_p);
		        gui_p.add(ready_bt);
		        gui_p.add(exit_bt);
		        
				add(paint_p);
				add(gui_p);
				add(scroll);
				add(chat_tx);
				add(menuexit_bt);
				add(menubar_l);
				add(background_l);
				
				setVisible(true);
				paint_p.setEnabled(false);
				pencil_bt.setEnabled(false);
				eraser_bt.setEnabled(false);
				eraseall_bt.setEnabled(false);
				colorselect_bt.setEnabled(false);
				setlinethickness_tx.setEnabled(false);
				question_tx.setVisible(false);
		
	}

    
    public void setUserMembers(String ID, String avatar) {
    	System.out.println(num + "  " + ID + "  " + avatar);
    	charlist.get(num).setIcon(setCharacter_img(avatar));
    	idlist.get(num).setText(ID);
    	num++;
    }
	
	public Icon setCharacter_img(String character_num) {

		if(character_num.equals("1")) {
			avatar = "ingamecharacter1.png";
		} else if(character_num.equals("2")) {
			avatar = "ingamecharacter2.png";
		} else {
			avatar = "ingamecharacter3.png";
		}
		character_img = new ImageIcon("src/images/" + avatar);
		return character_img;
	}
	



	public JLabel getRound_l() {
		return round_l;
	}


	public JTextField getQuestion_tx() {
		return question_tx;
	}


	public JLabel getTimer_l() {
		return timer_l;
	}




	public String getIdlist(int num) {
		return idlist.get(num).getText();
	}

	public String getScorelist(int num) {
		return sclist.get(num).getText();
	}

	public void setScorelist(int num, String score) {
		sclist.get(num).setText(score);
	}


	public ImageIcon getExitBasic2_img() {
		return exitBasic2_img;
	}



	public ImageIcon getExitEntered2_img() {
		return exitEntered2_img;
	}



	public ImageIcon getReadyBasic_img() {
		return readyBasic_img;
	}



	public JButton getReady_bt() {
		return ready_bt;
	}



	public ImageIcon getReadyEntered_img() {
		return readyEntered_img;
	}



	public String getSendchat_s() {
		return sendchat_s;
	}



	public void setSendchat_s(String sendchat_s) {
		this.sendchat_s = sendchat_s;
	}



	public JTextArea getChat_txa() {
		return chat_txa;
	}



	public JTextField getChat_tx() {
		return chat_tx;
	}



	public int getStartX() {
		return startX;
	}



	public int getStartY() {
		return startY;
	}



	public JTextField getSetlinethickness_tx() {
		return setlinethickness_tx;
	}



	public Color getSelectedColor() {
		return selectedColor;
	}



	public void setSelectedColor(Color selectedColor) {
		this.selectedColor = selectedColor;
	}



	public int getEndX() {
		return endX;
	}



	public void setEndX(int endX) {
		this.endX = endX;
	}



	public int getEndY() {
		return endY;
	}



	public void setEndY(int endY) {
		this.endY = endY;
	}



	public boolean isTf() {
		return tf;
	}



	public void setTf(boolean tf) {
		this.tf = tf;
	}



	public Graphics2D getGraphics2() {
		return graphics2;
	}



	public void setThickness(int thickness) {
		this.thickness = thickness;
	}



	public int getThickness() {
		return thickness;
	}



	public int getMouseX() {
		return mouseX;
	}



	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}



	public int getMouseY() {
		return mouseY;
	}



	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}



	public JPanel getPaintdraw_p() {
		return paintdraw_p;
	}



	public JButton getPencil_bt() {
		return pencil_bt;
	}



	public JButton getEraser_bt() {
		return eraser_bt;
	}



	public JButton getEraseall_bt() {
		return eraseall_bt;
	}



	public JButton getColorselect_bt() {
		return colorselect_bt;
	}



	public JButton getMenuexit_bt() {
		return menuexit_bt;
	}



	public JLabel getMenubar_l() {
		return menubar_l;
	}



	public ImageIcon getExitbasic_img() {
		return exitbasic_img;
	}



	public ImageIcon getExitentered_img() {
		return exitentered_img;
	}



	public void setStartX(int startX) {
		this.startX = startX;
	}



	public void setStartY(int startY) {
		this.startY = startY;
	}



	public JButton getExit_bt() {
		return exit_bt;
	}
	

	public void setInitChatText() {
		chat_tx.setText("");
	}
	
	public void setChatText(String s) {
		chat_txa.append(s);
		chat_txa.setCaretPosition(chat_txa.getDocument().getLength());
	}


	public JComponent getPaint_p() {
		// TODO Auto-generated method stub
		return paint_p;
	}


	public JComponent getLinethickness_l() {
		// TODO Auto-generated method stub
		return linethickness_l;
	}
}