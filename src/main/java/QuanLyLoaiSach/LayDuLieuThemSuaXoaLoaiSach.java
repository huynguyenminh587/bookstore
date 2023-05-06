package QuanLyLoaiSach;

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
 * Servlet implementation class LayDuLieuThemSuaXoaLoaiSach
 */
@WebServlet("/LayDuLieuThemSuaXoaLoaiSach")
public class LayDuLieuThemSuaXoaLoaiSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BookCategoryDbUtil bookCategoryDbUtil;
    
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public LayDuLieuThemSuaXoaLoaiSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		bookCategoryDbUtil =new BookCategoryDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten="laydulieu";
		if(request.getParameter("ten")!=null){
			
			ten=request.getParameter("ten");
		}
		switch (ten) {
		case "laydulieu":
			List<BookCategory> bookCategories = null;
			try {
				 bookCategories= bookCategoryDbUtil.getBookCategory();
				 request.setAttribute("BookCategory", bookCategories);
				 RequestDispatcher dispatcher=request.getRequestDispatcher("TrangQuanTriVien/QuanLyLoaiSach/QuanLyLoaiSach.jsp");
			     dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;

		case "them":
			
			
			String Name=request.getParameter("Name");
			BookCategory bookCategory=new BookCategory(Name);
			try {
				
				bookCategoryDbUtil.ThemLoaiSach(bookCategory);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;
		case "sua":
			int Id=Integer.parseInt(request.getParameter("Id"));
			String Name1=request.getParameter("Name");
			BookCategory bookCategory1=new BookCategory(Id, Name1);
			try {
				bookCategoryDbUtil.SuaThongTinLoaiSach(bookCategory1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;
		case "xoa":
			int Id1=Integer.parseInt(request.getParameter("Id"));
			try {
				bookCategoryDbUtil.XoaLoaiSach(Id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("TrangQuanTriVien/QuanTriVien.jsp");
			break;
		}
		
	}

}
