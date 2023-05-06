package QuanLyLoaiSach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookCategoryDbUtil {
	private DataSource dataSource;

	public BookCategoryDbUtil(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
	
	List<BookCategory> getBookCategory() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<BookCategory> bookCategories=new ArrayList<BookCategory>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select*from bookcategory";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			BookCategory bookCategory;
			
			while(myRs.next()) {
				int Id=myRs.getInt("Id");
				String Name=myRs.getString("name");
				bookCategory=new BookCategory(Id, Name);
				bookCategories.add(bookCategory);
			}
			
			return bookCategories;
		} finally {
			close(myRs,myStmt,myConn);
		}
		
	}
	void ThemLoaiSach(BookCategory bookCategory) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "insert bookcategory (name) values (?)";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, bookCategory.getName());
			

			myStmt.execute();

		} finally {
			close(null, myStmt, myConn);
		}
	}
	void SuaThongTinLoaiSach( BookCategory bookCategory) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update bookcategory set Name=? where Id=" + bookCategory.getId();
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, bookCategory.getName());
			
			myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}
	}
	void XoaLoaiSach(int Id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql="delete from bookcategory where id="+Id;
			myStmt = myConn.prepareStatement(sql);
			myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}
	}

	private void close(ResultSet myRs, PreparedStatement myStmt, Connection myConn) throws SQLException {
		if (myRs != null)
			myRs.close();
		if (myStmt != null)
			myStmt.close();
		if (myConn != null)
			myConn.close();
		
	}
	

}
