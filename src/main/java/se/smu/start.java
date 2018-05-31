package jikong;

import java.util.*;
import java.awt.EventQueue;

class Account {
	private String ID;
	private String email;
	String passwd;
	String passwdOK;
	String nickname;
	public Account(String ID,String passwd,String passwdOK,String nickname,String email) { 
		this.ID=ID; this.email=email; this.passwd=passwd;
		this.passwdOK=passwdOK; this.nickname=nickname;
	}
	String getID() {return ID;}
	String getemail() {return email;}
	String getpasswd() {return passwd;}
	String getpasswdOK() {return passwdOK;}
	String getnickname() {return nickname;}
}

class List {
	ArrayList<String> strtodo = new ArrayList<String>(4);
	ArrayList<Integer> inttodo= new ArrayList<Integer>(5);
	private String sub; private String pro;
	int time; int grade; int sem; String todo;
	int deadline; int realdead; String ox;
	
	public List(String sub,String pro,int time,int grade,int sem) {
		strtodo.add(0,sub); strtodo.add(1,pro);
		inttodo.add(0,time); inttodo.add(1,grade); inttodo.add(2,sem);
	//this.sub=sub; this.pro=pro; this.time=time; this.grade=grade; this.sem=sem;
	}
	public List(String todo,int deadline,int realdead,String ox) {
		strtodo.add(2,todo); inttodo.add(3,deadline);
		inttodo.add(4,realdead); strtodo.add(3,ox);
	//this.todo=todo; this.deadline=deadline; this.realdead=realdead; this.ox=ox;
	}
	
	String getsub() {return strtodo.get(0);}
	String getpro() {return strtodo.get(1);}
	int gettime() {return inttodo.get(0);}
	int getgrade() {return inttodo.get(1);}
	int getsem() {return inttodo.get(2);}
	String gettodo() {return strtodo.get(2);}
	int getdeadline() {return inttodo.get(3);}
	int getrealdead() {return inttodo.get(4);}
	String getox() {return strtodo.get(3);}
}

public class start {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					HashMap<String,Account> map = new HashMap<String,Account>();
					login frame = new login(map);
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}	
	
}


