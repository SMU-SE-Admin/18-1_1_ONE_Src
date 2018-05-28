import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.TileObserver;
import java.awt.*;

class Account {
	private String ID;
	private String email;
	String passwd;
	public Account(String ID,String email,String passwd) { 
		this.ID=ID; this.email=email; this.passwd=passwd;
	}
	String getID() {return ID;}
	String getemail() {return email;}
	String getpasswd() {return passwd;}
}
class FID extends JDialog {
	HashMap<String,Account> map;
	JLabel putemail = new JLabel("�̸��� ���� �Է�:");
	JTextField tf = new JTextField("");
	JButton okB = new JButton("ã��");
	JButton exit = new JButton("Ȯ��");
	
	public FID(JFrame frame,String title2,HashMap<String,Account> map) {
		super(frame,title2);
		this.map = map;
		setLayout(null);
		setLocation(75,100); setSize(450,230);
		putemail.setLocation(40,40); putemail.setSize(100,30);
		tf.setLocation(150,40); tf.setSize(170,30);
		okB.setLocation(330,40); okB.setSize(60,30);
		exit.setLocation(160,120); exit.setSize(100,30);
		add(putemail); add(tf); add(okB); add(exit);
		
		okB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set<String> ids = map.keySet();
				Iterator<String> it = ids.iterator();
				Scanner sc = new Scanner(System.in);
								
				int num=0;
				String schemail = tf.getText();
				while(it.hasNext()) {
					String dicid=it.next();
					Account dicac= map.get(dicid);
					if(schemail.equals(dicac.getemail()))	 {
						JLabel txtID = new JLabel("�ش� �̸����� ID: ");
						JLabel finalID = new JLabel(dicid);
						txtID.setLocation(120,80); txtID.setSize(130,30); txtID.setLayout(null);
						finalID.setLocation(230,80); finalID.setSize(130,30); finalID.setLayout(null);
						add(txtID); add(finalID);
						tf.setText("");
						num++;
						txtID.setVisible(true); finalID.setVisible(true);
					}
				}
					if(num==0) {
						JLabel failID = new JLabel("�ش� �̸����� ID������ �������� �ʽ��ϴ�.");
						failID.setLocation(80,120); failID.setSize(300,30);
						setVisible(true);
					}
			}
		
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}

public class Login extends JFrame{
	public Login() {
		HashMap<String, Account> map = new HashMap<String, Account>();
		 map.put("gab1",new Account("gab1","gab1@naver.com","gabgab"));
		 map.put("eul2",new Account("eul2","eul2@naver.com","euleul"));
		 map.put("byeong3",new Account("byeong3","byeng3@naver.com","byeongbyeong"));
	
		
		Set<String> ids = map.keySet();
	
		setTitle("To Do List Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		Font f1 = new Font("����",Font.BOLD,30);
		Color backcolor = new Color(228,247,186);
		c.setBackground(backcolor);
		c.setLayout(null);
		
		JLabel title =new JLabel("�α���");
		title.setLocation(240,30); title.setSize(150,50); title.setFont(f1);
		c.add(title);
		
		JPanel IDPWD = new JPanel();
		GridLayout grid1 = new GridLayout(2,1); grid1.setVgap(25);
		IDPWD.setLocation(90,100); IDPWD.setSize(70,100);
		IDPWD.add(new JLabel("���̵�"));
		IDPWD.add(new JLabel("��й�ȣ"));
		IDPWD.setLayout(grid1); IDPWD.setBackground(backcolor);	
		c.add(IDPWD);
		
		JPanel PutIDPWD= new JPanel();
		GridLayout grid2 = new GridLayout(2,1); grid2.setVgap(25);
		PutIDPWD.setLocation(160,100); PutIDPWD.setSize(200,100);
		PutIDPWD.add(new JTextField(""));
		PutIDPWD.add(new JPasswordField(""));
		PutIDPWD.setLayout(grid2); PutIDPWD.setBackground(backcolor);
		c.add(PutIDPWD);
		
		JButton login = new JButton("�α���");
		login.setLocation(400,100); login.setSize(110,100);
		c.add(login);
		
		JPanel etc = new JPanel();
		JButton findID = new JButton("���̵�ã��"); JButton findPWD = new JButton("��й�ȣã��"); JButton register = new JButton("ȸ������");
		GridLayout grid3 = new GridLayout(1,3,15,0);
		etc.setLocation(90,240); etc.setSize(420,40);
		etc.add(findID);
		etc.add(findPWD);
		etc.add(register);
		etc.setLayout(grid3); etc.setBackground(backcolor);
		c.add(etc);
		
		FID popfindID=new FID(this,"���̵� ã��",map);
		
		
		findID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popfindID.setVisible(true);
			}
		});
		
		/*	
	// ���̵�ã�� ��ư ��������
	findID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<String> it = ids.iterator();
				Scanner scanner = new Scanner(System.in);
				int num=0;
				
				
				System.out.print("�̸��� ���� �Է�: ");
				String putemail = scanner.next();
				while(it.hasNext()) {
					String dicid=it.next();
					Account dicac= map.get(dicid);
					if(putemail.equals(dicac.getemail()))	 {
						System.out.println("�ش� �̸����� ID: "+dicid);
						num++;
					}
				}
				if(num==0)
					System.out.println("�ش� �̸����� ID������ �������� �ʽ��ϴ�.");		
				scanner.close();
			}
		});
	
	//��й�ȣ ã�� ��������
	System.out.print("ID ���� �Է�: ");
	String putID = scanner.next();
	if(!map.containsKey(putID)) {
		System.out.println("�ش� ID������ �������� �ʽ��ϴ�.");	return;
	}
	System.out.print("�� ��й�ȣ �Է�: ");
	String newpasswd = scanner.next();
	System.out.print("�� ��й�ȣ �ٽ� �Է�: ");
	String newnewpasswd = scanner.next();
	if(!newpasswd.equals(newnewpasswd)) {
		System.out.println("����й�ȣ�� ��ġ���� �ʽ��ϴ�.");	return;
	}
	Account Resetac=map.get(putID);
	Resetac.passwd=newpasswd;
	map.put(putID,Resetac);
	System.out.println("ID: "+putID+"\n����й�ȣ: "+Resetac.getpasswd());
	scanner.close();
	*/
	setSize(600,400);
	setVisible(true);
	}
	public static void main(String [] args) {
		new Login();
	}
}
