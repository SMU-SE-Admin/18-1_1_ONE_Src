package se.smu;


import java.util.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;


public class searchOK extends JFrame{

private JPanel contentPane;
	
	public searchOK(final HashMap<String,Account> map,String dicid,int ok)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 170);
		Color backcolor = new Color(228,247,186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backcolor);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//contentPane.setBackground(Color.WHITE);
		setTitle("�˸�!!");
		
		
		JLabel Label = new JLabel();
		if(ok==0)
			Label.setText("       �ش� ������ �������� ����");
		else 
			Label.setText("     ������ "+dicid+" �Դϴ�.");
		Label.setOpaque(true);
		Label.setBackground(backcolor);
		//NewLabel.setBackground(Color.WHITE);
		Label.setFont(new Font("����", Font.PLAIN, 25));
		Label.setBounds(0, 10, 350, 45);
		contentPane.add(Label);
		
		JButton Button = new JButton("Ȯ��");
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
		Button.setBounds(135, 70, 100, 30);
		Button.setBackground(Color.YELLOW);
		Button.setForeground(Color.BLACK);
		Button.setFont(new Font("����", Font.PLAIN, 15));
		contentPane.add(Button);
	}
}


