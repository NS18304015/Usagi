package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.IndexProfile;

public class IndexOldQueryTest{
	
	public static void main(String[] args){
		
		List<IndexProfile> al = getQueryList();
		System.out.println("title      time		response"); //���o��

		for(int i = 0; i < al.size();i++){
			IndexProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getTime()+"\t"+prof.getContents());
		
		}
	
	
	}
	
	public static List<IndexProfile> getQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql_1="select Thread_Name,Thread_Time,Response_Contents from THREAD_TABLE natural join RESPONSE_TABLE order by Thread_Time asc";
			//String sql_2="select Response_Contents from Response_TABLE";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql_1);	//rs1��THREAD_TABALE
			//ResultSet rs2=st.executeQuery(sql_2);	//rs1��RESPONSE_TABALE

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String time = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String contents = rs.getString(3);	//2��ڂ̃f�[�^���擾
				prof.setTitle(title);
				prof.setTime(time);
				prof.setContents(contents);
				
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				//System.out.println(name+"\t"+pass);				//�m�F���̂Q
			}

			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
		
	}
}











