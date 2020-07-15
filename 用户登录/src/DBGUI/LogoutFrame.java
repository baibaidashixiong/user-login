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

public class LogoutFrame extends JFrame {
	public String verfication2;
	
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JTextField mailTxt;
	private JTextField VerificationTxt;

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
					LogoutFrame frame = new LogoutFrame();
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
	public LogoutFrame() {
		setTitle("\u7528\u6237\u6CE8\u9500");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6CE8\u9500");
		lblNewLabel.setIcon(new ImageIcon(LogoutFrame.class.getResource("/images/\u6CE8\u9500.PNG")));
		lblNewLabel.setBounds(144, 10, 162, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(75, 86, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(144, 83, 162, 25);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u90AE  \u7BB1\uFF1A");
		lblNewLabel_2.setBounds(75, 129, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		mailTxt = new JTextField();
		mailTxt.setBounds(144, 128, 162, 25);
		contentPane.add(mailTxt);
		mailTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		lblNewLabel_3.setBounds(75, 174, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		VerificationTxt = new JTextField();
		VerificationTxt.setBounds(144, 170, 162, 25);
		contentPane.add(VerificationTxt);
		VerificationTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verficationPerformed(e);
			}
		});
		btnNewButton.setBounds(317, 170, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u9500");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutPerformed(e);
			}
		});
		btnNewButton_1.setBounds(94, 215, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u53D6\u6D88");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame a=new LoginFrame();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(231, 215, 93, 23);
		contentPane.add(btnNewButton_2);
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
	}
	/**
	 * 用户注销验证码
	 * @param e
	 */
	protected void verficationPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*10000)%70;
		int b=(int)(Math.random()*10000)%50;
		int c=a+b;
		String c1=String.valueOf(c);
		verfication2=c1;
		JOptionPane.showMessageDialog(null, String.valueOf(a)+"+"+String.valueOf(b));
		
	}

	/***
	 * 用户注销事件
	 * @param e
	 */
	private void LogoutPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String logout_userName=this.userNameTxt.getText();
		String logout_mail=this.mailTxt.getText();
		
		if(logout_userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		else if(logout_mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "邮箱不能为空！");
			return;
		}
		else  if(!VerificationTxt.getText().equals(verfication2)) {			
			JOptionPane.showMessageDialog(null, "验证码输入有误！");
			return;
		}
		//判断输入是否为空
		
		Connection con=null;
		User_reset administrator=new User_reset(logout_userName,logout_mail) ;
		try{
			con=DbUtil.getCon();
			User currentUser=resetpassworddao.resetpassword(con, administrator);
			if(currentUser!=null){
				
				
				int exit=JOptionPane.showConfirmDialog(null, "是否注销？");
				if (exit == 0) {
					Statement stmt=null;
					String sql="use Login_system delete from user_login where userName='"+logout_userName+"'";
					stmt = con.createStatement();
					stmt.executeUpdate(sql);
					dispose();
					JOptionPane.showMessageDialog(null, "注销成功！");
					loginframe.setVisible(true);
				}
				
				//dispose();
				
			}else {
				JOptionPane.showMessageDialog(null, "用户名或邮箱错误！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "注销失败！");
		}finally{
			try {
				DbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
