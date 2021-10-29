package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.PhoneBookConnectImpl;

public class PhoneBookManager extends PhoneBookConnectImpl
{
	public PhoneInfo[] friends;
	public int index;
	
	public PhoneBookManager(int num)
	{
		super(ORACLE_DRIVER, "kosmo", "1234");
		friends = new PhoneInfo[num];
	}

	public void printMenu()
	{
		System.out.println("■■■■■■■■■■ 옵션 ■■■■■■■■■■");
		System.out.println("■     1. 데이터 입력     ■");
		System.out.println("■     2. 데이터 검색     ■");		
		System.out.println("■     3. 데이터 삭제     ■");				
		System.out.println("■     4. 종       료     ■");
	}
	
	public void dataInput()
	{
		String sql = "insert into phonebook_tb values"
				+ " (?, ?, ?)";
		try
		{
			preState = connection.prepareStatement(sql);
			
			preState.setString(1, scanValue("이    름 : "));
			preState.setString(2, scanValue("전화번호 : "));
			preState.setString(3, scanValue("생년월일 : "));
			
			int affected = preState.executeUpdate();
			System.out.println(affected +"번째 데이터가 입력되었습니다");
		}
		catch (NullPointerException e)
		{
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}			
	}
	
	@Override
	public void dataSearch()
	{
		try
		{
			state = connection.createStatement();
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("검색할 이름을 입력하세요. : ");
			String searchName = scanner.nextLine();
			System.out.println();
			
			String query = "SELECT name, phonenumber, birthday"
					+ " FROM phonebook_tb where 1=1";
			
			if (searchName != null)
			{
				query += " AND name LIKE '%"+ searchName +"%'";
			}
			
			resultSet = state.executeQuery(query);
			
			while (resultSet.next())
			{
				String name = resultSet.getString("name");
				String phonenumber = resultSet.getString("phonenumber");
				String birthday = resultSet.getString("birthday");
				
				System.out.println("이    름 : " + name);
				System.out.println("전화번호 : " + phonenumber);
				System.out.println("생년월일 : " + birthday);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void dataDelete()
	{
		try
		{
			String query = "DELETE FROM name WHERE name=?";
			
			preState = connection.prepareStatement(query);	
			preState.setString(1, scanValue("삭제할 이름을 입력하세요 : "));
			
			int affected = preState.executeUpdate();
			System.out.println(affected +"번 데이터가 삭제되었습니다.");		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}	
	}
}