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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GREEN);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//contentPane.setBackground(Color.WHITE);
		
		JButton Button = new JButton("확인");

		setTitle("          알림!!");
		
		if(ok==0) {
			JLabel Label = new JLabel();
			Label.setText("해당 계정이 존재하지 않음");
			Label.setBackground(Color.GREEN);
			Label.setBounds(10, 10, 350, 45);
			//NewLabel.setBackground(Color.WHITE);
			Label.setFont(new Font("돋음", Font.PLAIN, 25));
			contentPane.add(Label);
			
			Button.setBounds(135, 70, 100, 30);
			
			
			
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
		else {
			setBounds(200,200,400,300);
			JLabel newpw = new JLabel("새 비밀번호 입력: ");
			JLabel newpww = new JLabel("새 비밀번호 다시 입력: ");
			JTextField textField = new JTextField();
			JTextField textField2= new JTextField();
			
			newpw.setOpaque(true);
			newpw.setFont(new Font("돋음", Font.PLAIN, 15));
			newpw.setBounds(20,60,150,40);
			contentPane.add(newpw);
			
			newpww.setOpaque(true);
			newpww.setFont(new Font("돋음", Font.PLAIN, 15));
			newpww.setBounds(20,120,150,40);
			contentPane.add(newpww);
			
			textField.setBounds(180,60,180,40);
			contentPane.add(textField);
			
			textField2.setBounds(180,120,180,40);
			contentPane.add(textField2);
			
			String tf = textField.getText();
			String tf2 = textField2.getText();
				
			Button.setBounds(135, 190, 100, 30);	
		
			Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Account dicac = map.get(ID);
								Account dicnewac= new Account(ID,tf,tf2,dicac.getnickname(),dicac.getemail());
								//	System.out.println(dicac.getID()+dicac.getpasswd()+dicac.getnickname()+dicac.getemail());
								map.put(ID, dicnewac);
								//	System.out.println(dicnewac.getID()+dicnewac.getpasswd()+dicnewac.getnickname()+dicnewac.getemail());

								login frame = new login(map);
								frame.setVisible(true);
								setVisible(false);
								//System.out.println("띠용");
									//Account a= map.get(ID);
								//	System.out.println(a.getID()+a.getpasswd()+a.getnickname()+a.getemail());
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			
		}
	
		

		Button.setBackground(Color.YELLOW);
		Button.setForeground(Color.BLACK);
		Button.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button);
	}
	
}
