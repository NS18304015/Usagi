import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.AddminDelete;
import database.AddminQueryTest;
import java.util.List;


public class AddminServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<UsagiProfile> plist1=getList1();
		List<UsagiProfile> plist2=getList2();
		
		System.out.println("ゲットだよ");
		
		//パラメータをJSPに転送したい。
		req.setAttribute("response",plist1);
		req.setAttribute("thread",plist2);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/addmin");
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	public List<UsagiProfile> getList1(){
		List<UsagiProfile> plist=AddminQueryTest.getAddminResQueryList();
		
		return plist;
	}
	
	public List<UsagiProfile> getList2(){
		List<UsagiProfile> plist=AddminQueryTest.getAddminThreadQueryList();
		
		return plist;
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//パラメータを受け取りたい
		req.setCharacterEncoding("Windows-31J");
		
		//データベースに値を送る
		//resnumがnullのときとそうでないときで分岐
		if(req.getParameter("resnum") == null){
			//空処理
		}else{
			int resnum=Integer.parseInt(req.getParameter("resnum"));
			database.AddminDelete.DeleteResponseTable(resnum);
		}
		
		//threadnumがnullのときとそうでないときで分岐
		if(req.getParameter("threadnum") == null){
			//空処理
		}else{
			int threadnum=Integer.parseInt(req.getParameter("threadnum"));
			System.out.println(threadnum);
			database.AddminDelete.DeleteThreadTable(threadnum);
		}
		
		
		//データベースからリストをもらいたい
		List<UsagiProfile> plist1=getList1();
		List<UsagiProfile> plist2=getList2();
		
		//パラメータをJSPに転送したい。
		req.setAttribute("response",plist1);
		req.setAttribute("thread",plist2);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/addmin");
		
		//JSPに転送
		dis.forward(req,res);
	}
}