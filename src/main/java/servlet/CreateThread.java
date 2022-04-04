package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.NowDateLogic;
import model.PostMutterLogic;
import model.PostThreadLogic;
import model.Thread;
import model.User;

@WebServlet("/CreateThread")
public class CreateThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateThread() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
				
		if(loginUser == null) {
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createThread.jsp");
			dispatcher.forward(request, response);
					
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String threadName = request.getParameter("threadName");
		String text = request.getParameter("text");
		
		//入力値チェック
		if(threadName != null && threadName.length() != 0 && text != null && text.length() != 0) {
			
			ServletContext application = this.getServletContext();
			List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");	
			if(threadList == null) {
				threadList= new ArrayList<Thread>();
			}
//			List<Thread> threadList = new ArrayList<Thread>();
			
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			
			//現在の時間を取得
			NowDateLogic nowDate = new NowDateLogic();
			String date = nowDate.execute();
			
			//つぶやきをつぶやきリストに追加する
			Mutter mutter = new Mutter(loginUser.getName(),text,date);
			List<Mutter> mutterList = new ArrayList<Mutter>();
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			
			Thread thread = new Thread(threadName,mutterList);
			
			//スレッドをリストに追加する
			PostThreadLogic postThreadLogic = new PostThreadLogic();
			postThreadLogic.execute(thread, threadList);
			
			application.setAttribute("threadList", threadList);
			
			//メニュー画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createThread.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

}
