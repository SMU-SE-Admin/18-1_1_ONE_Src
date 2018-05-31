package se.smu;
import java.util.*;
public abstract class Subject 
{
	protected String[] Name=new String[100];	//����� String, **��������� I/O �޼ҵ� ó���س�����
	protected String[] Professor=new String[100];	//������ String
	protected String[] Lecture_day=new String[100];		//�������� String
	protected String[] Semester_and_Year=new String[100];	//�б�� �⵵ ���� String
	
	protected boolean[] Done=new boolean[100];	//�Ϸ� ���� true/false
	protected int[] Importance=new int[100];	//�߿䵵 ǥ��
	// i�� 0~5�� ��, �ݺ����� �����Ͽ� ������ŭ ��ǥ��. **������� �� ��, i�� 0�Ǵ� 1�� ��. (�� �� �Է��� Degenerate Caseó��)								
	protected boolean Hide[]=new boolean[100]; //�����, �������.
	
	int IOindex=0; //���� �Է� ���� ��ġ�� ����Ű�� �ε���
	
	public void Add_Subject(String name, String professor, String lecture_day, String semester_and_year)
	{
		Name[IOindex]=name;
		Professor[IOindex]=professor;
		Lecture_day[IOindex]=lecture_day;
		Semester_and_Year[IOindex]=semester_and_year;
		IOindex++;
	}
	
	public String getProfessor(String name) 
	{
		int j=0;
		int i=0;
		while(j!=0)
		{
			if(name==Name[i])
			{
				j++;
			}
			i++;
		}
		return Professor[i];
	}
	
	public String getLecture_day(String name)
	{
		int j=0;
		int i=0;
		while(j!=0)
		{
			if(name==Name[i])
			{
				j++;
			}
			i++;
		}
		return Lecture_day[i];
	}
	
	public String getSemester_and_Year(String name)
	{
		int j=0;
		int i=0;
		while(j!=0)
		{
			if(name==Name[i])
			{
				j++;
			}
			i++;
		}
		return Semester_and_Year[i];
	}
	
	
	public void Del_Subject(String name)
	{
		int i=-1,j=0;
		while(j==0)
		{
			i++;
			if(Name[i]==name)
			{
				j++;
			}
		}
		for(;i<IOindex;i++)
		{
			Name[i]=Name[i+1];
			Professor[i]=Professor[i+1];
			Lecture_day[i]=Lecture_day[i+1];
			Semester_and_Year[i]=Semester_and_Year[i+1];
		}
		IOindex--;
	}
	
	public void setImportantance(String name,int num)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		Importance[i]=num;
	}
	
	public int getImportance(String name)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		return Importance[i];
	}
	
	public void setDone(String name,boolean a)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		Done[i]=a;
	}
	
	public boolean getDone(String name)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		return Done[i];
	}
	
	public void setHide(String name)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		Hide[i]=true;
	}
	
	public boolean getHide(String name)
	{
		int i=0;
		for(;i<IOindex;i++)
		{
			if(Name[i]==name)
				break;
		}
		return Hide[i];
	}
	
}

