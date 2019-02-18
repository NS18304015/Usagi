import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.IndexProfile;
import database.IndexNewInsertTest;
import database.IndexNewQueryTest;
import java.util.List;


public class IndexNewServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	//�p�����[�^���󂯎�肽��
		
		req.setCharacterEncoding("Windows-31J");
		
		String title=req.getParameter("title");
		String name=req.getParameter("name");
		String contents=req.getParameter("contents");
		
		//�f�[�^�x�[�X�ɏ������݂���
		IndexNewInsertTest.insertUser_ThreadTable(title);
		IndexNewInsertTest.insertUser_ResponseTable(name,contents);
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<IndexProfile> plist=getList();
		
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
		List<IndexProfile> plist=getList();
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<IndexProfile> getList(){
		List<IndexProfile> plist=IndexNewQueryTest.getQueryList();
		
		return plist;
	}
}