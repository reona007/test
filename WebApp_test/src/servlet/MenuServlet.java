package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MenuServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//ログインしてるか確認するためスコープからユーザー情報取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("user");

		if (user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html/");
			dispatcher.forward(request, response);

		} else {//ログインしている場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
			dispatcher.forward(request, response);
		}
	}

}
