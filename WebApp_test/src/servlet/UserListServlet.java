package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserDAO;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//ユーザー一覧情報を取得して、リクエストスコープに保存
		UserDAO dao = new UserDAO();
		List<UserBean> userList = dao.findAll();
		request.setAttribute("userList", userList);

		//ログイン可否確認のため、セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("user");

		if(user == null) { //ログインしてない場合,ログイン画面にリダイレクト
			response.sendRedirect("/login.html/");
		}else { //ログインしている場合、一覧表示のuser-list.jspにフォワード
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/user-list.jsp");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		//セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		UserBean user = (UserBean)session.getAttribute("user");

		//ユーザー一覧情報を取得して、リクエストスコープに保存
		UserDAO dao = new UserDAO();
		List<UserBean> userList = dao.findAll();
		request.setAttribute("userList", userList);

		//一覧表示のuser-list.jspにフォワード
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/user-list.jsp");
		dis.forward(request, response);
	}

}
