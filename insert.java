package jikong;

import java.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class insert extends JFrame{
	private JPanel contentPane;
	
	public insert()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GREEN);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel Label = new JLabel();
		Label.setText("          ¼±ÅÃÇÏ¼¼¿ä.");
		Label.setOpaque(true);
		Label.setBackground(Color.GREEN);
		//NewLabel.setBackground(Color.WHITE);
		Label.setFont(new Font("µ¸À½", Font.PLAIN, 35));
		Label.setBounds(0, 20, 300, 30);
		contentPane.add(Label);
		
		JButton Button = new JButton("°ú¸ñ");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button.setBounds(75, 70, 100, 30); 
	
		Button.setFont(new Font("µ¸À½", Font.PLAIN, 15));
		contentPane.add(Button);
		JButton Button1 = new JButton("to do list");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							todolist frame = new todolist();
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button1.setBounds(235, 70, 100, 30);
	
		Button1.setFont(new Font("µ¸À½", Font.PLAIN, 15));
		contentPane.add(Button1);
	}
}
