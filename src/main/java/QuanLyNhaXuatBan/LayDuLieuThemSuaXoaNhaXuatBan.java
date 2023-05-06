package QuanLyNhaXuatBan;

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
 * Servlet implementation class LayDuLieuThemSuaXoaNhaXuatBan
 */
@WebServlet("/LayDuLieuThemSuaXoaNhaXuatBan")
public class LayDuLieuThemSuaXoaNhaXuatBan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublisherDbUtil publisherDbUtil;
	@Resource(name = "jdbc/bookshop")
	private DataSource dataSource;

	public LayDuLieuThemSuaXoaNhaXuatBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		publisherDbUtil = new PublisherDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten = "laydulieu";
		if (request.getParameter("ten") != null) {
			ten = request.getParameter("ten");
		}
		switch (ten) {
		case "them":
			String NamePublisher = request.getParameter("NamePublisher");
			String Address = request.getParameter("Address");
			String Email = request.getParameter("Email");
			String Phone = request.getParameter("Phone");
			Publisher publisher = new Publisher(NamePublisher, Address, Email, Phone);
			try {
				publisherDbUtil.ThemNhaXuatBan(publisher);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;
		case "sua":
			int Id=Integer.parseInt(request.getParameter("Id"));
			String NamePublisher1 = request.getParameter("NamePublisher");
			String Address1 = request.getParameter("Address");
			String Email1 = request.getParameter("Email");
			String Phone1 = request.getParameter("Phone");
			Publisher publisher1 = new Publisher(Id,NamePublisher1, Address1, Email1, Phone1);
			try {
				publisherDbUtil.SuaThongTinNhaXuatBan(publisher1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;
			
		case "xoa":
			int Id1=Integer.parseInt(request.getParameter("Id"));
			try {
				publisherDbUtil.Xoa(Id1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;

		case "laydulieu":
			List<Publisher> publisher2 = null;
			try {
				publisher2 = publisherDbUtil.getPublisher();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			for(Publisher a:publisher) {
//				System.out.println(a.getId());
//				System.out.println(a.getNamePublisher());
//				System.out.println(a.getAddress());
//				System.out.println(a.getEmail());
//				System.out.println(a.getPhone());
//			}
			request.setAttribute("Publisher", publisher2);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("TrangQuanTriVien/QuanLyNhaXuatBan/QuanLyNhaXuatBan.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}

}
