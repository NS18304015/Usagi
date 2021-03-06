package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.UsagiProfile;

public class ThreadOldQueryTest{
	/*public static void main(String[] args){
		IndexOldInsertTest.insertUser_Table(args[0],args[1]);
	}*/
	
	UsagiProfile proftwo;
	
	
	public static List<UsagiProfile> getQueryList(String Tno){
		
		List<UsagiProfile> userList = new ArrayList<UsagiProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("接続完了");
			
			//select文
			String sql_1="select response_serialno,response_username,response_contents,response_rating,thread_name,response_no,thread_table.thread_no,response_time from response_table join thread_table on response_table.thread_no=thread_table.thread_no where thread_table.thread_no='"+Tno+"' order by response_serialno asc";
			//String sql_1="select Thread_Name,Thread_Time,Response_Contents from THREAD_TABLE natural join Response_TABLE order by Thread_Time desc";
			//String sql_2="select Response_Contents from Response_TABLE";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql_1);	//rs1はTHREAD_TABALE
			//ResultSet rs2=st.executeQuery(sql_2);	//rs1はRESPONSE_TABALE

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				UsagiProfile prof = new UsagiProfile();
				
				String serialno = rs.getString(1);	//1列目のデータを取得
				String name = rs.getString(2);	//1列目のデータを取得
				String contents = rs.getString(3);	//2列目のデータを取得
				String rating = rs.getString(4);	//2列目のデータを取得
				String title = rs.getString(5);
				String resno = rs.getString(6);
				String time = rs.getString(8);
				System.out.println("クエリのレス番号"+resno);
				prof.setSerialno(serialno);
				prof.setName(name);
				prof.setContents(contents);
				prof.setRating(rating);
				prof.setTitle(title);
				prof.setResno(resno);
				prof.setTime(time);
				
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();
			
			System.out.println(Tno);

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
		
	}
	
	/*public static List<UsagiProfile> getQueryListTwo(String Tno){
		
		List<UsagiProfile> userList = Old ArrayList<UsagiProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("接続完了");
			
			//select文
			String sql_1="select response_serialno,response_username,response_contents,response_rating,thread_name,thread_table.thread_no from response_table join thread_table on response_table.thread_no=thread_table.thread_no where thread_table.thread_no='"+Tno+"'";
			//String sql_1="select Thread_Name,Thread_Time,Response_Contents from THREAD_TABLE natural join Response_TABLE order by Thread_Time desc";
			//String sql_2="select Response_Contents from Response_TABLE";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql_1);	//rs1はTHREAD_TABALE
			//ResultSet rs2=st.executeQuery(sql_2);	//rs1はRESPONSE_TABALE

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				proftwo = Old UsagiProfile();
				
				String serialno = rs.getString(1);	//1列目のデータを取得
				String name = rs.getString(2);	//1列目のデータを取得
				String contents = rs.getString(3);	//2列目のデータを取得
				String rating = rs.getString(4);	//2列目のデータを取得
				String title = rs.getString(5);
				proftwo.setSerialno(serialno);
				proftwo.setName(name);
				proftwo.setContents(contents);
				proftwo.setRating(rating);
				proftwo.setTitle(title);
				
				userList.add(proftwo);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();
			
			System.out.println(Tno);

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
		
	}*/
}
