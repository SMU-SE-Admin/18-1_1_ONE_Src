package jikong;

import java.util.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class main extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTable table1;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;

	private JTextField tf12;
	private JTextField tf22;
	private JTextField tf32;
	private JTextField tf42;

	public main(int seq, HashMap<Integer, List> todo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 750, 500);
		Color backcolor = new Color(228, 247, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(backcolor);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		// contentPane.setBackground(Color.WHITE);
		setTitle("MAIN");

		JLabel Label = new JLabel();
		Label.setText("                과목등록");
		Label.setOpaque(true);
		Label.setFont(new Font("돋음", Font.PLAIN, 20));
		Label.setBounds(400, 5, 400, 20);
		Label.setBackground(backcolor);
		contentPane.add(Label);

		JLabel Label1 = new JLabel();
		Label1.setText("  과목명");
		Label1.setOpaque(true);
		Label1.setFont(new Font("돋음", Font.PLAIN, 13));
		Label1.setBounds(400, 30, 100, 30);
		Label1.setBackground(backcolor);
		contentPane.add(Label1);

		JLabel Label2 = new JLabel();
		Label2.setText("  교수명");
		Label2.setOpaque(true);
		Label2.setFont(new Font("돋음", Font.PLAIN, 13));
		Label2.setBounds(400, 55, 100, 30);
		Label2.setBackground(backcolor);
		contentPane.add(Label2);

		JLabel Label3 = new JLabel();
		Label3.setText("  수업시간");
		Label3.setOpaque(true);
		Label3.setFont(new Font("돋음", Font.PLAIN, 13));
		Label3.setBounds(400, 80, 100, 30);
		Label3.setBackground(backcolor);
		contentPane.add(Label3);

		JLabel Label4 = new JLabel();
		Label4.setText("  학년");
		Label4.setOpaque(true);
		Label4.setFont(new Font("돋음", Font.PLAIN, 13));
		Label4.setBounds(400, 105, 100, 30);
		Label4.setBackground(backcolor);
		contentPane.add(Label4);

		JLabel Label5 = new JLabel();
		Label5.setText("  학기");
		Label5.setOpaque(true);
		Label5.setFont(new Font("돋음", Font.PLAIN, 13));
		Label5.setBounds(400, 130, 100, 30);
		Label5.setBackground(backcolor);
		contentPane.add(Label5);

		tf1 = new JTextField();
		tf1.setBounds(510, 30, 180, 25);
		contentPane.add(tf1);

		tf2 = new JTextField();
		tf2.setBounds(510, 55, 180, 25);
		contentPane.add(tf2);

		tf3 = new JTextField();
		tf3.setBounds(510, 80, 180, 25);
		contentPane.add(tf3);

		tf4 = new JTextField();
		tf4.setBounds(510, 105, 180, 25);
		contentPane.add(tf4);

		tf5 = new JTextField();
		tf5.setBounds(510, 130, 180, 25);
		contentPane.add(tf5);

		JButton Button = new JButton("  과목등록");

		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FileWriter filewr = new FileWriter("subject.txt", true);
							BufferedWriter buf = new BufferedWriter(filewr);
							buf.write(tf1.getText() + " ");
							buf.write(tf2.getText() + " ");
							buf.write(tf3.getText() + " ");
							buf.write(tf4.getText() + " ");
							buf.write(tf5.getText() + " ");
							buf.write("\r\n");
							buf.close();

							FileReader filer = new FileReader("subject.txt");
							BufferedReader inf = new BufferedReader(filer);
							String li = inf.readLine();

							String[] columnsName = li.split(" ");
							DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
							model1.setColumnIdentifiers(columnsName);

							String[] dataRow = { tf1.getText(), tf2.getText(), tf3.getText(), tf4.getText(),
									tf5.getText() };
							model1.addRow(dataRow);
							inf.close();

							tf1.setText("");
							tf2.setText("");
							tf3.setText("");
							tf4.setText("");
							tf5.setText("");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		Button.setBounds(570, 165, 120, 25);

		contentPane.add(Button);

		JTextField tf = new JTextField(10); // 텍스트필드 초기화
		tf.setBounds(10, 10, 130, 30);
		contentPane.add(tf);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 400, 150);
		scrollPane.setBackground(Color.WHITE);
		contentPane.add(scrollPane);

		table1 = new JTable();
		table1.setAutoCreateRowSorter(true);
		try {
			FileReader filer = new FileReader("subject.txt");
			BufferedReader inf = new BufferedReader(filer);
			String li = inf.readLine();
			String[] columnsName = li.split(" ");

			DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
			model1.setColumnIdentifiers(columnsName);

			Object[] tableL = inf.lines().toArray();
			for (int i = 0; i < tableL.length; i++) {
				String line2 = tableL[i].toString().trim();
				String[] dataRow = line2.split(" ");
				model1.addRow(dataRow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scrollPane.setViewportView(table1);

		JButton OK = new JButton("검색");
		OK.setBounds(145, 10, 80, 30);
		contentPane.add(OK);

		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
							int j = 0;
							j = table1.getRowCount();
							for (int i = 0; i < j; i++) {
								if (table1.getValueAt(i, 0).equals(tf.getText())) {
									table1.setRowHeight(i, 50);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton star = new JButton("★");
		star.setBounds(240, 10, 50, 30);
		contentPane.add(star);
		
		star.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							int j1 = table.getSelectedRow(); // todolist

							if (j1 != -1) {
								String s1 = table.getModel().getValueAt(j1, 0).toString();
								String s2 = table.getModel().getValueAt(j1, 1).toString();
								String s3 = table.getModel().getValueAt(j1, 2).toString();
								String s4 = table.getModel().getValueAt(j1, 3).toString();

								String mo = s1 + " " + s2 + " " + s3 + " " + s4;
								String mo2;
								if(mo.indexOf("★") != -1) {
									mo2 = mo.replace("★", "");
								}
								else {
									mo2 = s1 + " " + s2 + " " + s3 + " ★" + s4;
								}
									

								String dummy = "마감예정일 실제마감일 완료여부 내용 \r\n";

								FileReader filer = new FileReader("todolist.txt");
								BufferedReader inf = new BufferedReader(filer);
								String li = inf.readLine();

								// 1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
								String line;
								for (int i = 0; i < j1; i++) {
									line = inf.readLine(); // 읽으며 이동
									dummy += (line + "\r\n");
								}

								// 2. 수정하고자 하는 데이터
								dummy += (mo2 + "\r\n");
								inf.readLine();

								// 3. 삭제하고자 하는 position 이후부터 dummy에 저장
								while ((line = inf.readLine()) != null) {
									dummy += (line + "\r\n");
								}
								// 4. FileWriter를 이용해서 덮어쓰기
								FileWriter filewr = new FileWriter("todolist.txt");

								filewr.write(dummy);

								inf.close();
								filewr.close();
								
							}
							
							FileReader filer2 = new FileReader("todolist.txt");
							BufferedReader inFile12 = new BufferedReader(filer2);
							String line1 = inFile12.readLine();

							String[] columnsName2 = line1.split(" ");
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setColumnIdentifiers(columnsName2);
							model.setRowCount(0);
							Object[] tableLines = inFile12.lines().toArray();
							for (int i = 0; i < tableLines.length; i++) {
								String lline = tableLines[i].toString().trim();
								String[] dataRow = lline.split(" ");
								model.addRow(dataRow);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "과목순", "마감기한순", "실제마감일순", }));
		comboBox.setBackground(backcolor);
		comboBox.setBounds(300, 10, 100, 30);
		contentPane.add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기

				int index = cb.getSelectedIndex();// 선택된 아이템의 인덱스

				try {
					if (index == 0) { // 과목 이름순서
						FileReader filer = new FileReader("subject.txt");
						BufferedReader inf = new BufferedReader(filer);
						String li = inf.readLine();

						Object[] tableL = inf.lines().toArray();
						String temp[] = new String[tableL.length];

						for (int i = 0; i < tableL.length; i++) {
							temp[i] = tableL[i].toString().trim();
						}

						filer.close();
						inf.close();

						Arrays.sort(temp);

						String dummy = "과목명 교수명 수업시간 학년 학기\r\n";

						for (int i = 0; i < tableL.length; i++) {
							dummy += (temp[i] + "\r\n");
						}

						FileWriter filewr9 = new FileWriter("subject.txt");

						filewr9.write(dummy);

						filewr9.close();

						FileReader filer2 = new FileReader("subject.txt");
						BufferedReader inf2 = new BufferedReader(filer2);
						String li2 = inf2.readLine();
						String[] columnsName2 = li2.split(" ");

						DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
						model1.setRowCount(0);
						model1.setColumnIdentifiers(columnsName2);

						Object[] tableL2 = inf2.lines().toArray();
						for (int i = 0; i < tableL2.length; i++) {
							String line2 = tableL2[i].toString().trim();
							String[] dataRow2 = line2.split(" ");
							model1.addRow(dataRow2);
						}
					} else if (index == 1) { // 마감기한순
						FileReader filer = new FileReader("todolist.txt");
						BufferedReader inf = new BufferedReader(filer);
						String li = inf.readLine();

						Object[] tableL = inf.lines().toArray();
						String temp[] = new String[tableL.length];

						for (int i = 0; i < tableL.length; i++) {
							temp[i] = tableL[i].toString().trim();
						}

						filer.close();
						inf.close();

						Arrays.sort(temp);

						String dummy = "마감예정일 실제마감일 완료여부 내용\r\n";

						for (int i = 0; i < tableL.length; i++) {
							dummy += (temp[i] + "\r\n");
						}

						FileWriter filewr9 = new FileWriter("todolist.txt");

						filewr9.write(dummy);

						filewr9.close();

						FileReader filer2 = new FileReader("todolist.txt");
						BufferedReader inf2 = new BufferedReader(filer2);
						String li2 = inf2.readLine();
						String[] columnsName2 = li2.split(" ");

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						model.setColumnIdentifiers(columnsName2);

						Object[] tableL2 = inf2.lines().toArray();
						for (int i = 0; i < tableL2.length; i++) {
							String line2 = tableL2[i].toString().trim();
							String[] dataRow2 = line2.split(" ");
							model.addRow(dataRow2);
						}
					} else { // 실제 마감순
						FileReader filer = new FileReader("todolist.txt");
						BufferedReader inf = new BufferedReader(filer);
						String li = inf.readLine();

						Object[] tableL = inf.lines().toArray();
						String temp[] = new String[tableL.length];
						for (int i = 0; i < tableL.length; i++) {
							String line2 = tableL[i].toString().trim();
							String[] dataRow = line2.split(" ");
							temp[i] = dataRow[1] + " " + dataRow[0] + " " + dataRow[2] + " " + dataRow[3];
						}

						filer.close();
						inf.close();

						Arrays.sort(temp);

						for (int i = 0; i < tableL.length; i++) {
							String[] dataRow = temp[i].split(" ");
							temp[i] = dataRow[1] + " " + dataRow[0] + " " + dataRow[2] + " " + dataRow[3];
						}

						String dummy = "마감예정일 실제마감일 완료여부 내용\r\n";

						for (int i = 0; i < tableL.length; i++) {
							dummy += (temp[i] + "\r\n");
						}

						FileWriter filewr9 = new FileWriter("todolist.txt");

						filewr9.write(dummy);

						filewr9.close();

						FileReader filer2 = new FileReader("todolist.txt");
						BufferedReader inf2 = new BufferedReader(filer2);
						String li2 = inf2.readLine();
						String[] columnsName2 = li2.split(" ");

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						model.setColumnIdentifiers(columnsName2);

						Object[] tableL2 = inf2.lines().toArray();
						for (int i = 0; i < tableL2.length; i++) {
							String line2 = tableL2[i].toString().trim();
							String[] dataRow2 = line2.split(" ");
							model.addRow(dataRow2);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		JLabel Label_2 = new JLabel();
		Label_2.setText("                 todolist등록");
		Label_2.setOpaque(true);
		Label_2.setFont(new Font("돋음", Font.PLAIN, 20));
		Label_2.setBounds(400, 205, 400, 20);
		Label_2.setBackground(backcolor);
		contentPane.add(Label_2);

		JLabel Label12 = new JLabel();
		Label12.setText("  마감예정일");
		Label12.setOpaque(true);
		Label12.setFont(new Font("돋음", Font.PLAIN, 13));
		Label12.setBounds(400, 230, 100, 30);
		Label12.setBackground(backcolor);
		contentPane.add(Label12);

		JLabel Label22 = new JLabel();
		Label22.setText("  실제마감일");
		Label22.setOpaque(true);
		Label22.setFont(new Font("돋음", Font.PLAIN, 13));
		Label22.setBounds(400, 255, 100, 30);
		Label22.setBackground(backcolor);
		contentPane.add(Label22);

		JLabel Label32 = new JLabel();
		Label32.setText("  완료여부");
		Label32.setOpaque(true);
		Label32.setFont(new Font("돋음", Font.PLAIN, 13));
		Label32.setBounds(400, 280, 100, 30);
		Label32.setBackground(backcolor);
		contentPane.add(Label32);

		JLabel Label42 = new JLabel();
		Label42.setText("  내용");
		Label42.setOpaque(true);
		Label42.setFont(new Font("돋음", Font.PLAIN, 13));
		Label42.setBounds(400, 305, 100, 30);
		Label42.setBackground(backcolor);
		contentPane.add(Label42);

		tf12 = new JTextField();
		tf12.setBounds(510, 230, 180, 25);
		contentPane.add(tf12);

		tf22 = new JTextField();
		tf22.setBounds(510, 255, 180, 25);
		contentPane.add(tf22);

		tf32 = new JTextField();
		tf32.setBounds(510, 280, 180, 25);
		contentPane.add(tf32);

		tf42 = new JTextField();
		tf42.setBounds(510, 305, 180, 100);
		contentPane.add(tf42);

		JButton Button31 = new JButton("  todolist등록");

		Button31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FileWriter filewr2 = new FileWriter("todolist.txt", true);
							BufferedWriter buf2 = new BufferedWriter(filewr2);
							buf2.write(tf12.getText() + " ");
							buf2.write(tf22.getText() + " ");
							buf2.write(tf32.getText() + " ");
							buf2.write(tf42.getText() + " ");
							buf2.write("\r\n");
							buf2.close();

							FileReader filer1 = new FileReader("todolist.txt");
							BufferedReader inFile12 = new BufferedReader(filer1);
							String line1 = inFile12.readLine();

							String[] columnsName = line1.split(" ");
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setColumnIdentifiers(columnsName);

							String[] dataRow = { tf12.getText(), tf22.getText(), tf32.getText(), tf42.getText() };
							model.addRow(dataRow);
							inFile12.close();
							tf12.setText("");
							tf22.setText("");
							tf32.setText("");
							tf42.setText("");

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		Button31.setBounds(570, 425, 120, 25);

		contentPane.add(Button31);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 230, 400, 150);
		scrollPane_1.setBackground(Color.WHITE);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		try {
			FileReader filer1 = new FileReader("todolist.txt");
			BufferedReader inFile12 = new BufferedReader(filer1);
			String line1 = inFile12.readLine();

			String[] columnsName = line1.split(" ");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setColumnIdentifiers(columnsName);

			Object[] tableLines = inFile12.lines().toArray();
			for (int i = 0; i < tableLines.length; i++) {
				String lline = tableLines[i].toString().trim();
				String[] dataRow = lline.split(" ");
				model.addRow(dataRow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollPane_1.setViewportView(table);

		JButton Button2 = new JButton("수정");

		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							int j1 = table.getSelectedRow(); // todolist
							int j2 = table1.getSelectedRow(); // subject

							System.out.println(j1);
							System.out.println(j2);

							if (j1 != -1) {
								String s1 = table.getModel().getValueAt(j1, 0).toString();
								String s2 = table.getModel().getValueAt(j1, 1).toString();
								String s3 = table.getModel().getValueAt(j1, 2).toString();
								String s4 = table.getModel().getValueAt(j1, 3).toString();

								String mo = s1 + " " + s2 + " " + s3 + " " + s4;

								String dummy = "마감예정일 실제마감일 완료여부 내용 \r\n";

								FileReader filer = new FileReader("todolist.txt");
								BufferedReader inf = new BufferedReader(filer);
								String li = inf.readLine();

								// 1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
								String line;
								for (int i = 0; i < j1; i++) {
									line = inf.readLine(); // 읽으며 이동
									dummy += (line + "\r\n");
								}

								// 2. 수정하고자 하는 데이터
								dummy += (mo + "\r\n");
								inf.readLine();

								// 3. 삭제하고자 하는 position 이후부터 dummy에 저장
								while ((line = inf.readLine()) != null) {
									dummy += (line + "\r\n");
								}
								// 4. FileWriter를 이용해서 덮어쓰기
								FileWriter filewr = new FileWriter("todolist.txt");

								filewr.write(dummy);

								inf.close();
								filewr.close();
							}

							if (j2 != -1) {
								String s1 = table1.getModel().getValueAt(j2, 0).toString();
								String s2 = table1.getModel().getValueAt(j2, 1).toString();
								String s3 = table1.getModel().getValueAt(j2, 2).toString();
								String s4 = table1.getModel().getValueAt(j2, 3).toString();
								String s5 = table1.getModel().getValueAt(j2, 4).toString();
								String mo2 = s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5;

								String dummy2 = "과목명 교수명 수업시간 학년 학기\r\n";

								FileReader filer2 = new FileReader("subject.txt");
								BufferedReader inf2 = new BufferedReader(filer2);
								String li2 = inf2.readLine();

								// 1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
								String line2;
								for (int i = 0; i < j2; i++) {
									line2 = inf2.readLine(); // 읽으며 이동
									dummy2 += (line2 + "\r\n");
								}

								// 2. 수정하고자 하는 데이터
								dummy2 += (mo2 + "\r\n");
								inf2.readLine();

								// 3. 삭제하고자 하는 position 이후부터 dummy에 저장
								while ((line2 = inf2.readLine()) != null) {
									dummy2 += (line2 + "\r\n");
								}
								// 4. FileWriter를 이용해서 덮어쓰기
								FileWriter filewr2 = new FileWriter("subject.txt");

								filewr2.write(dummy2);

								inf2.close();
								filewr2.close();
							}

							System.out.println("수정되었습니다.");

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button2.setBounds(0, 420, 100, 40);
		contentPane.add(Button2);

		JButton Button3 = new JButton("삭제");

		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// 삭제 로직 추가
							DefaultTableModel model1 = (DefaultTableModel) table1.getModel();

							int j1 = table1.getSelectedRow();
							model1.removeRow(j1);

							System.out.println("삭제되었습니다.");

							String dummy = "과목명 교수명 수업시간 학년 학기\r\n";

							FileReader filer = new FileReader("subject.txt");
							BufferedReader inf = new BufferedReader(filer);
							String li = inf.readLine();

							// 1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
							String line;
							for (int i = 0; i < j1; i++) {
								line = inf.readLine(); // 읽으며 이동
								dummy += (line + "\r\n");
							}

							// 2. 삭제하고자 하는 데이터는 건너뛰기
							String delData = inf.readLine();

							// 3. 삭제하고자 하는 position 이후부터 dummy에 저장
							while ((line = inf.readLine()) != null) {
								dummy += (line + "\r\n");
							}
							// 4. FileWriter를 이용해서 덮어쓰기
							FileWriter filewr = new FileWriter("subject.txt");

							filewr.write(dummy);

							inf.close();
							filewr.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button3.setBounds(150, 190, 100, 30);
		contentPane.add(Button3);

		JButton Button33 = new JButton("삭제");

		Button33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// 삭제 로직 추가

							DefaultTableModel model2 = (DefaultTableModel) table.getModel();
							int j2 = table.getSelectedRow();
							model2.removeRow(j2);

							System.out.println("삭제되었습니다.");

							String dummy = "마감예정일 실제마감일 완료여부 내용\r\n";

							FileReader filer = new FileReader("todolist.txt");
							BufferedReader inf = new BufferedReader(filer);
							String li = inf.readLine();

							// 1. 삭제하고자 하는 position 이전까지는 이동하며 dummy에 저장
							String line;
							for (int i = 0; i < j2; i++) {
								line = inf.readLine(); // 읽으며 이동
								dummy += (line + "\r\n");
							}

							// 2. 삭제하고자 하는 데이터는 건너뛰기
							String delData = inf.readLine();

							// 3. 삭제하고자 하는 position 이후부터 dummy에 저장
							while ((line = inf.readLine()) != null) {
								dummy += (line + "\r\n");
							}
							// 4. FileWriter를 이용해서 덮어쓰기
							FileWriter filewr = new FileWriter("todolist.txt");

							filewr.write(dummy);

							inf.close();
							filewr.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		Button33.setBounds(150, 380, 100, 30);
		contentPane.add(Button33);

		JButton Button4 = new JButton("숨기기");

		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DefaultTableModel model1 = (DefaultTableModel) table1.getModel();

							int j1 = table1.getSelectedRow();
							if (j1 != -1)
								model1.removeRow(j1);

							DefaultTableModel model = (DefaultTableModel) table.getModel();

							int j2 = table.getSelectedRow();
							if (j2 != -1)
								model.removeRow(j2);

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		Button4.setBounds(150, 420, 100, 40);
		contentPane.add(Button4);

		JButton Button5 = new JButton("보이기");

		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FileReader filer = new FileReader("subject.txt");
							BufferedReader inf = new BufferedReader(filer);
							String li = inf.readLine();
							String[] columnsName = li.split(" ");

							DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
							model1.setRowCount(0);
							model1.setColumnIdentifiers(columnsName);

							Object[] tableL = inf.lines().toArray();
							for (int i = 0; i < tableL.length; i++) {
								String line2 = tableL[i].toString().trim();
								String[] dataRow = line2.split(" ");
								model1.addRow(dataRow);
							}

							FileReader filer2 = new FileReader("todolist.txt");
							BufferedReader inFile12 = new BufferedReader(filer2);
							String line1 = inFile12.readLine();

							String[] columnsName2 = line1.split(" ");
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							model.setColumnIdentifiers(columnsName2);
							model.setRowCount(0);
							Object[] tableLines = inFile12.lines().toArray();
							for (int i = 0; i < tableLines.length; i++) {
								String lline = tableLines[i].toString().trim();
								String[] dataRow = lline.split(" ");
								model.addRow(dataRow);
							}

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		Button5.setBounds(300, 420, 100, 40);
		contentPane.add(Button5);

	}
}
