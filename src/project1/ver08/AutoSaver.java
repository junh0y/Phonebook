package project1.ver08;

import java.io.IOException;

public class AutoSaver extends Thread
{
	PhoneBookManager phonebook;
	
	public AutoSaver (PhoneBookManager phonebook)
	{
		this.phonebook = phonebook;
	}
	
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				phonebook.saveObj();
				sleep(5000);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}