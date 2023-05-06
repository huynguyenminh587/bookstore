package thongkedonhang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import DangKiDangNhap.Account;

public class DonHangDbUtil {
	private DataSource dataSource;

	public DonHangDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<OrderInfo> getOrderInfo() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<OrderInfo> infos = new ArrayList<OrderInfo>();
		try {

			myConn = dataSource.getConnection();
			String sql = "select o.id,o.accountid,t.username,o.quantity,o.totalprice,o.OrderDate from orderinfo o join taikhoan t on o.accountid=t.id";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				int id = myRs.getInt("id");
				int accountId = myRs.getInt("accountid");
				String userName = myRs.getString("username");
				int quantity = myRs.getInt("quantity");
				int totalPrice = myRs.getInt("totalprice");
				String orderDate = myRs.getString("orderdate");
				OrderInfo info = new OrderInfo(id, accountId, userName, quantity, totalPrice, orderDate);
				infos.add(info);
			}
		} finally {
			close(myRs, myStmt, myConn);
		}
		return infos;
	}

	public List<Account> getAccount(int accountId) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Account> accounts = new ArrayList<Account>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select*from taikhoan where id=" + accountId;
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				int id = myRs.getInt("id");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				int isAdmin = myRs.getInt("isAdmin");
				Account taikhoan = new Account(id, username, password, isAdmin);
				accounts.add(taikhoan);
			}

		} finally {
			close(myRs, myStmt, myConn);
		}
		return accounts;
	}

	public List<OrderInfoDetail> getOrderIdInfoDetail(int orderId) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<OrderInfoDetail> infoDetails = new ArrayList<OrderInfoDetail>();

		try {
			myConn = dataSource.getConnection();
			String sql = "select*from orderdetail where orderid=" + orderId;
			myStmt = myConn.prepareStatement(sql);

			myRs = myStmt.executeQuery();

			while (myRs.next()) {

				int id = myRs.getInt("id");

				String bookName = myRs.getString("bookName");
				int quantity = myRs.getInt("quantity");
				int price = myRs.getInt("price");
				OrderInfoDetail infoDetail = new OrderInfoDetail(id, orderId, bookName, quantity, price);
				infoDetails.add(infoDetail);

			}

		} finally {
			close(myRs, myStmt, myConn);
		}

		return infoDetails;
	}

	public void xoaDonHang(int orderId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "delete from orderdetail where orderid=" + orderId;
			myStmt = myConn.prepareStatement(sql);
			myStmt.execute();
			myStmt.close();
			sql = "delete  from orderinfo where id=" + orderId;
			myStmt = myConn.prepareStatement(sql);
			myStmt.execute();

		} finally {
			close(null, myStmt, myConn);
		}

	}

	private void close(ResultSet myRs, PreparedStatement myStmt, Connection myConn) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myConn != null) {
				myConn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
