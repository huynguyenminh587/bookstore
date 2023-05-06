package QuanLyDanhMuc;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SuaSachController
 */
@WebServlet("/SuaSachController")
public class SuaSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuanLyDanhMuc.SachDbUtil sachDbUtil;
	@Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public SuaSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sachDbUtil=new QuanLyDanhMuc.SachDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Id=Integer.parseInt(request.getParameter("Id"));
		String Name=request.getParameter("Name");
		System.out.println(Name);
		int Price=Integer.parseInt(request.getParameter("Price"));
		System.out.println(Price);
		String Image=request.getParameter("Image");
		System.out.println(Image);
		int CategoryId=Integer.parseInt(request.getParameter("BookCategoryId"));
		System.out.println(CategoryId);
		int PublisherId=Integer.parseInt(request.getParameter("PublisherId"));
		int AuthorId=Integer.parseInt(request.getParameter("AuthorId")) ;
		String PublishYear=request.getParameter("PublishYear");
		int TotalPage=Integer.parseInt(request.getParameter("TotalPage"));
		String Language=request.getParameter("Language");
		String Description=request.getParameter("Description");
		
		Sach sach=new Sach(Id, Name, Price, Image, CategoryId, PublisherId, AuthorId, PublishYear, TotalPage, Language, Description);
		try {
			sachDbUtil.SuaSach(sach);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
	}

}
