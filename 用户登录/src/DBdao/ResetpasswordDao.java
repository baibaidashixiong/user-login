package DBdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBmodel.User;
import DBmodel.User_reset;

/**
 * 用户密码修改
 *
 */
public class ResetpasswordDao {
	/**
	 * 密码修改
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User resetpassword(Connection con,User_reset administrator)throws Exception{
		User resultUser=null;
		String sql="use Login_system select * from user_login where userName=? and mail=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administrator.getUserName());
		pstmt.setString(2, administrator.getMail());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setMail(rs.getString("mail"));
		}
		
		return resultUser;
	}
}
