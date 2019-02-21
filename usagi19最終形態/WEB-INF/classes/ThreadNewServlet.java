import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.ThreadNewInsertTest;
import database.ThreadNewQueryTest;
import java.util.List;


public class ThreadNewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい
		
		req.setCharacterEncoding("Windows-31J");
		
		String tno=req.getParameter("tno");	
		//ThreadNewQueryTest.getQueryList(tno);
		//データベースに書き込みたい
		List<UsagiProfile> plist=ThreadNewQueryTest.getQueryList(tno);
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		//JSPに転送
		dis.forward(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい
		
		req.setCharacterEncoding("Windows-31J");
		
		String name=req.getParameter("name");
		String contents=req.getParameter("contents");
		String tno=req.getParameter("tno");
		
		//データベースに書き込みたい
		ThreadNewInsertTest.insertUser_ResponseTable(name,contents,tno);
		//データベースからリストをもらいたい
		/*List<UsagiProfile> plist=getList();*/
		List<UsagiProfile> plist=ThreadNewQueryTest.getQueryList(tno);
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		//JSPに転送
		dis.forward(req,res);
	}
}