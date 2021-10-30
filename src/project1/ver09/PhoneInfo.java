package project1.ver09;

public class PhoneInfo
{
	public String name;
	public String phoneNumber;
	public String birthday;
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
}