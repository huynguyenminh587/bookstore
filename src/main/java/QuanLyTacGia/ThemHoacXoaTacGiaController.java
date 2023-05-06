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
@WebServlet("/ThemHoacXoaTacGiaController")
public class ThemHoacXoaTacGiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TacGiaDbUtil tacGiadbUtil;
	@Resource(name = "jdbc/bookshop")
	private DataSource dataSource;

	public ThemHoacXoaTacGiaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tacGiadbUtil = new TacGiaDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String NameAuthor = request.getParameter("NameAuthor");
		if (NameAuthor == null) {//cẩn thân lỗi nếu chỉ chạy file này
			int Id = Integer.parseInt(request.getParameter("Id"));
			try {
				tacGiadbUtil.XoaTacGia(Id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String Birthday = request.getParameter("Birthday");
			String Email = request.getParameter("Email");
			String Phone = request.getParameter("Phone");
			TacGia tacgia = new TacGia(NameAuthor, Birthday, Email, Phone);
			try {
				tacGiadbUtil.ThemTacGia(tacgia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
	}

}
