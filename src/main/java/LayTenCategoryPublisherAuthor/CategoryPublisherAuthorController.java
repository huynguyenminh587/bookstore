package LayTenCategoryPublisherAuthor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

import QuanLyLoaiSach.BookCategory;
import QuanLyNhaXuatBan.Publisher;
import QuanLyTacGia.TacGia;

/**
 * Servlet implementation class CategoryPublisherAuthorController
 */
@WebServlet("/CategoryPublisherAuthorController")
public class CategoryPublisherAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private CategoryPublisherAuthorDbUtil categoryPublisherAuthorDbUtil;
    
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public CategoryPublisherAuthorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		categoryPublisherAuthorDbUtil=new CategoryPublisherAuthorDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookCategory> name=new ArrayList<BookCategory>();
		List<Publisher> name1=new ArrayList<Publisher>();
		List<TacGia> name2=new ArrayList<TacGia>();
		try {
			 name=categoryPublisherAuthorDbUtil.CategoryName();
			 name1=categoryPublisherAuthorDbUtil.NamePublisher();
			 name2=categoryPublisherAuthorDbUtil.NameAuthor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(BookCategory a:name) {
//			System.out.println(a.getId()+" "+a.getName());
//		}
//		System.out.println();
//		for(Publisher a:name1) {
//			System.out.println(a.getId()+" "+a.getNamePublisher());
//		}
//		System.out.println();
//		for(TacGia a:name2) {
//			System.out.println(a.getId()+" "+a.getNameAuthor());
//		}
		request.setAttribute("categoryName", name);
		request.setAttribute("publisherName", name1);
		request.setAttribute("authorName", name2);
		if(request.getParameter("Name")!=null) {
			RequestDispatcher dispatcher =request.getRequestDispatcher("TrangQuanTriVien/SuaSach.jsp");
			dispatcher.forward(request, response);
		}
		else {
		RequestDispatcher dispatcher =request.getRequestDispatcher("TrangQuanTriVien/ThemSach.jsp");
		dispatcher.forward(request, response);
		}
	}

}
