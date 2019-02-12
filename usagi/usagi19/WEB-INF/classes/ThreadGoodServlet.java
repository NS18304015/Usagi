import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.ThreadProfile;
//import database.IndexInsertTest;
import database.ThreadGoodQueryTest;
import java.util.List;


public class ThreadGoodServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<ThreadProfile> plist=getList();
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<ThreadProfile> getList(){
		List<ThreadProfile> plist=ThreadGoodQueryTest.getThreadGoodQueryList();
		
		
		
		return plist;
	}
}