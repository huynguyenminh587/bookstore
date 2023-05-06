package DangKiDangNhap;

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

/**
 * Servlet implementation class DangNhapConTroller
 */
@WebServlet("/DangNhapConTroller")
public class DangNhapConTroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DangNhapDbUtil dangnhap;
    @Resource(name="jdbc/bookshop")   
    private DataSource dataSource;
    public DangNhapConTroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dangnhap=new DangNhapDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Account account=new Account(username, password);
			try {
				
				Account a=dangnhap.checkLogin(account);
				
				if (a==null) {
					response.sendRedirect("DangNhapSai.jsp");
//				}
//				else if(a.getIsAdmin()==1) {
//					HttpSession session =request.getSession();
//					session.setAttribute("account", a);
//					response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
				}
				else {
//					User acc= new User(username, password);
					HttpSession session =request.getSession();
					session.setAttribute("account", a);
					response.setStatus(response.SC_MOVED_PERMANENTLY);
					response.setHeader("Location", "TrangChuController");//gửi đến trang servlet
					//cũng có thể dùng response.sendRedirect()
					System.out.println(session.getAttribute("account"));//dùng để phân quyền đăng nhập
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

}
