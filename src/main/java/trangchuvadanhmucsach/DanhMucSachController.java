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


@WebServlet("/DanhMucSachController")
public class DanhMucSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SachDbUtil sachDbutil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public DanhMucSachController() {
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
		int danhmucsach=Integer.parseInt(request.getParameter("param")) ;
				
		//Lấy Sách từ SachDbUtil
		List<Sach> nsach=sachDbutil.getSach(danhmucsach);
		
//		PrintWriter out=response.getWriter();
//		
//		for(Sach s: nsach) {
//			out.println(s.getName());
//			out.println(s.getPrice());
//			
//			
//		}
//		System.out.println(danhmucsach);
		request.setAttribute("book_list", nsach);
		 switch (danhmucsach){
		 case 2:
			 RequestDispatcher dispatcher=request.getRequestDispatcher("SachKyNang.jsp");
			 dispatcher.forward(request, response);
			 break;
		 case 3:
			 RequestDispatcher dispatcher1=request.getRequestDispatcher("SachQuanLyKinhDoanh.jsp");
			 dispatcher1.forward(request, response);
		 case 4:
			 RequestDispatcher dispatcher2=request.getRequestDispatcher("SachKienThucBachKhoa.jsp");
			 dispatcher2.forward(request, response);
		default:
			RequestDispatcher dispatcher3=request.getRequestDispatcher("SachTinhYeu.jsp");
			 dispatcher3.forward(request, response);
		
		 }
		
		
		
		
		
	}

}
