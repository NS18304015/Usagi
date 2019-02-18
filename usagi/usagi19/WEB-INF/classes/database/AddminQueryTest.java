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
		System.out.println("username      password"); //見出し

		for(int i = 0; i < al.size();i++){
			IndexProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getName());
		
		}
	
	
	}
	
	//レスポンス表からデータを取得
	public static List<IndexProfile> getAddminResQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			String sql="select Thread_Name,Response_UserName,Response_Time,Response_Contents,Response_Report,Response_No from THREAD_TABLE natural join RESPONSE_TABLE where Response_Report >= 1";
			
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1列目のデータを取得
				String name = rs.getString(2);	//2列目のデータを取得
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
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

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
	
	
	
	//スレッド表からデータを取得
	public static List<IndexProfile> getAddminThreadQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			String sql="select Thread_Name,Thread_Time,Thread_Report from THREAD_TABLE where Response_Report >= 1";
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1列目のデータを取得
				String time = rs.getString(2);	//2列目のデータを取得
				int threadreport = rs.getInt(3);
				prof.setTitle(title);
				prof.setTime(time);
				prof.setThreadreport(threadreport);
				
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

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
	
}











