package QuanLyTacGia;

public class TacGia {
	private int Id;
	private String NameAuthor;
	private String Birthday;
	private  String Email; 
	private String Phone;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNameAuthor() {
		return NameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		NameAuthor = nameAuthor;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public TacGia(int id, String nameAuthor, String birthday, String email, String phone) {
		
		Id = id;
		NameAuthor = nameAuthor;
		Birthday = birthday;
		Email = email;
		Phone = phone;
	}
	public TacGia(String nameAuthor, String birthday, String email, String phone) {
		
		NameAuthor = nameAuthor;
		Birthday = birthday;
		Email = email;
		Phone = phone;
	}
	public TacGia(int id, String nameAuthor) {
		
		Id = id;
		NameAuthor = nameAuthor;
	}
	
	
	
	
	

}
