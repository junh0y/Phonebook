package project1.ver06;

public class MenuSelectException extends Exception
{
	public MenuSelectException()
	{
		System.out.println("1과 5 사이의 숫자를 입력하세요.");
	}
}