package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * �������ݿ�
 * 
 *
 */
public class DBUtil {
	private String DBDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//��������
	private String DBURL="jdbc:sqlserver://127.0.0.1:1433";//���ݿ����ӵ�ַ
	private String DBUser="sa";//�û���
	private String DBPass="123456";//����
	//�������ݿ�
	public Connection getCon() throws Exception{
		Class.forName(DBDriver);
		Connection con=DriverManager.getConnection(DBURL,DBUser,DBPass);
		return con;
	}
	//�ر����ݿ�
	public void closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DBUtil a=new DBUtil();
		try {
			a.getCon();
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
