package project1.ver08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet; 
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.PhoneInfo;
import project1.ver08.PhoneSchoolInfo;
import project1.ver08.PhoneCompanyInfo;
import project1.ver08.SubMenuitem;


public class PhoneBookManager implements SubMenuitem
{
	HashSet<PhoneInfo> friends;
	
	public PhoneBookManager(int num)
	{
		friends = new HashSet<PhoneInfo>();
		readObj();
	}
	
	public void printMenu()
	{
		System.out.println("■■■■■■■■■■■■■■ 옵 션 ■■■■■■■■■■■■■■");
		System.out.println("■         1.  데이터 입력         ■");
		System.out.println("■         2.  데이터 검색         ■");		
		System.out.println("■         3.  데이터 삭제         ■");		
		System.out.println("■         4.  데이터 출력         ■");		
		System.out.println("■         5.  데이터 저장         ■");		
		System.out.println("■         6.  종       료         ■");
	}
	
	public void dataInput()
	{
		String name, phoneNumber, subject, companyName;
		int grade;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("■■■■■■■■■■■■■■ 옵 션 ■■■■■■■■■■■■■■");
		System.out.println("■             1. 일반             ■");
		System.out.println("■             2. 동창             ■");		
		System.out.println("■             3. 회사             ■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.print("――――――――――――――――옵션을 선택하세요 : ");
		int select = scanner.nextInt();
		
		switch (select)
		{
			case general :
			{	
				boolean isFind;
				
				System.out.print("이    름 : ");
				scanner.nextLine();	
				name = scanner.nextLine();
				System.out.print("전화번호 : ");
				phoneNumber = scanner.nextLine();
				
				PhoneInfo generalFriend = new PhoneInfo(name, phoneNumber);
				isFind = friends.add(generalFriend); // False
				
				if(isFind == false)
				{
					System.out.println("―――――이미 저장된 데이터입니다.―――――");
					System.out.println("――――――――――덮어 쓸까요? (Y/N 입력) : ");
					String choice = scanner.nextLine();
					
					if (choice.equalsIgnoreCase("Y"))
					{
						friends.remove(generalFriend);
						friends.add(generalFriend);
						System.out.println("―――새로운 데이터를 입력했습니다.―――");
					}
					else
					{
						System.out.println("―――――기존 데이터를 유지합니다.―――――");
					}
				}
				break;
			}
			
			case college :
			{
				boolean isFind;
				
				System.out.print("이    름 : ");
				scanner.nextLine();
				name = scanner.nextLine();
				System.out.print("전화번호 : ");
				phoneNumber = scanner.nextLine();
				System.out.print("전    공 : ");
				subject = scanner.nextLine();
				System.out.print("학    년 : ");
				grade = scanner.nextInt();
				
				PhoneSchoolInfo collegeFriend 
					= new PhoneSchoolInfo(name, phoneNumber, subject, grade);
				isFind = friends.add(collegeFriend); // False
				
				if(isFind == false)
				{
					System.out.println("―――――이미 저장된 데이터입니다.―――――");
					System.out.println("――――――――――덮어 쓸까요? (Y/N 입력) : ");
					String choice = scanner.nextLine();
					
					if (choice.equalsIgnoreCase("Y"))
					{
						friends.remove(collegeFriend);
						friends.add(collegeFriend);
						System.out.println("―――새로운 데이터를 입력했습니다.―――");
					}
					else
					{
						System.out.println("―――――기존 데이터를 유지합니다.―――――");
					}
				}
				break;
			}
			case colleague :
			{
				boolean isFind;
				
				System.out.print("이    름 : ");
				scanner.nextLine();
				name = scanner.nextLine();
				System.out.print("전화번호 : ");
				phoneNumber = scanner.nextLine();
				System.out.print("회 사 명 : ");
				companyName = scanner.nextLine();
				PhoneCompanyInfo companyFriend
					= new PhoneCompanyInfo(name, phoneNumber, companyName);
				isFind = friends.add(companyFriend); // False
				
				if(isFind == false)
				{
					System.out.println("―――――이미 저장된 데이터입니다.―――――");
					System.out.println("――――――――――덮어 쓸까요? (Y/N 입력) : ");
					String choice = scanner.nextLine();
					
					if (choice.equalsIgnoreCase("Y"))
					{
						friends.remove(companyFriend);
						friends.add(companyFriend);
						System.out.println("―――새로운 데이터를 입력했습니다.―――");
					}
					else
					{
						System.out.println("―――――기존 데이터를 유지합니다.―――――");
					}
				}
				break;
			}
		}
	}
	
	public void dataSearch()
	{
		boolean isFind = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("――――――――검색할 이름을 입력하세요. : ");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> iterator = friends.iterator();
		
		while (iterator.hasNext())
		{
			PhoneInfo friend = iterator.next();
			if (searchName.equals(friend.name))
			{
				System.out.println("――――요청하는 정보를 찾았습니다.――――");
				friend.showData();
				isFind = true;
			}
		}
		if (isFind == false)
		{
			System.out.println("―――――――찾는 정보가 없습니다.―――――――");
		}
	}
	
	public void dataDelete()
	{
		boolean isFind = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("――――――――삭제할 이름을 입력하세요. : ");
		String deleteName = scanner.nextLine();
		
		Iterator<PhoneInfo> iterator = friends.iterator();
		
		while (iterator.hasNext())
		{
			PhoneInfo friend = iterator.next();
			if (deleteName.equals(friend.name))
			{
				friends.remove(friend);
				System.out.println("―――지정 데이터가 삭제되었습니다.―――");
				
				isFind = true;
			}
		}
		if (isFind == false)
		{
			System.out.println("―――――― 찾는 정보가 없습니다. ――――――");
		}
	}
	
	public void showAllData()
	{
		for (PhoneInfo friend : friends)
		{
			friend.showData();
		}
		System.out.println("――― 전체 정보가 출력되었습니다. ―――");
	}
	
	public void dataSave(AutoSaver autoSave)
	{
		System.out.println("■■■■■■■■■■■■ 저장 옵션 ■■■■■■■■■■■■");
		System.out.println("■         1.자동 저장 On          ■");
		System.out.println("■         2.자동 저장 Off         ■");	
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.print("――――――――――――――――옵션을 선택하세요 : ");
		
		
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		
		if (select == autoOn)
		{		
			if(autoSave.isAlive())
			{
				autoSave.setDaemon(true);
				autoSave.start();
				System.out.println("――――――자동 저장을 시작합니다.――――――");
				
			}
			else
			{
				System.out.println("―――――――자동 저장 상태입니다.―――――――");
			}
		}
		else if (select == autoOff)
		{
				autoSave.interrupt();
				System.out.println("――――――자동 저장을 종료합니다.――――――");
		}
		else
		{
			System.out.println("―옵션(숫자)을 잘못 입력하였습니다.―");
		}
	}
	
	public void saveObj()
	{
		try
		{	
			ObjectOutputStream outData = new ObjectOutputStream
					(new FileOutputStream("src/project1/ver08/PhoneBook.ojb"));
			
			for (PhoneInfo phoneInfo : friends)
			{
				outData.writeObject(phoneInfo);
			}
		}
		catch (FileNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
		catch (Exception e)
		{
		}
	}
	public void readObj()
	{
		try
		{
			ObjectInputStream inData = new ObjectInputStream
					(new FileInputStream("src/project1/ver08/PhoneBook.ojb"));
			
			while (true)
			{
				PhoneInfo phoneInfo = (PhoneInfo)inData.readObject();
				friends.add(phoneInfo);
				if (phoneInfo == null)
				{
					break;
				}
			}
			System.out.println("―――데이터 정보가 복원되었습니다.―――");
		}
		catch (FileNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
		catch (Exception e)
		{
		}
	}
	public void phoneInfoText()
	{
		try
		{
			PrintWriter outText = new PrintWriter
					(new FileWriter("src/project1/ver08/PhoneBook.txt"));
			
			for (PhoneInfo phoneInfo : friends)
			{
				if (phoneInfo instanceof PhoneCompanyInfo)
				{
					outText.println("이    름 : "+ phoneInfo.getName());
					outText.println("전화번호 : "+ phoneInfo.getPhoneNumber());
					outText.println("전    공 : "+ ((PhoneCompanyInfo)phoneInfo).getCompanyName());
				}
				else if (phoneInfo instanceof PhoneSchoolInfo)
				{
					outText.println("이    름 : "+ phoneInfo.getName());
					outText.println("전화번호 : "+ phoneInfo.getPhoneNumber());
					outText.println("전    공 : "+ ((PhoneSchoolInfo)phoneInfo).getSubject());
					outText.println("학    년 : "+ ((PhoneSchoolInfo)phoneInfo).getGrade());
				}
				else if (phoneInfo instanceof PhoneInfo)
				{
				outText.println("이    름 : "+ phoneInfo.getName());
				outText.println("전화번호 : "+ phoneInfo.getPhoneNumber());
				}
			}
			outText.close();
		}
		catch (IOException e)
		{
		}
		catch (Exception e)
		{
		}
	}
}