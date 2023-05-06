package quanlytaikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import DangKiDangNhap.Account;
import DangKiDangNhap.AccountDetail;

public class AccountDbUtil {

	private DataSource dataSource;

	public AccountDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<Account> getAccount() throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Account> accounts = new ArrayList<Account>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select*from taikhoan ";
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

	public AccountDetail getAccountDetail(int accountId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		AccountDetail accountDetail = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select *from accountdetail where AccountId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, accountId);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id = myRs.getInt("Id");

				String fullName = myRs.getString("FullName");
				String gender = myRs.getString("Gender");
				String birthday = myRs.getString("Birthday");
				String address = myRs.getString("Address");
				String email = myRs.getString("Email");
				String phone = myRs.getString("Phone");
				accountDetail = new AccountDetail(id, accountId, fullName, gender, birthday, address, email, phone);
			}

		} finally {
			close(myRs, myStmt, myConn);
		}

		return accountDetail;

	}

	public void deleteAccountAndAccountDetail(int accountId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "delete  from accountdetail where  AccountId= " + accountId;
			myStmt = myConn.prepareStatement(sql);
			myStmt.execute();
			myStmt.close();;
			String sql1="delete from taikhoan where id="+accountId;
			myStmt = myConn.prepareStatement(sql1);
			myStmt.execute();

		} finally {
			close(null, myStmt, myConn);
		}

	}
	
	
	
	public void capQuyenAdmin(int accountId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql="update taikhoan set isAdmin=1 where id="+accountId;
			myStmt=myConn.prepareStatement(sql);
			myStmt.execute();
			
		} finally {
			close(null, myStmt, myConn);
			
	
		}
		
	}
	
	
	public void xoaQuyenAdmin(int accountId) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql="update taikhoan set isAdmin=0 where id="+accountId;
			myStmt=myConn.prepareStatement(sql);
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
