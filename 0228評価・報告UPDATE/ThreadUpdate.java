package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ThreadUpdate{
	public static void main(String[] args){
		ThreadUpdate.UpdateRating("1");
	}
	
	public static void Update(String sql){
		try{
			//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X��Ԃ�
			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			
			//�����R�~�b�g��OFF�ɂ���
			cn.setAutoCommit(false);
			
			System.out.println("�ڑ�����");
			
			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement st=cn.createStatement();
			
			//SQL�����s���g�����U�N�V�������J�n�����B
			st.executeUpdate(sql);
			
			//�g�����U�N�V�������R�~�b�g����
			cn.commit();
			
			//�X�e�[�g�����g���N���[�Y����
			st.close();
			
			//RDBMS����ؒf����
			cn.close();
			
			System.out.println("�ؒf����");
			//System.out.println(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void UpdateRating(String rating){
		String sql="UPDATE RESPONSE_TABLE SET Response_Rating = (SELECT Response_Rating + 1 FROM RESPONSE_TABLE WHERE Response_No = "+ rating +") WHERE Response_No = "+ rating;
		
		Update(sql);
	}
	public static void UpdateReport(String report){
		String sql="UPDATE RESPONSE_TABLE SET Response_Report = (SELECT Response_Report + 1 FROM RESPONSE_TABLE WHERE Response_No = "+ report +") WHERE Response_No = "+ report;
		
		Update(sql);
	}
	
	public static void UpdateThreadReport(String report){
		String sql="UPDATE THREAD_TABLE SET Thread_Report = (SELECT Thread_Report + 1 FROM THREAD_TABLE WHERE Thread_No = "+ report +") WHERE Thread_No = "+ report;
		
		Update(sql);
	}
}

