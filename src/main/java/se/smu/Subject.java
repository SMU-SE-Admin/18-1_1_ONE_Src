package se.smu;
import java.util.*;
public abstract class Subject 
{
	protected String[] Name=new String[100];	//과목명 String, **과목명으로 I/O 메소드 처리해놓았음
	protected String[] Professor=new String[100];	//교수명 String
	protected String[] Lecture_day=new String[100];		//요일정보 String
	protected String[] Semester_and_Year=new String[100];	//학기와 년도 정보 String
	
	protected boolean[] Done=new boolean[100];	//완료 여부 true/false
	protected int[] Importance=new int[100];	//중요도 표시
	// i는 0~5의 값, 반복문에 대입하여 갯수만큼 별표시. **명세서대로 할 시, i는 0또는 1의 값. (그 외 입력은 Degenerate Case처리)								
	protected boolean Hide[]=new boolean[100]; //숨기기, 숨김취소.
	
	int IOindex=0; //과목 입력 수정 위치를 가리키는 인덱스
	
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

