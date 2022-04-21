package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Thread;


@WebServlet("/ThreadSearch")
public class ThreadSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ThreadSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String searchResult = (String)request.getParameter("threadNameSearch");
		request.setAttribute("threadNameSearch", searchResult);
		
		//スレッドがないか確認
		ServletContext application = this.getServletContext();
		List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");
		String errorMsg = null;
		if(threadList == null) {
			errorMsg = "スレッドが一つもありません。";
			request.setAttribute("errorMsg", errorMsg);
		}
		
		HttpSession session = request.getSession();
		Account loginUser = (Account)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/threadSearch.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	}

}
