package jikong;


import java.util.*;

import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class searchpwok extends JFrame{
private JPanel contentPane;
	
	public searchpwok(HashMap<String,Account> map,String ID,int ok)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 150);
		Color backcolor = new Color(228,247,186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backcolor);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//contentPane.setBackground(Color.WHITE);
		
		JButton Button = new JButton("확인");

		setTitle("          알림!!");
		JLabel Label = new JLabel();
		if(ok==0)
			Label.setText("해당 계정이 존재하지 않음");
		else {
			Account findpw = map.get(ID);
			Label.setText(" 비밀번호는 "+findpw.getpasswd()+" 입니다.");
		}
		Label.setBackground(Color.GREEN);
		Label.setBounds(10, 10, 350, 45);
		//NewLabel.setBackground(Color.WHITE);
		Label.setFont(new Font("돋음", Font.PLAIN, 25));
		contentPane.add(Label);
		
		Button.setBounds(135, 70, 100, 30);
		Button.setBackground(Color.YELLOW);
		Button.setForeground(Color.BLACK);
		Button.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button);
		
		
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setVisible(false);
							login frame = new login(map);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
	
}
