package project1.ver01;

public class PhoneInfo
{
	String name;		// 이    름
	String phoneNumber;	// 전화번호
	String birthday;	// 생년월일
	
	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
//	2개의 멤버 변수를 가진 생성자 오버로딩	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지 않음";
	}
	
	public void showPhoneInfo()
	{
		System.out.println("이    름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("생년월일 : "+ birthday);
	}
}