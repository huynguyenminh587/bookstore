package QuanLyDanhMuc;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class XoaSachController
 */
@WebServlet("/XoaSachController")
public class XoaSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuanLyDanhMuc.SachDbUtil sachDbUtil;
	@Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public XoaSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sachDbUtil=new QuanLyDanhMuc.SachDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id=Integer.parseInt(request.getParameter("Id"));
		try {
			sachDbUtil.XoaSach(Id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
		
	}

}
