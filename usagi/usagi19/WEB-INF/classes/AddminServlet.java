import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.IndexProfile;
import database.AddminDelete;
import database.AddminQueryTest;
import java.util.List;


class AddminServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<IndexProfile> plist1=getList1();
		List<IndexProfile> plist2=getList2();
		
		//パラメータをJSPに転送したい。
		req.setAttribute("res",plist1);
		req.setAttribute("thread",plist2);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/addminpage");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<IndexProfile> getList1(){
		List<IndexProfile> plist=AddminQueryTest.getAddminResQueryList();
		
		return plist;
	}
	
	public List<IndexProfile> getList2(){
		List<IndexProfile> plist=AddminQueryTest.getAddminThreadQueryList();
		
		return plist;
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//パラメータを受け取りたい
		req.setCharacterEncoding("Windows-31J");
		
		//データベースに値を送る
		//ボタンのname要素の値がresnumかthreadnumかで分岐
		if(req.getParameter("name") == "resnum"){
			int resnum=Integer.parseInt(req.getParameter("resnum"));
			AddminDelete.DeleteResponseTable(resnum);
		}else if(req.getParameter("name") == "threadnum"){
			int threadnum=Integer.parseInt(req.getParameter("threadnum"));
			AddminDelete.DeleteThreadTable(threadnum);
		}
		
		//データベースからリストをもらいたい
		List<IndexProfile> plist1=getList1();
		List<IndexProfile> plist2=getList2();
		
		//パラメータをJSPに転送したい。
		req.setAttribute("res",plist1);
		req.setAttribute("thread",plist2);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/addminpage");
		
		//JSPに転送
		dis.forward(req,res);
	}
}