package jikong;

import java.util.*;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class main extends JFrame{
	private JPanel contentPane;
	private JTable table;

	public main()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,420,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//contentPane.setBackground(Color.WHITE);
		setTitle("MAIN");

		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"과목순", "마감기한순", "실제마감일순",}));
		comboBox.setBounds(300, 10,100, 30);
		contentPane.add(comboBox);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 400, 300);
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {""}
		));
		scrollPane.setViewportView(table);
		
		JButton Button = new JButton("등록");
		
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
							insert frame = new insert();
							frame.setVisible(true);
						}catch (Exception e)
						{
							e.printStackTrace();
						}
					}
						});
			}
				});
		Button.setBounds(10,380,100,40);
		contentPane.add(Button);

		JButton Button2 = new JButton("수정");
	
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
							insert frame = new insert();
							frame.setVisible(true);
							
						}catch (Exception e)
						{
							e.printStackTrace();
						}
					}
						});
			}
				});
		Button2.setBounds(150,380,100,40);
		contentPane.add(Button2);

		JButton Button3 = new JButton("삭제");
		
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
							insert frame = new insert();
							frame.setVisible(true);

							
						}catch (Exception e)
						{
							e.printStackTrace();
						}
					}
						});
			}
				});
		Button3.setBounds(300,380,100,40);
		contentPane.add(Button3);
	
	}
}
