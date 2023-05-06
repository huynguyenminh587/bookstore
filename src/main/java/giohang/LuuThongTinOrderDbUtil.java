package giohang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class LuuThongTinOrderDbUtil {
	private DataSource dataSource;

	public LuuThongTinOrderDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addOrderInfo(OrderInfo orderInfo) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();
			String mySql = "insert orderinfo (accountid,quantity,totalprice,OrderDate) values " + "(?,?,?,?)";
			myStmt = myConn.prepareStatement(mySql);

			myStmt.setInt(1, orderInfo.getAccountId());
			myStmt.setInt(2, orderInfo.getQuantity());
			myStmt.setInt(3, orderInfo.getTotalPrice());
			myStmt.setString(4, orderInfo.getOderDate());
			myStmt.execute();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	public OrderInfo getOrderInfo(OrderInfo orderInfo) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		OrderInfo info = new OrderInfo();
		try {
			myConn = dataSource.getConnection();
			String sql = "select*from orderinfo where accountid=? and OrderDate=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, orderInfo.getAccountId());
			myStmt.setString(2, orderInfo.getOderDate());
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id = myRs.getInt("id");
				int accountId = myRs.getInt("accountId");
				int quantity = myRs.getInt("quantity");
				int totalPrice = myRs.getInt("totalPrice");
				String OrderDate = myRs.getString("OrderDate");
				info = new OrderInfo(id, accountId, quantity, totalPrice, OrderDate);
			}
		} finally {
			close(myConn, myStmt, myRs);
		}
		return info;
	}

	public void addOrderDetail(List<item> cart, int orderId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();
			String mySql = "insert orderdetail (orderid,bookname,Quantity,price) values " + "(?,?,?,?)";
			myStmt = myConn.prepareStatement(mySql);

			for (item item : cart) {
				
				
				myStmt.setInt(1, orderId);
				myStmt.setString(2, item.getName());
				myStmt.setInt(3, item.getQuantity());
				myStmt.setInt(4, item.getPrice());
				myStmt.execute();
			}
		}

		finally {
			close(myConn, myStmt, null);
		}
	}

	public List<OrderDetail> getOrderDetail(int orderId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<OrderDetail> detail = new ArrayList<OrderDetail>() ;

		try {
			myConn = dataSource.getConnection();
			String sql = "select*from orderdetail where orderId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, orderId);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id = myRs.getInt("id");
				
				String bookName = myRs.getString("bookName");
				int quantity  = myRs.getInt("quantity");
				int price = myRs.getInt("price");
				OrderDetail orderDetail=new OrderDetail(id, orderId, bookName, quantity, price);
				detail.add(orderDetail);
			}
		} finally {
			close(myConn, myStmt, myRs);
		}

		return detail;

	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}
		if (myStmt != null) {
			myStmt.close();
		}
		if (myConn != null) {
			myConn.close();
		}

	}

}
