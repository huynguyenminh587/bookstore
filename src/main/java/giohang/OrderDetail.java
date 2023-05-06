package giohang;

public class OrderDetail {
	private int id;
	private int orderId;
	private String bookName;
	private int Quantity;
	private int price;
	
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderDetail(int id, int orderId, String bookName, int quantity, int price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.bookName = bookName;
		Quantity = quantity;
		this.price = price;
	}


	public OrderDetail(int orderId, String bookName, int quantity, int price) {
		super();
		this.orderId = orderId;
		this.bookName = bookName;
		Quantity = quantity;
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
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", bookName=" + bookName + ", Quantity=" + Quantity
				+ ", price=" + price + "]";
	}
	
	

}
