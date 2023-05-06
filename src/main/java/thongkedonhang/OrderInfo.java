package thongkedonhang;

public class OrderInfo {
	private int id;
	private int accountId;
	private String userName;
	private int quantity;
	private int totalPrice;
	private String orderDate;
	
	
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderInfo(int id, int accountId, String userName, int quantity, int totalPrice, String orderDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.userName = userName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}


	public OrderInfo(int accountId, String userName, int quantity, int totalPrice, String orderDate) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	
	


	public OrderInfo(int id, int accountId, int quantity, int totalPrice, String orderDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}


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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", accountId=" + accountId + ", userName=" + userName + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + "]";
	}
	
	

}
