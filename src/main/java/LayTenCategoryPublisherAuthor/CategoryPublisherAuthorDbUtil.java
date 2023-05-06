package LayTenCategoryPublisherAuthor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import QuanLyLoaiSach.BookCategory;
import QuanLyNhaXuatBan.Publisher;
import QuanLyTacGia.TacGia;

public class CategoryPublisherAuthorDbUtil {
	private DataSource dataSource;

	public CategoryPublisherAuthorDbUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	List<BookCategory> CategoryName() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
//		String[] name;
		List<BookCategory> kq= new ArrayList<BookCategory>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select id, name from bookcategory";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id=myRs.getInt("Id");
				String name = myRs.getString("name");
				BookCategory n=new BookCategory(id, name);
				kq.add(n);
			}
		} finally {
			close(myRs,myStmt,myConn);

		}
		return kq;
	}
	
	List<Publisher> NamePublisher() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
//		String[] name;
		List<Publisher> kq = new ArrayList<Publisher>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select id, namepublisher from publisher";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id=myRs.getInt("id");
				String name = myRs.getString("namepublisher");
				Publisher n=new Publisher(id, name);
				kq.add(n);
			}
		} finally {
			close(myRs,myStmt,myConn);

		}
		return kq;
	}
	
	List<TacGia> NameAuthor() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
//		String[] name;
		List<TacGia> kq = new ArrayList<TacGia>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select id, nameauthor from author";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id=myRs.getInt("id");
				String name = myRs.getString("nameauthor");
				TacGia n=new TacGia(id, name);
				kq.add(n);
			}
		} finally {
			close(myRs,myStmt,myConn);

		}
		return kq;
	}

	private void close(ResultSet myRs, PreparedStatement myStmt, Connection myConn) throws SQLException {
		if(myRs!=null) myRs.close();
		if(myStmt!=null) myStmt.close();
		if(myConn!=null) myConn.close();
		
	}

}
