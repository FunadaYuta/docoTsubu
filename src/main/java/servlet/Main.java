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

import model.Mutter;
import model.NowDateLogic;
import model.PostMutterLogic;
import model.Thread;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strIndex = request.getParameter("index");
		int index = Integer.parseInt(strIndex);
		HttpSession session = request.getSession();
		session.setAttribute("index", index);
		
		//つぶやきリストをアプリケーションスコープから取得
//		ServletContext application = this.getServletContext();
//		List<Mutter> mutterList = 
//				(List<Mutter>)application.getAttribute("mutterList");
		
		//取得出来なかった場合時は、つぶやきリストを新規作成して
		//アプリケーションスコープに保存
//		if(mutterList == null) {
//			mutterList = new ArrayList<>();
//			application.setAttribute("mutterList", mutterList);
//		}
		
		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
//		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
					
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力値チェック
		if(text != null && text.length() != 0) {
			ServletContext application = this.getServletContext();
//			List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");	
			List<Thread> threadList = (List<Thread>)application.getAttribute("threadList");
		
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			int index = (int)session.getAttribute("index");
		
			//現在の時間を取得
			NowDateLogic nowDate = new NowDateLogic();
			String date = nowDate.execute();
			
			//つぶやきをつぶやきリストに追加
			List<Mutter> mutterList = threadList.get(index).getMutterList();
			Mutter mutter = new Mutter(loginUser.getName(),text,date);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
		
			application.setAttribute("mutterList", mutterList);
		
		}else {
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
	

}
