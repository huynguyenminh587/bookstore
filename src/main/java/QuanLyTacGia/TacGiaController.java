package QuanLyTacGia;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class TacGiaController
 */
@WebServlet("/TacGiaController")
public class TacGiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TacGiaDbUtil tacGiaDbUtil;
    @Resource (name="jdbc/bookshop")
    DataSource dataSource;
    
    public TacGiaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tacGiaDbUtil= new TacGiaDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TacGia> tacGia;
//		System.out.println(1);
		try {
			tacGia = tacGiaDbUtil.getTacGia();
//			for(TacGia a: tacGia) {
//				System.out.println(a.getId());
//				System.out.println(a.getNameAuthor());
//				System.out.println(a.getBirthday());
//				System.out.println(a.getEmail());
//				System.out.println(a.getPhone());
//			}
			request.setAttribute("TacGia", tacGia);
			RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyTacGia.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
	}

}
