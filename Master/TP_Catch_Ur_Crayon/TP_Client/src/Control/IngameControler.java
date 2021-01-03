package Control;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

import Model.Ingame;
import Model.Music;
import Starter.Application;
import Thread.CanVasColorReceiveThread;
import Thread.CanVasColorSendThread;
import Thread.CanVasReceiveThread;
import Thread.CanVasSendThread;
import Thread.IngameChatReceiveThread;
import Thread.IngameChatSendThread;
import Thread.TimerReceiveThread;
import Thread.TimerSendThread;
import Thread.UsersInfoReceiveThread;
import Thread.UsersInfoSendThread;
import View.IngameView;
import View.WaitingView;

public class IngameControler {
	private Application app;
	private IngameView iv;
	private Mouse mouse;
	private ToolActionListener tool;
	private PaintDraw paint;

	private Ingame []i;		
	private Socket s,s1,s2,s3,s4,s5;
	private String ID;
	private String color = null;
	private String avatar;
	private UsersInfoReceiveThread uirt;
	private UsersInfoSendThread uist;
	private CanVasSendThread cvst;
	private CanVasReceiveThread cvrt;
	private CanVasColorSendThread cvcst;
	private CanVasColorReceiveThread cvcrt;
	private Color c;
	private IngameChatSendThread icst;
	private IngameChatReceiveThread icrt;
	private TimerSendThread tst;
	private TimerReceiveThread trt;
	private int num;
	private WaitingControler wc;
	private WaitingView wv;
	
	private class Mouse extends MouseAdapter{

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == iv.getMenubar_l()) {
				iv.setMouseX(e.getX());
				iv.setMouseY(e.getY());
			} else if(e.getSource() == iv.getPaintdraw_p()) {
				iv.setStartX(e.getX());
				iv.setStartY(e.getY());

			} else if(e.getSource() == iv.getMenuexit_bt()) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}

			} else {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();

				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			int x = e.getXOnScreen();
			int y = e.getYOnScreen();

			app.setLocation(x - iv.getMouseX(), y - iv.getMouseY());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == iv.getMenuexit_bt()) {
				iv.getMenuexit_bt().setIcon(iv.getExitentered_img());
				iv.getMenuexit_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == iv.getReady_bt()) {
				iv.getReady_bt().setIcon(iv.getReadyEntered_img());
				iv.getReady_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			} else if(e.getSource() == iv.getExit_bt()) {
				iv.getExit_bt().setIcon(iv.getExitEntered2_img());
				iv.getExit_bt().setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == iv.getMenuexit_bt()) {
				iv.getMenuexit_bt().setIcon(iv.getExitbasic_img());
				iv.getMenuexit_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else if(e.getSource() == iv.getReady_bt()) {
				iv.getReady_bt().setIcon(iv.getReadyBasic_img());
				iv.getReady_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			} else if(e.getSource() == iv.getExit_bt()) {
				iv.getExit_bt().setIcon(iv.getExitBasic2_img());
				iv.getExit_bt().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}

	}

	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){

			if(event.getSource() == iv.getMenuexit_bt()) {
				app.offMusic();
				app.dispose();

			} else if(event.getSource() == iv.getChat_tx()) {

				String m = iv.getChat_tx().getText();
				icst = new IngameChatSendThread(s4, m, iv);
				icst.start();
				iv.getChat_txa().setCaretPosition(iv.getChat_txa().getDocument().getLength());

			} else if(event.getSource() == iv.getExit_bt()) {

				JOptionPane.showMessageDialog(null, "���Ƿ� �����ϴ�");
				app.cards.show(app.getContentPane(), "Two");
				//wc.setRanking();
			} else if(event.getSource() == iv.getReady_bt()) {
				iv.getPencil_bt().setEnabled(true);
				iv.getEraser_bt().setEnabled(true);
				iv.getEraseall_bt().setEnabled(true);
				iv.getColorselect_bt().setEnabled(true);
				iv.getSetlinethickness_tx().setEnabled(true);
				iv.getQuestion_tx().setVisible(true);
				iv.getPaintdraw_p().addMouseMotionListener(paint);
				iv.getChat_tx().setEditable(false);
				tst = new TimerSendThread(s5, getTheme(num) , getRound(num));
				tst.start();
			}
		}
	}


	public class PaintDraw implements MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) {


			iv.setThickness(Integer.parseInt(iv.getSetlinethickness_tx().getText()));

			iv.setEndX(e.getX());
			iv.setEndY(e.getY());

			if(e.getX() < 0 || e.getY() < 0 || e.getX() > 895 || e.getY() > 455)
			{
				return;
			}
			iv.getGraphics2().setStroke(new BasicStroke(iv.getThickness(), BasicStroke.CAP_ROUND, 0));

			iv.getGraphics2().drawLine(iv.getStartX()+82, iv.getStartY()+100, iv.getEndX()+82, iv.getEndY()+100);

			iv.setStartX(iv.getEndX());
			iv.setStartY(iv.getEndY());


			cvst=new CanVasSendThread(s2, Integer.toString(iv.getStartX()) , Integer.toString(iv.getStartY()) , Integer.toString(iv.getEndX()) ,Integer.toString(iv.getEndY()),Integer.toString(iv.getThickness()));
			cvst.start();
		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{

		}
	}

	public class ToolActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e)   {

			if(e.getSource() == iv.getPencil_bt()) { 
				color="����";
				iv.getGraphics2().setColor(Color.BLACK);

			} else if(e.getSource() == iv.getEraser_bt())   {
				color="���찳";
				iv.getGraphics2().setColor(Color.WHITE);
			}
			else if(e.getSource()==iv.getEraseall_bt())
			{   
				color="clear";
				iv.repaint();
			}
			else if(e.getSource() == iv.getColorselect_bt()) {

				iv.setTf(true);
				JColorChooser chooser = new JColorChooser();
				iv.setSelectedColor(chooser.showDialog(null, "Color", Color.orange));
				iv.getGraphics2().setColor(iv.getSelectedColor());
				color = Integer.toString(iv.getSelectedColor().getRed())+","+Integer.toString(iv.getSelectedColor().getGreen())+","+Integer.toString(iv.getSelectedColor().getBlue());               //System.out.println(String.valueOf(chooser.getColor()));

			}

			cvcst=new CanVasColorSendThread(s3,color);
			color = null;
			cvcst.start();

		}


	}

	public IngameControler(Application app, IngameView iv, WaitingView wv) {
		this.app = app;
		this.iv = iv;
		this.wv = wv;
		i = new Ingame[4];
		i[0] = new Ingame("1����");
		i[1] = new Ingame("2����");
		i[2] = new Ingame("3����");
		i[3] = new Ingame("4����");

	}

	public void buttonHandler() {
		ButtonListener listen = new ButtonListener();
		mouse = new Mouse();
		tool = new ToolActionListener();
		paint = new PaintDraw();

		iv.getMenubar_l().addMouseListener(mouse);
		iv.getMenubar_l().addMouseMotionListener(mouse);
		iv.getExit_bt().addMouseListener(mouse);
		iv.getReady_bt().addMouseListener(mouse);
		iv.getMenuexit_bt().addMouseListener(mouse);
		iv.getPaintdraw_p().addMouseListener(mouse);
		iv.getPencil_bt().addActionListener(tool);
		iv.getEraser_bt().addActionListener(tool);
		iv.getEraseall_bt().addActionListener(tool);
		iv.getColorselect_bt().addActionListener(tool);

		iv.getChat_tx().addActionListener(listen);
		iv.getExit_bt().addActionListener(listen);
		iv.getMenuexit_bt().addActionListener(listen);
		iv.getReady_bt().addActionListener(listen);
	}

	public void checkScore(String ID) {
		for(int i=0; i<4; i++) {
			if(ID.equals(iv.getIdlist(i)))
			{
				iv.setScorelist(i, String.valueOf(Integer.parseInt(iv.getScorelist(i)) + 12));
				break;
			}
		}
	}

	public void set_connection(boolean check) {
		if(check == true) {
			iv.getPaintdraw_p().addMouseMotionListener(paint);
		} else {
			iv.getPaintdraw_p().removeMouseMotionListener(paint);
		}
	}

	public String getPW(int num) {
		return i[num].getPw();
	}

	public String getTitle(int num) {
		return i[num].getTitle();
	}

	public void setTitle(int num, String title) {
		i[num].setTitle(title);
	}

	public void setPW(int num, String pw) {
		i[num].setPw(pw);
	}

	public void setRound(int num, String round) {
		i[num].setRound(round);
	}

	public String getRound(int num) {
		return i[num].getRound();
	}

	public void setTheme(int num, String theme) {
		i[num].setTheme(theme);
	}

	public String getTheme(int num) {
		return i[num].getTheme();
	}

	
	public void setWaitingControler(WaitingControler wc) {
		this.wc = wc;
	
	}
	
	
	
	public void setUserInfo(Socket s, String ID, String avatar, int num) throws IOException {

		this.s = s;
		this.num = num;
		s1 = new Socket(s.getInetAddress(), s.getPort()+1);
		s2 = new Socket(s.getInetAddress(), s.getPort()+1);
		s3 = new Socket(s.getInetAddress(), s.getPort()+1);
		s4 = new Socket(s.getInetAddress(), s.getPort()+1);
		s5 = new Socket(s.getInetAddress(), s.getPort()+1);

		this.ID = ID;
		this.avatar = avatar;
		uist = new UsersInfoSendThread(s1, ID, avatar);
		uirt = new UsersInfoReceiveThread(s1, iv);
		uist.start();
		uirt.start();
		cvrt = new CanVasReceiveThread(s2,iv,ID);
		cvrt.start();
		cvcrt = new CanVasColorReceiveThread(s3,iv,ID);
		cvcrt.start();
		icrt = new IngameChatReceiveThread(s4,iv,ID, this);
		icrt.start();
		trt = new TimerReceiveThread(s5, iv);
		trt.start();        

	}


}
