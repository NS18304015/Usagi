package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddminDelete{
	public static void main(String[] args){
		AddminDelete.DeleteResponseTable(1);
	}
	
	public static void DeleteTest(String sql){
		try{
			//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X��Ԃ�
			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			
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
			System.out.println("�f���[�g������");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void DeleteResponseTable(int resnum){
		String sql="delete from RESPONSE_TABLE where Response_No = "+resnum;
		
		DeleteTest(sql);
	}
	public static void DeleteThreadTable(int threadnum){
		String sql1="delete from RESPONSE_TABLE where Thread_No = "+ threadnum;
		String sql2="delete from THREAD_TABLE where Thread_No = "+threadnum;
		DeleteTest(sql1);
		DeleteTest(sql2);
	}
}

