package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{
	public static void main(String[] args)
	{
		while (true)
		{
			System.out.println("■■■■■■ 옵션 ■■■■■■");
			System.out.println("■ 1. 데이터 입력 ■");
			System.out.println("■ 2. 종       료 ■ ");		
			Scanner scanner = new Scanner(System.in);
			System.out.println("■■■■■■■■■■■■■■■■■■");
			System.out.print("옵션을 선택하세요 : ");
			
			int selectNum = scanner.nextInt();
			if (selectNum == 1)
			{
				PhoneInfo phoneInfo = new PhoneInfo();
				phoneInfo.showPhoneInfo();
			}
			else if (selectNum == 2)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}