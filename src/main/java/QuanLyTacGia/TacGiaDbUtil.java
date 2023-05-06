package QuanLyTacGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TacGiaDbUtil {

	DataSource datasouce;
	

	public TacGiaDbUtil(DataSource datasouce) {
		
		this.datasouce = datasouce;
	}


	List<TacGia> getTacGia() throws SQLException {
		
		List<TacGia> kq= new ArrayList<TacGia>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = datasouce.getConnection();
			String sql = "select*from author";
			myStmt=myConn.prepareStatement(sql);
			myRs=myStmt.executeQuery();
			TacGia tacgia;
			
			while(myRs.next()) {
				int Id=myRs.getInt("Id");
				String NameAuthor=myRs.getString("NameAuthor");
				String Birthday=myRs.getString("Birthday");
				String Email=myRs.getString("Email");
				String Phone=myRs.getString("Phone");
				tacgia=new TacGia(Id, NameAuthor, Birthday, Email, Phone);
				kq.add(tacgia);
			}
			return kq;
		} finally{
			close(myRs,myStmt,myConn);
		}
		

	}
	void ThemTacGia(TacGia tacgia) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn=datasouce.getConnection();
			String sql="insert author (NameAuthor,Birthday,Email,Phone)"
					+ "values (?,?,?,?)";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, tacgia.getNameAuthor());
			myStmt.setString(2, tacgia.getBirthday());
			myStmt.setString(3, tacgia.getEmail());
			myStmt.setString(4, tacgia.getPhone());
			
			myStmt.execute();
			
		} finally {
			close(null,myStmt,myConn);
		}
	}
	void SuaThongTinTacGia(TacGia tacGia) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn=datasouce.getConnection();
			String sql="update author set NameAuthor=?,Birthday=?,Email=?,Phone=? where Id="+tacGia.getId();
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, tacGia.getNameAuthor());
			myStmt.setString(2, tacGia.getBirthday());
			myStmt.setString(3, tacGia.getEmail());
			myStmt.setString(4, tacGia.getPhone());
			myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}
		
	}
	void XoaTacGia(int Id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn=datasouce.getConnection();
			String sql="delete from author where id="+Id;
			myStmt=myConn.prepareStatement(sql);
			myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}
	}


	private void close(ResultSet myRs, PreparedStatement myStmt, Connection myConn) throws SQLException {
		if(myRs!=null) myRs.close();
		if(myStmt!=null) myStmt.close();
		if(myConn!=null) myConn.close();
		
	}

}
