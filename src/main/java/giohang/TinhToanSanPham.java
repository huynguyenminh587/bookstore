package giohang;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TinhToanSanPham
 */
@WebServlet("/TinhToanSanPham")
public class TinhToanSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinhToanSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<item> cart=(List<item>)session.getAttribute("cart");
		String tensp=request.getParameter("tensp");
//		System.out.println(tensp);
		String pheptinh=request.getParameter("action");
		int soluong=Integer.parseInt(request.getParameter("soluong"));
		item itemcu = null;
		item itemmoi = null;
		
		switch (pheptinh) {
		case "+":
			for(item p :cart){
				System.out.println(1);
				if(p.getName().equals(tensp)) {
					System.out.println(1);
					int i=p.getQuantity()+1;
					int y=p.getPrice()+p.getPrice()/p.getQuantity();
					itemcu=p;
					itemmoi=new item(p.getName(), y, p.getImage(), i);
				}
				
			}
//			cart.remove(itemcu);
//			cart.add(itemmoi); thử thay bằng replaceall để không thay đổi vị trí trong mảng=>hiển thị thứ tự trang jsp ko thay đổi
			Collections.replaceAll(cart, itemcu, itemmoi);
			session.setAttribute("cart", cart);
			break;
		case "-":
			if(soluong==1) {
				for(item p:cart) {
					if(p.getName().equals(tensp)) {
						itemcu=p;
						
					}
				}
				cart.remove(itemcu);
				session.setAttribute("cart", cart);
			}
			else {
				for(item p:cart) {
					if(p.getName().equals(tensp)) {
						int i=p.getQuantity()-1;
						int y=p.getPrice()-p.getPrice()/p.getQuantity();
						itemcu=p;
						itemmoi=new item(p.getName(), y, p.getImage(), i);
					}
				}
				Collections.replaceAll(cart, itemcu, itemmoi);
				session.setAttribute("cart", cart);
				
			}
			
			break;

		case "xóa":
			for(item p:cart) {
				if(p.getName().equals(tensp)) {
					
					itemcu=p;
				}
			}
			cart.remove(itemcu);
			session.setAttribute("cart", cart);
		}
		response.sendRedirect("GioHang.jsp");
	}

}
