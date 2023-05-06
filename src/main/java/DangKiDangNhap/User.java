package DangKiDangNhap;

public class User {
	private String UserName;
	private String PassWord;
	public User(String userName, String passWord) {
		
		UserName = userName;
		PassWord = passWord;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", PassWord=" + PassWord + "]";
	}
	
	

}
