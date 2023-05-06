package giohang;

public class OrderInfo {
	private int id;
	private int accountId;
	private int quantity;
	private int totalPrice;
	private String oderDate;
	public OrderInfo(int id, int accountId, int quantity, int totalPrice, String oderDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.oderDate = oderDate;
	}
	public OrderInfo(int accountId, int quantity, int totalPrice, String oderDate) {
		super();
		this.accountId = accountId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.oderDate = oderDate;
	}
	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getOderDate() {
		return oderDate;
	}
	public void setOderDate(String oderDate) {
		this.oderDate = oderDate;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", accountId=" + accountId + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", oderDate=" + oderDate + "]";
	}
	
	

}
