package project1.ver09;

public interface PhoneBookConnect
{
	String ORACLE_DRIVER ="oracle.jdbc.OracleDriver";
	String ORACLE_URL ="jdbc:oracle:thin:@localhost:1521:xe";
	
	void connect(String user, String password);
	void dataInput();
	void dataSearch();
	void dataDelete();
	void close();
	
	String scanValue(String title);
}