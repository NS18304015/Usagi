import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.UsagiProfile;
import database.InsertTest;
import database.KensakuQuery;
import java.util.List;


public class KensakuServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		req.setCharacterEncoding("SJIS");

			//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
			String title = req.getParameter("title");
			
			List<UsagiProfile> plist=KensakuQuery.getQueryList(title);
			

			//HttpServletRequest�̎����N���X�̃C���X�^���X��
			//name�Ƃ������O��pass�Ƃ������O�Ńf�[�^��o�^����
			req.setAttribute("users",plist);


			//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			//�����͓]�����URL
			RequestDispatcher dispatcher=
				req.getRequestDispatcher("/kekka");
			
			//�]����ɗv����]������
			dispatcher.forward(req,res);
	}
	
	/*
	public List getList(String title){
		List plist=kensakuQurery.getQueryList(u);
		
		return plist;
	}
	*/
	
}

