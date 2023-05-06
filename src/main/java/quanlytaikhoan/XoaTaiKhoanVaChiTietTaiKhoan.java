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
 * Servlet implementation class XoaTaiKhoanVaChiTietTaiKhoan
 */
@WebServlet("/XoaTaiKhoanVaChiTietTaiKhoan")
public class XoaTaiKhoanVaChiTietTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private AccountDbUtil accountDbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
   
    public XoaTaiKhoanVaChiTietTaiKhoan() {
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
		int accountId=Integer.parseInt(request.getParameter("accountId"));
//		System.out.println(accountId);
//		System.out.println("1");
		try {
			accountDbUtil.deleteAccountAndAccountDetail(accountId);
			
		} catch (Exception e) {
			System.out.println("Không xóa đc");
		}
		response.sendRedirect("AccountController");
	}

}
