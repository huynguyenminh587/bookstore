package DangKiDangNhap;

public class AccountDetail {
	private int id;
	private  int accountId;
	private String fullName;
	private String gender;
	private String birthday;
	private String address;
	private String email;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public AccountDetail(int id, int accountId, String fullName, String gender, String birthday, String address,
			String email, String phone) {
	
		this.id = id;
		this.accountId = accountId;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	
	public AccountDetail(int accountId, String fullName, String gender, String birthday, String address, String email,
			String phone) {
		
		this.accountId = accountId;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	
	public AccountDetail(String fullName, String gender, String birthday, String address, String email, String phone) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	
	
	

}
