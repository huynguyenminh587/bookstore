package giohang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	//trang này để kiểm tra và thêm sô lượng,giá item
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		
		int price=Integer.parseInt(request.getParameter("price")) ;
		String tenservlet=request.getParameter("tenservlet");//ý tưởng lấy tên servlet để chuyển đến trang đó đổ dữ liệu lên lại trang jsp hiện tại
//		System.out.println(tenservlet);
		
		String image=request.getParameter("image");
		
//		List<item> cart=new ArrayList<item>();
		HttpSession session=request.getSession();
//		List<item> cart=(List<item>)session.getAttribute("cart");
		List<item> cart=new ArrayList<item>();
		item moi = null;
		item cu = null;
	    boolean kt=true;
	    boolean kt2=true;
	    int j=0;
		if(session.getAttribute("cart")==null) { //trường hợp chưa có session
			moi=new item(name, price, image, 1);
			cart.add(moi);
			session.setAttribute("cart", cart);
			kt2=false;
			
		}
		else {
			for(item p :(List<item>)session.getAttribute("cart") ) { //trường hợp có session , kt xem có trong session chưa
				if(p.getName().equals(name)) {
					int i=p.getQuantity()+1;
					int y=p.getPrice()+p.getPrice()/p.getQuantity();
//					System.out.println(y);
					cu =p;
					moi=new item(p.getName(), y, p.getImage(), i);
					kt=false;
					
				}
			}
		
		}
		if(kt&&kt2) { 
			cart=(List<item>)session.getAttribute("cart");//khong có item trùng
			moi=new item(name, price, image, 1);
			cart.add(moi);
			session.setAttribute("cart", cart);
		}
		else if(kt2) {
			cart=(List<item>)session.getAttribute("cart");//có item trùng
			Collections.replaceAll(cart, cu, moi);
			session.setAttribute("cart", cart);
		}
		
		response.sendRedirect("GioHang.jsp");
		
	}

}
