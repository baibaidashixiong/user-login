package DBmodel;

public class User_reset {

		private int id;//���
		private String userName;//�û���
		private String password;//�û�����
		private String mail;//�û�����
		public User_reset() {
			super();
		}
		
		public User_reset(String userName,String mail) {
			super();
			this.userName=userName;
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
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
		
}
