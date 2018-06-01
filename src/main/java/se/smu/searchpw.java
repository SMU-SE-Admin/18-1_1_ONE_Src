package jikong;


import java.util.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class searchpw extends JFrame{

	private JPanel contentPane;
	private JTextField textField;

	public searchpw(HashMap<String,Account> map)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 150);
		Color backcolor = new Color(228,247,186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backcolor);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("               비밀번호 찾기");
		
		JLabel Label = new JLabel();
		
		Label.setText("아이디계정입력: ");
		Label.setOpaque(true);
		Label.setBackground(backcolor);
		Label.setFont(new Font("돋음", Font.PLAIN, 15));
		Label.setBounds(0, 20, 130, 30);
		contentPane.add(Label);

		textField = new JTextField();
		textField.setBounds(130,20,200,30);
		contentPane.add(textField);

		JButton Button = new JButton("확인");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Set<String> ids = map.keySet();
							Iterator<String> it = ids.iterator();
							String putID = textField.getText();
							if(!map.containsKey(putID)) {
								searchpwok frame = new searchpwok(map,putID,0);
								frame.setVisible(true);
								setVisible(false);
								}
							else {
								searchpwok frame = new searchpwok(map,putID,1);
								frame.setVisible(true);
								setVisible(false);
								}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button.setBounds(135, 60, 100, 40);
		Button.setBackground(Color.YELLOW);
		Button.setForeground(Color.BLACK);
		Button.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button);
	}
}
