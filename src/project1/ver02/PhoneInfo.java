package project1.ver02;

import java.util.Scanner;

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
	public PhoneInfo()
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지 않음";
	}
	
	public void showPhoneInfo()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("이    름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phoneNumber = scanner.nextLine();
		System.out.print("생년월일 : ");
		String birthday = scanner.nextLine();
		
		System.out.println();
		System.out.println("이    름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("생년월일 : "+ birthday);
		System.out.println();
	}
}