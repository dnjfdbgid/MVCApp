package mvc.exam3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * String cmd = req.getParameter("command"); 
		 * String nextPage = "";
		 * 
		 * CommandFactory factory = CommandFactory.getInstance(); ICommand iCmd
		 * = factory.createCommand(cmd);
		 * 
		 * nextPage = (String) iCmd.processCommand(req, resp); RequestDispatcher
		 * view = req.getRequestDispatcher(nextPage); view.forward(req, resp);
		 */

		String cmd = req.getParameter("command");
		String nextPage = "";

		HttpSession session = req.getSession();
		String current = (String) session.getAttribute("currentState");
		//System.out.println(current);

		if (current != null && current.equals("COMPLETE")) {
			nextPage = "/exam3/alreadyRegister.jsp";
		} else {
			CommandFactory factory = CommandFactory.getInstance();
			ICommand iCmd = factory.createCommand(cmd);

			nextPage = (String) iCmd.processCommand(req, resp);
		}

		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
}
