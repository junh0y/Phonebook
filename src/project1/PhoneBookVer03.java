package project1;

import java.util.Scanner;

import project1.ver03.PhoneBookManager;
import project1.ver03.PhoneInfo;

public class PhoneBookVer03
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
			case 1 : phone.dataInput();		break;
			case 2 : phone.dataSearch();	break;
			case 3 : phone.dataDelete();	break;
			case 4 : phone.showAllData();	break;
			case 5 : System.out.println("프로그램을 종료합니다."); return;
			}
		}
	}
}