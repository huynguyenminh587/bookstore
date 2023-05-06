package QuanLyDanhMuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

public class SachDbUtil {
	DataSource dataSource;
	Date date=null;
	SimpleDateFormat df= new SimpleDateFormat("yyyy");

	public SachDbUtil(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	List<Sach1> getSach() throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Sach1 nSach;
		List<Sach1> kq = new ArrayList<Sach1>();
		try {
			myConn = dataSource.getConnection();
			String sql = "select b.id,b.name,b.price,b.image, c.name as BookCategory ,p.NamePublisher,a.NameAuthor,b.PublishYear,b.Totalpage,b.Language,b.Description from book as b join bookcategory as c on b.BookCategoryId=c.id \r\n"
					+ "join publisher as p on b.publisherid=p.id join author as a on b.authorid=a.id";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int Id = myRs.getInt("Id");
				String Name = myRs.getString("Name");
				int Price = myRs.getInt("Price");
				String Image = myRs.getString("Image");
				String  BookCategory = myRs.getString("BookCategory");
				String NamePublisher = myRs.getString("NamePublisher");
				
				String NameAuthor = myRs.getString("NameAuthor");
				String PublishYear = myRs.getString("PublishYear");
				//thêm
				try {
					date=df.parse(PublishYear);
					PublishYear=df.format(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				int TotalPage = myRs.getInt("TotalPage");
				String Language = myRs.getString("Language");
				String Description = myRs.getString("Description");
				nSach = new Sach1(Id, Name, Price, Image, BookCategory, NamePublisher, NameAuthor, PublishYear, TotalPage, Language, Description);
				kq.add(nSach);
			}
			return kq;

		} finally {
			close(myRs, myStmt, myConn);
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

	void ThemSach(Sach sach) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {

			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert  book"
					+ "(name,price,Image,BookCategoryId,PublisherId,AuthorId,PublishYear,TotalPage,Language,Description)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			// set the param values for the student
			
			myStmt.setString(1, sach.getName());
			myStmt.setInt(2, sach.getPrice());
			myStmt.setString(3, sach.getImage());
			myStmt.setInt(4, sach.getCategoryId());
			myStmt.setInt(5, sach.getPublisherId());
			myStmt.setInt(6, sach.getAuthorId());
			myStmt.setString(7, sach.getPublishYear());
			myStmt.setInt(8, sach.getTotalPage());
			myStmt.setString(9, sach.getLanguage());
			myStmt.setString(10, sach.getDescription());
			// excute sql insert
			myStmt.execute();

		} finally {
			close(null, myStmt, myConn);
		}
	}
	void SuaSach(Sach sach) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
		myConn = dataSource.getConnection();
		String sql="update book set name=?,price=?,image=?,bookcategoryid=?,PublisherId=?,AuthorId=?,PublishYear=?,"
				+"TotalPage=?,Language=?,Description=? where Id="+sach.getId();
		myStmt=myConn.prepareStatement(sql);
		myStmt.setString(1, sach.getName());
		myStmt.setInt(2, sach.getPrice());
		myStmt.setString(3, sach.getImage());
		myStmt.setInt(4, sach.getCategoryId());
		myStmt.setInt(5, sach.getPublisherId());
		myStmt.setInt(6, sach.getAuthorId());
		myStmt.setString(7, sach.getPublishYear());
		myStmt.setInt(8, sach.getTotalPage());
		myStmt.setString(9, sach.getLanguage());
		myStmt.setString(10, sach.getDescription());
		// excute sql insert
		myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}
	}
	void XoaSach(int id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql="delete from book where id="+id;
			myStmt=myConn.prepareStatement(sql);
			myStmt.execute();
			
		}finally {
			close(null, myStmt, myConn);
		}
	}
	//xem lại
	int CategoryId(String categoryName) throws SQLException{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int a;
		try {
			myConn=dataSource.getConnection();
			String sql="select id from bookcategory where name="+categoryName;
			myStmt=myConn.prepareStatement(sql);
			myRs=myStmt.executeQuery();
			a=myRs.getInt("Id");
		} finally {
			close(myRs, myStmt, myConn);
		}
		
		
		return a;
	}
	
	int PublisherId(String publisherName) throws SQLException{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int a;
		try {
			myConn=dataSource.getConnection();
			String sql="select id from publisher where name="+publisherName;
			myStmt=myConn.prepareStatement(sql);
			myRs=myStmt.executeQuery();
			a=myRs.getInt("Id");
		} finally {
			close(myRs, myStmt, myConn);
		}
		
		
		return a;
	}


}
