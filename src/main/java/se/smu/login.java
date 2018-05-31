package jikong;

import java.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class login extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	
	public login(HashMap<String,Account> map)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,400,400);
		Color backcolor = new Color(228,247,186);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backcolor);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("Login");
		//contentPane.setBackground(Color.WHITE);
	
	JLabel Label = new JLabel();
	Label.setText("                	   로그인");
	Label.setOpaque(true);
	Label.setFont(new Font("돋음",Font.PLAIN,30));
	Label.setBackground(backcolor);
	Label.setBounds(0,0,400,75);
	contentPane.add(Label);

	JLabel Label2 = new JLabel();
	Label2.setText("아이디");
	Label2.setOpaque(true);
	Label2.setFont(new Font("돋음",Font.PLAIN,20));
	Label2.setBackground(backcolor);
	Label2.setBounds(50,80,60,40);
	contentPane.add(Label2);
	
	JLabel Label3 = new JLabel();
	Label3.setText("비밀번호");
	Label3.setOpaque(true);
	Label3.setFont(new Font("돋음",Font.PLAIN,20));
	Label3.setBackground(backcolor);
	Label3.setBounds(50,130,100,40);
	contentPane.add(Label3);
	
	textField = new JTextField();
	textField.setBounds(150,85,180,30);
	contentPane.add(textField);

	textField2 = new JTextField();
	textField2.setBounds(150,135,180,30);
	contentPane.add(textField2);

	JButton Button = new JButton("ID찾기");
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
						setVisible(false);
						searchID frame = new searchID(map);
						frame.setVisible(true);
					}catch (Exception e)
					{
						e.printStackTrace();
					}
				}
					});
		}
			});
	Button.setBounds(60,215,115,40);
	contentPane.add(Button);

	JButton Button2 = new JButton("PW 찾기");
	Button2.setBackground(Color.GREEN);
	Button2.setForeground(Color.BLACK);
	Button2.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent arg0)
		{
			EventQueue.invokeLater(new Runnable()
					{
				public void run()
				{
					try
					{
						setVisible(false);
						searchpw frame = new searchpw(map);
						frame.setVisible(true);
					}catch (Exception e)
					{
						e.printStackTrace();
					}
				}
					});
		}
			});
	Button2.setBounds(60,260,115,40);
	contentPane.add(Button2);

	JButton Button3 = new JButton("회원가입");
	Button3.setBackground(Color.GREEN);
	Button3.setForeground(Color.BLACK);
	Button3.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent arg0)
		{
			EventQueue.invokeLater(new Runnable()
					{
				public void run()
				{
					try
					{
						setVisible(false);
						signup frame = new signup(map);
						frame.setVisible(true);

						
					}catch (Exception e)
					{
						e.printStackTrace();
					}
				}
					});
		}
			});
	Button3.setBounds(195,215,115,40);
	contentPane.add(Button3);

	JButton Button4 = new JButton("로그인");
	Button4.setBackground(Color.GREEN);
	Button4.setForeground(Color.BLACK);
	Button4.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent arg0)
		{
			EventQueue.invokeLater(new Runnable()
					{
				public void run()
				{
					try
					{
						String ID = textField.getText();
						String PW = textField2.getText();
						Set<String> ids = map.keySet();
						Iterator<String> it = ids.iterator();
						int num=0;
						
						while(it.hasNext()) {
							String dicid = it.next();
							Account dicac = map.get(dicid);
							if(ID.equals(dicid)&&PW.equals(dicac.getpasswd())) {
								setVisible(false);
								HashMap<Integer,List> todo = new HashMap<Integer,List>();
								main frame = new main(1,todo);
								frame.setVisible(true);
								num++;
							}
						}
						
						if(num==0) {
							textField.setText("");
							textField2.setText("");
						}
						
					}catch (Exception e)
					{
						e.printStackTrace();
					}
				}
					});
		}
			});
	Button4.setBounds(195,260,115,40);
	contentPane.add(Button4);
	}
}

