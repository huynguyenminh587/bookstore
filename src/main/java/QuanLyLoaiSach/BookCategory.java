package QuanLyLoaiSach;

public class BookCategory {
	private int Id;
	private String Name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public BookCategory(int id, String name) {
		
		Id = id;
		Name = name;
	}
	public BookCategory(String name) {
		
		Name = name;
	}
	
	

}
