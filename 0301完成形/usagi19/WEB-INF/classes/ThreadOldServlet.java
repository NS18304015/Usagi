import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.ThreadOldInsertTest;
import database.ThreadOldQueryTest;
import database.ThreadUpdate;
import java.util.List;


public class ThreadOldServlet extends HttpServlet{
	
	String tno;
	String today;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//パラメータを受け取りたい
		
		req.setCharacterEncoding("Windows-31J");
		
		tno=req.getParameter("tno");
		
		//serial=req.getParameter("serial");
		//ThreadOldQueryTest.getQueryList(tno);
		
		System.out.println(tno);
		List<UsagiProfile> plist=ThreadOldQueryTest.getQueryList(tno);
		
		//パラメータをJSPに転送したい。
		
		req.setAttribute("tno",tno);
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		System.out.println(tno);
		
		//JSPに転送
		dis.forward(req,res);
	}
	
	
	
	
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//パラメータを受け取りたい
		req.setCharacterEncoding("Windows-31J");
		
		if(req.getParameter("name") == null){
		}else{
			String name=req.getParameter("name");
			String contents=req.getParameter("contents");
			String serial=req.getParameter("serial");
			today=req.getParameter("today");
			
			String n="";
			
			if(name.indexOf("\r\n")>=0){
				n=name.replace("\r\n","<br>");
				System.out.println(n+"aaaa");
			}else{
				n=name;
			}
			
			
			String c="";
			
			if(contents.indexOf("\r\n")>=0){
				c=contents.replace("\r\n","<br>");
				System.out.println(c+"aaaa");
			}else{
				c=contents;
			}
			
			//データベースに書き込みたい
			ThreadOldInsertTest.insertUser_ResponseTable(n,c,tno,serial,today);
		}
		
		
		
		//ratingがnullのときとそうでないときで分岐
		if(req.getParameter("rating") == null){
			//空処理
		}else{
			String rating=req.getParameter("rating");
			System.out.println("サーブレット"+rating);
			database.ThreadUpdate.UpdateRating(rating);
		}
		
		//reportがnullのときとそうでないときで分岐
		if(req.getParameter("report") == null){
			//空処理
		}else{
			String report=req.getParameter("report");
			System.out.println("サーブレット"+report);
			database.ThreadUpdate.UpdateReport(report);
		}
		
		
		//データベースからリストをもらいたい
		/*List<UsagiProfile> plist=getList();*/
		List<UsagiProfile> plist=ThreadOldQueryTest.getQueryList(tno);
		//パラメータをJSPに転送したい。
		req.setAttribute("tno",tno);
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		//JSPに転送
		dis.forward(req,res);
	}
}