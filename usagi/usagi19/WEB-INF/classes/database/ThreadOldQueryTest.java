package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.ThreadProfile;

public class ThreadOldQueryTest{
	
	public static void main(String[] args){
		
		List<ThreadProfile> al = getThreadOldQueryList();

		for(int i = 0; i < al.size();i++){
			ThreadProfile prof = al.get(i);
			System.out.println(prof.getSerialno()+"\t"+prof.getUsername()+"\t"+prof.getTime()+"\t"+prof.getContents()+"\t"+prof.getRating());
		
		}
	
	
	}
	
	public static List<ThreadProfile> getThreadOldQueryList(){
		
		List<ThreadProfile> userList = new ArrayList<ThreadProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql_1="select Response_SerialNo,Response_UserName,Response_Time,Response_Contents,Response_Rating from RESPONSE_TABLE order by Thread_Time asc";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql_1);	//RESPONSE_TABLE

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ThreadProfile prof = new ThreadProfile();
				
				String serialno = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String username = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String time = rs.getString(3);		//3��ڂ̃f�[�^���擾
				String contents = rs.getString(4);	//4��ڂ̃f�[�^���擾
				String rating = rs.getString(5);	//5��ڂ̃f�[�^���擾
				prof.setSerialno(serialno);
				prof.setUsername(username);
				prof.setTime(time);
				prof.setContents(contents);
				prof.setRating(rating);
				
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











