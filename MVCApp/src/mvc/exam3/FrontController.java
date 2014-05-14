package mvc.exam3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String cmd = req.getParameter("command");
		String nextPage = "";

		if (cmd.equals("MAIN")) {
			nextPage = "/exam3/index.jsp";
		} else if (cmd.equals("REGFORM")) {
			nextPage = "/exam3/regForm.html";
		} else if (cmd.equals("REGCONFIRM")) {
			//입력값 확인
			//입력값이 잘못되었을 경우 해당 페이지 에러페이지로 이동
			nextPage = "/exam3/regConfirm.jsp";
		} else if (cmd.equals("REGCOMPLETE")) {
			// DB 연동 데이터 저장
			nextPage = "/exam3/regComplete.jsp";
		}else{
			// 정상적인 요청이 아닌 것에 대해 예외 처리
		}
		RequestDispatcher view = req.getRequestDispatcher(nextPage);
		view.forward(req, resp);
	}
}
