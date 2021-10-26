package project1.ver03;

import java.util.Scanner;

import project1.ver03.PhoneInfo;

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
		System.out.println("---선택하세요---");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");		
		System.out.println("3. 데이터 삭제");		
		System.out.println("4. 주소록 출력");		
		System.out.println("5. 프로그램 종료");
	}
	
	public void dataInput()
	{
		String name, phoneNumber, birthday;
		Scanner scanner = new Scanner(System.in);	
		
		System.out.print("이    름 : ");
		name = scanner.nextLine();
		System.out.print("전화번호 : ");
		phoneNumber = scanner.nextLine();
		System.out.print("생년월일 : ");
		birthday = scanner.nextLine();
		
		friends[index++] = new PhoneInfo(name, phoneNumber, birthday);
		
	}
	
	public void dataSearch()
	{
		boolean isFind = false;
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요. : ");
		String searchName = scanner1.nextLine();
		
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
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요. : ");
		String deleteName = scanner2.nextLine();
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