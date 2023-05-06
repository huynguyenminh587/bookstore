package QuanLyDanhMuc;

public class Sach {
	private int Id;
	private String Name;
	private int Price;
	private String Image;
	private int CategoryId;
	private int PublisherId;
	private  int AuthorId ;
	private String PublishYear;
	private int TotalPage;
	private String Language;
	private String Description;
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
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public int getPublisherId() {
		return PublisherId;
	}
	public void setPublisherId(int publishId) {
		PublisherId = publishId;
	}
	public int getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}
	public String getPublishYear() {
		return PublishYear;
	}
	public void setPublishYear(String publishYear) {
		PublishYear = publishYear;
	}
	public int getTotalPage() {
		return TotalPage;
	}
	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Sach(int id, String name, int price, String image, int categoryId, int publisherId, int authorId,
			String publishYear, int totalPage, String language, String description) {
		
		Id = id;
		Name = name;
		Price = price;
		Image = image;
		CategoryId = categoryId;
		PublisherId = publisherId;
		AuthorId = authorId;
		PublishYear = publishYear;
		TotalPage = totalPage;
		Language = language;
		Description = description;
	}
	public Sach(String name, int price, String image, int categoryId, int publisherId, int authorId, String publishYear,
			int totalPage, String language, String description) {
		
		Name = name;
		Price = price;
		Image = image;
		CategoryId = categoryId;
		PublisherId = publisherId;
		AuthorId = authorId;
		PublishYear = publishYear;
		TotalPage = totalPage;
		Language = language;
		Description = description;
	}
	
	
	
	

}
