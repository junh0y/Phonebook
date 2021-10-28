package project1.ver08;

import java.io.Serializable;

public class PhoneInfo implements Serializable
{
	String name;
	String phoneNumber;
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName()
	{
		return name;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void showData()
	{
		System.out.println("■■■■ PHONE INFO ■■■■");
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
	
	@Override
    public int hashCode()
    {
    	int nameHcode = this.name.hashCode();
    	return nameHcode;
    }
	
    @Override
    public boolean equals(Object obj)
    {
    	PhoneInfo phoneInfo = (PhoneInfo)obj;
    	if (this.name.equals(phoneInfo.name))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}