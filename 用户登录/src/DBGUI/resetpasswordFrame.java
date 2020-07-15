package DBGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DBUtil.DBUtil;
import DBdao.ResetpasswordDao;
import DBmodel.User;
import DBmodel.User_reset;

public class resetpasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField mailTxt;
	private JTextField newPasswordTxt;
	private JTextField confirmPasswordTxt;
	
	private DBUtil DbUtil=new DBUtil();
	private LoginFrame loginframe=new LoginFrame();
	private ResetpasswordDao resetpassworddao=new ResetpasswordDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        }catch(Exception e) {
		        	System.out.println(e);
		        }
				/**
				 * 美化窗口
				 * 
				 */
				try {
					resetpasswordFrame frame = new resetpasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public resetpasswordFrame() {
		setResizable(false);
		setTitle("\u5FD8\u8BB0\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u91CD\u8BBE\u5BC6\u7801");
		lblNewLabel.setIcon(new ImageIcon(resetpasswordFrame.class.getResource("/images/\u5BC6\u7801.PNG")));
		lblNewLabel.setBounds(139, 10, 126, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(76, 91, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(139, 88, 126, 25);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE  \u7BB1\uFF1A");
		lblNewLabel_2.setBounds(76, 126, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		mailTxt = new JTextField();
		mailTxt.setBounds(139, 123, 126, 25);
		contentPane.add(mailTxt);
		mailTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setBounds(76, 159, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		newPasswordTxt = new JTextField();
		newPasswordTxt.setBounds(139, 156, 126, 25);
		contentPane.add(newPasswordTxt);
		newPasswordTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setBounds(76, 192, 60, 15);
		contentPane.add(lblNewLabel_4);
		
		confirmPasswordTxt = new JTextField();
		confirmPasswordTxt.setBounds(139, 190, 127, 25);
		contentPane.add(confirmPasswordTxt);
		confirmPasswordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButtonPerformed(e);
			}
		});
		btnNewButton.setBounds(64, 232, 70, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				mailTxt.setText("");
				newPasswordTxt.setText("");
				confirmPasswordTxt.setText("");
			}
		});
		btnNewButton_1.setBounds(147, 232, 70, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u767B\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame a=new LoginFrame();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(232, 232, 70, 23);
		contentPane.add(btnNewButton_2);
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
	}
	
	private void confirmButtonPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String resetpassword_userName=this.userNameTxt.getText();
		String resetpassword_mail=this.mailTxt.getText();
		String resetpassword_newpassword=this.newPasswordTxt.getText();
		String resetpassword_confirmpassword=this.confirmPasswordTxt.getText();
		
		if(resetpassword_userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		else if(resetpassword_mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "邮箱不能为空！");
			return;
		}
		else if(resetpassword_newpassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		else if(resetpassword_confirmpassword.isEmpty()) {
			JOptionPane.showMessageDialog(null, "请再次输入密码！");
			return;
		}
		else if(!resetpassword_newpassword.equals(resetpassword_confirmpassword)) {
			JOptionPane.showMessageDialog(null, "两次输入密码不一致，请重新输入！");
			return;
		}
		//判断输入内容是否为空
		
		Connection con=null;
		User_reset administrator=new User_reset(resetpassword_userName,resetpassword_mail) ;
		try{
			con=DbUtil.getCon();
			User currentUser=resetpassworddao.resetpassword(con, administrator);
			if(currentUser!=null){
				Statement stmt=null;
				String sql="use Login_system update user_login SET password="+resetpassword_newpassword+" where userName= '"+resetpassword_userName+"'";
				stmt = con.createStatement();
				stmt.executeUpdate(sql);
				
				JOptionPane.showMessageDialog(null, "密码修改成功！");
				dispose();
				loginframe.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或邮箱错误！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "密码修改失败");
		}finally{
			try {
				DbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
