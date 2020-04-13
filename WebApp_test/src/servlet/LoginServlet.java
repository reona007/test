package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConnectionManager;
import model.UserBean;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String name= request.getParameter("id");
		String pass= request.getParameter("pass");

		UserBean user =new UserBean(name,pass);


		ConnectionManager mana=new ConnectionManager();
		boolean islogin =mana.ninsyo(user);

		if(islogin) {
			HttpSession session =request.getSession();
			session.setAttribute("loginUser", user);

		}else {
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/login-failure.html");
		dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);
	}
}