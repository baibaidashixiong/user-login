package DBGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DBUtil.DBUtil;
import DBdao.AdministratorDao;
import DBmodel.User;

public class administratorLoginFrame extends JFrame {
	public String verfication2;
	
	private JPanel contentPane;
	private JTextField administratorTxt;
	private JPasswordField passwordTxt;
	private JTextField VerificationTxt;
	
	private DBUtil dbUtil=new DBUtil();
	private AdministratorDao administratordao=new AdministratorDao();

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
					administratorLoginFrame frame = new administratorLoginFrame();
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
	public administratorLoginFrame() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		lblNewLabel.setIcon(new ImageIcon(administratorLoginFrame.class.getResource("/images/\u7BA1\u7406\u54581.PNG")));
		lblNewLabel.setBounds(137, 20, 162, 75);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7BA1\u7406\u5458\u767B\u5F55");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u666E\u901A\u7528\u6237\u767B\u5F55");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame a=new LoginFrame();
				a.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B89\u5168\u9000\u51FA");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int exit=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if (exit == 0) {
					dispose();
				}
				}
		});
		menuBar.add(mnNewMenu_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u540D\uFF1A");
		lblNewLabel_1.setBounds(77, 105, 67, 15);
		contentPane.add(lblNewLabel_1);
		
		administratorTxt = new JTextField();
		administratorTxt.setBounds(147, 102, 152, 29);
		contentPane.add(administratorTxt);
		administratorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_2.setBounds(77, 149, 62, 15);
		contentPane.add(lblNewLabel_2);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(146, 141, 153, 29);
		contentPane.add(passwordTxt);
		
		JLabel lblNewLabel_3 = new JLabel("\u9A8C \u8BC1 \u7801\uFF1A");
		lblNewLabel_3.setBounds(77, 190, 62, 15);
		contentPane.add(lblNewLabel_3);
		
		VerificationTxt = new JTextField();
		VerificationTxt.setBounds(147, 180, 152, 29);
		contentPane.add(VerificationTxt);
		VerificationTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verficationPerformed(e);
			}
		});
		btnNewButton.setBounds(309, 186, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				administratorloginPerformed(e);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(77, 232, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.setBounds(180, 232, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		btnNewButton_3.setBounds(283, 232, 93, 23);
		contentPane.add(btnNewButton_3);
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
	}
	/**
	 * 验证码事件
	 * @param e
	 */
	private void verficationPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*10000)%70;
		int b=(int)(Math.random()*10000)%50;
		int c=a+b;
		String c1=String.valueOf(c);
		verfication2=c1;
		JOptionPane.showMessageDialog(null, String.valueOf(a)+"+"+String.valueOf(b));
	}

	/**
	 * 管理员登录事件处理
	 * @param e
	 */
	private void administratorloginPerformed(MouseEvent e) {
		// TODO Auto-generated method stub
		String userName=this.administratorTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		else if(!VerificationTxt.getText().equals(verfication2)) {			
			JOptionPane.showMessageDialog(null, "验证码输入有误！");
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=administratordao.login(con, user);
			if(currentUser!=null) {
				JOptionPane.showMessageDialog(null, "登录成功！");
				dispose();
				administratorFrame a=new administratorFrame();
				a.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print("登陆失败！");
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "登录失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
	}
}
