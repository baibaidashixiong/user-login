package DBGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBUtil.DBUtil;

public class administratorFrame extends JFrame {

	private JPanel contentPane;
	private DBUtil DbUtil=new DBUtil();
	
	
	
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
				/***
				 * 美化文本
				 */
				try {
					administratorFrame frame = new administratorFrame();
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
	public administratorFrame() {
		setTitle("\u6B22\u8FCE\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u7528\u6237\u6CE8\u518C\u6570");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registercountPerformed(e);				
			}
			
		});
		btnNewButton.setBounds(132, 53, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u7528\u6237\u6CE8\u9500\u6570");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutcountPerformed(e);
			}
		});
		btnNewButton_1.setBounds(132, 105, 132, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame a=new LoginFrame();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(150, 157, 93, 23);
		contentPane.add(btnNewButton_2);
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
	}
	/**
	 * 管理员查看用户总注销数
	 * @param e
	 */
	protected void logoutcountPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con=DbUtil.getCon();
			Statement stmt=null;
			String sql="use Login_system select sumlogout from administrator_login where id='1'";
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {				
				JOptionPane.showMessageDialog(null, "总用户注销数为:"+rs.getString("sumlogout"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 管理员查看用户注册数
	 * @param e
	 */
	private void registercountPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			con=DbUtil.getCon();
			Statement stmt=null;
			String sql="use Login_system select sumregister from administrator_login where id='1'";
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {				
				JOptionPane.showMessageDialog(null, "总用户注册数为:"+rs.getString("sumregister"));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
