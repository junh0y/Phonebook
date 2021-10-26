package project1.ver06;

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
	
	@Override
	public void showData()
	{
		System.out.println("---- 대학교 친구 정보 ----");
		super.showData();
		System.out.println("전    공 : " + subject);
		System.out.println("학    년 : " + grade);
	}
}
