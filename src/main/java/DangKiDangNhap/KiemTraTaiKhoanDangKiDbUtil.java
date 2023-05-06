package DangKiDangNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class KiemTraTaiKhoanDangKiDbUtil {
	private DataSource dataSource;

	public KiemTraTaiKhoanDangKiDbUtil(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	String KiemTraTaiKhoan(String username) throws SQLException {
		Connection myConn =null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		try {
			myConn=dataSource.getConnection();
			String sql="select*from taikhoan where username=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, username);
			myRs=myStmt.executeQuery();//ko có sql trong ngoặc
			if(myRs.next()) {
				return "tk da ton tai";
			}
			else {
				return "tk chua ton tai";
			}
			
		} finally {
			close(myConn,myStmt,myRs);
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
