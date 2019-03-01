package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import info.UsagiProfile;

public class AddminQueryTest{
	
	public static void main(String[] args){
		
		List<UsagiProfile> al = getAddminResQueryList();
		System.out.println("username      password"); //見出し

		for(int i = 0; i < al.size();i++){
			UsagiProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getName());
		}
	}
	
	
	//レスポンス表からデータを取得
	public static List<UsagiProfile> getAddminResQueryList(){
		
		List<UsagiProfile> userList = new ArrayList<UsagiProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
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
				UsagiProfile prof = new UsagiProfile();
				
				String title = rs.getString(1);	//1列目のデータを取得
				String name = rs.getString(2);	//2列目のデータを取得
				String restime = rs.getString(3);
				String contents = rs.getString(4);
				String resreport = rs.getString(5);
				String resno = rs.getString(6);
				prof.setTitle(title);
				prof.setName(name);
				prof.setRestime(restime);
				prof.setContents(contents);
				prof.setResreport(resreport);
				prof.setResno(resno);
				
				System.out.println("レスクエリテスト"+prof);
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
			System.out.println("addminresquerytest");
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
	public static List<UsagiProfile> getAddminThreadQueryList(){
		
		List<UsagiProfile> userList = new ArrayList<UsagiProfile>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("接続完了");
			
			String sql="select Thread_No,Thread_Name,Thread_Time,Thread_Report from THREAD_TABLE where Thread_Report >= 1";
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				UsagiProfile prof = new UsagiProfile();
				
				String threadno = rs.getString(1);	//1列目のデータを取得
				String title = rs.getString(2);	//2列目のデータを取得
				String time = rs.getString(3);
				String threadreport = rs.getString(4);
				prof.setThreadno(threadno);
				prof.setTitle(title);
				prof.setTime(time);
				prof.setThreadreport(threadreport);
				
				System.out.println("スレッドクエリテスト"+prof);
				userList.add(prof);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
			System.out.println("addminthreadquerytest");
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











