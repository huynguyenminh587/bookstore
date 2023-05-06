package thongtintaikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UpdateMatKhau {
	private DataSource dataSource;

	public UpdateMatKhau() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UpdateMatKhau(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	public void updatePassword(String password, int id) throws SQLException {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			myConn=dataSource.getConnection();
			String sql="update taikhoan set password=? where id="+id;
			
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1,password);
			myStmt.execute();
		} finally {
			close(myConn,myStmt,null);
		}
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {
		if(myRs!=null) {
			myRs.close();
		}
		if(myStmt!=null) {
			myStmt.close();
		}
		if(myConn!=null) {
			myConn.close();
		}
	}

}
