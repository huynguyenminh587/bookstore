package QuanLyNhaXuatBan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PublisherDbUtil {
	private DataSource dataSource;

	public PublisherDbUtil(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	List<Publisher> getPublisher() throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select*from publisher";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();
			Publisher publisher;
			List<Publisher> kq = new ArrayList<Publisher>();
			while (myRs.next()) {
				int Id = myRs.getInt("Id");
				String NamePublisher = myRs.getString("NamePublisher");
				String Address = myRs.getString("Address");
				String Email = myRs.getString("Email");
				String Phone = myRs.getString("Phone");
				publisher = new Publisher(Id, NamePublisher, Address, Email, Phone);
				kq.add(publisher);
			}
			return kq;
		} finally {
			close(myRs, myStmt, myConn);
		}

	}

	void ThemNhaXuatBan(Publisher publisher) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "insert publisher (NamePublisher,Address,Email,Phone)" + "values (?,?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, publisher.getNamePublisher());
			myStmt.setString(2, publisher.getAddress());
			myStmt.setString(3, publisher.getEmail());
			myStmt.setString(4, publisher.getPhone());

			myStmt.execute();

		} finally {
			close(null, myStmt, myConn);
		}
	}

	void SuaThongTinNhaXuatBan(Publisher publisher) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "update publisher set NamePublisher=?,Address=?,Email=?,Phone=? where Id=" + publisher.getId();
			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, publisher.getNamePublisher());
			myStmt.setString(2, publisher.getAddress());
			myStmt.setString(3, publisher.getEmail());
			myStmt.setString(4, publisher.getPhone());
			myStmt.execute();
		} finally {
			close(null, myStmt, myConn);
		}

	}

	void Xoa(int Id) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "delete from publisher where id=" + Id;
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
