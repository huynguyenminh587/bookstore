package ChiTiet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SachDbUtil {
	private DataSource dataSource;
	
	
	 public SachDbUtil(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	List<Sach> getSach(int id) throws SQLException{
		 Connection myConn=null;
		 PreparedStatement myStmt =null;
		 ResultSet myRs=null;
		 try {
			myConn=dataSource.getConnection();
			String sql="select b.id,b.name,b.price,b.image,a.NameAuthor,p.NamePublisher,b.PublishYear,b.TotalPage,b.Language,b.Description from book b join Author a \r\n"
					+ "on b.authorid=a.id join Publisher p on b.publisherid=p.id where b.id=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setLong(1, id);//thay séttring
			myRs=myStmt.executeQuery();
			Sach nSach;
			List<Sach> kq = new ArrayList<Sach>();
			while(myRs.next()) {
				String name=myRs.getString("name");
				int price =myRs.getInt("price");
				String image=myRs.getString("image");
				String NameAuthor=myRs.getString("NameAuthor");
				String NamePublisher=myRs.getString("NamePublisher");
				String PublisherYear=myRs.getString("PublishYear");
				int TotalPage=myRs.getInt("TotalPage");
				String Language=myRs.getString("Language");
				String Description=myRs.getString("Description");
				nSach=new Sach(id, name, price, image, NamePublisher, NameAuthor, PublisherYear, TotalPage, Language, Description);
			    kq.add(nSach);
			}
			return kq;
			
			
		} finally {
			close(myConn,myStmt,myRs);
		}
		 
		
		
	}

	private void close(Connection myConn, PreparedStatement myStmt, ResultSet myRs) throws SQLException {
		if(myRs!=null) myRs.close();
		if(myStmt!=null) myStmt.close();
		if(myConn!=null) myConn.close();
		
	}

}
