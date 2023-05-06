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
import DangKiDangNhap.AccountDetail;
import DangKiDangNhap.DangKiDbUtil;

/**
 * Servlet implementation class CapNhatThongTinTaiKhoan
 */
@WebServlet("/CapNhatThongTinTaiKhoan")
public class CapNhatThongTinTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DangKiDbUtil dangKiDbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
   
    public CapNhatThongTinTaiKhoan() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fullName=request.getParameter("fullName");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		AccountDetail accountDetail=new AccountDetail(fullName, gender, birthday, address, email, phone);
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		
		//test
//		System.out.println("1");
//		String fullName="Nguyễn Văn H";
//		String gender="Nam";
//		String birthday="200-01-01"	;	
//		String address="Vinh An";
//		String email="H@gmail.com";
//		String phone="0123456";
//		AccountDetail accountDetail=new AccountDetail(fullName, gender, birthday, address, email, phone);
//		Account account=new Account(1, "huy", "1", 0);
		try {
			dangKiDbUtil.updateAccountDetail(account, accountDetail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ThongTinTaiKhoan");
	}

}
