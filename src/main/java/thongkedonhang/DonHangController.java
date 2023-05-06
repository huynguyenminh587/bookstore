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

/**
 * Servlet implementation class DonHangController
 */
@WebServlet("/DonHangController")
public class DonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DonHangDbUtil donHangDbUtil;
	@Resource(name="jdbc/bookshop")
	private DataSource dataSource;

	public DonHangController() {
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
		List<OrderInfo> infos=null;
		try {
			infos=donHangDbUtil.getOrderInfo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("infos", infos);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyDonHang/ThongTinCacDonHang.jsp");
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
