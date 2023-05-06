package TimKiem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import trangchuvadanhmucsach.Sach;

/**
 * Servlet implementation class TimKiemController
 */
@WebServlet("/TimKiemController")
public class TimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TimKiemDbUtil Timkiemdbutil;
    @Resource(name="jdbc/bookshop")
    DataSource datasource;
    
    public TimKiemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Timkiemdbutil=new TimKiemDbUtil(datasource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Tensachcantim=request.getParameter("Tensachcantim");
		

		List<Sach> Kq=new ArrayList<>();
		try {
			
			Kq=Timkiemdbutil.KetQuaTimKiem(Tensachcantim);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(Sach a:Kq) {
//			System.out.println(a.getName());
//		}
		request.setAttribute("book_list", Kq);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangChu.jsp");
		dispatcher.forward(request, response);
	}

}
