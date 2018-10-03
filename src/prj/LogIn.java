package prj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogIn extends JPanel {
	private JPanel p_t, p_b, mid1, mid2, total;
	private JButton login, register;
	private JLabel id_l, pw_l, back_lb;
	private JTextField id, pw;
	private start F;
	private register rg;
	private ImageIcon back_img = new ImageIcon("C:\\\\Users\\\\심재섭\\\\Desktop\\\\자바\\\\teampjt\\\\src\\\\images\\\\introBackground.jpg");
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == login) {
				// DB에 저장된 회원데이터와 비교하여 로그인시킬지 말지 판별하는 부분
				JOptionPane.showMessageDialog(null, "로그인 되었습니다");
				F.changePanel();
				F.setTitle("대기실");
				F.setSize(1280, 720);
			} else {
				rg = new register();
			}
		}
	}

	public LogIn(start f) {
		setLayout(null);
		total = new JPanel();
		total.setLayout(new GridLayout(2, 1));
		total.setBounds(500, 450, 300, 150);
		
		back_lb = new JLabel(back_img);
		back_lb.setBounds(0, 0, 1280, 720);
	
		F = f;
		mid1 = new JPanel();
		mid2 = new JPanel();
		mid1.setLayout(new FlowLayout(FlowLayout.CENTER));
		mid2.setLayout(new FlowLayout(FlowLayout.CENTER));

		p_t = new JPanel();
		p_b = new JPanel();

		id_l = new JLabel("ID");
		pw_l = new JLabel("PW");
		id = new JTextField(20);
		pw = new JTextField(20);
		login = new JButton("로그인");
		register = new JButton("회원가입");
		p_b.setLayout(new GridLayout(1, 2));
		p_t.setLayout(new GridLayout(2, 2));
		
		mid1.add(id_l);
		p_t.add(mid1);
		p_t.add(id);
		mid2.add(pw_l);
		p_t.add(mid2);
		p_t.add(pw);
		p_b.add(login);
		p_b.add(register);

		total.add(p_t);
		total.add(p_b);	
	
		add(total);
		add(back_lb);
		
		ButtonListener listen = new ButtonListener();
		login.addActionListener(listen);
		register.addActionListener(listen);
		
		setVisible(true);
		
	}
}
