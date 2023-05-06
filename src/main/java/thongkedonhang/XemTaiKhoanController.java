package thongkedonhang;

import java.io.IOException;
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

import DangKiDangNhap.Account;



/**
 * Servlet implementation class XemTaiKhoanController
 */
@WebServlet("/XemTaiKhoanController")
public class XemTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DonHangDbUtil donHangDbUtil;
	@Resource(name = "jdbc/bookshop")
	private DataSource dataSource;

	public XemTaiKhoanController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		donHangDbUtil=new DonHangDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int accountId=Integer.parseInt(request.getParameter("accountId"));
		List<Account> accounts=null;
		try {
			accounts=donHangDbUtil.getAccount(accountId);
		} catch (Exception e) {
	
		}
		
		request.setAttribute("accounts",accounts);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyTaiKhoan/ThongTinCacTaiKhoan.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
