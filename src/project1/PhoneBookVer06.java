package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.PhoneBookManager;
import project1.ver06.Menuitem;
import project1.ver06.MenuSelectException;

public class PhoneBookVer06 implements Menuitem
{
	public static void main(String[] args) throws MenuSelectException
	{
		project1.ver05.PhoneBookManager phone
			= new project1.ver05.PhoneBookManager(100);
		
		while (true)
		{
			phone.printMenu();
			
			Scanner scanner = new Scanner(System.in);		
			System.out.println("■■■■■■■■■■■■■■■■■■");
			System.out.print("옵션을 선택하세요 : ");
			try
			{
				int selectNum = scanner.nextInt();
				try 
				{
					if (selectNum < 1 || selectNum > 5)
					{
						MenuSelectException ex = new MenuSelectException();
						throw ex;
					}
				}
				catch (MenuSelectException e)
				{
					e.getMessage();
				}
				
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
			catch (InputMismatchException e)
			{
				System.out.println("숫자를 입력해야 합니다.");
			}
			catch (NullPointerException e)
			{
				e.printStackTrace();
			}
		}
	}
}