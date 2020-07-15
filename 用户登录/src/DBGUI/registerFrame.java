package DBGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DBUtil.DBUtil;
import DBdao.RegisterDao;
import DBmodel.User;

public class registerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField register_userName;
	private JPasswordField register_password;
	private JTextField mailTxt;
	private DBUtil DbUtil=new DBUtil();
	private LoginFrame loginframe=new LoginFrame();
	
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
					registerFrame frame = new registerFrame();
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
	public registerFrame() {
		setResizable(false);
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6CE8\u518C");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(164, 20, 150, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(100, 82, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		register_userName = new JTextField();
		register_userName.setBounds(164, 79, 133, 26);
		contentPane.add(register_userName);
		register_userName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_2.setBounds(100, 118, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton registerButton = 
				new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		registerButton.setBounds(100, 184, 65, 23);
		contentPane.add(registerButton);
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register_userName.setText("");
				register_password.setText("");
				mailTxt.setText("");
			}
		});
		resetButton.setBounds(175, 184, 65, 23);		
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
		contentPane.add(resetButton);
		
		register_password = new JPasswordField();
		register_password.setBounds(164, 115, 133, 21);
		contentPane.add(register_password);
		
		JLabel lblNewLabel_3 = new JLabel("\u90AE  \u7BB1\uFF1A");
		lblNewLabel_3.setBounds(101, 153, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		mailTxt = new JTextField();
		mailTxt.setBounds(164, 150, 133, 24);
		contentPane.add(mailTxt);
		mailTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				loginframe.setVisible(true);
			}
		});
		btnNewButton.setBounds(250, 184, 64, 23);
		contentPane.add(btnNewButton);
	}
	/**
	 * 注册事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String register_userName=this.register_userName.getText();
		String register_password=new String (this.register_password.getPassword());
		String register_mail=this.mailTxt.getText();
		
		if (register_userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(register_password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		else if(register_mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "邮箱不能为空");
			return;
		}
		//判断输入是否为空
		Connection con=null;
		User user=new User(register_userName,register_password,register_mail);
		try{
			con=DbUtil.getCon();
			int addNum=RegisterDao.add(con, user);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "注册成功！");
				dispose();
				loginframe.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "注册失败！");
			}
		
		}catch(Exception e2){
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败2！");
		}finally{
			try {
				DbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
}
