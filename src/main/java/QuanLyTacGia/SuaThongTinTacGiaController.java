package QuanLyTacGia;

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
 * Servlet implementation class ThemTacGiaController
 */
@WebServlet("/SuaThongTinTacGiaController")
public class SuaThongTinTacGiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    TacGiaDbUtil tacGiadbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public SuaThongTinTacGiaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tacGiadbUtil=new TacGiaDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id=Integer.parseInt(request.getParameter("Id"));
//		System.out.println(Id);
		String NameAuthor=request.getParameter("NameAuthor");
//		System.out.println(NameAuthor);
		String Birthday=request.getParameter("Birthday");
//		System.out.println(Birthday);
		String Email=request.getParameter("Email");
//		System.out.println(Email);
		String Phone=request.getParameter("Phone");
//		System.out.println(Phone);
		TacGia tacgia=new TacGia(Id,NameAuthor, Birthday, Email, Phone);
		try {
			tacGiadbUtil.SuaThongTinTacGia(tacgia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
	}

}
