import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
//import database.ThreadNewInsertTest;
import database.ThreadNewQueryTest;
import database.ThreadUpdate;
import java.util.List;


public class ThreadNewServlet extends HttpServlet{
	
	String tno;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい
		
		req.setCharacterEncoding("Windows-31J");
		
		tno=req.getParameter("tno");
		
		
		
		System.out.println(tno);
		List<UsagiProfile> plist=ThreadNewQueryTest.getQueryList(tno);
		
		//パラメータをJSPに転送したい。
		req.setAttribute("tno",tno);
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		System.out.println(tno);
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	
	
	
	
	
	
	
}