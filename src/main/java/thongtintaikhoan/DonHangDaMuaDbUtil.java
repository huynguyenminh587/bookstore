package thongtintaikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import thongkedonhang.OrderInfo;
public class DonHangDaMuaDbUtil {
	private DataSource dataSource;

	public DonHangDaMuaDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<OrderInfo> getOrderInfo(int accountId) throws SQLException{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<OrderInfo> infos = new ArrayList<OrderInfo>();
		try {
			myConn = dataSource.getConnection();
			String sql="select *from orderinfo where accountid="+accountId;
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				int id = myRs.getInt("id");
				int quantity = myRs.getInt("quantity");
				int totalPrice = myRs.getInt("totalprice");
				String orderDate = myRs.getString("orderdate");
				OrderInfo orderInfo=new OrderInfo(id, accountId, quantity, totalPrice, orderDate);
				infos.add(orderInfo);
			}
			
			
		} finally {
			close(myRs, myStmt, myConn);
		}
		
		return infos;
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
