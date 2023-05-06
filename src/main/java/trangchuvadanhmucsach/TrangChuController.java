package trangchuvadanhmucsach;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/TrangChuController")
public class TrangChuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SachDbUtil sachDbutil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public TrangChuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			sachDbutil =new SachDbUtil(dataSource);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listSach(request,response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	private void listSach(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Lấy Sách từ SachDbUtil
		List<Sach> nsach=sachDbutil.getSach(1);
		
//		PrintWriter out=response.getWriter();
//		
//		for(Sach s: nsach) {
//			out.println(s.getName());
//			out.println(s.getPrice());
//			
//			
//		}
//		String tenservlet="TrangChuController";
//		request.setAttribute("tenservlet", tenservlet);//đẩy tên trang servlet lên trang chủ
		request.setAttribute("book_list", nsach);
		RequestDispatcher dispatcher=request.getRequestDispatcher("TrangChu.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
