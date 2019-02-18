import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.IndexProfile;
//import database.IndexInsertTest;
import database.IndexOldQueryTest;
import java.util.List;


public class IndexOldServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<IndexProfile> plist=getList();
		
		//�p�����[�^��JSP�ɓ]���������B
		
		req.setAttribute("users",plist);
		/*for(int i=0; i<plist.size(); i++){
			System.out.println(plist.get(i).i)
		}*/
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/index");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<IndexProfile> getList(){
		List<IndexProfile> plist=IndexOldQueryTest.getQueryList();
		
		
		
		return plist;
	}
}