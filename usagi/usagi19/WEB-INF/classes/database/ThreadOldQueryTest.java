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

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			System.out.println("接続完了");
			
			//select文
			String sql_1="select Response_SerialNo,Response_UserName,Response_Time,Response_Contents,Response_Rating from RESPONSE_TABLE order by Thread_Time asc";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql_1);	//RESPONSE_TABLE

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				ThreadProfile prof = new ThreadProfile();
				
				String serialno = rs.getString(1);	//1列目のデータを取得
				String username = rs.getString(2);	//2列目のデータを取得
				String time = rs.getString(3);		//3列目のデータを取得
				String contents = rs.getString(4);	//4列目のデータを取得
				String rating = rs.getString(5);	//5列目のデータを取得
				prof.setSerialno(serialno);
				prof.setUsername(username);
				prof.setTime(time);
				prof.setContents(contents);
				prof.setRating(rating);
				
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











