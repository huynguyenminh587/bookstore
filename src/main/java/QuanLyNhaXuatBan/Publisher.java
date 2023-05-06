package QuanLyNhaXuatBan;

public class Publisher {
	private int Id;
	private String NamePublisher;
	private String Address;
	private String Email;
	private String Phone;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNamePublisher() {
		return NamePublisher;
	}
	public void setNamePublisher(String namePublisher) {
		NamePublisher = namePublisher;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
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
	public Publisher(int id, String namePublisher, String address, String email, String phone) {
		
		Id = id;
		NamePublisher = namePublisher;
		Address = address;
		Email = email;
		Phone = phone;
	}
	public Publisher(String namePublisher, String address, String email, String phone) {
		
		NamePublisher = namePublisher;
		Address = address;
		Email = email;
		Phone = phone;
	}
	public Publisher(int id, String namePublisher) {
		
		Id = id;
		NamePublisher = namePublisher;
	}
	
	
	
	
	
	
	

}
