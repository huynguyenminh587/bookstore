package thongkedonhang;

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
 * Servlet implementation class XoaDonHangController
 */
@WebServlet("/XoaDonHangController")
public class XoaDonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DonHangDbUtil donHangDbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public XoaDonHangController() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		
		try {
			donHangDbUtil.xoaDonHang(orderId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("DonHangController");
	}

}
