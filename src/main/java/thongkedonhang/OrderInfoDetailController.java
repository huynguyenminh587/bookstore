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
 * Servlet implementation class OrderInfoDetailController
 */
@WebServlet("/OrderInfoDetailController")
public class OrderInfoDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DonHangDbUtil dbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public OrderInfoDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dbUtil=new DonHangDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		List<OrderInfoDetail>  orderInfoDetails=null;
		try {
			orderInfoDetails=dbUtil.getOrderIdInfoDetail(orderId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		request.setAttribute("orderInfoDetails", orderInfoDetails);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyDonHang/ChiTietDonHang.jsp");
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
