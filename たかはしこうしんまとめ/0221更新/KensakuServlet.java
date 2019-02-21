import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.InsertTest;
import database.KensakuQuery;
import java.util.List;


public class KensakuServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		req.setCharacterEncoding("SJIS");

			//POST要求によって送信されたパラメータを取得する
			String title = req.getParameter("title");
			
			List<UsagiProfile> plist=KensakuQuery.getQueryList(title);
			

			//HttpServletRequestの実装クラスのインスタンスに
			//nameという名前とpassという名前でデータを登録する
			req.setAttribute("users",plist);


			//RequestDispatcherインターフェイスを実装するクラスの
			//インスタンスを取得する
			//引数は転送先のURL
			RequestDispatcher dispatcher=
				req.getRequestDispatcher("/kekka");
			
			//転送先に要求を転送する
			dispatcher.forward(req,res);
	}
	
	/*
	public List getList(String title){
		List plist=kensakuQurery.getQueryList(u);
		
		return plist;
	}
	*/
	
}

