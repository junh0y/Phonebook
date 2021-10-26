package project1.ver04;

import java.util.Scanner;

import project1.ver04.PhoneInfo;

public class PhoneBookManager
{
	public PhoneInfo[] friends;
	public int index;
	
	public PhoneBookManager(int num)
	{
		friends = new PhoneInfo[num];
		index = 0;
	}
	
	public void printMenu()
	{
		System.out.println("■■■■■■ 옵션 ■■■■■■");
		System.out.println("■ 1. 데이터 입력 ■");
		System.out.println("■ 2. 데이터 검색 ■");		
		System.out.println("■ 3. 데이터 삭제 ■");		
		System.out.println("■ 4. 주소록 출력 ■");		
		System.out.println("■ 5. 종       료 ■");
	}
	
	public void dataInput()
	{
		String name, phoneNumber, subject, companyName;
		int grade;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("■■■■■■ 옵션 ■■■■■■");
		System.out.println("■■■■ 1. 일 반 ■■■■");
		System.out.println("■■■■ 2. 동 창 ■■■■");		
		System.out.println("■■■■ 3. 회 사 ■■■■");
		System.out.println("■■■■■■■■■■■■■■■■■■");
		System.out.print("옵션을 선택하세요 : ");
		int choice = scanner.nextInt();
		
		if (choice == 1)
		{
			System.out.print("이    름 : ");
			scanner.nextLine();
			name = scanner.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scanner.nextLine();
			PhoneInfo friend = new PhoneInfo(name, phoneNumber);
			friends[index++] = friend;
		}
		else if (choice == 2)
		{
			System.out.print("이    름 : ");
			scanner.nextLine();
			name = scanner.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scanner.nextLine();
			System.out.print("전    공 : ");
			subject = scanner.nextLine();
			System.out.print("학    년 : ");
			grade = scanner.nextInt();
			PhoneSchoolInfo school
				= new PhoneSchoolInfo(name, phoneNumber, subject, grade);
			friends[index++] = school;
		}
		else if (choice == 3)
		{
			System.out.print("이    름 : ");
			scanner.nextLine();
			name = scanner.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scanner.nextLine();
			System.out.print("회 사 명 : ");
			companyName = scanner.nextLine();
			PhoneCompanyInfo company
				= new PhoneCompanyInfo(name, phoneNumber, companyName);
			friends[index++] = company;
		}
	}
	
	public void dataSearch()
	{
		boolean isFind = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요. : ");
		String searchName = scanner.nextLine();
		
		for (int i = 0 ; i < index ; i++)
		{
			if (searchName.compareTo(friends[i].name) == 0)
			{
				System.out.println("-- 귀하가 요청하는 정보를 찾았습니다. --");
				friends[i].showData();
				isFind = true;
			}
		}
		if (isFind == false)
			System.out.println("------ 찾는 정보가 없습니다. ------");
	}
	
	public void dataDelete()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요. : ");
		String deleteName = scanner.nextLine();
		int deleteIndex = -1;
		
		for (int i = 0 ; i < index ; i++)
		{
			if (deleteName.compareTo(friends[i].name) == 0)
			{
				friends[i] = null;
				deleteIndex = i;
				index--;
				break;
			}
		}
		
		if (deleteIndex == -1)
		{
			System.out.println("---- 삭제된 데이터가 없습니다. ----");
		}
		else
		{
			for (int i = deleteIndex ; i < index ; i++)
			{
				friends[i] = friends[i++];
			}
			System.out.println("-- 데이터("+ deleteIndex +"번)가 삭제되었습니다. --");
		}
	}
	
	public void showAllData()
	{
		for (int i = 0 ; i < index ; i++)
		{
			friends[i].showData();
		}
		System.out.println("--- 전체 정보가 출력되었습니다. ---");
	}
}
