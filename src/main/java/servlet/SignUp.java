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
import model.SignUpLogic;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String strage = request.getParameter("age");
		
		int age = 0;
		
		//入力確認
		
		//名前
		
		
		
		
		//年齢
		boolean isNumeric =  strage.matches("[+-]?\\d*(\\.\\d+)?");
		if(!isNumeric) {
			String errorMsg = "年齢は数字で入力して下さい";
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
			dispatcher.forward(request, response);
		}else {
			age = Integer.parseInt(strage);
		}
		
		
		Account account = new Account(name,pass,age);
		SignUpLogic bo = new SignUpLogic();
		Account newAccount = bo.execute(account);
		
		if(newAccount != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", account);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);
		}else {
			String errorMsg = "その名前は既に登録されています";
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
			dispatcher.forward(request, response);
		}
		
	
	}

}
