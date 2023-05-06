package QuanLyDanhMuc;

public class Sach1 {
	private int Id;
	private String Name;
	private int Price;
	private String Image;
	private String BookCategory;
	private String  NamePublisher;
	private  String NameAuthor ;
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
	public String getBookCategory() {
		return BookCategory;
	}
	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}
	public String getNamePublisher() {
		return NamePublisher;
	}
	public void setNamePublisher(String namePublisher) {
		NamePublisher = namePublisher;
	}
	public String getNameAuthor() {
		return NameAuthor;
	}
	public void setNameAuthor(String nameAuthor) {
		NameAuthor = nameAuthor;
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
	public Sach1(int id, String name, int price, String image, String bookCategory, String namePublisher,
			String nameAuthor, String publishYear, int totalPage, String language, String description) {
		
		Id = id;
		Name = name;
		Price = price;
		Image = image;
		BookCategory = bookCategory;
		NamePublisher = namePublisher;
		NameAuthor = nameAuthor;
		PublishYear = publishYear;
		TotalPage = totalPage;
		Language = language;
		Description = description;
	}
	public Sach1(String name, int price, String image, String bookCategory, String namePublisher, String nameAuthor,
			String publishYear, int totalPage, String language, String description) {
		
		Name = name;
		Price = price;
		Image = image;
		BookCategory = bookCategory;
		NamePublisher = namePublisher;
		NameAuthor = nameAuthor;
		PublishYear = publishYear;
		TotalPage = totalPage;
		Language = language;
		Description = description;
	}
	
	
	
	

}
