package DBmodel;



/**
 * �û�ʵ��
 * 
 *
 */
public class User {
	private int id;//���
	private String userName;//�û���
	private String password;//�û�����
	private String mail;//�û�����
	public User() {
		super();
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User(String userName,String password) {
		super();
		this.userName=userName;
		this.password=password;
	}
	public User(String userName,String password,String mail) {
		super();
		this.userName=userName;
		this.password=password;
		this.mail=mail;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}