package DangKiDangNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DangKiDbUtil {
	private DataSource dataSource;

	public DangKiDbUtil(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	public void addAccount(Account account) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt =null;
		try {
			//kêt nối với database
			myConn=dataSource.getConnection();
			
			//tạo câu lệnh chèn
			String sql="insert taikhoan"
					+"(username,password)"
					+"value(?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			//đưa giá trị vào bảng
			myStmt.setString(1, account.getUserName());
			myStmt.setString(2, account.getPassWord());
			
			//thực hiện câu lệnh
			myStmt.execute();
			
		} finally {
			close(myConn,myStmt,null);
		}
		
	}
	
	
	
	public Account getAccount(Account account) throws SQLException {
		
		Connection myConn=null;
		PreparedStatement myStmt =null;
		ResultSet myRs=null;
		Account taikhoan = null;
		try {
			myConn=dataSource.getConnection();
			String sql="select*from taikhoan where username=? and password=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, account.getUserName());
			myStmt.setString(2,account.getPassWord());
			
			myRs=myStmt.executeQuery();//ko có sql trong ngoặc
			
			
			while(myRs.next()) { //next() là một boolean đưa tới các chỉ mục của myRs
				int id=myRs.getInt("id");
				String username=myRs.getString("username");
				String password=myRs.getString("password");
				int isAdmin=myRs.getInt("isAdmin");
				taikhoan =new Account(id,username, password, isAdmin);
			}
			
		} finally {
			close(myConn,myStmt,myRs);
		}
		
		return taikhoan;
		
	}
	
	
	
	public void addAccountDetail(AccountDetail accountDetail) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt =null;
		try {
			
			myConn=dataSource.getConnection();
			String sql="insert AccountDetail"
					+"(AccountId,fullName,Gender,Birthday,Address,Email,Phone)"
					+"value(?,?,?,?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, accountDetail.getAccountId());
			myStmt.setString(2, accountDetail.getFullName());
			myStmt.setString(3, accountDetail.getGender());
			myStmt.setString(4, accountDetail.getBirthday());
			myStmt.setString(5, accountDetail.getAddress());
			myStmt.setString(6, accountDetail.getEmail());
			myStmt.setString(7, accountDetail.getPhone());
			
			myStmt.execute();
			
		} finally {
			close(myConn,myStmt,null);
		}
		
	}
	
	
	//phương thúc này gọi ở pakage taikhoancuaban servlet ThongTinTaiKhoan
	
	public AccountDetail getAccountDetail(Account account) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt =null;
		ResultSet myRs=null;
		AccountDetail accountDetail=null;
		try {
			myConn=dataSource.getConnection();
			String sql="select *from accountdetail where AccountId=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, account.getId());
			myRs=myStmt.executeQuery();
			while(myRs.next()) {
				int id=myRs.getInt("Id");
				int accountId=myRs.getInt("AccountId");
				String fullName=myRs.getString("FullName");
				String gender=myRs.getString("Gender");
				String birthday=myRs.getString("Birthday");
				String address=myRs.getString("Address");
				String email=myRs.getString("Email");
				String phone=myRs.getString("Phone");
				accountDetail=new AccountDetail(id, accountId, fullName, gender, birthday, address, email, phone);
			}
			
		} finally {
			close(myConn, myStmt, myRs);
		}
		
		return accountDetail;
		
	}
	
	//phương thức này gọi ở pakage thongtintaikhoan servlet CapNhatThongTinTaiKhoan
	
	public void updateAccountDetail(Account account,AccountDetail accountDetail) throws SQLException {
		
		Connection myConn=null;
		PreparedStatement myStmt =null;
		
		try {
			myConn=dataSource.getConnection();
			String sql="update accountdetail set FullName=?,Gender=?,Birthday=?,Address=?,Email=?,Phone=?"
					+ " where AccountId="+account.getId();
			myStmt=myConn.prepareStatement(sql);
  		    myStmt.setString(1, accountDetail.getFullName());
  		    myStmt.setString(2,accountDetail.getGender());
  		    myStmt.setString(3, accountDetail.getBirthday());
  		    myStmt.setString(4, accountDetail.getAddress());
  		    myStmt.setString(5,accountDetail.getEmail());
  		    myStmt.setString(6,accountDetail.getPhone());
  		    myStmt.execute();
			
		} finally {
			close(myConn, myStmt, null);
		}
	}
	
	
	

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {
		try {
			if(myRs!=null) {
				myRs.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(myConn!=null) {
				myConn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
