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
		List<UsagiProfile> plist=IndexGoodQueryTest.getQueryList();
		
		return plist;
	}
}