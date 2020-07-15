package DBdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DBmodel.User;
/**
 * 用户注册类别
 *
 */
public class RegisterDao {
	
	public static int add(Connection con,User user)throws Exception{
		String sql="use Login_system insert into user_login(userName,password,mail) values(?,?,?) ";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3,user.getMail());
		
		return pstmt.executeUpdate();
	}
}
