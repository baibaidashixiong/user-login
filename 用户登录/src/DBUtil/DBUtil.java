package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 连接数据库
 * 
 *
 */
public class DBUtil {
	private String DBDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动名称
	private String DBURL="jdbc:sqlserver://127.0.0.1:1433";//数据库链接地址
	private String DBUser="sa";//用户名
	private String DBPass="123456";//密码
	//连接数据库
	public Connection getCon() throws Exception{
		Class.forName(DBDriver);
		Connection con=DriverManager.getConnection(DBURL,DBUser,DBPass);
		return con;
	}
	//关闭数据库
	public void closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DBUtil a=new DBUtil();
		try {
			a.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
