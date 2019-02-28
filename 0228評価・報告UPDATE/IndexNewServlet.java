import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.IndexNewInsertTest;
import database.IndexNewQueryTest;
import java.util.List;


public class IndexNewServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//�p�����[�^���󂯎�肽��
		
		req.setCharacterEncoding("Windows-31J");
		
		if(req.getParameter("name") == null){
		}else{
			String title=req.getParameter("title");
			String name=req.getParameter("name");
			String contents=req.getParameter("contents");
			
			String t="";
			
			if(title.indexOf("\r\n")>=0){
				t=title.replace("\r\n","<br>");
				System.out.println(t+"aaaa");
			}else{
				t=title;
			}
			
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
			
			//�f�[�^�x�[�X�ɏ������݂���
			IndexNewInsertTest.insertUser_ThreadTable(t);
			IndexNewInsertTest.insertUser_ResponseTable(n,c);
		}
		
		
		//report��null�̂Ƃ��Ƃ����łȂ��Ƃ��ŕ���
		if(req.getParameter("report") == null){
			//�󏈗�
		}else{
			String report=req.getParameter("report");
			System.out.println("�T�[�u���b�g"+report);
			database.ThreadUpdate.UpdateThreadReport(report);
		}
		
		
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<UsagiProfile> plist=getList();
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<UsagiProfile> plist=getList();
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<UsagiProfile> getList(){
		List<UsagiProfile> plist=IndexNewQueryTest.getQueryList();
		
		return plist;
	}
}