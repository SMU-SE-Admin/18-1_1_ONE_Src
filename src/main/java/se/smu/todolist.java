package jikong;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import javax.swing.border.*;
import java.awt.event.*;

public class todolist extends JFrame{
	
	private JPanel contentPane; 
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	
	public todolist()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,350,450);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setTitle("TODOLIST");
		
		JLabel Label = new JLabel();
		Label.setText("            TO DO LIST");
		Label.setOpaque(true);
		Label.setFont(new Font("돋음",Font.PLAIN,30));
		Label.setBounds(0,0,350,75);
		contentPane.add(Label);
		
		JLabel Label1 = new JLabel();
		Label1.setText("마감 예정일");
		Label1.setOpaque(true);
		Label1.setFont(new Font("돋음",Font.PLAIN,13));
		Label1.setBounds(0,150,100,30);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel();
		Label2.setText("실제 마감일");
		Label2.setOpaque(true);
		Label2.setFont(new Font("돋음",Font.PLAIN,13));
		Label2.setBounds(0,200,100,30);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel();
		Label3.setText(" 완료여부");
		Label3.setOpaque(true);
		Label3.setFont(new Font("돋음",Font.PLAIN,13));
		Label3.setBounds(0,250,100,30);
		contentPane.add(Label3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"O", "X",}));
		comboBox.setBounds(100, 250,100, 30);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(20,100,300,30);
		contentPane.add(textField);
		
		textField1 = new JTextField();
		textField1.setBounds(100,150,210,30);
		contentPane.add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(100,200,210,30);
		contentPane.add(textField2);

		JButton Button = new JButton("등록");
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
		Button.setBounds(15, 300, 100, 30);
	
		Button.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button);
		JButton Button1 = new JButton("종료");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							main frame = new main();
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button1.setBounds(205, 300, 100, 30);
	
		Button1.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button1);
	}


}
