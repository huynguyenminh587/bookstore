package DangKiDangNhap;

public class Account {
	private int id;
	private String userName;
	private String passWord;
	private int isAdmin;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Account(int id, String userName, String passWord, int isAdmin) {
		
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.isAdmin = isAdmin;
	}
	public Account(String userName, String passWord, int isAdmin) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.isAdmin = isAdmin;
	}
	public Account(String userName, String passWord) {
		
		this.userName = userName;
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
	

}
