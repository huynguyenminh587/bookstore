package thongtintaikhoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DangKiDangNhap.Account;

/**
 * Servlet implementation class KiemTraMatKhauCu
 */
@WebServlet("/KiemTraMatKhauCu")
public class KiemTraMatKhauCu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KiemTraMatKhauCu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
 //		PrintWriter out=response.getWriter();
//		out.println("Hello");
//		response.getWriter().append("Huy").append(request.getContextPath());
        String password=request.getParameter("password");
        System.out.println(password);
        
        HttpSession session=request.getSession();
        Account account=(Account)session.getAttribute("account");
        System.out.println(account);
        String password1=account.getPassWord();
        
        if(password1.equals(password)) {
        	response.getWriter().append("true");
        }else {
        	response.getWriter().append("false");
        }
    	
		

	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
////		response.getWriter().append("Huy");
//		PrintWriter out=response.getWriter();
//		out.println("Hello");
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
