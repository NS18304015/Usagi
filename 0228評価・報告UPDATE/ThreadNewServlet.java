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
import database.ThreadUpdate;
import java.util.List;


public class ThreadNewServlet extends HttpServlet{
	
	String tno;
	String serial;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//�p�����[�^���󂯎�肽��
		
		req.setCharacterEncoding("Windows-31J");
		
		tno=req.getParameter("tno");
		//serial=req.getParameter("serial");
		//ThreadNewQueryTest.getQueryList(tno);
		
		System.out.println(tno);
		List<UsagiProfile> plist=ThreadNewQueryTest.getQueryList(tno);
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		System.out.println(tno+serial);
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	
	
	
	
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�p�����[�^���󂯎�肽��
		req.setCharacterEncoding("Windows-31J");
		
		if(req.getParameter("name") == null){
		}else{
			String name=req.getParameter("name");
			String contents=req.getParameter("contents");
			serial=req.getParameter("serial");
			
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
			ThreadNewInsertTest.insertUser_ResponseTable(n,c,tno,serial);
		}
		
		
		
		//rating��null�̂Ƃ��Ƃ����łȂ��Ƃ��ŕ���
		if(req.getParameter("rating") == null){
			//�󏈗�
		}else{
			String rating=req.getParameter("rating");
			System.out.println("�T�[�u���b�g"+rating);
			database.ThreadUpdate.UpdateRating(rating);
		}
		
		//report��null�̂Ƃ��Ƃ����łȂ��Ƃ��ŕ���
		if(req.getParameter("report") == null){
			//�󏈗�
		}else{
			String report=req.getParameter("report");
			System.out.println("�T�[�u���b�g"+report);
			database.ThreadUpdate.UpdateReport(report);
		}
		
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		/*List<UsagiProfile> plist=getList();*/
		List<UsagiProfile> plist=ThreadNewQueryTest.getQueryList(tno);
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/thread");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
}