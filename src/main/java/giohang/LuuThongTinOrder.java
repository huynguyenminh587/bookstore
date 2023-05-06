package giohang;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DangKiDangNhap.Account;

/**
 * Servlet implementation class LuuThongTinOrder
 */
@WebServlet("/LuuThongTinOrder")
public class LuuThongTinOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private LuuThongTinOrderDbUtil luuThongTinOrderDbUtil;
    @Resource(name="jdbc/bookshop")
    private DataSource dataSource;
    public LuuThongTinOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		luuThongTinOrderDbUtil = new LuuThongTinOrderDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		List<item> cart=(List<item>)session.getAttribute("cart");
//		System.out.println(cart);
//		System.out.println("1");
		
		
		Account account=(Account)session.getAttribute("account");
		
		
		//tạo đối tương OrderInfo
		int accountId=account.getId();
		int quantity =0;
		int totalPrice=0;
		for (item item : cart) {
			quantity+=item.getQuantity();
			totalPrice+=item.getPrice();
		}
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date date = new Date(System.currentTimeMillis());
		String orderDate =formatter.format(date);
		OrderInfo orderInfo=new OrderInfo(accountId, quantity, totalPrice, orderDate);
		
		try {
			luuThongTinOrderDbUtil.addOrderInfo(orderInfo);

			//lưu thồn tin OrderDetail
			
			OrderInfo orderInfo2 = luuThongTinOrderDbUtil.getOrderInfo(orderInfo);
			int orderId=orderInfo2.getId();
			luuThongTinOrderDbUtil.addOrderDetail(cart, orderId);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.removeAttribute("cart");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
