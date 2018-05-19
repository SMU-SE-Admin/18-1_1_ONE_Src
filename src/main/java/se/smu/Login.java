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
	JLabel putemail = new JLabel("이메일 계정 입력:");
	JTextField tf = new JTextField("");
	JButton okB = new JButton("찾기");
	JButton exit = new JButton("확인");
	
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
						JLabel txtID = new JLabel("해당 이메일의 ID: ");
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
						JLabel failID = new JLabel("해당 이메일의 ID계정이 존재하지 않습니다.");
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
		Font f1 = new Font("돋움",Font.BOLD,30);
		Color backcolor = new Color(228,247,186);
		c.setBackground(backcolor);
		c.setLayout(null);
		
		JLabel title =new JLabel("로그인");
		title.setLocation(240,30); title.setSize(150,50); title.setFont(f1);
		c.add(title);
		
		JPanel IDPWD = new JPanel();
		GridLayout grid1 = new GridLayout(2,1); grid1.setVgap(25);
		IDPWD.setLocation(90,100); IDPWD.setSize(70,100);
		IDPWD.add(new JLabel("아이디"));
		IDPWD.add(new JLabel("비밀번호"));
		IDPWD.setLayout(grid1); IDPWD.setBackground(backcolor);	
		c.add(IDPWD);
		
		JPanel PutIDPWD= new JPanel();
		GridLayout grid2 = new GridLayout(2,1); grid2.setVgap(25);
		PutIDPWD.setLocation(160,100); PutIDPWD.setSize(200,100);
		PutIDPWD.add(new JTextField(""));
		PutIDPWD.add(new JPasswordField(""));
		PutIDPWD.setLayout(grid2); PutIDPWD.setBackground(backcolor);
		c.add(PutIDPWD);
		
		JButton login = new JButton("로그인");
		login.setLocation(400,100); login.setSize(110,100);
		c.add(login);
		
		JPanel etc = new JPanel();
		JButton findID = new JButton("아이디찾기"); JButton findPWD = new JButton("비밀번호찾기"); JButton register = new JButton("회원가입");
		GridLayout grid3 = new GridLayout(1,3,15,0);
		etc.setLocation(90,240); etc.setSize(420,40);
		etc.add(findID);
		etc.add(findPWD);
		etc.add(register);
		etc.setLayout(grid3); etc.setBackground(backcolor);
		c.add(etc);
		
		FID popfindID=new FID(this,"아이디 찾기",map);
		
		
		findID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popfindID.setVisible(true);
			}
		});
		
		/*	
	// 아이디찾기 버튼 눌렀을때
	findID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<String> it = ids.iterator();
				Scanner scanner = new Scanner(System.in);
				int num=0;
				
				
				System.out.print("이메일 계정 입력: ");
				String putemail = scanner.next();
				while(it.hasNext()) {
					String dicid=it.next();
					Account dicac= map.get(dicid);
					if(putemail.equals(dicac.getemail()))	 {
						System.out.println("해당 이메일의 ID: "+dicid);
						num++;
					}
				}
				if(num==0)
					System.out.println("해당 이메일의 ID계정이 존재하지 않습니다.");		
				scanner.close();
			}
		});
	
	//비밀번호 찾기 눌렀을때
	System.out.print("ID 계정 입력: ");
	String putID = scanner.next();
	if(!map.containsKey(putID)) {
		System.out.println("해당 ID계정이 존재하지 않습니다.");	return;
	}
	System.out.print("새 비밀번호 입력: ");
	String newpasswd = scanner.next();
	System.out.print("새 비밀번호 다시 입력: ");
	String newnewpasswd = scanner.next();
	if(!newpasswd.equals(newnewpasswd)) {
		System.out.println("새비밀번호가 일치하지 않습니다.");	return;
	}
	Account Resetac=map.get(putID);
	Resetac.passwd=newpasswd;
	map.put(putID,Resetac);
	System.out.println("ID: "+putID+"\n새비밀번호: "+Resetac.getpasswd());
	scanner.close();
	*/
	setSize(600,400);
	setVisible(true);
	}
	public static void main(String [] args) {
		new Login();
	}
}
