package project1.ver06;

public class PhoneCompanyInfo extends PhoneInfo
{
	String companyName;

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName)
	{
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showData()
	{
		System.out.println("---- 회사 직원들 정보 ----");
		super.showData();
		System.out.println("회 사 명 : " + companyName);
	}
}
