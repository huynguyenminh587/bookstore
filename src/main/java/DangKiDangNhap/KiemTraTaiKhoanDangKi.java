package DangKiDangNhap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/KiemTraTaiKhoanDangKi")
public class KiemTraTaiKhoanDangKi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private KiemTraTaiKhoanDangKiDbUtil kiemTraTaiKhoanDangKiDbUtil;
    @Resource (name="jdbc/bookshop")
    private DataSource dataSource;
    public KiemTraTaiKhoanDangKi() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig e) throws ServletException {
		super.init(e);
		kiemTraTaiKhoanDangKiDbUtil=new KiemTraTaiKhoanDangKiDbUtil(dataSource);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		PrintWriter out=response.getWriter();
		try {
		    
			String kt=kiemTraTaiKhoanDangKiDbUtil.KiemTraTaiKhoan(username);
			
			
			
			out.print(kt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		out.print("hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
