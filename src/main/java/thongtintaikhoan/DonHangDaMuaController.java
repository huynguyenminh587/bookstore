package thongtintaikhoan;

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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DangKiDangNhap.Account;
import thongkedonhang.OrderInfo;

/**
 * Servlet implementation class DonHangDaMuaController
 */
@WebServlet("/DonHangDaMuaController")
public class DonHangDaMuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DonHangDaMuaDbUtil donHangDaMuaDbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public DonHangDaMuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		donHangDaMuaDbUtil=new DonHangDaMuaDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("account");
		int accountId=account.getId();
		List<OrderInfo> orderInfos=null;
		try {
			orderInfos=donHangDaMuaDbUtil.getOrderInfo(accountId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("orderInfos", orderInfos);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TaiKhoanCuaBan/DonHangDaMua.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
