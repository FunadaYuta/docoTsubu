package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Login() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);
    }
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		//ログイン処理
		//LoginLogic loginLogic = new LoginLogic();
		//boolean isLogin = loginLogic.execute(user);
		
		//リクエストパラメータの取得
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		User user = new User(name,pass);
		
		//ログイン処理の実行
		LoginLogic bo = new LoginLogic();
		Account account = bo.execute(user);
		
		
		//ログイン成功時の処理
		if(account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", account);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);
		}else {
			String errorMsg = "ユーザー名かパスワードが正しくありません";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}
		//ログイン結果画面へフォワード
		
		
	}

}
