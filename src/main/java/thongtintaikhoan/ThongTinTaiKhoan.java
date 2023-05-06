package thongtintaikhoan;

import java.io.IOException;
import java.sql.SQLException;

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
import DangKiDangNhap.AccountDetail;
import DangKiDangNhap.DangKiDbUtil;

/**
 * Servlet implementation class ThongTinTaiKhoan
 */
@WebServlet("/ThongTinTaiKhoan")
public class ThongTinTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private DangKiDbUtil dangKiDbUtil;
   
   @Resource(name="jdbc/bookshop")
   private DataSource dataSource;
    public ThongTinTaiKhoan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dangKiDbUtil=new DangKiDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account) session.getAttribute("account");
		try {
			AccountDetail accountDetail=dangKiDbUtil.getAccountDetail(account);
			request.setAttribute("accountDetail", accountDetail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("TaiKhoanCuaBan/ThongTinTaiKhoan.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
