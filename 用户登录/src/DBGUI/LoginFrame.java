package DBGUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import DBUtil.DBUtil;
import DBdao.UserDao;
import DBmodel.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
	private String verfication2;
	
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JTextField verificationTxt;

	private DBUtil dbUtil=new DBUtil();
	private UserDao userDao=new UserDao();
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
			LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		
		setTitle("\u7528\u6237\u767B\u5F55\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u666E\u901A\u7528\u6237\u767B\u5F55");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7BA1\u7406\u5458\u767B\u5F55");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				administratorLoginFrame frame=new administratorLoginFrame();
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u6CE8\u9500");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LogoutFrame a=new LogoutFrame();
				a.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu exitMenu = new JMenu("\u5B89\u5168\u9000\u51FA");
		exitMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int exit=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if (exit == 0) {
					dispose();
				}
			}
		});
		
		
		menuBar.add(exitMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u767B\u5F55");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7528\u6237.PNG")));
		
		passwordTxt = new JPasswordField();
		
		verificationTxt = new JTextField();
		verificationTxt.setColumns(10);
		
		JButton verificationButton = new JButton("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		verificationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verficationPerformed(e);
			}
		});
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginActionPerformed(e);
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registerFrame().setVisible(true);
			}
		});
		
		JButton passwordButton = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		passwordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				resetpasswordFrame a=new resetpasswordFrame();
				a.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(userNameTxt, Alignment.LEADING)
										.addComponent(passwordTxt, Alignment.LEADING)
										.addComponent(verificationTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(verificationButton))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(loginButton)
							.addGap(39)
							.addComponent(registerButton)
							.addGap(28)
							.addComponent(passwordButton)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(verificationTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(verificationButton))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(registerButton)
						.addComponent(passwordButton))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		setLocationRelativeTo(null);//设置初始位置为屏幕中央
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 校验码实现
	 * @param e
	 */
	public  void verficationPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*10000)%70;
		int b=(int)(Math.random()*10000)%50;
		int c=a+b;
		String c1=String.valueOf(c);
		verfication2=c1;
		JOptionPane.showMessageDialog(null, String.valueOf(a)+"+"+String.valueOf(b));
		
		
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(MouseEvent e) {
		// TODO Auto-generated method stub
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(userName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}		
		else if(!verificationTxt.getText().equals(verfication2)) {			
			JOptionPane.showMessageDialog(null, "验证码输入有误！");
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser!=null) {
				JOptionPane.showMessageDialog(null, "登录成功！");
				
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block			
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

