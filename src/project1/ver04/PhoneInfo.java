package project1.ver04;

public class PhoneInfo
{
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showData()
	{
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}
