package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IndexNewInsertTest{
	/*public static void main(String[] args){
		IndexNewInsertTest.insertUser_Table(args[0],args[1]);
	}*/
	
	public static int insertUser_ThreadTable(String Title){
		int count = 0; //���������s�������邽�߂̕ϐ�
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
			
			//SQL����ϐ��Ɋi�[����
			String sql="insert into THREAD_TABLE(Thread_No,Thread_Name,Thread_Report) values(TEST_SEQ_A.nextval,'"+Title+"',1)";
			
			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement st=cn.createStatement();
			
			//SQL�����s���g�����U�N�V�������J�n�����B�����������Ԃ����
			count=st.executeUpdate(sql);
			
			System.out.println(count+"����������");
			
			//�g�����U�N�V�������R�~�b�g����
			cn.commit();
			
			//�X�e�[�g�����g���N���[�Y����
			st.close();
			
			//RDBMS����ؒf����
			cn.close();
			
			System.out.println("�ؒf����");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public static int insertUser_ResponseTable(String Name,String Contents){
		int count = 0; //���������s�������邽�߂̕ϐ�
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
			
			//SQL����ϐ��Ɋi�[����
			String sql="insert into RESPONSE_TABLE values(TEST_SEQ_B.nextval,1,'"+Name+"','"+Contents+"','11',TEST_SEQ_C.nextval,1,1,1)";
			
			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement st=cn.createStatement();
			
			//SQL�����s���g�����U�N�V�������J�n�����B�����������Ԃ����
			count=st.executeUpdate(sql);
			
			System.out.println(count+"����������");
			
			//�g�����U�N�V�������R�~�b�g����
			cn.commit();
			
			//�X�e�[�g�����g���N���[�Y����
			st.close();
			
			//RDBMS����ؒf����
			cn.close();
			
			System.out.println("�ؒf����");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
}

