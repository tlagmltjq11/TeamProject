package View;
import Starter.Application;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.*;
public class WaitingView extends JPanel{

	public static JButton r1_bt, r2_bt, r3_bt, r4_bt;
	private JButton mkr_bt, exit_bt, userexit_bt;
	private JTextArea chatarea_ta, rank_ta;
	private JTextField chatfield_tf, id_tf;
	private JLabel back_l, menubar_l, character_l;
	private JPanel user_p, userbottom_p, room_p, roomtop_p, roombot_p, rank_p;
	private JScrollPane scroll;
	private String ID,avatar;
	private LoginView Lgview;
	private ImageIcon back_img = new ImageIcon("src/images/waitingback.jpg");
	private ImageIcon menu_img = new ImageIcon("src/images/menubar.png");
	private ImageIcon exitbasic_img = new ImageIcon("src/images/exitButtonBasic.png");
	private ImageIcon exitentered_img = new ImageIcon("src/images/exitButtonEntered.png");
	private ImageIcon character_img = new ImageIcon("src/images/character1.png");
	private ImageIcon chosen_character;
	private int mouseX, mouseY;


	private Application app;
	private DefaultTableModel model;	
	private JTable table;				
	private JScrollPane sc;				

	public WaitingView() {
		String []a= {"����","ID","����"};
		String [][]b = {{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""},{"","",""}};


		model = new DefaultTableModel(b,a) {
			public boolean isCellEditable(int i, int c){ 
				return false; 
			}
		};
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30); 
		table.getColumnModel().getColumn(1).setPreferredWidth(130); 
		table.getColumnModel().getColumn(2).setPreferredWidth(40); 
		sc = new JScrollPane(table);
		sc.setPreferredSize(new Dimension(240,420));
	

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();


		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		setLayout(null);

		exit_bt = new JButton(exitbasic_img);
		exit_bt.setBounds(1245, 0, 30, 30);
		exit_bt.setBorderPainted(false);
		exit_bt.setContentAreaFilled(false);
		exit_bt.setFocusPainted(false);



		menubar_l = new JLabel(menu_img);
		menubar_l.setBounds(0, 0, 1280, 30);



		userexit_bt = new JButton("�����ϱ�"); 



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

		r1_bt.setEnabled(false);
		r2_bt.setEnabled(false);
		r3_bt.setEnabled(false);
		r4_bt.setEnabled(false);


		mkr_bt = new JButton("�游���");
		roombot_p.add(mkr_bt);

		room_p.add(roomtop_p, BorderLayout.CENTER);
		room_p.add(roombot_p, BorderLayout.SOUTH);

		room_p.setBounds(20, 50, 975, 450);

		chatfield_tf = new JTextField("");
		chatfield_tf.setBounds(20, 665, 975, 48);
		chatfield_tf.setCaretPosition(chatfield_tf.getText().length());

		Font font = new Font("���ʷյ���", Font.BOLD, 15);
		chatarea_ta = new JTextArea();
		chatarea_ta.setEditable(false);
		chatarea_ta.setFont(font);

		scroll = new JScrollPane(chatarea_ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(20, 510, 975, 155);

		rank_p = new JPanel();
		rank_p.setBounds(1010, 50, 250, 450);
		rank_p.add(sc);

		back_l = new JLabel(back_img);
		back_l.setBounds(0, 0, 1280, 720);

		user_p = new JPanel();
		user_p.setLayout(new GridLayout(2, 1));

		userbottom_p = new JPanel();
		userbottom_p.setLayout(new GridLayout(2, 1));

		id_tf = new JTextField("");
		id_tf.setHorizontalAlignment(JTextField.CENTER);
		id_tf.setFont(font);
		id_tf.setEditable(false);
		character_l = new JLabel();

		userbottom_p.add(id_tf);
		userbottom_p.add(userexit_bt);

		user_p.add(character_l);
		user_p.add(userbottom_p);

		user_p.setBounds(1010, 510, 250, 210);

		Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);
		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

		room_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		chatfield_tf.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		rank_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		user_p.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		add(room_p);
		add(scroll);
		add(chatfield_tf);
		add(rank_p);
		add(user_p);
		add(exit_bt);
		add(menubar_l);
		add(back_l);

		setVisible(true);

	}


	public static JButton getR(int i) {
		if(i == 0) {
			return r1_bt;
		} else if(i == 1) {
			return r2_bt;
		} else if(i == 2) {
			return r3_bt;
		} else {
			return r4_bt;
		}
	}



	public void setCharacter_img(String character_num) {

		if(character_num.equals("1")) {
			avatar = "smallcharacter1.png";
		} else if(character_num.equals("2")) {
			avatar = "smallcharacter2.png";
		} else {
			avatar = "smallcharacter3.png";
		}
		character_img = new ImageIcon("src/images/" + avatar);
		character_l.setIcon(character_img);
	}


	public JButton getMkr_bt() {
		return mkr_bt;
	}



	public JButton getExit_bt() {
		return exit_bt;
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



	public ImageIcon getExitbasic_img() {
		return exitbasic_img;
	}



	public ImageIcon getExitentered_img() {
		return exitentered_img;
	}



	public JButton getUserexit_bt() {
		return userexit_bt;
	}



	public JLabel getMenubar_l() {
		return menubar_l;
	}



	public JTable getTable() {
		return table;
	}

	public JTextArea getTextArea() {
		return chatarea_ta;
	}

	public JTextField getTextField() {
		return chatfield_tf;
	}

	public String getChatText() {
		return chatfield_tf.getText();
	}

	public void setInitChatText() {
		chatfield_tf.setText("");
	}

	public void setChatText(String s) {
		chatarea_ta.append(s);
		chatarea_ta.setCaretPosition(chatarea_ta.getDocument().getLength());
	}


	public void getUserID(String ID) {
		this.ID = ID;
		id_tf.setText(ID);
	}
}






