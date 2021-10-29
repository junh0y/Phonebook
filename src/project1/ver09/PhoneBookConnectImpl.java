package project1.ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBookConnectImpl implements PhoneBookConnect
{
	public static Connection connection;
	public static PreparedStatement preState;
	public Statement state;
	public static ResultSet resultSet;
	
	public PhoneBookConnectImpl(String driver, String user, String password)
	{
		try
		{
			Class.forName(driver);
			connect(user, password);
		}
		catch (ClassNotFoundException e)
		{
		}
	}
	
	@Override
	public void connect(String user, String password)
	{
		try
		{
			connection = DriverManager.getConnection(ORACLE_URL, user, password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void dataInput()
	{	
	}

	@Override
	public void dataSearch()
	{	
	}

	@Override
	public void dataDelete()
	{
	}

	@Override
	public void close()
	{
		try
		{
			if (preState != null) preState.close();
			if (state != null) state.close();
			if (connection != null) connection.close();
			if (resultSet != null) resultSet.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String scanValue(String title)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 입력 (exit → 종료) : ");
		String inputStr = scan.nextLine();
		
		if ("EXIT".equalsIgnoreCase(inputStr))
		{
			System.out.println("프로그램을 종료합니다.");
			close();
			System.exit(0); // 프로그램 자체를 즉시 종료시킴.
		}
		return inputStr;
	}	
}