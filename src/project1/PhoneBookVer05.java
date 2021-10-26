package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;

interface select
{
	int input = 1, search = 2, delete = 3, showAllData = 4, exit = 5;
}

public class PhoneBookVer05
{
	public static void main(String[] args)
	{
		PhoneBookManager phone = new PhoneBookManager(100);
		
		while (true)
		{
			phone.printMenu();
			
			Scanner scanner = new Scanner(System.in);		
			System.out.print("선택 : ");
			int selectNum = scanner.nextInt();
			
			switch (selectNum)
			{
			case select.input : phone.dataInput();			break;
			case select.search : phone.dataSearch();		break;
			case select.delete : phone.dataDelete();		break;
			case select.showAllData : phone.showAllData();	break;
			case select.exit : System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
