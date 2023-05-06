package TimKiem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import trangchuvadanhmucsach.Sach;

public class TimKiemDbUtil {
	DataSource datasource;

	public TimKiemDbUtil(DataSource datasource) {

		this.datasource = datasource;
	}

//	Connection myConn = null;
//	PreparedStatement myStmt = null;
//	ResultSet myRs = null;
//	String[] TenBang = { "trangchu", "sachtinhyeu", "sachquanlykinhdoanh", "sachkynang", "sachkienthucbachkhoa" };
//	List<Sach> Kq = new ArrayList<Sach>();

	List<Sach> KetQuaTimKiem(String Tensachcantim) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Sach> Kq = new ArrayList<Sach>();
		try {
			

				myConn = datasource.getConnection();
				String sql = "select*from book where name like '%" + Tensachcantim + "%'";
			
				myStmt = myConn.prepareStatement(sql);
			
				myRs = myStmt.executeQuery();
				Sach nSach = null;
				if (myRs != null) {
			
					while (myRs.next()) {
						nSach = new Sach(myRs.getString("name"), myRs.getInt("price"), myRs.getString("image"));
						Kq.add(nSach);// có thể có điều kiện nSach!=null;
					}
				}
			return Kq;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) {

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
