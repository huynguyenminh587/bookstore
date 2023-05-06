package quanlytaikhoan;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UpdateQuyenAdmin
 */
@WebServlet("/UpdateQuyenAdmin")
public class UpdateQuyenAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountDbUtil accountDbUtil;
	@Resource(name = "jdbc/bookshop")
	private DataSource dataSource;

	public UpdateQuyenAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		accountDbUtil = new AccountDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String quyen = request.getParameter("quyen");
		if (quyen.equalsIgnoreCase("capquyen")) {
			try {
				accountDbUtil.capQuyenAdmin(accountId);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			try {
				accountDbUtil.xoaQuyenAdmin(accountId);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		response.sendRedirect("AccountController");
	}

}
