package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.UsagiProfile;

public class ThreadNewQueryTest{
	/*public static void main(String[] args){
		IndexNewInsertTest.insertUser_Table(args[0],args[1]);
	}*/
	
	public static List<UsagiProfile> getQueryList(String Tno){
		
		List<UsagiProfile> userList = new ArrayList<UsagiProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql_1="select response_serialno,response_username,response_contents,response_rating,thread_name,thread_table.thread_no from response_table join thread_table on response_table.thread_no=thread_table.thread_no where thread_table.thread_no='"+Tno+"'";
			//String sql_1="select Thread_Name,Thread_Time,Response_Contents from THREAD_TABLE natural join Response_TABLE order by Thread_Time desc";
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
				UsagiProfile prof = new UsagiProfile();
				
				String serialno = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String name = rs.getString(2);	//1��ڂ̃f�[�^���擾
				String contents = rs.getString(3);	//2��ڂ̃f�[�^���擾
				String rating = rs.getString(4);	//2��ڂ̃f�[�^���擾
				String title = rs.getString(5);
				prof.setSerialno(serialno);
				prof.setName(name);
				prof.setContents(contents);
				prof.setRating(rating);
				prof.setTitle(title);
				
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				//System.out.println(name+"\t"+pass);				//�m�F���̂Q
			}

			
			//Oracle����ؒf����
			cn.close();
			
			System.out.println(Tno);

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
