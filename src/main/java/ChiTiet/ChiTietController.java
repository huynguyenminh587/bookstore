package ChiTiet;

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
 * Servlet implementation class ChiTietController
 */
@WebServlet("/ChiTietController")
public class ChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SachDbUtil Sach;
	

	@Resource (name="jdbc/bookshop")
	private DataSource dataSource;
	
    
    public ChiTietController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Sach=new SachDbUtil(dataSource);
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			List<Sach> kq=Sach.getSach(id);
//			for(Sach a:kq) {
//				System.out.println(a.getName());
//			}
			request.setAttribute("book_list", kq);
			RequestDispatcher dispatcher=request.getRequestDispatcher("TrangChiTiet.jsp");
			dispatcher.forward(request, response);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
