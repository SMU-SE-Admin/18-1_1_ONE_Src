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
