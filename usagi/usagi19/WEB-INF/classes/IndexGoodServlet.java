import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.IndexProfile;
//import database.IndexInsertTest;
import database.IndexGoodQueryTest;
import java.util.List;


class IndexServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<IndexProfile> plist=getList();
		
		//パラメータをJSPに転送したい。
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<IndexProfile> getList(){
		List<IndexProfile> plist=IndexGoodQueryTest.getQueryList();
		
		return plist;
	}
}