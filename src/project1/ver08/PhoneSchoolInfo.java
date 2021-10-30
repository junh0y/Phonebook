package project1.ver08;

public class PhoneSchoolInfo extends PhoneInfo
{
	String subject;
	int grade;	
	
	public PhoneSchoolInfo(String name, String phoneNumber, String subject, int grade)
	{
		super(name, phoneNumber);
		this.subject = subject;
		this.grade = grade;
	}
	
	public String getSubject()
	{
		return subject;
	}

	public int getGrade()
	{
		return grade;
	}

	@Override
	public void showData()
	{
		super.showData();
		System.out.println("전    공 : " + subject);
		System.out.println("학    년 : " + grade);
	}
}