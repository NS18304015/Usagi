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
		System.out.println("title      time		response"); //見出し

		for(int i = 0; i < al.size();i++){
			IndexProfile prof = al.get(i);
			System.out.println(prof.getTitle()+"\t"+prof.getTime()+"\t"+prof.getContents());
		
		}
	
	
	}
	
	public static List<IndexProfile> getQueryList(){
		
		List<IndexProfile> userList = new ArrayList<IndexProfile>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("接続完了");
			
			//select文
			String sql_1="select Thread_Name,Thread_Time,Response_Contents from THREAD_TABLE natural join RESPONSE_TABLE order by Thread_Time asc";
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
				IndexProfile prof = new IndexProfile();
				
				String title = rs.getString(1);	//1列目のデータを取得
				String time = rs.getString(2);	//2列目のデータを取得
				String contents = rs.getString(3);	//2列目のデータを取得
				prof.setTitle(title);
				prof.setTime(time);
				prof.setContents(contents);
				
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











