package project1.ver08;

public class PhoneCompanyInfo extends PhoneInfo
{
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName)
	{
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}

	@Override
	public void showData()
	{
		super.showData();
		System.out.println("회 사 명 : " + companyName);
	}
}
