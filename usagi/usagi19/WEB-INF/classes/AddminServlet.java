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
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<IndexProfile> plist1=getList1();
		List<IndexProfile> plist2=getList2();
		
		//�p�����[�^��JSP�ɓ]���������B
		req.setAttribute("res",plist1);
		req.setAttribute("thread",plist2);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/addminpage");
		
		//JSP�ɓ]��
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
		//�p�����[�^���󂯎�肽��
		req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X�ɒl�𑗂�
		//�{�^����name�v�f�̒l��resnum��threadnum���ŕ���
		if(req.getParameter("name") == "resnum"){
			int resnum=Integer.parseInt(req.getParameter("resnum"));
			AddminDelete.DeleteResponseTable(resnum);
		}else if(req.getParameter("name") == "threadnum"){
			int threadnum=Integer.parseInt(req.getParameter("threadnum"));
			AddminDelete.DeleteThreadTable(threadnum);
		}
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<IndexProfile> plist1=getList1();
		List<IndexProfile> plist2=getList2();
		
		//�p�����[�^��JSP�ɓ]���������B
		req.setAttribute("res",plist1);
		req.setAttribute("thread",plist2);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/addminpage");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
}