import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
//import database.IndexInsertTest;
import database.IndexGoodQueryTest;
import java.util.List;


public class IndexGoodServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<UsagiProfile> plist=getList();
		
		//パラメータをJSPに転送したい。
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<UsagiProfile> getList(){
		List<UsagiProfile> plist=IndexGoodQueryTest.getQueryList();
		
		return plist;
	}
}