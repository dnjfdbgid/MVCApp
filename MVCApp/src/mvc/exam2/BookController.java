package mvc.exam2;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("euc-kr");

		HttpSession session = req.getSession();

		String cmd = req.getParameter("command");
		Vector bookList = (Vector) session.getAttribute("cart");

		if (cmd.equals("chk")) {
			RequestDispatcher view = req
					.getRequestDispatcher("/exam2/checkout.jsp");
			view.forward(req, resp);
		} else {
			if (cmd.equals("add")) {
				if (bookList == null) {
					bookList = new Vector();
				}
				bookList.add(getBook(req));
			} else if (cmd.equals("del")) {
				int idx = Integer.parseInt(req.getParameter("idx"));
				bookList.remove(idx);
			}
			session.setAttribute("cart", bookList);
			RequestDispatcher view = req
					.getRequestDispatcher("/exam2/bookShop.jsp");
			view.forward(req, resp); 
		}

	}

	public BookDto getBook(HttpServletRequest req) {
		String book = req.getParameter("book");
		String qty = req.getParameter("quantity").trim();

		StringTokenizer token = new StringTokenizer(book, "/");
		String title = token.nextToken().trim();
		String author = token.nextToken().trim();
		String price = token.nextToken().trim();

		BookDto dto = new BookDto();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPrice(Integer.parseInt(price));
		dto.setQuantity(Integer.parseInt(qty));

		return dto;
	}
}
