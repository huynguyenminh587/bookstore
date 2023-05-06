package thongtintaikhoan;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DangKiDangNhap.Account;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet("/DoiMatKhau")
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UpdateMatKhau khau;
	@Resource(name = "jdbc/bookshop")
	private DataSource dataSource;

	public DoiMatKhau() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		khau = new UpdateMatKhau(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

		try {
			khau.updatePassword(password, account.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account account2 = new Account(account.getId(), account.getUserName(), password, account.getIsAdmin());
		
		session.setAttribute("account", account2);
		response.sendRedirect("ThongTinTaiKhoan");

	}
}
