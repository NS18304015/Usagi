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
	
	String tno;
	String serial;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//�p�����[�^���󂯎�肽��
		
		req.setCharacterEncoding("Windows-31J");
		
		tno=req.getParameter("tno");
		//serial=req.getParameter("serial");
		//ThreadNewQueryTest.getQueryList(tno);
		//�f�[�^�x�[�X�ɏ������݂���
		
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
		
		String name=req.getParameter("name");
		String contents=req.getParameter("contents");
		serial=req.getParameter("serial");
		//tno=req.getParameter("tno");
		
		//�f�[�^�x�[�X�ɏ������݂���
		ThreadNewInsertTest.insertUser_ResponseTable(name,contents,tno,serial);
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