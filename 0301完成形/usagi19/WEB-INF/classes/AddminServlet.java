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
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<UsagiProfile> plist1=getList1();
		List<UsagiProfile> plist2=getList2();
		
		System.out.println("�Q�b�g����");
		
		//�p�����[�^��JSP�ɓ]���������B
		req.setAttribute("response",plist1);
		req.setAttribute("thread",plist2);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/addmin");
		
		//JSP�ɓ]��
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
		//�p�����[�^���󂯎�肽��
		req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X�ɒl�𑗂�
		//resnum��null�̂Ƃ��Ƃ����łȂ��Ƃ��ŕ���
		if(req.getParameter("resnum") == null){
			//�󏈗�
		}else{
			int resnum=Integer.parseInt(req.getParameter("resnum"));
			database.AddminDelete.DeleteResponseTable(resnum);
		}
		
		//threadnum��null�̂Ƃ��Ƃ����łȂ��Ƃ��ŕ���
		if(req.getParameter("threadnum") == null){
			//�󏈗�
		}else{
			int threadnum=Integer.parseInt(req.getParameter("threadnum"));
			System.out.println(threadnum);
			database.AddminDelete.DeleteThreadTable(threadnum);
		}
		
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<UsagiProfile> plist1=getList1();
		List<UsagiProfile> plist2=getList2();
		
		//�p�����[�^��JSP�ɓ]���������B
		req.setAttribute("response",plist1);
		req.setAttribute("thread",plist2);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/addmin");
		
		//JSP�ɓ]��
		dis.forward(req,res);
	}
}