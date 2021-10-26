package project1.ver03;

public class PhoneInfo
{
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showData()
	{
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("생년월일 : " + birthday);
	}
}