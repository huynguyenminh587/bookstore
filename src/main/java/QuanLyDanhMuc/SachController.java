package QuanLyDanhMuc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuanLyDanhMuc.SachDbUtil Sach;
	@Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Sach=new QuanLyDanhMuc.SachDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Sach1> nSach=Sach.getSach();
			request.setAttribute("Sach", nSach);
//			for(Sach a:nSach) {
//				System.out.println(a.getId());
//				System.out.println(a.getName());
//			}
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/TrangThongKeSach.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
