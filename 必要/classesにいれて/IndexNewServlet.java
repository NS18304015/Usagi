import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.IndexProfile;
import database.IndexNewInsertTest;
import database.IndexNewQueryTest;
import java.util.List;


public class IndexNewServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい
		
		req.setCharacterEncoding("Windows-31J");
		
		String title=req.getParameter("title");
		String name=req.getParameter("name");
		String contents=req.getParameter("contents");
		
		//データベースに書き込みたい
		IndexNewInsertTest.insertUser_ThreadTable(title);
		IndexNewInsertTest.insertUser_ResponseTable(name,contents);
		//データベースからリストをもらいたい
		List<IndexProfile> plist=getList();
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSPに転送
		dis.forward(req,res);
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<IndexProfile> plist=getList();
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<IndexProfile> getList(){
		List<IndexProfile> plist=IndexNewQueryTest.getQueryList();
		
		return plist;
	}
}