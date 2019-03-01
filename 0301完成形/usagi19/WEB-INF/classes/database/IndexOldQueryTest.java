package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.UsagiProfile;

public class IndexOldQueryTest{
	
	public static void main(String[] args){
		
		List<UsagiProfile> al = getQueryList();
		System.out.println("title      time		response"); //���o��

		for(int i = 0; i < al.size();i++){
			UsagiProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getName()+"\t"+prof.getContents());
		
		}
	
	
	}
	
	public static List<UsagiProfile> getQueryList(){
		
		List<UsagiProfile> userList = new ArrayList<UsagiProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql_1="select thread_table.thread_no,thread_name,response_username,response_contents,response_time from thread_table join response_table on thread_table.thread_no=response_table.thread_no where response_serialno=1 order by thread_table.thread_no asc";
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
				
				String no = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String title = rs.getString(2);	//1��ڂ̃f�[�^���擾
				String name = rs.getString(3);	//2��ڂ̃f�[�^���擾
				String contents = rs.getString(4);	//2��ڂ̃f�[�^���擾
				String today = rs.getString(5);
				prof.setThreadno(no);
				prof.setTitle(title);
				prof.setName(name);
				prof.setContents(contents);
				prof.setTime(today);
				
				System.out.println(prof);
				
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











