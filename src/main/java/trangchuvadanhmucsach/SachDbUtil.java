package trangchuvadanhmucsach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SachDbUtil {
	private DataSource dataSource;

	public SachDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Sach> getSach(int a) throws Exception{
		List<Sach> nSach=new ArrayList<Sach>();
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		try {
			//kết nối mysql
			myConn=dataSource.getConnection();
			//tạo câu lệnh
			String sql="select*from book where BookCategoryID= "+a;
			myStmt=myConn.createStatement();
			//thực hiện câu lệnh
			myRs=myStmt.executeQuery(sql);
			//lấy dữ liệu
			while(myRs.next()) {
				int id=myRs.getInt("Id");//mới thêm
				String name=myRs.getString("name");
				int price=myRs.getInt("price");
				String image=myRs.getString("image");
				//tạo đối tượng mới
				Sach tempSach=new Sach(id,name,price,image);
				
				//thêm vào mảng
				nSach.add(tempSach);
			}
			return nSach;

		} finally {
			close(myConn,myStmt,myRs);
		}
		
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
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
