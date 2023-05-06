package DangKiDangNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



public class DangNhapDbUtil {
	private DataSource dataSource;
	
	
	
	public DangNhapDbUtil(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	public Account checkLogin(Account account) throws SQLException {
		Connection myConn =null;
		PreparedStatement myStmt=null;
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
				int  id=myRs.getInt("id");
				String username=myRs.getString("username");
				String password=myRs.getString("password");
				int isAdmin=myRs.getInt("isAdmin");
				taikhoan =new Account(id,username, password, isAdmin);
			}//hoặc return trong vòng for
			
		} finally {
			close(myConn,myStmt,myRs);
		}
		return taikhoan;
		
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
