import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.Profile;
import database.InsertTest;
import database.QueryTest;
import java.util.List;


public class KamataServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい!
		
		req.setCharacterEncoding("Windows-31J");
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		//データベースに書き込みたい
		InsertTest.insertUser_Table(name,pass);
		
		//データベースからリストをもらいたい
		List<Profile> plist=getList();
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<Profile> plist=getList();
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<Profile> getList(){
		List<Profile> plist=QueryTest.getQueryList();
		
		
		
		return plist;
	}
}