package se.smu;

import java.util.*;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class searchID extends JFrame{

	private JPanel contentPane;
	private JTextField textField;

	public searchID(final HashMap<String,Account> map)
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
		setTitle("아이디찾기");
		
		JLabel Label = new JLabel();
		
		Label.setText("이메일계정입력:");
		Label.setOpaque(true);
		Label.setBackground(backcolor);
		//NewLabel.setBackground(Color.WHITE);
		Label.setFont(new Font("돋음", Font.PLAIN, 15));
		Label.setBounds(10, 20, 120, 30);
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
							int num=0;
								
							String putemail= textField.getText();
							while(it.hasNext()) {
								String dicid=it.next();
								Account dicac = map.get(dicid);
								if(putemail.equals(dicac.getemail())) {
									searchOK frame = new searchOK(map,dicid,1);
									textField.setText("");
									num++;
									setVisible(false);
									frame.setVisible(true);
								}
							}
							if(num==0) {
								searchOK frame = new searchOK(map,"",0);
								textField.setText("");
								setVisible(false);
								frame.setVisible(true);
								
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button.setBounds(135, 60, 100, 40);
		//Button.setBackground(Color.YELLOW);
		Button.setForeground(Color.BLACK);
		Button.setFont(new Font("돋음", Font.PLAIN, 15));
		contentPane.add(Button);

	}
}

