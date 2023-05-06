package thongkedonhang;

public class OrderInfoDetail {
	private int id;
	private int orderId;
	private String bookName;
	private int quantity;
	private int price;
	
	
	public OrderInfoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderInfoDetail(int id, int orderId, String bookName, int quantity, int price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookName = bookName;
		this.quantity = quantity;
		this.price = price;
	}


	public OrderInfoDetail(int orderId, String bookName, int quantity, int price) {
		super();
		this.orderId = orderId;
		this.bookName = bookName;
		this.quantity = quantity;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "OrderInfoDetail [id=" + id + ", orderId=" + orderId + ", bookName=" + bookName + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	

}
