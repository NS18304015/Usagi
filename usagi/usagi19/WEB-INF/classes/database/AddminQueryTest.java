package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.IndexProfile;

public class AddminQueryTest{
	
	public static void main(String[] args){
		
		List<IndexProfile> al = getAddminResQueryList();
		System.out.println("username      password"); //���o��

		for(int i = 0; i < al.size();i++){
			IndexProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getName());
		
		}
	
	
	}
	
	//���X�|���X�\����f�[�^���擾
	public static List<IndexProfile> getAddminResQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			String sql="select Thread_Name,Response_UserName,Response_Time,Response_Contents,Response_Report,Response_No from THREAD_TABLE natural join RESPONSE_TABLE where Response_Report >= 1";
			
			
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String name = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String restime = rs.getString(3);
				String contents = rs.getString(4);
				int resreport = rs.getInt(5);
				int resno = rs.getInt(6);
				prof.setTitle(title);
				prof.setName(name);
				prof.setRestime(restime);
				prof.setContents(contents);
				prof.setResreport(resreport);
				prof.setResno(resno);
				
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
	
	
	
	//�X���b�h�\����f�[�^���擾
	public static List<IndexProfile> getAddminThreadQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			String sql="select Thread_Name,Thread_Time,Thread_Report from THREAD_TABLE where Response_Report >= 1";
			
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String time = rs.getString(2);	//2��ڂ̃f�[�^���擾
				int threadreport = rs.getInt(3);
				prof.setTitle(title);
				prof.setTime(time);
				prof.setThreadreport(threadreport);
				
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











