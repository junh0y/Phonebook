package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver05.Menuitem;

public class PhoneBookVer05 implements Menuitem
{
	public static void main(String[] args)
	{
		project1.ver05.PhoneBookManager phone
			= new project1.ver05.PhoneBookManager(100);
		
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