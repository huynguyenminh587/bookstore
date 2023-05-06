package trangchuvadanhmucsach;

public class Sach {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private int price;
	String image;
	public Sach(String name, int price, String image) {
		
		this.name = name;
		this.price = price;
		this.image = image;
	}
	public Sach(int id, String name, int price, String image) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Sach [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
	
	
	

	
	

}
