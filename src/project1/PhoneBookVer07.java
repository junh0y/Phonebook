package project1;

import java.util.Scanner;

import project1.ver07.PhoneBookManager;
import project1.ver07.Menuitem;

public class PhoneBookVer07 implements Menuitem
{
	public static void main(String[] args)
	{
		PhoneBookManager phone = new PhoneBookManager(100);
		
		while (true)
		{
			phone.printMenu();
			
			Scanner scanner = new Scanner(System.in);		
			System.out.println("■■■■■■■■■■■■■■■■■■");
			System.out.print("옵션을 선택하세요 : ");
			int selectNum = scanner.nextInt();
			
			switch (selectNum)
			{
			case input:
				phone.dataInput();		break;
			case search :
				phone.dataSearch();		break;
			case delete :
				phone.dataDelete();		break;
			case showAllData :
				phone.showAllData();	break;
			case exit : 
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}