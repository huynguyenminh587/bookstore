package quanlytaikhoan;

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

import DangKiDangNhap.AccountDetail;



/**
 * Servlet implementation class AccountDetailController
 */
@WebServlet("/AccountDetailController")
public class AccountDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AccountDbUtil accountDbUtil;
    
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public AccountDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		accountDbUtil =new AccountDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int accountId=(Integer.parseInt(request.getParameter("accountId")));
		AccountDetail accountDetail=null;
		try {
			 accountDetail=accountDbUtil.getAccountDetail(accountId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("accountDetail", accountDetail);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyTaiKhoan/ThongTinChiTietTaiKhoan.jsp");
		dispatcher.forward(request, response);
		
	}

}
