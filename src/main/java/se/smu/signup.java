package jikong;

import java.util.*;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.*;
import java.awt.event.*;

public class signup extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

	public signup(HashMap<String,Account> map)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,380,500);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("회원가입");
		
		JLabel Label = new JLabel();
		Label.setText("             회원가입");
		Label.setOpaque(true);
		Label.setFont(new Font("돋음",Font.PLAIN,30));
		Label.setBounds(10,0,350,75);
		contentPane.add(Label);
		
		JLabel Label1 = new JLabel();
		Label1.setText("아이디");
		Label1.setOpaque(true);
		Label1.setFont(new Font("돋음",Font.PLAIN,20));
		Label1.setBounds(10,110,100,40);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel();
		Label2.setText("비밀번호");
		Label2.setOpaque(true);
		Label2.setFont(new Font("돋음",Font.PLAIN,20));
		Label2.setBounds(10,160,100,40);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel();
		Label3.setText("비밀번호확인");
		Label3.setOpaque(true);
		Label3.setFont(new Font("돋음",Font.PLAIN,20));
		Label3.setBounds(10,210,130,40);
		contentPane.add(Label3);
		
		JLabel Label4 = new JLabel();
		Label4.setText("닉네임");
		Label4.setOpaque(true);
		Label4.setFont(new Font("돋음",Font.PLAIN,20));
		Label4.setBounds(10,260,100,40);
		contentPane.add(Label4);
		
		JLabel Label5 = new JLabel();
		Label5.setText("e-mail");
		Label5.setOpaque(true);
		Label5.setFont(new Font("돋음",Font.PLAIN,20));
		Label5.setBounds(10,310,100,40);
		contentPane.add(Label5);

		textField = new JTextField();
		textField.setBounds(140,110,180,30);
		contentPane.add(textField);
		
		textField2 = new JTextField();
		textField2.setBounds(140,160,180,30);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setBounds(140,210,180,30);
		contentPane.add(textField3);
		
		textField4 = new JTextField();
		textField4.setBounds(140,260,180,30);
		contentPane.add(textField4);
		
		textField5 = new JTextField();
		textField5.setBounds(140,310,180,30);
		contentPane.add(textField5);

		JButton Button = new JButton("회원가입완료");
		Button.setBackground(Color.GREEN);
		Button.setForeground(Color.BLACK);
		Button.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent arg0)
			{
				EventQueue.invokeLater(new Runnable()
						{
					public void run()
					{
						try
						{
							String tf=textField.getText();
							String tf2=textField2.getText();
							String tf3=textField3.getText();
							String tf4=textField4.getText();
							String tf5=textField5.getText();
							Account newac = new Account(tf,tf2,tf3,tf4,tf5);
							map.put(tf,newac);
							setVisible(false);
		
				System.out.println(map.get(tf).getID()+map.get(tf).getpasswd()+map.get(tf).getemail());
						
							login frame = new login(map);
							frame.setVisible(true);
							
						}catch (Exception e)
						{
							e.printStackTrace();
						}
					}
						});
			}
				});
		Button.setBounds(110,385,155,40);
		contentPane.add(Button);

	}

}
