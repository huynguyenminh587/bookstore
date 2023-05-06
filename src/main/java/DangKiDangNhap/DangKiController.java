package DangKiDangNhap;

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

/**
 * Servlet implementation class DangKiController
 */
@WebServlet("/DangKiController")
public class DangKiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DangKiDbUtil dangKiDbUtil;
       
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public DangKiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			dangKiDbUtil =new DangKiDbUtil(dataSource);
		}
		catch (Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//			addAccount(request,response);
//		} catch (SQLException | ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		//đọc thông tin
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fullName=request.getParameter("FullName");
		String gender =request.getParameter("Gender");
		String birthday=request.getParameter("Birthday");
		String address=request.getParameter("Address");
		String email=request.getParameter("Email");
		String phone=request.getParameter("Phone");
		//tạo một đối tượng mới
		
		Account account =new Account(username, password);
		Account account2=null;
		
		try {
			
			//thêm tài khoản vào database
			dangKiDbUtil.addAccount(account);
			
			//lây id tài khoản
			 account2= dangKiDbUtil.getAccount(account);
			int accountId=account2.getId();
			
			//thêm vào accountDetail
			
			AccountDetail accountDetail=new AccountDetail(accountId, fullName, gender, birthday, address, email, phone);
			dangKiDbUtil.addAccountDetail(accountDetail);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//phương thức addAccount sẽ thêm sau vào class DangKiUtil
		HttpSession session=request.getSession();
		session.setAttribute("account", account2);
		
		
		System.out.println(session.getAttribute("account"));
		
		
		
		
		//chuyển đến trang chủ
		response.setStatus(response.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "TrangChuController");
	}

	
		
	

}
