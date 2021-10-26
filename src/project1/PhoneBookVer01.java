package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01
{
	public static void main(String[] args)
	{
		PhoneInfo phoneInfo1
			= new PhoneInfo("홍길동", "010-1111-1111", "1980-10-10");
		phoneInfo1.showPhoneInfo();
		
		PhoneInfo phoneInfo2
			= new PhoneInfo("홍길순", "010-2222-2222");
		phoneInfo2.showPhoneInfo();
	}
}