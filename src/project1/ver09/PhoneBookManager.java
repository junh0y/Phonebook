package project1.ver09;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.ver09.PhoneInfo;

public class PhoneBookManager
{
	Connection connection;
	PreparedStatement preState;
	Statement state;
	ResultSet resultSet;
	
	PhoneInfo[] friends;
	int index;
	String name, phoneNumber, birthday;
	
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager(int num)
	{
		friends = new PhoneInfo[num];
		index = 0;
	}
	
	public void dataConnect()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "kosmo", "1234");
			
			if (connection != null)
			{
				
			}
			else
			{
				System.out.println("실패");
			}
		}
		catch (Exception e)
		{
			
		}
	}

	public void printMenu()
	{
		System.out.println("■■■■■■■■■■■■■■ 옵 션 ■■■■■■■■■■■■■■");
		System.out.println("■         1.  데이터 입력         ■");
		System.out.println("■         2.  데이터 검색         ■");		
		System.out.println("■         3.  데이터 삭제         ■");				
		System.out.println("■         4.  데이터 출력         ■");
		System.out.println("■         5.  종       료         ■");
	}
	
	public void dataInput()
	{	
		try
		{
			dataConnect();
			
			String sql = "INSERT INTO phonebook_tb"
					+ " (idx, name, phonenumber, birthday)"
					+ "  VALUES (seq_phonebook.nextval, ?, ?, ?)";
			
			System.out.print("이    름 : ");
			name = scanner.nextLine();
			System.out.print("전화번호 : ");
			phoneNumber = scanner.nextLine();
			System.out.print("생년월일 : ");
			birthday = scanner.nextLine();
			
			preState = connection.prepareStatement(sql);
			
			preState.setString(1, name);
			preState.setString(2, phoneNumber);
			preState.setString(3, birthday);
			
			friends[index++] = new PhoneInfo(name, phoneNumber, birthday);
			
			preState.executeUpdate();
		}
		catch (SQLException e)
		{
			
		}
		finally
		{
			close();
		}
	}
	
	public void dataSearch()
	{
		try
		{	
			dataConnect();
			
			state = connection.createStatement();
				
			System.out.print("――――――――검색할 이름을 입력하세요. : ");
			String searchName = scanner.nextLine();
			
			String sql = "SELECT idx, "
					+ " name, "
					+ " phonenumber, "
					+ " to_char(birthday, 'yyyy/mm/dd') "
					+ " FROM phonebook_tb"
					+ " WHERE name LIKE '%" + searchName + "%'";
			
			resultSet = state.executeQuery(sql);
			
			while (resultSet.next())
			{
				int idx = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phonenumber = resultSet.getString(3);
				String birthday = resultSet.getString(4);
				
				System.out.println("이    름 : "+ name);
				System.out.println("전화번호 : "+ phonenumber);
				System.out.println("생년월일 : "+ birthday);
			}
		}
		catch (SQLException e)
		{
			System.out.println("쿼리 오류");
		}
		finally
		{
			close();
		}
	}
	
	public void dataDelete()
	{
		try
		{
			dataConnect();
			
			String sql = "DELETE FROM phonebook_tb WHERE name=?";
			
			System.out.print("――――――――삭제할 이름을 입력하세요. : ");
			String deleteName = scanner.nextLine();
			
			int deleteIndex = -1;
			
			preState = connection.prepareStatement(sql);
			preState.setString(1, deleteName);
			
			preState.executeUpdate();
			
			for (int i = 0 ; i < index ; i++)
			{
				if (deleteName.equalsIgnoreCase(friends[i].name))
				{
					friends[i] = null;
					deleteIndex = i;
					index--;
					break;
				}
			}
			
			if (deleteIndex != -1)
			{
				for (int i = deleteIndex ; i < index ; i++)
				{
					friends[i] = friends [i+1];
				}
				System.out.println(deleteName +" 데이터가 삭제되었습니다.");
			}
			else
			{
				System.out.println("일치하는 데이터가 없습니다.");
			}
		}
		catch (Exception e)
		{
			
		}	
	}
	
	public void dataAllShow()
	{
		dataConnect();
		
		try
		{
			String sql = "SELECT "
					+ " name, "
					+ " phonenumber, "
					+ " TO_CHAR(birthday, 'yyyy/mm/dd') "
					+ " FROM phonebook_tb";
			
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			
			while (resultSet.next())
			{
				System.out.println("이    름 : "+ resultSet.getString(1));
				System.out.println("전화번호 : "+ resultSet.getString(2));
				System.out.println("생년월일 : "+ resultSet.getString(3));
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	public void close()
	{	
		try
		{
			if(resultSet != null) resultSet.close();
			if(connection != null) connection.close();
			if(state != null) state.close();
			if(preState != null) preState.close();
		}
		catch(Exception e)
		{
			
		}		
	}
}